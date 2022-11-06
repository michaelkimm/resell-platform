package flab.resellPlatform.repository.sale;

import flab.resellPlatform.domain.sale.SaleEntity;

import java.util.Optional;

public interface SaleRepository {

    Optional<SaleEntity> getSaleInfo(long productId, String size);
    SaleEntity updateSaleInfo(SaleEntity saleEntity);
}
