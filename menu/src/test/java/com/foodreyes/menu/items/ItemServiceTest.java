package com.foodreyes.menu.items;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    Item item;
    List<Item> items;

    private static final Long ITEM_ID = 1L;

    @Mock
    ItemRepository itemRepository;

    ItemService itemService;

    @BeforeEach
    void setUp() {
        item = new Item();

        itemService = new ItemService(itemRepository);
    }

    @Test
    void createItem() {
        when(itemRepository.save(item)).thenReturn(item);

        Item returnedItem = itemService.createItem(item);

        Assertions.assertEquals(item, returnedItem, "Items do not match");
    }

    @Test
    void updateItem() {
        when(itemRepository.save(item)).thenReturn(item);

        Item returnedItem = itemService.createItem(item);

        Assertions.assertEquals(item, returnedItem, "Items do not match");
    }

    @Test
    void findAllItems() {
        when(itemRepository.findAll()).thenReturn(items);

        List<Item> returnedItems = itemService.findAllItems();

        Assertions.assertEquals(items, returnedItems, "Lists of items do not match");
    }

    @Test
    void findItemById() {
        when(itemRepository.findItemByItemId(ITEM_ID)).thenReturn(item);

        Item returnedItem = itemService.findItemById(ITEM_ID);

        Assertions.assertEquals(item, returnedItem, "Items do not match");
    }

    @Test
    void deleteItem() {
        when(itemRepository.findItemByItemId(ITEM_ID)).thenReturn(item);

        itemService.deleteItem(ITEM_ID);

        verify(itemRepository, times(1)).delete(item);
    }
}