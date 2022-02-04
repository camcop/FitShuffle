package com.qa.fitshuffle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.fitshuffle.domain.Item;

import java.util.Optional;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {

//	Method to retrieve WardrobeItem from database by name
//	Item getByName(String name);

//	@Query("SELECT i FROM Item WHERE Item.name = ?1")
	Optional<Item> findItemByName(String name);
}

// Where is this implemented???