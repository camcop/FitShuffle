package com.qa.fitshuffle.service;

import com.qa.fitshuffle.domain.Item;
import com.qa.fitshuffle.repo.ItemRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class ItemServiceUnitTest {

    private Item newItem;
    private Item savedItem;

    @InjectMocks
    private ItemService service;

    @Mock
    private ItemRepo repo;

    @BeforeEach
    public void setUp() {
        newItem = new Item("Uniqlo hoodie","Top", "Hoodie", "Uniqlo", "Pink");
        savedItem = new Item(1L, "Uniqlo hoodie","Top", "Hoodie", "Uniqlo", "Pink");

        System.out.println("before");
    }

    @Test
    public void testAdd() {
//        System.out.println("add");

//        Given testing data above
        Optional<Item> optItem = Optional.of(savedItem);
//        When
        Mockito.when(this.repo.findItemByName(newItem.getName())).thenReturn(optItem);
        Mockito.when(this.repo.save(newItem)).thenReturn(savedItem);
//        Then
        assertThat(this.service.add(newItem)).isEqualTo(savedItem);
//        Verify
        Mockito.verify(this.repo, Mockito.times(1)).findItemByName(savedItem.getName());
        Mockito.verify(this.repo, Mockito.times(1)).save(newItem);
    }

    @Test
    public void testUpdate() {
        Long id = 1L;
        Item toUpdate = new Item("Sunspel hoodie","Top", "Hoodie", "Sunspel", "Indigo");
        Optional<Item> optItem = Optional.of(new Item(id,null, null, null, null, null));
        Item updated = new Item(id, toUpdate.getName(), toUpdate.getType(), toUpdate.getSubtype(), toUpdate.getBrand(), toUpdate.getColour());

//        When
        Mockito.when(this.repo.findById(id)).thenReturn(optItem);
        Mockito.when(this.repo.save(toUpdate)).thenReturn(updated);
//        Then
        assertThat(this.service.updateById(id, toUpdate)).isEqualTo(updated);
//        Verify
        Mockito.verify(this.repo, Mockito.times(1)).save(updated);
        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
    }

    @Test
    public void testDelete() {
//        Given
        Long id = 1L;
        Item deletedItem = new Item(id,"Sunspel hoodie","Top", "Hoodie", "Sunspel", "Indigo");
//        When
        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(deletedItem));
//        Then
        assertThat(this.service.deleteById(id)).isEqualTo(Optional.of(deletedItem));
//        Verify
        Mockito.verify(this.repo, Mockito.times(1)).deleteById(id);
        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
    }



//    @Test
//    public void addTest() {
//        Item testInput = new Item("Uniqlo hoodie","Top", "Hoodie", "Uniqlo", "Pink");
//        Item mockInput = new Item("Uniqlo hoodie","Top", "Hoodie", "Uniqlo", "Pink");
//        Mockito.when(this.service.add(testInput)).thenReturn(mockInput);
//        assertEquals(mockInput, this.service.add(testInput));
//        Mockito.verify(this.repo, Mockito.times(1)).save(testInput);
//    }

//    @Test
//    public void getByIDTest() {
//        Item item4 = new Item(4L,"Uniqlo hoodie","Top", "Hoodie", "Uniqlo", "Pink");
//        this.repo.save(item4);
//        Long validId  = 4L;
//        Optional<Item> validItem = Optional.ofNullable(new Item(4L,"Uniqlo hoodie","Top", "Hoodie", "Uniqlo", "Pink"));
//        Mockito.when(this.repo.findById(validId)).thenReturn(validItem);
//        assertEquals(validItem.get(), this.service.getById(validId));
//        Mockito.verify(this.repo, Mockito.times(1)).findById(validId);
//    }

//    @Test
//    public void testDeleteNonExistingItem() {
//        Long invalidId = 5L;
//        Mockito.when(this.repo.existsById(invalidId).thenReturn(false));
//        assertEquals(true, this.service.deleteById(invalidId));
//        Mockito.verify(this.repo, Mockito.times(1)).deleteById(invalidId);
//    }

}
