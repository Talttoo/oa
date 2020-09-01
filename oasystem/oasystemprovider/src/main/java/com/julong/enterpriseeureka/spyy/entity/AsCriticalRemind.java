package com.julong.enterpriseeureka.spyy.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
* <p>
    * 
    * </p>
*
* @author lyt
* @since 2020-06-24
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("AS_CRITICAL_REMIND")
public class AsCriticalRemind implements Serializable {

    private static final long serialVersionUID = 1L;

        @TableField("REP_NO")
    private Long repNo;

        @TableField("REQ_NO")
    private Long reqNo;

        @TableField("NAME")
    private String name;

        @TableField("SEX")
    private String sex;

        @TableField("DEPT_CODE")
    private String deptCode;

        @TableField("TYPE")
    private String type;

        @TableField("OPER_NO")
    private String operNo;

        @TableField("ROOM_CODE")
    private String roomCode;

        @TableField("REQ_DR")
    private String reqDr;

        @TableField("REQ_DATE")
    private String reqDate;

        @TableField("REP_DATE")
    private String repDate;

        @TableField("SITE")
    private String site;

        @TableField("READER")
    private String reader;

        @TableField("READ_FLAG")
    private String readFlag;

        @TableField("GROUP_CODE")
    private String groupCode;

        @TableField("CRITICAL_NOTE")
    private String criticalNote;

        @TableField("READ_NOTE")
    private String readNote;

        @TableField("READ_TIME")
    private String readTime;


}
