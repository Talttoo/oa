CREATE OR REPLACE
PROCEDURE      "PROC_QRY_IP_BED_DAILY"
--生成每天床位使用
IS
	ls_today varchar2(20);
        ls_yestoday varchar(20);
BEGIN
    select to_char(sysdate-1,'yyyy.mm.dd') into ls_today from dual;
    select to_char(sysdate-2,'yyyy.mm.dd') into ls_yestoday from dual;
    delete from QRY_IP_BED_DAILY where DATE_DAILY = ls_today ;
        insert into QRY_IP_BED_DAILY
        select code_department.dept_code,
        code_department.dept_name,
        ls_today,
        /*科室编制床数*/
        (select count(bed_code) from ip_code_bed where dept_code = code_department.dept_code and TYPE = '1') as total_num,
        /*科室入院人数*/
        (select count(reg_no) from ip_patient where dept_code = code_department.dept_code and IN_DATE = ls_today  and INWAY = '1' and ip_patient.CURR_FLAG = 'T') as in_num,
        /*科室出院人数*/
        (select count(reg_no) from ip_patient where dept_code = code_department.dept_code and  OUT_DATE = ls_today and OUTWAY  in('1','3','4','5') and ip_patient.CURR_FLAG = 'T') as out_num,
        /*转科 科室转入人数*/
        (select count(distinct reg_no) from IP_TRANSFER where substr(TRANS_TIME,1,10) = ls_today and new_dept = code_department.dept_code and FLAG = '1' ) as trans_in ,
        /*转科 科室转出人数*/
        (select count(distinct reg_no) from IP_TRANSFER where substr(TRANS_TIME,1,10) = ls_today and old_dept = code_department.dept_code and FLAG = '1') as trans_out ,
        /*科室已安排床位人数*/
	(select COUNT( IP_REGISTER.REG_NO) from ip_patient,ip_register,ip_code_bed
				   where
				   ip_patient.dept_code = code_department.dept_code
				   and ( OP_DATE  is null or OP_DATE >=  ls_today    )
				   and IP_DATE <= ls_today and ip_register.REG_NO = ip_patient.REG_NO and ip_register.IP_NO not like 'zx%'
	                           and ip_patient.CURR_FLAG = 'T'
	                           and IP_REGISTER.REG_NO = IP_CODE_BED.REG_NO
	                           and ip_code_bed.DEPT_CODE = ip_patient.dept_code
				and IP_CODE_BED.STATUS = '2'
			  ) as in_total_num,

        (select count(reg_no) from ip_patient  where dept_code = code_department.dept_code and
          ((OUTWAY = '0' or OUTWAY is null and IN_DATE <= ls_today ) or
          ( IN_DATE <= ls_today and out_date > ls_today))) /
        (select decode(count(bed_code),0,100,count(bed_code)) from ip_code_bed where dept_code = code_department.dept_code and TYPE = '1') * 100 as ls_use_lv,
        (select sum(ip_chrgentry.total_sum) from ip_charge,ip_chrgentry
         where  ip_charge.chrg_date = ls_yestoday and ip_charge.chrg_no = ip_chrgentry.chrg_no and ip_chrgentry.dept_code = code_department.dept_code and
           ip_charge.status = '1') as total_yestoday,
        (select count(distinct p.reg_no)  from ip_patient p,ip_register r
          where p.dept_code = code_department.DEPT_CODE and p.reg_no = r.reg_no and
                r.ip_date <= ls_today and
                r.loc_flag = '1' and
	        p.curr_flag = 'T' and
	        p.class = '1') as pat_class_1,
        (select count(distinct p.reg_no)
		  from ip_patient p,ip_register r
		  where p.dept_code = code_department.DEPT_CODE and
              p.reg_no = r.reg_no and
              r.ip_date <= ls_today and
              r.loc_flag = '1' and
	      p.curr_flag = 'T' and
	      p.class = '2') as pat_class_2,
        (select count(distinct p.reg_no)
		  from ip_patient p,ip_register r
		  where p.dept_code = code_department.DEPT_CODE and
              p.reg_no = r.reg_no and
              r.ip_date <= ls_today and
              r.loc_flag = '1' and
	      p.curr_flag = 'T' and
	      p.class = '3') as pat_class_3,
        (select count(distinct p.reg_no)
		  from ip_patient p,ip_register r
		  where p.dept_code = code_department.DEPT_CODE and
              p.reg_no = r.reg_no and
              r.ip_date <= ls_today and
              r.loc_flag = '1' and
	      p.curr_flag = 'T' and
	      p.lea_flag = 'T') as pat_leave,
        (select count(distinct p.reg_no)
		from ip_patient p
		where p.dept_code = code_department.DEPT_CODE and
	      p.inway = '1' and
	      p.in_date = ls_today) as pat_in_1,
        (select count(distinct p.reg_no)
			from ip_patient p
			where p.dept_code = code_department.DEPT_CODE and
		p.inway = '2' and
		p.in_date = ls_today) as pat_in_2,
        /*正常出院*/
	(select count(distinct p.reg_no) from ip_patient p where p.dept_code = code_department.DEPT_CODE and p.outway = '1' and	p.out_date = ls_today) as pat_out_1,
        /*转出*/
	(select count(distinct p.reg_no) from ip_patient p where p.dept_code = code_department.DEPT_CODE and p.outway = '2' and	p.out_date = ls_today) as pat_out_2,
        /*死亡*/
        (select count(distinct p.reg_no) from ip_patient p where p.dept_code = code_department.DEPT_CODE and p.outway = '3' and	p.out_date = ls_today) as pat_out_3,
        /*24小时死亡*/
	 (select count(distinct p.reg_no) from ip_patient p where p.dept_code = code_department.DEPT_CODE and p.outway = '4' and p.out_date = ls_today) as pat_out_4,
          /*转院*/
	(select count(distinct p.reg_no) from ip_patient p where p.dept_code = code_department.DEPT_CODE and p.outway = '5' and p.out_date = ls_today) as pat_out_5,
        /*危重病人*/
         (select count(reg_no) from ip_register where OP_DATE is null and ip_date <= ls_today and IP_CASE = '1') as icu_num,
         (select count(distinct reg_no)  from ip_code_bed where dept_code = '0381' and bed_code like '11%' and reg_no is not null) AS ICU_01,
         (select count(distinct reg_no)  from ip_code_bed where dept_code = '0381' and bed_code like '12%' and reg_no is not null) AS ICU_02,
         (select count(distinct reg_no)  from ip_code_bed where dept_code = '0381' and bed_code like '13%' and reg_no is not null) AS ICU_03,
         (select count(distinct reg_no)  from ip_code_bed where dept_code = '0381' and bed_code like '14%' and reg_no is not null) AS ICU_04,
          /*科室床位总数*/
          (select count(bed_code) from ip_code_bed where dept_code = code_department.dept_code) as DEPT_BED_TATAL,
          /*科室总人数*/
          (select COUNT( IP_REGISTER.REG_NO) from ip_patient,ip_register
				   where ip_patient.dept_code = code_department.dept_code
                                   and ip_register.REG_NO = ip_patient.REG_NO
				   and ( OP_DATE  is null or OP_DATE >=  ls_today    )
				   and IP_DATE <= ls_today
                                   and ip_register.IP_NO not like 'zx%'
	                           and ip_patient.CURR_FLAG = 'T'
			  ) as DEPT_PAT_SUM,
          /*科室包床人数*/
          (select COUNT( IP_REGISTER.REG_NO) from ip_patient,ip_register,ip_code_bed
				   where ip_patient.dept_code = code_department.dept_code
				   and ( OP_DATE  is null or OP_DATE >=  ls_today    )
				   and IP_DATE <= ls_today
                                   and ip_register.REG_NO = ip_patient.REG_NO
                                   and ip_register.IP_NO not like 'zx%'
	                           and ip_patient.CURR_FLAG = 'T'
	                           and IP_REGISTER.REG_NO = IP_CODE_BED.REG_NO
	                           and ip_code_bed.DEPT_CODE = ip_patient.dept_code
				and IP_CODE_BED.STATUS = '3'
			  ) as DEPT_PAT_charter_DED_SUM,
          /*科室原有在院人数g OP_DATE >=  ls_today 过滤上天出院患者*/
          (select COUNT( IP_REGISTER.REG_NO) from ip_patient,ip_register
				   where ip_patient.dept_code = code_department.dept_code
                                   and ip_register.REG_NO = ip_patient.REG_NO
				   and ( OP_DATE is null or OP_DATE >=  ls_today    )
				   and IP_DATE <= ls_yestoday
                                   and ip_register.IP_NO not like 'zx%'
	                           and ip_patient.CURR_FLAG = 'T'
			  ) as DEPT_PAT_ORIGINAL_SUM
         from code_department
        where dept_code in(select distinct dept_code from ip_code_bed) and
           dept_code not in(select rule_code from DEF_CONFIGURATION where config_code = 'ip95');
--	  if sqlcode =0 then
	    commit;
--	  else
--	    rollback;
--	  end if;

END;