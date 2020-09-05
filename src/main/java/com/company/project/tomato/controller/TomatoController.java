package com.company.project.tomato.controller;

import com.company.project.tomato.DTO.Proportion;
import com.company.project.tomato.DTO.Tomato;
import com.company.project.tomato.service.TomatoServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api("番茄钟记录信息")
@RestController
@RequestMapping("/tomatoInfo")
public class TomatoController {

    @Autowired
    @Qualifier("TomatoService")
    private TomatoServiceImpl tomatoService;

    @ApiOperation(value = "添加数据",tags = "添加记录数据", notes = "这是提示内容")
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public Integer insert(@RequestBody @ApiParam(name = "user" ,value="记录实体类" ,required = true) Tomato tomato) {
        return tomatoService.insert(tomato);
    }

    @ApiOperation(value = "删除数据",tags = "删除记录数据", notes = "这是提示内容")
    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    public Boolean delete(@ApiParam(name = "id" ,value="记录id" ,required = true) @RequestParam Integer id) {
        if(tomatoService.deleteById(id) == 1)
            return true;
        return false;
    }

    @ApiOperation(value = "更新数据",tags = "更新记录数据", notes = "这是提示内容")
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public Integer update(@ApiParam(name = "id" ,value="记录id" ,required = true) @RequestBody Tomato tomato) {
        return tomatoService.update(tomato);
    }

    @ApiOperation(value = "根据ID显示记录数据" ,tags = "显示某记录数据" ,notes = "参数是记录id")
    @RequestMapping(value = "/selectById" ,method = RequestMethod.GET)
    public Tomato selectById(@ApiParam(name = "id" ,value="记录id" ,required = true) @RequestParam Integer id) {
        Tomato tomato = tomatoService.selectById(id);
        return tomato;
    }

    @ApiOperation(value = "显示所有记录数据" ,tags = "显示所有记录数据")
    @RequestMapping(value = "/selectAll" ,method = RequestMethod.GET)
    public List<Tomato> selectAll(){
        return tomatoService.selectAll();
    }

    @ApiOperation(value = "查询不同类型的任务完成的数量" ,tags = "显示任务数量" ,notes = "返回的是所有任务的完成的数量")
    @RequestMapping(value = "/selectProportion",method = RequestMethod.GET)
    public List<Proportion> selectProportion(){
        return tomatoService.selectProportion();
    }

    @ApiOperation(value = "分页查询" ,tags = "分页查询" ,notes = "分页查询")
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public List<Tomato> list(@ApiParam(name = "page" ,value="页数" ,required = true) @RequestParam(defaultValue = "0") Integer page, @ApiParam(name = "size" ,value="每一页显示的数量" ,required = true)@RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Tomato> list = tomatoService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return list;
    }

    @ApiOperation(value = "批量删除" ,tags = "批量删除" ,notes = "格式：1,2,3 （中间用英文逗号分开）")
    @RequestMapping(value = "/deleteByIds" ,method = RequestMethod.GET)
    public Boolean deleteByIds(@ApiParam(name = "ids" ,value="记录们id" ,required = true) @RequestParam String ids) {
        if(tomatoService.deleteByIds(ids) != 0)
            return true;
        return false;
    }
}
