package flab.resellPlatform.service.sale;

import flab.resellPlatform.domain.order.OrderEntity;
import flab.resellPlatform.domain.sale.SaleDTO;
import flab.resellPlatform.domain.sale.SaleEntity;
import flab.resellPlatform.repository.sale.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService{

    SaleRepository saleRepository;

    @Override
    @Transactional
    public SaleDTO purchaseImmediately(SaleDTO saleDTO) {
        // 1. 판매 서비스는 sale 테이블을 확인하여 남은 수량이 있는지 확인한다.
        SaleEntity saleEntity = saleRepository.getSaleInfo(saleDTO.getProductId(), saleDTO.getSize())
                                    .orElseThrow(() -> new RuntimeException("Sale info not found"));

        // 2. 판매 서비스는 남는 수량이 있으면 해당 수량을 감소 시킨 후 주문을 생성한다.
        if (!saleEntity.isStockLeft()) {
            throw new RuntimeException("Out of order");
        }
        saleEntity.decreaseStock();
        saleRepository.updateSaleInfo(saleEntity);

        // 3. 생성된 주문은 주문 테이블에 기록된다.
        return saleDTO;
    }
}
