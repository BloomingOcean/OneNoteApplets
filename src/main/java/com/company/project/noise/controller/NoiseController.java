package com.company.project.noise.controller;

import com.company.project.noise.DTO.Noise;
import com.company.project.noise.service.NoiseServiceImpl;
import com.company.project.tomato.DTO.Tomato;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("噪音")
@RestController
@RequestMapping("/noise")
public class NoiseController {
    @Autowired
    @Qualifier("NoiseService")
    private NoiseServiceImpl noiseService;

    @ApiOperation(tags = "增加噪音种类",value = "增加噪音种类")
    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
    public Boolean insert(@ApiParam(name = "noise" ,value = "噪音种类" ,required = true) @RequestBody Noise noise){
        if(noiseService.insert(noise) == 1)
            return true;
        return false;
    }

    @ApiOperation(value = "删除噪音种类",tags = "删除噪音种类")
    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)// @RequestParam
    public Boolean delete(@ApiParam(name = "id" ,value="噪音id" ,required = true) @RequestParam Integer id) {
        if(noiseService.deleteById(id) == 1)
            return true;
        return false;
    }

    @ApiOperation(value = "更新噪音种类",tags = "更新噪音种类")
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public Boolean update(@ApiParam(name = "id" ,value="噪音id" ,required = true) @RequestBody Noise noise) {
        if(noiseService.update(noise) == 1)
            return true;
        return false;
    }

    @ApiOperation(value = "根据ID显示噪音种类" ,tags = "显示某噪音种类" ,notes = "参数是噪音id")
    @RequestMapping(value = "/selectById" ,method = RequestMethod.GET)
    public Noise selectById(@ApiParam(name = "id" ,value="噪音id" ,required = true) @RequestParam Integer id) {
        Noise noise = noiseService.selectById(id);
        return noise;
    }

    @ApiOperation(value = "分页查询" ,tags = "分页查询" ,notes = "分页查询")
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public List<Noise> list(@ApiParam(name = "page" ,value="页数" ,required = true) @RequestParam(defaultValue = "0") Integer page, @ApiParam(name = "size" ,value="每一页显示的数量" ,required = true)@RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Noise> list = noiseService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return list;
    }

    @ApiOperation(value = "批量删除噪音" ,tags = "批量删除噪音" ,notes = "格式：1,2,3 （中间用英文逗号分开）")
    @RequestMapping(value = "/deleteByIds" ,method = RequestMethod.GET)
    public Boolean deleteByIds(@ApiParam(name = "ids" ,value="噪音们id" ,required = true) @RequestParam String ids) {
        if(noiseService.deleteByIds(ids) != 0)
            return true;
        return false;
    }
}
