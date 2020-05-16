package org.mankell.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.mankell.gmall.pms.entity.Brand;
import org.mankell.gmall.pms.mapper.BrandMapper;
import org.mankell.gmall.pms.service.BrandService;
import org.mankell.gmall.vo.PageInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author Mankell
 * @since 2020-05-14
 */
@Component
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Autowired(required = false)
    private BrandMapper brandMapper;

    @Override
    public PageInfoVO getBrandPageInfo(String keyword, Long pageNum, Long pageSize) {
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(keyword)) {
            queryWrapper.like("name", keyword);
        }
        IPage<Brand> page = brandMapper.selectPage(new Page<>(pageNum, pageSize), queryWrapper);
        PageInfoVO pageInfoVO = new PageInfoVO(page.getTotal(), page.getPages(),
                page.getSize(), page.getRecords(), page.getCurrent());
        return pageInfoVO;
    }
}
