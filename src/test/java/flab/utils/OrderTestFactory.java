package flab.utils;

import flab.resellPlatform.domain.order.OrderDTO;

public class OrderTestFactory {
    private OrderTestFactory() {}

    public static final long BUYER_ID = 1l;
    public static final long SELLER_ID = 2l;
    public static final long ADDRESS_ID = 1l;
    public static final long PRODUCT_ID = 1l;
    public static final long PRICE = 1l;
    public static final String SIZE = "270";


    public static OrderDTO.OrderDTOBuilder createOrderDTOBuilder() {
        return OrderDTO.builder()
                .buyerId(BUYER_ID)
                .sellerId(SELLER_ID)
                .addressId(ADDRESS_ID)
                .productId(PRODUCT_ID)
                .price(PRICE)
                .size(SIZE);
    }
}
