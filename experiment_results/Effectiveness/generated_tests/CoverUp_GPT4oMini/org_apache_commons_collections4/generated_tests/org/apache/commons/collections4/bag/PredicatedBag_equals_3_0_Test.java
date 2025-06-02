package org.apache.commons.collections4.bag;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.PredicatedBag;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Set;
import org.apache.commons.collections4.collection.PredicatedCollection;

class PredicatedBag_equals_3_0_Test {

    private static class TestPredicate implements Predicate<Object> {

        @Override
        public boolean evaluate(Object object) {
            // Simple predicate for testing
            return true;
        }
    }

    @Test
    void testEquals_SameInstance() {
        Bag<String> bag = new HashBag<>();
        Predicate<Object> predicate = new TestPredicate();
        PredicatedBag predicatedBag = new PredicatedBag(bag, predicate);
        assertTrue(predicatedBag.equals(predicatedBag), "Should be equal to itself");
    }

    @Test
    void testEquals_Null() {
        Bag<String> bag = new HashBag<>();
        Predicate<Object> predicate = new TestPredicate();
        PredicatedBag predicatedBag = new PredicatedBag(bag, predicate);
        assertFalse(predicatedBag.equals(null), "Should not be equal to null");
    }

    @Test
    void testEquals_DifferentClass() {
        Bag<String> bag = new HashBag<>();
        Predicate<Object> predicate = new TestPredicate();
        PredicatedBag predicatedBag = new PredicatedBag(bag, predicate);
        assertFalse(predicatedBag.equals("Not a Bag"), "Should not be equal to an object of a different class");
    }

    @Test
    void testEquals_EqualBags() {
        Bag<String> bag1 = new HashBag<>();
        bag1.add("item1");
        Bag<String> bag2 = new HashBag<>();
        bag2.add("item1");
        Predicate<Object> predicate = new TestPredicate();
        PredicatedBag predicatedBag1 = new PredicatedBag(bag1, predicate);
        PredicatedBag predicatedBag2 = new PredicatedBag(bag2, predicate);
        assertTrue(predicatedBag1.equals(predicatedBag2), "Should be equal to another PredicatedBag with the same contents");
    }

    @Test
    void testEquals_DifferentBags() {
        Bag<String> bag1 = new HashBag<>();
        bag1.add("item1");
        Bag<String> bag2 = new HashBag<>();
        bag2.add("item2");
        Predicate<Object> predicate = new TestPredicate();
        PredicatedBag predicatedBag1 = new PredicatedBag(bag1, predicate);
        PredicatedBag predicatedBag2 = new PredicatedBag(bag2, predicate);
        assertFalse(predicatedBag1.equals(predicatedBag2), "Should not be equal to another PredicatedBag with different contents");
    }

    @Test
    void testEquals_EqualToDecorated() {
        Bag<String> bag = new HashBag<>();
        bag.add("item1");
        Predicate<Object> predicate = new TestPredicate();
        PredicatedBag predicatedBag = new PredicatedBag(bag, predicate);
        assertTrue(predicatedBag.equals(bag), "Should be equal to the decorated bag");
    }

    @Test
    void testEquals_EqualToDifferentPredicate() {
        Bag<String> bag = new HashBag<>();
        Predicate<Object> predicate1 = new TestPredicate();
        Predicate<Object> predicate2 = new TestPredicate();
        PredicatedBag predicatedBag1 = new PredicatedBag(bag, predicate1);
        PredicatedBag predicatedBag2 = new PredicatedBag(bag, predicate2);
        assertTrue(predicatedBag1.equals(predicatedBag2), "Should be equal even with different predicates");
    }

    // Reflection test for private methods (if any)
    private Object invokePrivateMethod(String methodName, Object instance, Class<?>[] parameterTypes, Object... args) throws Exception {
        Method method = instance.getClass().getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method.invoke(instance, args);
    }
}
