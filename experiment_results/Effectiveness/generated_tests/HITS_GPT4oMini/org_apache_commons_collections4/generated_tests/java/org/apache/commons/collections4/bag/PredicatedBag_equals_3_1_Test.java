package org.apache.commons.collections4.bag;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.bag.HashBag;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Set;
import org.apache.commons.collections4.collection.PredicatedCollection;

public class PredicatedBag_equals_3_1_Test {

    private PredicatedBag predicatedBag;

    @BeforeEach
    public void setUp() {
        Bag<String> bag = new HashBag<>();
        Predicate<String> predicate = new Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                // Example predicate
                return object != null;
            }
        };
        predicatedBag = new PredicatedBag(bag, predicate);
    }

    @Test
    public void testEquals_SameInstance() {
        // Test that equals returns true when comparing the same instance
        assertTrue(predicatedBag.equals(predicatedBag));
    }

    @Test
    public void testEquals_DifferentObject() {
        // Test that equals returns false when comparing to a different object
        Object differentObject = new Object();
        assertFalse(predicatedBag.equals(differentObject));
    }

    @Test
    public void testEquals_NullObject() {
        // Test that equals returns false when comparing to null
        assertFalse(predicatedBag.equals(null));
    }

    @Test
    public void testEquals_AnotherPredicatedBag() {
        // Test that equals returns false when comparing to another PredicatedBag instance
        Bag<String> bag = new HashBag<>();
        Predicate<String> predicate = new Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                // Example predicate
                return object != null;
            }
        };
        PredicatedBag anotherPredicatedBag = new PredicatedBag(bag, predicate);
        assertFalse(predicatedBag.equals(anotherPredicatedBag));
    }
}
