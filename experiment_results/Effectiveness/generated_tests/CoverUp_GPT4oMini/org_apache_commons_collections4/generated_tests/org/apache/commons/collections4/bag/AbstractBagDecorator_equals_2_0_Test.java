package org.apache.commons.collections4.bag;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.AbstractBagDecorator;
import org.apache.commons.collections4.bag.HashBag;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Set;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

class AbstractBagDecorator_equals_2_0_Test {

    private TestBagDecorator testBagDecorator1;

    private TestBagDecorator testBagDecorator2;

    private TestBagDecorator testBagDecorator3;

    @BeforeEach
    void setUp() {
        Bag<String> bag1 = new HashBag<>();
        bag1.add("item1");
        testBagDecorator1 = new TestBagDecorator(bag1);
        Bag<String> bag2 = new HashBag<>();
        bag2.add("item1");
        testBagDecorator2 = new TestBagDecorator(bag2);
        Bag<String> bag3 = new HashBag<>();
        bag3.add("item2");
        testBagDecorator3 = new TestBagDecorator(bag3);
    }

    @Test
    void testEquals_SameInstance() {
        assertTrue(testBagDecorator1.equals(testBagDecorator1));
    }

    @Test
    void testEquals_SameContent() {
        assertTrue(testBagDecorator1.equals(testBagDecorator2));
    }

    @Test
    void testEquals_DifferentContent() {
        assertFalse(testBagDecorator1.equals(testBagDecorator3));
    }

    @Test
    void testEquals_Null() {
        assertFalse(testBagDecorator1.equals(null));
    }

    @Test
    void testEquals_DifferentType() {
        assertFalse(testBagDecorator1.equals("Not a Bag"));
    }

    private static class TestBagDecorator extends AbstractBagDecorator<String> {

        protected TestBagDecorator() {
            super();
        }

        protected TestBagDecorator(final Bag<String> bag) {
            super(bag);
        }
    }
}
