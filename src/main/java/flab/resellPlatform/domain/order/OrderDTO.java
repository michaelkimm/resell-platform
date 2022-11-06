package flab.resellPlatform.domain.order;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private long buyerId;
    private long sellerId;
    private long addressId;
    private long productId;
    private long price;
    private String size;
}
