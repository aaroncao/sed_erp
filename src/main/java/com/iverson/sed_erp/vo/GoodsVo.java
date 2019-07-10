package com.iverson.sed_erp.vo;

import lombok.Data;

@Data
public class GoodsVo {
    private String goodsNo;
    private String name;
    private String barcode;
    private double weight;
    private double price;
    private String categoryNo;
    private String categoryName;
    private String brandNo;
    private String brandName;
    private String store;
}
