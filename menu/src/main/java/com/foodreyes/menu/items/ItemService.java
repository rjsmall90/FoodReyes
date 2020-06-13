package com.foodreyes.menu.items;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ItemService {

    private final ItemRepository itemRepository;

    Item createItem(Item item){
        return itemRepository.save(item);
    }

    @Transactional
    Item updateItem(Item item) {
        return itemRepository.save(item);
    }

    List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    Item findItemById(Long itemId) {
        return itemRepository.getOne(itemId);
    }

    void deleteItem(Long itemId) {
        Item item = itemRepository.findItemByItemId(itemId);
        itemRepository.delete(item);
    }

}
