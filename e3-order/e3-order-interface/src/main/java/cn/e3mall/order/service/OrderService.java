package cn.e3mall.order.service;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.order.pojo.OrderInfo;

public interface OrderService {

	E3Result createOrder(OrderInfo orderInfo);
}
