package com.company.project.test.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.UUID;
import javax.persistence.*;

@Data
@Table(name = "user")
@ApiModel
public class User {
    @Id
    @Column(name = "id")
    @ApiModelProperty(value="用户id")//我裂开
    @GeneratedValue(strategy = GenerationType.IDENTITY)//存入数据库的时候会自增
    private Integer id;

    @ApiModelProperty(value="用户名")
    @Column(name = "user_name")
    private String username;

    @ApiModelProperty(value="用户密码")
    @Column(name = "password")
    private String password;

    @ApiModelProperty(value="昵称")
    @Column(name = "nick_name")
    private String nickName;

    @ApiModelProperty(value="性别")
    @Column(name = "sex")
    private Integer sex;

    @ApiModelProperty(value="注册日期")
    @Column(name = "register_date")
    private Date registerDate;

    @ApiModelProperty(value="头像")
    @Column(name = "head_portrait")
    private String headPortrait;

    @ApiModelProperty(value="座右铭")
    @Column(name = "motto")
    private String motto;

    @ApiModelProperty(value="VIP截至日期")
    @Column(name = "vip_due_date")
    private Date vipDueDate;
}