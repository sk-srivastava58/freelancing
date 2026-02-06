package com.item_management_api.controller;

import com.item_management_api.model.Item;
import com.item_management_api.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Item> addItem(@Valid @RequestBody Item item){
        return ResponseEntity.ok(itemService.addItem(item));

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable Long id){
        return itemService.getItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
