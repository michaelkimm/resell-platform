package flab.resellPlatform.domain.order;

import flab.resellPlatform.domain.sale.SaleEntity;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    private long id;
    private long buyerId;
    private long sellerId;
    private long addressId;
    private long productId;
    private long price;
    private String size;

    public static OrderEntity createOrder(SaleEntity saleEntity) {
        return new OrderEntity();
    }

    public OrderEntity(long buyerId, long sellerId, long addressId, long productId, long price, String size) {
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.addressId = addressId;
        this.productId = productId;
        this.price = price;
        this.size = size;
    }
}
