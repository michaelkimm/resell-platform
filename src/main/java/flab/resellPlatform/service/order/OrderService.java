package flab.resellPlatform.service.order;

import flab.resellPlatform.domain.order.OrderDTO;

public interface OrderService {

    OrderDTO createOrder(OrderDTO orderDTO);
}
