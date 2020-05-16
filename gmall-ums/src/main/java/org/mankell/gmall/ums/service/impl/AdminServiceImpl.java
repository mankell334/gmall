package org.mankell.gmall.ums.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.mankell.gmall.ums.entity.Admin;
import org.mankell.gmall.ums.mapper.AdminMapper;
import org.mankell.gmall.ums.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author Mankell
 * @since 2020-05-14
 */
@Component
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired(required = false)
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {

        String s = DigestUtils.md5DigestAsHex(password.getBytes());

        QueryWrapper<Admin> queryWrapper = new QueryWrapper<Admin>().eq("username", username).eq("password", s);

        Admin admin = adminMapper.selectOne(queryWrapper);

        return admin;
    }

    @Override
    public Admin getUserInfo(String userName) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<Admin>().eq("username", userName);
        Admin admin = adminMapper.selectOne(queryWrapper);
        return admin;
    }
}
