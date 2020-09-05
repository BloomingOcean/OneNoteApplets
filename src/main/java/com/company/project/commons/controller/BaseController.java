package com.company.project.commons.controller;

import com.company.project.commons.core.PublicErrorCode;
import com.company.project.commons.exception.CommonException;
import com.company.project.commons.service.InOpenidService;
import com.company.project.commons.service.WeixinService;
import com.company.project.commons.vo.UserIDDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign")
@Api("微信后台操作相关API")
public class BaseController {

	@Autowired
	private WeixinService weixinService;
	
	@Autowired
	private InOpenidService inOpenidService;
	
	//创建一个能储存Userid的对象
	UserIDDTO userIDDTO = new UserIDDTO();
	
    @RequestMapping(value = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(httpMethod = "GET", value = "根据微信code，获取用户userid", notes = "根据微信code，获取用户userid<br><br><b>@author 李洋</b>")
    public UserIDDTO get(@ApiParam(value = "微信Code", required = true) @PathVariable("code") String code) {
    	
    	//获取用户openid
        String openid = weixinService.getWeixinOpenInfo(code);
        openid.toString();
        
       if (openid == null) {
     	throw new CommonException(PublicErrorCode.QUERY_EXCEPTION.getIntValue(), "获取微信openId失败");
        } else {
        	//把openid传入库中,并把用户userId封装到对象中
        	userIDDTO = inOpenidService.returnUserId(openid);
        }
        return userIDDTO;
    }
}
