package org.mankell.gmall.pms.service;

import org.mankell.gmall.pms.entity.Brand;
import com.baomidou.mybatisplus.extension.service.IService;
import org.mankell.gmall.vo.PageInfoVO;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author Mankell
 * @since 2020-05-14
 */
public interface BrandService extends IService<Brand> {

    PageInfoVO getBrandPageInfo(String keyword, Long pageNum, Long pageSize);
}
