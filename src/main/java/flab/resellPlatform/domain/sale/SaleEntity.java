package flab.resellPlatform.domain.sale;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SaleEntity {

    private long id;
    private long productId;
    private String size;
    private long sellerId;
    private int quantity;

    public SaleEntity(long productId, String size, long sellerId, int quantity) {
        this.productId = productId;
        this.size = size;
        this.sellerId = sellerId;
        this.quantity = quantity;
    }

    public boolean isStockLeft() {
        return quantity != 0;
    }

    public void decreaseStock() {
        quantity -= 1;
    }
}
