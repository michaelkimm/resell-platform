package flab.resellPlatform.controller.sale;

import flab.resellPlatform.MessageConfig;
import flab.resellPlatform.SecurityConfig;
import flab.resellPlatform.domain.sale.SaleDTO;
import flab.resellPlatform.service.sale.SaleService;
import flab.utils.SaleTestFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {SaleController.class},
        excludeAutoConfiguration = SecurityAutoConfiguration.class,
        excludeFilters = {
                @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)})
@Import(MessageConfig.class)
@WithMockUser
class SaleControllerTest {

    @MockBean
    SaleService saleService;

    @Autowired
    MockMvc mockMvc;

    SaleDTO saleDTO;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        saleDTO = SaleTestFactory.createSaleDTOBuilder().build();
    }

    @DisplayName("즉시 구매 성공")
    @Test
    void purchaseImmediately_success() throws Exception {
        // when
        when(saleService.purchaseImmediately(any())).thenReturn(saleDTO);
        String orderData = objectMapper.writeValueAsString(saleDTO);

        // then
        ResultActions resultActions = mockMvc.perform(post("/sale")
                .contentType(MediaType.APPLICATION_JSON)
                .content(orderData)
                .with(csrf()));

        // given
        resultActions.andExpect(status().isOk());
    }
}