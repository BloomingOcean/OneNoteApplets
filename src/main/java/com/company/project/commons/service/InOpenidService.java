package com.company.project.commons.service;

import com.company.project.commons.dao.InOpenidDAO;
import com.company.project.commons.vo.OpenidDTO;
import com.company.project.commons.vo.UserIDDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class InOpenidService {

 	@Autowired
    private InOpenidDAO inOpenidDAO;
 	
// 	@Autowired
//  private OpenidDTO openidDTO;
	
	public UserIDDTO returnUserId(String openid) {
		
		if(inOpenidDAO.foundOpenid(openid) == null)
		{
		//添加Openid到数据库
		inOpenidDAO.add(openid);
		}
		
		//查找userid
		return inOpenidDAO.useridByOpenid(openid);
	}
	
	
	
	
	
	
}
