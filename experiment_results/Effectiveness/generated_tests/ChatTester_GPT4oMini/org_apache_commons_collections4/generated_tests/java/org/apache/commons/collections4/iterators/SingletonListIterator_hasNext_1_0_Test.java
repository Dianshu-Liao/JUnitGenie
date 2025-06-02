// Test method
package org.apache.commons.collections4.iterators;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class SingletonListIterator_hasNext_1_0_Test {

    private SingletonListIterator<String> iterator;

    @BeforeEach
    void setUp() {
        iterator = new SingletonListIterator<>("Test");
    }

    @Test
    void testHasNextBeforeFirst() {
        // Before first element, should return true
        assertTrue(iterator.hasNext());
    }

    @Test
    void testHasNextAfterNextCalled() throws Exception {
        // Simulate calling next() by using reflection
        invokeNextMethod(iterator);
        // After next() is called, should return false
        assertFalse(iterator.hasNext());
    }

    @Test
    void testHasNextAfterRemoval() throws Exception {
        // Simulate calling remove() by using reflection
        invokeRemoveMethod(iterator);
        // After removal, should return false
        assertFalse(iterator.hasNext());
    }

    @Test
    void testHasNextAfterSettingObject() throws Exception {
        // Simulate calling next() and then set() to check if hasNext() reflects that
        invokeNextMethod(iterator);
        invokeSetMethod(iterator, "NewTest");
        // After setting a new object, hasNext() should still return false
        assertFalse(iterator.hasNext());
    }

    private void invokeNextMethod(SingletonListIterator<String> iterator) throws Exception {
        Method nextMethod = SingletonListIterator.class.getDeclaredMethod("next");
        nextMethod.setAccessible(true);
        nextMethod.invoke(iterator);
    }

    private void invokeRemoveMethod(SingletonListIterator<String> iterator) throws Exception {
        Method removeMethod = SingletonListIterator.class.getDeclaredMethod("remove");
        removeMethod.setAccessible(true);
        removeMethod.invoke(iterator);
    }

    private void invokeSetMethod(SingletonListIterator<String> iterator, String object) throws Exception {
        Method setMethod = SingletonListIterator.class.getDeclaredMethod("set", Object.class);
        setMethod.setAccessible(true);
        setMethod.invoke(iterator, object);
    }
}
