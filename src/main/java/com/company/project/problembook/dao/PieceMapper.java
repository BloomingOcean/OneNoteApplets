package com.company.project.problembook.dao;

import com.company.project.core.Mapper;
import com.company.project.problembook.dto.Piece;
import org.apache.ibatis.annotations.*;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface PieceMapper extends Mapper<Piece> {

    @ResultMap("Piece")
    @Select("SELECT p_id,title,content FROM problem_book WHERE username = #{username} AND is_recite = 1 AND date = CURDATE();")
    public List<Piece> todayInsertRecite(@Param(value = "username") String username);

    @ResultMap("Piece")
    @Select("SELECT p_id,title,content FROM problem_book WHERE username = #{username} AND is_knowledge=1 AND date=CURDATE();")
    public List<Piece> todayKnowledge(@Param(value = "username") String username);

    @ResultMap("Piece")
    @Select("SELECT p_id,title,content FROM problem_book WHERE username = #{username} AND is_question = 1 ;")
    public List<Piece> allQuestion(@Param(value = "username") String username);

    @ResultMap("Piece")
    @Select("SELECT p_id,title,content FROM problem_book " +
            "WHERE username = #{username}" +
            "AND is_recite = 1 " +
            "AND date+1=CURDATE() OR date+2=CURDATE() OR date+5=CURDATE() OR date+8=CURDATE() OR date+15=CURDATE() OR date+30=CURDATE() OR date+91=CURDATE() OR date+180=CURDATE();")
    public List<Piece> todayRecite(@Param(value = "username") String username);
}
