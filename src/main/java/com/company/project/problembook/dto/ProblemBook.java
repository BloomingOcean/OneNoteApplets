package com.company.project.problembook.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@ApiModel
@Table(name = "problem_book")
public class ProblemBook {

    @Id
    @Column(name = "p_id")
    @ApiModelProperty(value = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pId;

    @Column(name = "username")
    @ApiModelProperty(value = "用户名")
    private String username;

    @Column(name = "title")
    @ApiModelProperty(value = "标题")
    private String title;

    @Column(name = "content")
    @ApiModelProperty(value = "内容")
    private String content;

    @Column(name = "is_question")
    @ApiModelProperty(value = "是否是问题")
    private Integer isQuestion;

    @Column(name = "is_knowledge")
    @ApiModelProperty(value = "是否是知识点")
    private Integer isKnowledge;

    @Column(name = "is_recite")
    @ApiModelProperty(value = "是否需要记背")
    private Integer isRecite;

    @Column(name = "question_state")
    @ApiModelProperty(value = "问题状态")
    private Integer questionState;

    @Column(name = "recite_state")
    @ApiModelProperty(value = "背诵状态")
    private Integer reciteState;

    @Column(name = "date")
    @ApiModelProperty(value = "修改日期")
    private Date date;
}
