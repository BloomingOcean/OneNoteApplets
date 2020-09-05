package com.company.project.message.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@ApiModel
@Table(name = "messages")
public class Message {

    @Id
    @ApiModelProperty(value = "id")
    @Column(name = "m_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mId;

    @ApiModelProperty(value = "用户1")
    @Column(name = "user_A")
    private Integer userA;

    @ApiModelProperty(value = "用户2")
    @Column(name = "user_B")
    private Integer userB;

    @ApiModelProperty(value = "文本消息")
    @Column(name = "text")
    private String text;

    @ApiModelProperty(value = "图片")
    @Column(name = "image")
    private String image;

    @ApiModelProperty(value = "消息发送时间")
    @Column(name = "time")
    private Date time;
}
