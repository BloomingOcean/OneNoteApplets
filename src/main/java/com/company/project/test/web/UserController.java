package com.company.project.test.web;
import com.company.project.test.model.User;
import com.company.project.test.service.impl.UserServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Created by CodeGenerator on 2020/04/16.
*/
@Api("用户信息的增删改查")
@RestController
@RequestMapping("/userInfo")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value = "添加数据",tags = "添加用户数据", notes = "这是提示内容")
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public Boolean insert(@RequestBody @ApiParam(name = "user" ,value="用户实体类" ,required = true) User user) {
        if(userService.insert(user) == 1)
            return true;
        return false;
    }

    @ApiOperation(value = "删除数据",tags = "删除用户数据", notes = "这是提示内容")
    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    public Boolean delete(@ApiParam(name = "id" ,value="用户id" ,required = true) @RequestParam Integer id) {
        if(userService.deleteById(id) == 1)
            return true;
        return false;
    }

    @ApiOperation(value = "更新数据",tags = "更新用户数据", notes = "这是提示内容")
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public Integer update(@ApiParam(name = "id" ,value="用户id" ,required = true) @RequestBody User user) {
       return userService.update(user);
    }

    @ApiOperation(value = "根据ID显示数据" ,tags = "显示某用户数据" ,notes = "参数是用户id")
    @RequestMapping(value = "/selectById" ,method = RequestMethod.GET)
    public User selectById(@ApiParam(name = "id" ,value="用户id" ,required = true) @RequestParam Integer id) {
        User user = userService.selectById(id);
        return user;
    }

    @ApiOperation(value = "分页查询" ,tags = "分页查询" ,notes = "分页查询")
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public List<User> list(@ApiParam(name = "page" ,value="页数" ,required = true) @RequestParam(defaultValue = "0") Integer page, @ApiParam(name = "size" ,value="每一页显示的数量" ,required = true)@RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return list;
    }

    @ApiOperation(value = "批量删除" ,tags = "批量删除" ,notes = "格式：1,2,3（中间用英文逗号分开） ")
    @RequestMapping(value = "/deleteByIds" ,method = RequestMethod.GET)
    public Boolean deleteByIds(@ApiParam(name = "ids" ,value="用户们id" ,required = true) @RequestParam String ids) {
        if(userService.deleteByIds(ids) != 0)
            return true;
    return false;
    }
}
