package com.company.project.questionprize.controller;

import com.company.project.problembook.dto.ProblemBook;
import com.company.project.questionprize.dto.QuestionPrize;
import com.company.project.questionprize.service.QuestionPrizeServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/QuestionPrize")
public class QuestionPrizeController {
    @Autowired
    @Qualifier("QuestionPrizeService")
    private QuestionPrizeServiceImpl questionPrizeService;


    @ApiOperation(tags = "增加问答数量",value = "增加问答数量")
    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
    public Boolean insert(@ApiParam(name = "Problem" ,value = "问答条目" ,required = true) @RequestBody QuestionPrize questionPrize){
        if(questionPrizeService.insert(questionPrize) == 1)
            return true;
        return false;
    }

    @ApiOperation(value = "删除问答",tags = "删除问答")
    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    public Boolean delete(@ApiParam(name = "id" ,value="问答id" ,required = true) @RequestParam Integer id) {
        if(questionPrizeService.deleteById(id) == 1)
            return true;
        return false;
    }

    @ApiOperation(value = "更新问答",tags = "更新问答")
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public Boolean update(@ApiParam(name = "id" ,value="问答id" ,required = true) @RequestBody QuestionPrize questionPrize) {
        if(questionPrizeService.update(questionPrize) == 1)
            return true;
        return false;
    }

    @ApiOperation(value = "根据ID显示问答" ,tags = "显示某问答" ,notes = "参数是问答id")
    @RequestMapping(value = "/selectById" ,method = RequestMethod.GET)
    public QuestionPrize selectById(@ApiParam(name = "id" ,value="问答id" ,required = true) @RequestParam Integer id) {
        QuestionPrize questionPrize = questionPrizeService.selectById(id);
        return questionPrize;
    }

    @ApiOperation(value = "分页查询" ,tags = "分页查询" ,notes = "分页查询")
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public List<QuestionPrize> list(@ApiParam(name = "page" ,value="页数" ,required = true) @RequestParam(defaultValue = "0") Integer page, @ApiParam(name = "size" ,value="每一页显示的数量" ,required = true)@RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<QuestionPrize> list = questionPrizeService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return list;
    }

    @ApiOperation(value = "批量删除问答" ,tags = "批量删除问答" ,notes = "格式：1,2,3（中间用英文逗号分开） ")
    @RequestMapping(value = "/deleteByIds" ,method = RequestMethod.GET)
    public Boolean deleteByIds(@ApiParam(name = "ids" ,value="问答们id" ,required = true) @RequestParam String ids) {
        if(questionPrizeService.deleteByIds(ids) != 0)
            return true;
        return false;
    }
}
