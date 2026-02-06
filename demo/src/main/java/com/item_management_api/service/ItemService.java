package com.item_management_api.service;

import com.item_management_api.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private List<Item> itemList = new ArrayList<>();

    public Item addItem(Item item){
        itemList.add(item);
        return item;
    }

    public Optional<Item> getItemById(Long id){
        return itemList.stream()
                .filter(i->i.getId().equals(id)).findFirst();
    }
}
