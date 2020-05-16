package org.mankell.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.mankell.gmall.constant.SystemCacheConstant;
import org.mankell.gmall.pms.entity.ProductCategory;
import org.mankell.gmall.pms.mapper.ProductCategoryMapper;
import org.mankell.gmall.pms.service.ProductCategoryService;
import org.mankell.gmall.vo.product.PmsProductCategoryWithChildrenItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 *
 * @author Mankell
 * @since 2020-05-14
 */
@Service
@Component
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

    @Autowired(required = false)
    private ProductCategoryMapper productCategoryMapper;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override

    public List<PmsProductCategoryWithChildrenItem> getListWithChildren(Integer i) {
        List<PmsProductCategoryWithChildrenItem> items;
        Object systemMenu = redisTemplate.opsForValue().get(SystemCacheConstant.SYSTEM_MENU);
        if (systemMenu != null) {
            items = (List<PmsProductCategoryWithChildrenItem>) systemMenu;
        } else {
            items = productCategoryMapper.selectListWithChildren(i);
            redisTemplate.opsForValue().set(SystemCacheConstant.SYSTEM_MENU, items);
        }
        return items;
    }
}
