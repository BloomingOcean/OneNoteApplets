package com.company.project.tomato.service;

import com.company.project.core.AbstractService;
import com.company.project.core.ServiceException;
import com.company.project.tomato.DAO.TomatoMapper;
import com.company.project.tomato.DTO.Proportion;
import com.company.project.tomato.DTO.Tomato;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service("TomatoService")
public class TomatoServiceImpl extends AbstractService<Tomato> implements TomatoService {

    @Autowired
    private TomatoMapper tomatoMapper;



    /**
     * @param tomato
     * @Description: 插入数据
     * @Reutrn Integer
     */
    public Integer insert(Tomato tomato){
        if(tomatoMapper.getId(tomato.getTitle()) != null){
            return 0;
        }
        tomatoMapper.insert(tomato);
        return tomatoMapper.getId(tomato.getTitle());
    }

    /**
     * @param id
     * @Description: 通过主鍵刪除
     * @Reutrn Integer
     */
    public Integer deleteById(Integer id){
        return tomatoMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param ids
     * @Description: 批量刪除 eg：ids -> “1,2,3,4”
     * @Reutrn Integer
     */
    public Integer deleteByIds(String ids){
        return tomatoMapper.deleteByIds(ids);
    }

    /**
     * @param tomato
     * @Description: 更新
     * @Reutrn Integer
     */
    public Integer update(Tomato tomato){
        return tomatoMapper.updateByPrimaryKey(tomato);
    }

    /**
     * @param id
     * @Description: 通过ID查找
     * @Reutrn T
     */
    public Tomato selectById(Integer id){
        Tomato tomato = tomatoMapper.selectByPrimaryKey(id);
        if(tomato == null){
            throw new ServiceException("暂无此数据");
        }
        return tomato;
    }

    /**
     * @param fieldName
     * @param value
     * @throws TooManyResultsException
     * @Description: 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
     * @Reutrn T
     */
//    public User selectBy(String fieldName, Object value) throws TooManyResultsException{}

    /**
     * @param fieldName javabean定义的属性名，不是数据库里的属性名
     * @param value
     * @Description: 通过Model中某个成员变量名称（非数据表中column的名称）查找
     * @Reutrn List<T>
     */
//    public List<User> selectListBy(String fieldName, Object value){}

    /**
     * @param ids
     * @Description: 通过多个ID查找//eg：ids -> “1,2,3,4”
     * @Reutrn List<T>
     */
//    public List<User> selectListByIds(String ids){}

    /**
     * @param condition
     * @Description: 根据条件查找
     * @Reutrn List<T>
     */
    public List<Tomato> selectByCondition(Condition condition){
        return tomatoMapper.selectByCondition(condition);
    }

    /**
     * @Description: 获取所有
     * @Reutrn List<T>
     */
    public List<Tomato> selectAll(){
        return tomatoMapper.selectAll();
    }

    /**
     * @param record
     * @return List<T>
     * @Description: 根据实体中的属性值进行查询，查询条件使用等号
     */
//    public List<User> select(User record){}

    /**
     * @param record
     * @return T
     * @Description: 根据实体中的属性值进行查询，查询条件使用等号
     */
//    public User selectOne(User record){}

    /**
     * @return List<String>
     * @Description: 查询出各个任务类型的完成总数
     */
    public List<Proportion> selectProportion() {
        List<Proportion> proportions = tomatoMapper.selectProportion();
        return proportions;
    }
}
