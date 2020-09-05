package com.company.project.tomato.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@ApiModel
@Table(name = "tomato")
public class Tomato {
    @Id
    @ApiModelProperty(value = "id")
    @Column(name = "t_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//存入数据库的时候会自增
    private Integer tId;

    @ApiModelProperty(value = "标题")
    @Column(name = "title")
    private String title;

    @ApiModelProperty(value = "完成数量")
    @Column(name = "completed_number")
    private Integer completedNumber;

    @ApiModelProperty(value = "失败数量")
    @Column(name = "fail_number")
    private Integer failNumber;

    @ApiModelProperty(value = "截止日期")
    @Column(name = "due_date")
    private Date dueDate;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_date")
    private Date createDate;
}
