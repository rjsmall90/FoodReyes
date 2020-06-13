package com.foodreyes.menu.items;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ItemService {

    private final ItemRepository itemRepository;

    public Item save(Item item){
        return itemRepository.saveAndFlush(item);
    }

    public Item update(Item item) {
        return itemRepository.save(item);
    }

    List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public Item findItemById(Long itemId) {
        return itemRepository.getOne(itemId);
    }

    public void delete(Item item) {
        itemRepository.delete(item);
    }

}
