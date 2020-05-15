package org.mankell.gmall.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.mankell.gmall.sms.entity.HomeRecommendProduct;
import org.mankell.gmall.sms.mapper.HomeRecommendProductMapper;
import org.mankell.gmall.sms.service.HomeRecommendProductService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人气推荐商品表 服务实现类
 * </p>
 *
 * @author Mankell
 * @since 2020-05-14
 */
@Service
public class HomeRecommendProductServiceImpl extends ServiceImpl<HomeRecommendProductMapper, HomeRecommendProduct> implements HomeRecommendProductService {

}
