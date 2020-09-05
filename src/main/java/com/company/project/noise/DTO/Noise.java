package com.company.project.noise.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Data
@ApiModel
@Table(name = "noise")
@Validated
public class Noise {

    @Id
    @Column(name = "n_id")
    @ApiModelProperty(value = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nId;

    @Email
    @Column(name = "noise_name")
    @ApiModelProperty(value = "噪音名称")
    private String noiseName;

    @Column(name = "noise_type")
    @ApiModelProperty(value = "噪音类型")
    private Integer noiseType;

    @Column(name = "url")
    @ApiModelProperty(value = "链接")
    private String url;
}
