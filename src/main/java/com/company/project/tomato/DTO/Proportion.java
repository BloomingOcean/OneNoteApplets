package com.company.project.tomato.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
public class Proportion {

    @ApiModelProperty(value = "任务名")
    @Column(name = "title")
    private String title;

    @ApiModelProperty(value = "完成的总数")
    @Column(name = "all_completed")
    private Integer allCompletedNumber;
}
