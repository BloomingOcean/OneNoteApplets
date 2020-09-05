package com.company.project.test.service.impl;

import com.company.project.core.ServiceException;
import com.company.project.test.dao.UserMapper;
import com.company.project.test.model.User;
import com.company.project.test.service.UserService;
import com.company.project.core.AbstractService;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * Created by CodeGenerator on 2020/04/16.
 */
@Service("UserService")
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @param user
     * @Description: 持久化
     * @Reutrn Integer
     */
    public Integer insert(User user){
        return userMapper.insert(user);
    }

    /**
     * @param id
     * @Description: 通过主鍵刪除
     * @Reutrn Integer
     */
    public Integer deleteById(Integer id){
        return userMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param ids
     * @Description: 批量刪除 eg：ids -> “1,2,3,4”
     * @Reutrn Integer
     */
    public Integer deleteByIds(String ids){
         return userMapper.deleteByIds(ids);
    }

    /**
     * @param user
     * @Description: 更新
     * @Reutrn Integer
     */
    public Integer update(User user){
        return userMapper.updateByPrimaryKey(user);
    }

    /**
     * @param id
     * @Description: 通过ID查找
     * @Reutrn T
     */
     public User selectById(Integer id){
         User user = userMapper.selectByPrimaryKey(id);
         if(user == null){
             throw new ServiceException("暂无该用户");
         }
         return user;
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
    public List<User> selectByCondition(Condition condition){
        return userMapper.selectByCondition(condition);
    }

    /**
     * @Description: 获取所有
     * @Reutrn List<T>
     */
    public List<User> selectAll(){
        return userMapper.selectAll();
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
}
