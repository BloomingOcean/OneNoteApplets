package com.company.project.commons.dao;

import com.company.project.commons.vo.OpenidDTO;
import com.company.project.commons.vo.UserIDDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class InOpenidDAO {

	 @Autowired
	 private JdbcTemplate jdbcTemplate;

	 /**
		 * 添加用户openid（并递增生成userid）
		 * @param openid
		 * @return
		 */
		public void add(String openid) {
	        final String sql = "INSERT INTO user(openid,register_date)" +
	        		" VALUES(?, CURDATE());";

	        jdbcTemplate.update(sql,  
	        		openid);
	    }




		/**
		 * 根据openid查找userid
		 * @param openid
		 * @return
		 */
		public UserIDDTO useridByOpenid (String openid) {
			final String sql = "SELECT id from user" +
					" WHERE openid = ?;";
			
			//内部类，封装多个不同的DTO并存储在一个List中
			List<UserIDDTO> list = jdbcTemplate.query(sql, new Object[]{openid}, new RowMapper<UserIDDTO>() {
		            public UserIDDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	UserIDDTO test = new UserIDDTO();
		            	test.setUserId(rs.getInt("id"));
		                return test;
		            }
		        });

			if (null != list && list.size() > 0) {
				return list.get(0);
			}
			return null;
		}
		
		
		/**
		 * 根据查找openid
		 * @param openid
		 * @return
		 */
		public OpenidDTO foundOpenid (String openid) {
			final String sql = "SELECT openid from user" +
					" WHERE openid = ?;";

			List<OpenidDTO> list = jdbcTemplate.query(sql, new Object[]{openid}, new RowMapper<OpenidDTO>() {
		            public OpenidDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	OpenidDTO test = new OpenidDTO();
		            	test.setOpenId(rs.getString("openid"));
		                return test;
		            }
		        });

			if (null != list && list.size() > 0) {
				return list.get(0);
			}
			return null;
		}
}
