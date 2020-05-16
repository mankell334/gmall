package org.mankell.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.mankell.gmall.pms.entity.Product;
import org.mankell.gmall.pms.mapper.ProductMapper;
import org.mankell.gmall.pms.service.ProductService;
import org.mankell.gmall.vo.PageInfoVO;
import org.mankell.gmall.vo.product.PmsProductQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author Mankell
 * @since 2020-05-14
 */
@Component
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired(required = false)
    private ProductMapper productMapper;

    @Override
    public PageInfoVO getPageInfo(PmsProductQueryParam productQueryParam) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(productQueryParam.getKeyword())) {
            queryWrapper.like("name", productQueryParam.getKeyword());
        }

        if (!StringUtils.isEmpty(productQueryParam.getProductSn())) {
            queryWrapper.like("product_sn", productQueryParam.getProductSn());
        }

        if (productQueryParam.getProductCategoryId() != null) {
            queryWrapper.eq("product_category_id", productQueryParam.getProductCategoryId());
        }

        if (productQueryParam.getVerifyStatus() != null) {
            queryWrapper.eq("verify_status", productQueryParam.getVerifyStatus());
        }

        if (productQueryParam.getPublishStatus() != null) {
            queryWrapper.eq("publish_status", productQueryParam.getPublishStatus());
        }

        if (productQueryParam.getBrandId() != null) {
            queryWrapper.eq("brand_id", productQueryParam.getBrandId());
        }



        IPage<Product> page = productMapper.selectPage(new Page<>(productQueryParam.getPageNum(),
                productQueryParam.getPageSize()), queryWrapper);

        PageInfoVO pageInfoVO = new PageInfoVO(page.getTotal(), page.getPages(),
                page.getSize(), page.getRecords(), page.getCurrent());

        return pageInfoVO;
    }
}
