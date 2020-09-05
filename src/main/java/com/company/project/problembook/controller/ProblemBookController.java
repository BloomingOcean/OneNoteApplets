package com.company.project.problembook.controller;

import com.company.project.problembook.dto.ProblemBook;
import com.company.project.problembook.service.ProblemBookServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ProblemBook")
@ApiModel(value = "笔记本")
@RestController
public class ProblemBookController {
    @Autowired
    @Qualifier("ProblemBookService")
    private ProblemBookServiceImpl problemBookService;

    @ApiOperation(tags = "增加笔记条目",value = "增加笔记条目")
    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
    public Boolean insert(@ApiParam(name = "Problem" ,value = "笔记条目" ,required = true) @RequestBody ProblemBook problemBook){
        if(problemBookService.insert(problemBook) == 1)
            return true;
        return false;
    }

    @ApiOperation(value = "删除笔记条目",tags = "删除笔记条目")
    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    public Boolean delete(@ApiParam(name = "id" ,value="笔记id" ,required = true) @RequestParam Integer id) {
        if(problemBookService.deleteById(id) == 1)
            return true;
        return false;
    }

    @ApiOperation(value = "更新笔记条目",tags = "更新笔记条目")
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public Boolean update(@ApiParam(name = "id" ,value="笔记id" ,required = true) @RequestBody ProblemBook problemBook) {
        if(problemBookService.update(problemBook) == 1)
            return true;
        return false;
    }

    @ApiOperation(value = "根据ID显示笔记条目" ,tags = "显示某笔记条目" ,notes = "参数是笔记id")
    @RequestMapping(value = "/selectById" ,method = RequestMethod.GET)
    public ProblemBook selectById(@ApiParam(name = "id" ,value="笔记id" ,required = true) @RequestParam Integer id) {
        ProblemBook problemBook = problemBookService.selectById(id);
        return problemBook;
    }

    @ApiOperation(value = "分页查询" ,tags = "分页查询" ,notes = "分页查询")
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public List<ProblemBook> list(@ApiParam(name = "page" ,value="页数" ,required = true) @RequestParam(defaultValue = "0") Integer page, @ApiParam(name = "size" ,value="每一页显示的数量" ,required = true)@RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ProblemBook> list = problemBookService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return list;
    }

    @ApiOperation(value = "批量删除笔记" ,tags = "批量删除笔记" ,notes = "格式：1,2,3（中间用英文逗号分开） ")
    @RequestMapping(value = "/deleteByIds" ,method = RequestMethod.GET)
    public Boolean deleteByIds(@ApiParam(name = "ids" ,value="笔记们id" ,required = true) @RequestParam String ids) {
        if(problemBookService.deleteByIds(ids) != 0)
            return true;
        return false;
    }

}
