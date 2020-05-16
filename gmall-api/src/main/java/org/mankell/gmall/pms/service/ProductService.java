package org.mankell.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.mankell.gmall.pms.entity.Product;
import org.mankell.gmall.vo.PageInfoVO;
import org.mankell.gmall.vo.product.PmsProductQueryParam;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author Mankell
 * @since 2020-05-14
 */
public interface ProductService extends IService<Product> {

    PageInfoVO getPageInfo(PmsProductQueryParam productQueryParam);
}
