package com.iverson.erp.pojo;

import lombok.Data;

@Data
public class Brand {
    /** id */
    private int id;
    /** 品牌编号 */
    private String brandNo;
    /** 品牌名称 */
    private String name;
    /** 状态 */
    private Integer status;
}
