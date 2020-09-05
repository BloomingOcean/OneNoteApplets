package com.company.project.commons.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@ApiModel(description="userID")
@Data
@NoArgsConstructor
@Component
public class UserIDDTO {

	@ApiModelProperty(value = "用户id")
	@Getter @Setter private int userId;
	
	public UserIDDTO(int userId) {
		this.userId = userId;
	}
}
