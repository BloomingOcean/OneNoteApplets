package com.company.project.message.servise;

import com.company.project.core.AbstractService;
import com.company.project.core.ServiceException;
import com.company.project.message.dao.MessageMapper;
import com.company.project.message.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

@Service("MessageService")
public class MessageServiceImpl extends AbstractService<Message> implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    /**
     * @param message
     * @Description: 插入数据
     * @Reutrn Integer
     */
    public Integer insert(Message message){
        return messageMapper.insert(message);
    }

    /**
     * @param id
     * @Description: 通过主鍵刪除
     * @Reutrn Integer
     */
    public Integer deleteById(Integer id){
        return messageMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param ids
     * @Description: 批量刪除 eg：ids -> “1,2,3,4”
     * @Reutrn Integer
     */
    public Integer deleteByIds(String ids){
        return messageMapper.deleteByIds(ids);
    }

    /**
     * @param message
     * @Description: 更新
     * @Reutrn Integer
     */
    public Integer update(Message message){
        return messageMapper.updateByPrimaryKey(message);
    }

    /**
     * @param id
     * @Description: 通过ID查找
     * @Reutrn T
     */
    public Message selectById(Integer id){
        Message message = messageMapper.selectByPrimaryKey(id);
        if(message == null){
            throw new ServiceException("暂无此数据");
        }
        return message;
    }

    /**
     * @param condition
     * @Description: 根据条件查找
     * @Reutrn List<T>
     */
    public List<Message> selectByCondition(Condition condition){
        return messageMapper.selectByCondition(condition);
    }

    /**
     * @Description: 获取所有
     * @Reutrn List<T>
     */
    public List<Message> selectAll(){
        return messageMapper.selectAll();
    }

}
