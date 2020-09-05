package com.company.project.studyhouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@ApiModel
@Table(name = "study_house")
public class StudyHouse {

    @Id
    @ApiModelProperty(value = "id")
    @Column(name = "s_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sId;

    @ApiModelProperty(value = "房间名")
    @Column(name = "house_name")
    private String houseName;

    @ApiModelProperty(value = "房间号")
    @Column(name = "house_id")
    private Integer houseId;
}
