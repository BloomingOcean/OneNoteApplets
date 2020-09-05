package com.company.project.studyhouse.service;

import com.company.project.core.AbstractService;
import com.company.project.core.ServiceException;
import com.company.project.shop.dto.Shop;
import com.company.project.studyhouse.dao.StudyHouseMapper;
import com.company.project.studyhouse.dto.StudyHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

@Service("StudyHouseService")
public class StudyHouseServiceImpl extends AbstractService<StudyHouse> implements StudyHouseService{

    @Autowired
    private StudyHouseMapper studyHouseMapper;

    /**
     * @param studyHouse
     * @Description: 插入数据
     * @Reutrn Integer
     */
    public Integer insert(StudyHouse studyHouse){
        return studyHouseMapper.insert(studyHouse);
    }

    /**
     * @param id
     * @Description: 通过主鍵刪除
     * @Reutrn Integer
     */
    public Integer deleteById(Integer id){
        return studyHouseMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param ids
     * @Description: 批量刪除 eg：ids -> “1,2,3,4”
     * @Reutrn Integer
     */
    public Integer deleteByIds(String ids){
        return studyHouseMapper.deleteByIds(ids);
    }

    /**
     * @param studyHouse
     * @Description: 更新
     * @Reutrn Integer
     */
    public Integer update(StudyHouse studyHouse){
        return studyHouseMapper.updateByPrimaryKey(studyHouse);
    }

    /**
     * @param id
     * @Description: 通过ID查找
     * @Reutrn T
     */
    public StudyHouse selectById(Integer id){
        StudyHouse studyHouse = studyHouseMapper.selectByPrimaryKey(id);
        if(studyHouse == null){
            throw new ServiceException("暂无此数据");
        }
        return studyHouse;
    }

    /**
     * @param condition
     * @Description: 根据条件查找
     * @Reutrn List<T>
     */
    public List<StudyHouse> selectByCondition(Condition condition){
        return studyHouseMapper.selectByCondition(condition);
    }

    /**
     * @Description: 获取所有
     * @Reutrn List<T>
     */
    public List<StudyHouse> selectAll(){
        return studyHouseMapper.selectAll();
    }
}
