package org.mankell.gmall.pms.service;

import org.mankell.gmall.pms.entity.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import org.mankell.gmall.vo.product.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * <p>
 * 产品分类 服务类
 * </p>
 *
 * @author Mankell
 * @since 2020-05-14
 */
public interface ProductCategoryService extends IService<ProductCategory> {

    List<PmsProductCategoryWithChildrenItem> getListWithChildren(Integer i);
}
