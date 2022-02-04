package com.qa.fitshuffle.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.fitshuffle.domain.Item;
import com.qa.fitshuffle.service.ItemService;

@RestController
@RequestMapping
public class ItemController {

	// This should be the ServiceInterface apparently to adhere to Interface
	// Segregation principle of SOLID?
	private final ItemService service;

	@Autowired
	public ItemController(ItemService service) {
		super();
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Item> add(@RequestBody Item item) {
		this.service.add(item);
		return new ResponseEntity<Item>(item, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List> getAll() {
		return new ResponseEntity<List>(this.service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Item> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<Item>(this.service.getById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Item> updateById(@PathVariable("id") Long id, @RequestBody Item item) {
		return new ResponseEntity<Item>(this.service.updateById(id, item), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Item> deleteById(@PathVariable("id") Long id) {
		return new ResponseEntity<Item>(this.service.deleteById(id), HttpStatus.OK);
	}

}

// will need to update methods to take parameters or endpoints