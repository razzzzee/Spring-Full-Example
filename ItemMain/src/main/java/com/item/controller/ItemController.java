package com.item.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.item.exception.ResourceNotFoundException;
import com.item.model.Item;
import com.item.repository.ItemRepository;
@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemRepository itemRepository;
	@GetMapping("/getall")
	public List<Item> getAllItems() {
	    return itemRepository.findAll();
	}

	@PostMapping("/add")
	public Item createItem(@Valid @RequestBody Item item) {
	    return itemRepository.save(item);
	}
	@GetMapping("/getbyname/{name}")
	public List<Item> getItemByName(@PathVariable(value = "name") String itemName) {
	   List<Item> x=  itemRepository.findByItemName(itemName);
	   if(x==null)throw new ResourceNotFoundException("Item", "id", itemName);
	    return x;
 
	}
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<?> deleteItem(@PathVariable(value = "id")Long itemId) {
	    Item item = itemRepository.findById(itemId)
	          .orElseThrow(() ->new ResourceNotFoundException("Item", "id", itemId));

	    itemRepository.delete(item);

	    return ResponseEntity.ok().build();
	}

}
