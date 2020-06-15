package com.foodreyes.menu.carts;

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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class CartSelectionControllerTest {

    private List<CartSelectionDTO> cartSelectionDTOS;
    private CartSelection cartSelection;

    private final static UUID TEST_CUSTOMER_ID = UUID.fromString("5352522f-48a2-4bb9-8108-3b432a99bd6b");
    private final static Long TEST_CART_ID = 1L;

    @Mock
    private CartSelectionService cartSelectionService;

    private ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        cartSelectionDTOS = new ArrayList<>();

        cartSelection = new CartSelection();

        mockMvc = MockMvcBuilders.standaloneSetup(new CartSelectionController(cartSelectionService)).build();
    }

    @Test
    void addItemToCart() throws Exception {
        mockMvc.perform(post("/api/carts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cartSelection)))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();

    }

    @Test
    void findAllCartSelectionsForCustomer() throws Exception {
        mockMvc.perform(get("/api/carts/" + TEST_CUSTOMER_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cartSelectionDTOS)))
                .andExpect(status().isOk());
    }

    @Test
    void removeItemFromCart() throws Exception {
        mockMvc.perform(delete("/api/carts/" + TEST_CART_ID + "/" + TEST_CUSTOMER_ID))
                .andExpect(status().isNoContent());
    }
}