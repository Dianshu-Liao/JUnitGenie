package org.apache.commons.collections4.bag;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Set;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

class AbstractBagDecorator_equals_2_0_Test {

    private TestBagDecorator testBag1;

    private TestBagDecorator testBag2;

    private TestBagDecorator testBag3;

    @BeforeEach
    void setUp() {
        Bag<String> bag1 = new HashBag<>();
        bag1.add("item1");
        bag1.add("item2");
        Bag<String> bag2 = new HashBag<>();
        bag2.add("item1");
        bag2.add("item2");
        Bag<String> bag3 = new HashBag<>();
        bag3.add("item3");
        testBag1 = new TestBagDecorator(bag1);
        testBag2 = new TestBagDecorator(bag2);
        testBag3 = new TestBagDecorator(bag3);
    }

    @Test
    void testEquals_SameInstance() {
        assertTrue(testBag1.equals(testBag1), "An instance should be equal to itself.");
    }

    @Test
    void testEquals_SameContentDifferentInstance() {
        assertTrue(testBag1.equals(testBag2), "Two bags with the same content should be equal.");
    }

    @Test
    void testEquals_DifferentContent() {
        assertFalse(testBag1.equals(testBag3), "Bags with different content should not be equal.");
    }

    @Test
    void testEquals_Null() {
        assertFalse(testBag1.equals(null), "A bag should not be equal to null.");
    }

    @Test
    void testEquals_DifferentType() {
        assertFalse(testBag1.equals("Not a Bag"), "A bag should not be equal to an object of a different type.");
    }

    static class TestBagDecorator extends AbstractBagDecorator {

        TestBagDecorator(Bag<?> bag) {
            super(bag);
        }
    }
}
