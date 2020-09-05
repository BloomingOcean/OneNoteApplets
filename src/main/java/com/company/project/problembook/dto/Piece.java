package com.company.project.problembook.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@ApiModel
@Table(name = "problem_book")
public class Piece {

    @Id
    @Column(name = "p_id")
    @ApiModelProperty(value = "笔记本id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pId;

    @ApiModelProperty(value = "标题")
    @Column(name = "title")
    private String title;

    @ApiModelProperty(value = "内容")
    @Column(name = "content")
    private String content;

}
