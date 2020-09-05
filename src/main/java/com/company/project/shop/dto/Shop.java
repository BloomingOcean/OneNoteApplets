package com.company.project.shop.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@ApiModel
@Table(name = "shop")
public class Shop {

    @Id
    @ApiModelProperty(value = "id")
    @Column(name = "s_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sId;

    @ApiModelProperty(value = "标题")
    @Column(name = "title")
    private String title;

    @ApiModelProperty(value = "价钱")
    @Column(name = "price")
    private Double price;

    @ApiModelProperty(value = "图片")
    @Column(name = "picture")
    private String picture;

    @ApiModelProperty(value = "产品介绍")
    @Column(name = "product_introduction")
    private String productIntroduction;

    @ApiModelProperty(value = "款式")
    @Column(name = "style")
    private String style;
}
