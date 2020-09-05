package com.company.project.shop.service;

import com.company.project.core.AbstractService;
import com.company.project.core.ServiceException;
import com.company.project.shop.dao.ShopMapper;
import com.company.project.shop.dto.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

@Service("ShopService")
public class ShopServiceImpl extends AbstractService<Shop> implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    /**
     * @param shop
     * @Description: 插入数据
     * @Reutrn Integer
     */
    public Integer insert(Shop shop){
        return shopMapper.insert(shop);
    }

    /**
     * @param id
     * @Description: 通过主鍵刪除
     * @Reutrn Integer
     */
    public Integer deleteById(Integer id){
        return shopMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param ids
     * @Description: 批量刪除 eg：ids -> “1,2,3,4”
     * @Reutrn Integer
     */
    public Integer deleteByIds(String ids){
        return shopMapper.deleteByIds(ids);
    }

    /**
     * @param shop
     * @Description: 更新
     * @Reutrn Integer
     */
    public Integer update(Shop shop){
        return shopMapper.updateByPrimaryKey(shop);
    }

    /**
     * @param id
     * @Description: 通过ID查找
     * @Reutrn T
     */
    public Shop selectById(Integer id){
        Shop shop = shopMapper.selectByPrimaryKey(id);
        if(shop == null){
            throw new ServiceException("暂无此数据");
        }
        return shop;
    }

    /**
     * @param condition
     * @Description: 根据条件查找
     * @Reutrn List<T>
     */
    public List<Shop> selectByCondition(Condition condition){
        return shopMapper.selectByCondition(condition);
    }

    /**
     * @Description: 获取所有
     * @Reutrn List<T>
     */
    public List<Shop> selectAll(){
        return shopMapper.selectAll();
    }
}
