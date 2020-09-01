package com.julong.enterpriseeureka.spyy.entity;

    import com.baomidou.mybatisplus.annotation.TableName;
    import com.baomidou.mybatisplus.annotation.TableField;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author jobob
* @since 2020-01-06
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("A1")
    public class A1 implements Serializable {

    private static final long serialVersionUID = 1L;

        @TableField("AID")
    private Double aid;

        @TableField("STATE")
    private String state;


}
