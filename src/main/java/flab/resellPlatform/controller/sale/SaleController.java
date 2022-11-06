package flab.resellPlatform.controller.sale;

import flab.resellPlatform.common.response.StandardResponse;
import flab.resellPlatform.domain.order.OrderDTO;
import flab.resellPlatform.domain.sale.SaleDTO;
import flab.resellPlatform.service.order.OrderService;
import flab.resellPlatform.service.sale.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/sale")
@RequiredArgsConstructor
public class SaleController {

    private final MessageSourceAccessor messageSourceAccessor;
    private final SaleService saleService;

    @PostMapping()
    public StandardResponse purchaseImmediately(@RequestBody SaleDTO saleDTO) {

        saleService.purchaseImmediately(saleDTO);

        StandardResponse standardResponse = StandardResponse.builder()
                .message(messageSourceAccessor.getMessage("order.create.success"))
                .data(Map.of())
                .build();
        return standardResponse;
    }
}
