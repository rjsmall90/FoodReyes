package com.foodreyes.menu.orders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class CustomerOrderControllerTest {

    private CustomerOrder customerOrder;

    private static final Long ORDER_NUMBER = 1L;

    @Mock
    private CustomerOrderService customerOrderService;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @BeforeEach
    void setUp() {
        customerOrder = new CustomerOrder();

        mockMvc = MockMvcBuilders.standaloneSetup(new CustomerOrderController(customerOrderService)).build();
    }

    @Test
    void submitPaidOrder() throws Exception {
        mockMvc.perform(put("/api/orders/" + ORDER_NUMBER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customerOrder)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }
}