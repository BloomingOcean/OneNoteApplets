package com.company.project.commons.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@ApiModel(description="单值视图对象")
@Data
@NoArgsConstructor
@Component
public class OneValueVO {
	
    @ApiModelProperty(value = "openid")
    private String openid;//本来这里的属性是code
    
    public OneValueVO (String openid) {
    	this.openid = openid;
    }
}





