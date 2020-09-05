package com.company.project.noise.service;

import com.company.project.core.AbstractService;
import com.company.project.core.ServiceException;
import com.company.project.noise.DAO.NoiseMapper;
import com.company.project.noise.DTO.Noise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

@Service("NoiseService")
public class NoiseServiceImpl extends AbstractService<Noise> implements NoiseService {

    @Autowired
    private NoiseMapper noiseMapper;

    /**
     * @param noise
     * @Description: 插入数据
     * @Reutrn Integer
     */
    public Integer insert(Noise noise){
        return noiseMapper.insert(noise);
    }

    /**
     * @param id
     * @Description: 通过主鍵刪除
     * @Reutrn Integer
     */
    public Integer deleteById(Integer id){
        return noiseMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param ids
     * @Description: 批量刪除 eg：ids -> “1,2,3,4”
     * @Reutrn Integer
     */
    public Integer deleteByIds(String ids){
        return noiseMapper.deleteByIds(ids);
    }

    /**
     * @param noise
     * @Description: 更新
     * @Reutrn Integer
     */
    public Integer update(Noise noise){
        return noiseMapper.updateByPrimaryKey(noise);
    }

    /**
     * @param id
     * @Description: 通过ID查找
     * @Reutrn T
     */
    public Noise selectById(Integer id){
        Noise noise = noiseMapper.selectByPrimaryKey(id);
        if(noise == null){
            throw new ServiceException("暂无此数据");
        }
        return noise;
    }

    /**
     * @param condition
     * @Description: 根据条件查找
     * @Reutrn List<T>
     */
    public List<Noise> selectByCondition(Condition condition){
        return noiseMapper.selectByCondition(condition);
    }

    /**
     * @Description: 获取所有
     * @Reutrn List<T>
     */
    public List<Noise> selectAll(){
        return noiseMapper.selectAll();
    }

}
