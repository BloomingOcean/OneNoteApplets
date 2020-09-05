package com.company.project.problembook.service;

import com.company.project.core.AbstractService;
import com.company.project.core.ServiceException;
import com.company.project.problembook.dao.ProblemBookMapper;
import com.company.project.problembook.dto.ProblemBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

@Service("ProblemBookService")
public class ProblemBookServiceImpl extends AbstractService<ProblemBook> implements ProblemBookService{
    @Autowired
    private ProblemBookMapper problemBookMapper;

    /**
     * @param problemBook
     * @Description: 插入数据
     * @Reutrn Integer
     */
    public Integer insert(ProblemBook problemBook){
        return problemBookMapper.insert(problemBook);
    }

    /**
     * @param id
     * @Description: 通过主鍵刪除
     * @Reutrn Integer
     */
    public Integer deleteById(Integer id){
        return problemBookMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param ids
     * @Description: 批量刪除 eg：ids -> “1,2,3,4”
     * @Reutrn Integer
     */
    public Integer deleteByIds(String ids){
        return problemBookMapper.deleteByIds(ids);
    }

    /**
     * @param problemBook
     * @Description: 更新
     * @Reutrn Integer
     */
    public Integer update(ProblemBook problemBook){
        return problemBookMapper.updateByPrimaryKey(problemBook);
    }

    /**
     * @param id
     * @Description: 通过ID查找
     * @Reutrn T
     */
    public ProblemBook selectById(Integer id){
        ProblemBook problemBook = problemBookMapper.selectByPrimaryKey(id);
        if(problemBook == null){
            throw new ServiceException("暂无此数据");
        }
        return problemBook;
    }

    /**
     * @param condition
     * @Description: 根据条件查找
     * @Reutrn List<T>
     */
    public List<ProblemBook> selectByCondition(Condition condition){
        return problemBookMapper.selectByCondition(condition);
    }

    /**
     * @Description: 获取所有
     * @Reutrn List<T>
     */
    public List<ProblemBook> selectAll(){
        return problemBookMapper.selectAll();
    }
}
