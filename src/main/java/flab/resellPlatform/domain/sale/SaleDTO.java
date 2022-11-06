package flab.resellPlatform.domain.sale;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO {
    private long buyerId;
    private long sellerId;
    private long addressId;
    private long productId;
    private long price;
    private String size;
}
