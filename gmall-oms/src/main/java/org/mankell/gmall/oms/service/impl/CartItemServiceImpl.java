package org.mankell.gmall.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.mankell.gmall.oms.entity.CartItem;
import org.mankell.gmall.oms.mapper.CartItemMapper;
import org.mankell.gmall.oms.service.CartItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author Mankell
 * @since 2020-05-14
 */
@Service
public class CartItemServiceImpl extends ServiceImpl<CartItemMapper, CartItem> implements CartItemService {

}
