package com.company.project.problembook.controller;

import com.company.project.problembook.dto.Piece;
import com.company.project.problembook.service.PieceServiceImpl;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/ProblemBook/PieceBook")
@ApiModel(value = "今日记背")
@RestController
public class PieceController {

    @Autowired
    @Qualifier("PieceService")
    private PieceServiceImpl reciteService;

    @ApiOperation(tags = "今日添加记背",value = "今日添加记背")
    @RequestMapping(value = "/todayInsertRecite" ,method = RequestMethod.GET)
    public List<Piece> todayInsertRecite(@ApiParam(name = "username" ,value = "用户名" ,required = true) @RequestParam String username){
        return reciteService.todayInsertRecite(username);
    }

    @ApiOperation(tags = "今日添加概念",value = "今日添加概念")
    @RequestMapping(value = "/todayKnowledge" ,method = RequestMethod.GET)
    public List<Piece> todayKnowledge(@ApiParam(name = "username" ,value = "用户名" ,required = true) @RequestParam String username){
        return reciteService.todayKnowledge(username);
    }

    @ApiOperation(tags = "所有我的问题",value = "所有我的问题")
    @RequestMapping(value = "/allQuestion" ,method = RequestMethod.GET)
    public List<Piece> allQuestion(@ApiParam(name = "username" ,value = "用户名" ,required = true) @RequestParam String username){
        return reciteService.allQuestion(username);
    }

    @ApiOperation(tags = "今日需记背",value = "今日需记背")
    @RequestMapping(value = "/todayRecite" ,method = RequestMethod.GET)
    public List<Piece> todayRecite(@ApiParam(name = "username" ,value = "用户名" ,required = true) @RequestParam String username){
        return reciteService.todayRecite(username);
    }
}
