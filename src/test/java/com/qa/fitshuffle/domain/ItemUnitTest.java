package com.qa.fitshuffle.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
public class ItemUnitTest {

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Item.class).usingGetClass()
                .withPrefabValues(Item.class, new Item("Uniqlo hoodie","Top", "Hoodie", "Uniqlo", "Pink"), new Item()).verify();
    }
    @Test
    public void testConstructorwithID() {
        Item item = new Item("Uniqlo hoodie","Top", "Hoodie", "Uniqlo", "Pink");
        //If this has been constructed and the values have been placed in
        // Then nothing inside of here should be Null
        assertNotNull(item.getId());
        assertNotNull(item.getName());

        //Weve entered the primitive Long - And we are getting back the Object Long
        assertEquals(Optional.of(1), item.getId());
        assertEquals("Uniqlo hoodie", item.getName());

    }
    //Try and make the ToString Test

    @Test
    public void testToString() {
        Item item = new Item("Uniqlo hoodie","Top", "Hoodie", "Uniqlo", "Pink");
        assertEquals("Item{id=1, name=Uniqlo hoodie, type=Top, subtype=Hoodie, brand=Uniqlo, colour=Pink", item.toString());
    }

}

