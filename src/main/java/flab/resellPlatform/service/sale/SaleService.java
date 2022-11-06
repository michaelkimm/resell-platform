package flab.resellPlatform.service.sale;

import flab.resellPlatform.domain.order.OrderDTO;
import flab.resellPlatform.domain.sale.SaleDTO;

public interface SaleService {

    SaleDTO purchaseImmediately(SaleDTO saleDTO);
}
