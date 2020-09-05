package com.company.project.message.controller;

import com.company.project.message.dto.Message;
import com.company.project.message.servise.MessageServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("聊天消息")
@RestController
@RequestMapping("/Message")
public class MessageController {

    @Autowired
    @Qualifier("MessageService")
    private MessageServiceImpl messageService;

    @ApiOperation(tags = "增加一条聊天消息",value = "增加一条聊天消息")
    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
    public Boolean insert(@ApiParam(name = "message" ,value = "噪音种类" ,required = true) @RequestBody Message message){
        if(messageService.insert(message) == 1)
            return true;
        return false;
    }

    @ApiOperation(value = "删除一条聊天消息",tags = "删除一条聊天消息")
    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)// @RequestParam
    public Boolean delete(@ApiParam(name = "id" ,value="聊天消息id" ,required = true) @RequestParam Integer id) {
        if(messageService.deleteById(id) == 1)
            return true;
        return false;
    }

    @ApiOperation(value = "更新一条聊天消息",tags = "更新一条聊天消息")
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public Boolean update(@ApiParam(name = "id" ,value="聊天消息id" ,required = true) @RequestBody Message message) {
        if(messageService.update(message) == 1)
            return true;
        return false;
    }

    @ApiOperation(value = "根据ID显示一条聊天消息" ,tags = "显示某一条聊天消息" ,notes = "参数是一条聊天消息id")
    @RequestMapping(value = "/selectById" ,method = RequestMethod.GET)
    public Message selectById(@ApiParam(name = "id" ,value="聊天消息id" ,required = true) @RequestParam Integer id) {
        Message message = messageService.selectById(id);
        return message;
    }

    @ApiOperation(value = "分页查询" ,tags = "分页查询" ,notes = "分页查询")
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public List<Message> list(@ApiParam(name = "page" ,value="页数" ,required = true) @RequestParam(defaultValue = "0") Integer page, @ApiParam(name = "size" ,value="每一页显示的数量" ,required = true)@RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Message> list = messageService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return list;
    }

    @ApiOperation(value = "批量删除聊天消息" ,tags = "批量删除聊天消息" ,notes = "格式：1,2,3 （中间用英文逗号分开）")
    @RequestMapping(value = "/deleteByIds" ,method = RequestMethod.GET)
    public Boolean deleteByIds(@ApiParam(name = "ids" ,value="聊天消息们id" ,required = true) @RequestParam String ids) {
        if(messageService.deleteByIds(ids) != 0)
            return true;
        return false;
    }


}
