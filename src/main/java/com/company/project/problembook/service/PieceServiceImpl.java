package com.company.project.problembook.service;

import com.company.project.core.AbstractService;
import com.company.project.problembook.dao.PieceMapper;
import com.company.project.problembook.dto.Piece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PieceService")
public class PieceServiceImpl extends AbstractService<Piece> implements PieceService{

    @Autowired
    private PieceMapper pieceMapper;

    /**
     * @Description: 今日添加记背
     * @param username 用户名
     * @return 今日添加记背
     */
    public List<Piece> todayInsertRecite(String username){
        return pieceMapper.todayInsertRecite(username);
    }

    /**
     * @Description: 今日添加概念
     * @param username 用户名
     * @return 今日添加概念
     */
    public List<Piece> todayKnowledge(String username){
        return pieceMapper.todayKnowledge(username);
    }

    /**
     * @Description: 用户所有问题
     * @param username 用户名
     * @return 用户所有问题
     */
    public List<Piece> allQuestion(String username){
        return pieceMapper.allQuestion(username);
    }

    /**
     * @Description: 今日需记背
     * @param username 用户名
     * @return 用户今日记背
     */
    public List<Piece> todayRecite(String username){
        return pieceMapper.todayRecite(username);
    }
}
