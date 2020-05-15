package org.mankell.gmall.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.mankell.gmall.pms.entity.ProductAttributeCategory;
import org.mankell.gmall.pms.mapper.ProductAttributeCategoryMapper;
import org.mankell.gmall.pms.service.ProductAttributeCategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品属性分类表 服务实现类
 * </p>
 *
 * @author Mankell
 * @since 2020-05-14
 */
@Service
public class ProductAttributeCategoryServiceImpl extends ServiceImpl<ProductAttributeCategoryMapper, ProductAttributeCategory> implements ProductAttributeCategoryService {

}
