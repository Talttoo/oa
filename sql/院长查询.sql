





select sum(in_total_num) from QRY_IP_BED_DAILY
where  to_date(DATE_DAILY,'yyyy-MM-dd') =  to_date('2020.06.18','yyyy-MM-dd');

select sum(total_num) from QRY_IP_BED_DAILY
where  to_date(DATE_DAILY,'yyyy-MM-dd') =  to_date('2020.06.18','yyyy-MM-dd');

select ICU_NUM from QRY_IP_BED_DAILY where to_date(DATE_DAILY,'yyyy-MM-dd') =  to_date('2020.06.18','yyyy-MM-dd') and ROWNUM <=1;



select sum(in_num)  from QRY_IP_BED_DAILY
where  to_date(DATE_DAILY,'yyyy-MM-dd') =  to_date('2020.06.20','yyyy-MM-dd');



select * from QRY_IP_BED_DAILY;


select count(*)
from IP_REGISTER
where IP_DATE = '2020.06.18';






select *  from QRY_IP_BED_DAILY
where  to_date(DATE_DAILY,'yyyy-MM-dd') =  to_date('2020.06.18','yyyy-MM-dd');



select in_num from QRY_IP_BED_DAILY where IN_NUM > 0;


select distinct DATE_DAILY from QRY_IP_BED_DAILY;



select sum(PAT_ORIGINAL_SUM) from QRY_IP_BED_DAILY
where  to_date(DATE_DAILY,'yyyy-MM-dd') =  to_date('2020.06.18','yyyy-MM-dd');












select count(DISTINCT (IP_CODE_BED.BED_CODE))
from ip_code_bed
where type = '1'







