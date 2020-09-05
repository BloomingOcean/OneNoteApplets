package com.company.project.questionprize.service;

import com.company.project.core.AbstractService;
import com.company.project.core.ServiceException;
import com.company.project.problembook.dto.ProblemBook;
import com.company.project.questionprize.dao.QuestionPrizeMapper;
import com.company.project.questionprize.dto.QuestionPrize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

@Service("QuestionPrizeService")
public class QuestionPrizeServiceImpl extends AbstractService<QuestionPrize> implements QuestionPrizeService{

    @Autowired
    private QuestionPrizeMapper questionPrizeMapper;

    /**
     * @param questionPrize
     * @Description: 插入数据
     * @Reutrn Integer
     */
    public Integer insert(QuestionPrize questionPrize){
        return questionPrizeMapper.insert(questionPrize);
    }

    /**
     * @param id
     * @Description: 通过主鍵刪除
     * @Reutrn Integer
     */
    public Integer deleteById(Integer id){
        return questionPrizeMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param ids
     * @Description: 批量刪除 eg：ids -> “1,2,3,4”
     * @Reutrn Integer
     */
    public Integer deleteByIds(String ids){
        return questionPrizeMapper.deleteByIds(ids);
    }

    /**
     * @param questionPrize
     * @Description: 更新
     * @Reutrn Integer
     */
    public Integer update(QuestionPrize questionPrize){
        return questionPrizeMapper.updateByPrimaryKey(questionPrize);
    }

    /**
     * @param id
     * @Description: 通过ID查找
     * @Reutrn T
     */
    public QuestionPrize selectById(Integer id){
        QuestionPrize questionPrize = questionPrizeMapper.selectByPrimaryKey(id);
        if(questionPrize == null){
            throw new ServiceException("暂无此数据");
        }
        return questionPrize;
    }

    /**
     * @param condition
     * @Description: 根据条件查找
     * @Reutrn List<T>
     */
    public List<QuestionPrize> selectByCondition(Condition condition){
        return questionPrizeMapper.selectByCondition(condition);
    }

    /**
     * @Description: 获取所有
     * @Reutrn List<T>
     */
    public List<QuestionPrize> selectAll(){
        return questionPrizeMapper.selectAll();
    }

}
