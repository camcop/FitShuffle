package com.qa.fitshuffle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.fitshuffle.domain.Item;
import com.qa.fitshuffle.repo.ItemRepo;

@Service
public class ItemService implements ServiceInterface<Item> {

	private final ItemRepo repo;

//	public void addNewItem(Item item) {
//		Optional<Item> itemByName = repo.findItemByName(item.getName());
//		if (itemByName.isPresent()) {
//			throw new IllegalStateException("Item name taken");
//		}
//		repo.save(item);
//	}

	public ItemService(ItemRepo repo) {
		super();
		this.repo = repo;
	}

// Create
	@Override
	public Item add(Item item) {
		Optional<Item> itemByName = repo.findItemByName(item.getName());
		if (itemByName.isPresent()) {
			throw new IllegalStateException("Item name taken");
		}
		return this.repo.save(item);
	}

//	Read all
	@Override
	public List<Item> getAll() {
		return this.repo.findAll();
	}

//	Read one
	@Override
	public Item getById(Long id) {
		return this.repo.findById(id).orElseThrow();
	}

//	Update
	@Override
	public Item updateById(Long id, Item item) {
		Item oldItem = this.repo.findById(id).orElseThrow();
		oldItem.setName(item.getName());
		oldItem.setType(item.getType());
		oldItem.setSubtype(item.getSubtype());
		oldItem.setBrand(item.getBrand());
		oldItem.setColour(item.getColour());
		return this.repo.save(oldItem);
	}

//	Delete	
	@Override
	public Item deleteById(Long id) {
		Optional<Item> deletedItem = this.repo.findById(id);
		this.repo.deleteById(id);
		return deletedItem.orElseThrow();
	}

}
