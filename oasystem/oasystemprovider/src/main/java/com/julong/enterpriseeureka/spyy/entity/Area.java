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
* @since 2019-07-09
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("AREA")
    public class Area implements Serializable {

    private static final long serialVersionUID = 1L;

        @TableField("ITEM_CODE")
    private String itemCode;

        @TableField("AREA")
    private String area;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


}
