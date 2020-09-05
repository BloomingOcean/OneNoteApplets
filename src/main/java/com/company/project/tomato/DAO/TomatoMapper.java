package com.company.project.tomato.DAO;

import com.company.project.core.Mapper;
import com.company.project.tomato.DTO.Proportion;
import com.company.project.tomato.DTO.Tomato;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface TomatoMapper extends Mapper<Tomato> {

    public List<Proportion> selectProportion();

    @Select("select t_id from tomato where title = #{title};")
    public Integer getId(@Param("title") String title);


}
