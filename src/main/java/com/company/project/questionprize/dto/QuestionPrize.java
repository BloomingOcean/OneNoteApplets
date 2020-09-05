package com.company.project.questionprize.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@ApiModel
@Table(name = "question_prize")
public class QuestionPrize {

    @Id
    @ApiModelProperty(value = "id")
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "问题")
    @Column(name = "question")
    private String question;

    @ApiModelProperty(value = "内容")
    @Column(name = "content")
    private String content;
}
