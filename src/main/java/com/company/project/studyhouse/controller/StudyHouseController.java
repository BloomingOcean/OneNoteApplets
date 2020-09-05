package com.company.project.studyhouse.controller;

import com.company.project.questionprize.dto.QuestionPrize;
import com.company.project.shop.service.ShopServiceImpl;
import com.company.project.studyhouse.dto.StudyHouse;
import com.company.project.studyhouse.service.StudyHouseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/StudyHouse")
@RestController
public class StudyHouseController {

    @Autowired
    @Qualifier("StudyHouseService")
    private StudyHouseServiceImpl studyHouseService;

    @ApiOperation(tags = "增加消息记录",value = "增加消息记录")
    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
    public Boolean insert(@ApiParam(name = "Problem" ,value = "消息记录条目" ,required = true) @RequestBody StudyHouse studyHouse){
        if(studyHouseService.insert(studyHouse) == 1)
            return true;
        return false;
    }

    @ApiOperation(value = "删除消息记录",tags = "删除消息记录")
    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    public Boolean delete(@ApiParam(name = "id" ,value="消息记录id" ,required = true) @RequestParam Integer id) {
        if(studyHouseService.deleteById(id) == 1)
            return true;
        return false;
    }

    @ApiOperation(value = "更新消息记录",tags = "更新消息记录")
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public Boolean update(@ApiParam(name = "id" ,value="消息记录id" ,required = true) @RequestBody StudyHouse studyHouse) {
        if(studyHouseService.update(studyHouse) == 1)
            return true;
        return false;
    }

    @ApiOperation(value = "根据ID显示消息记录" ,tags = "显示某条消息记录" ,notes = "参数是消息记录id")
    @RequestMapping(value = "/selectById" ,method = RequestMethod.GET)
    public StudyHouse selectById(@ApiParam(name = "id" ,value="消息记录id" ,required = true) @RequestParam Integer id) {
        StudyHouse studyHouse = studyHouseService.selectById(id);
        return studyHouse;
    }

    @ApiOperation(value = "分页查询" ,tags = "分页查询" ,notes = "分页查询")
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public List<StudyHouse> list(@ApiParam(name = "page" ,value="页数" ,required = true) @RequestParam(defaultValue = "0") Integer page, @ApiParam(name = "size" ,value="每一页显示的数量" ,required = true)@RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<StudyHouse> list = studyHouseService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return list;
    }

    @ApiOperation(value = "批量删除消息记录" ,tags = "批量删除消息记录" ,notes = "格式：1,2,3（中间用英文逗号分开） ")
    @RequestMapping(value = "/deleteByIds" ,method = RequestMethod.GET)
    public Boolean deleteByIds(@ApiParam(name = "ids" ,value="消息记录们id" ,required = true) @RequestParam String ids) {
        if(studyHouseService.deleteByIds(ids) != 0)
            return true;
        return false;
    }
}
