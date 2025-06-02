package org.apache.commons.collections4.iterators;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

public class SingletonListIterator_remove_7_0_Test {

    private SingletonListIterator<String> iterator;

    @BeforeEach
    public void setUp() {
        iterator = new SingletonListIterator<>("test");
    }

    @Test
    public void testRemoveBeforeNextCalled() {
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            iterator.remove();
        });
        assertEquals("IllegalStateException expected", thrown.getMessage());
    }

    @Test
    public void testRemoveAfterNextCalled() {
        // Call next to set nextCalled to true
        iterator.next();
        // Now remove should work
        iterator.remove();
        assertThrows(IllegalStateException.class, () -> {
            // Should throw IllegalStateException as it's already removed
            iterator.remove();
        });
    }

    @Test
    public void testRemoveAfterNextCalledAndObjectIsNull() {
        iterator.next();
        // Remove the object
        iterator.remove();
        assertThrows(IllegalStateException.class, () -> {
            // Should throw IllegalStateException as the object was removed
            iterator.set("new value");
        });
    }

    @Test
    public void testRemoveAfterSetCalled() {
        // Call next to set nextCalled to true
        iterator.next();
        // Set new value
        iterator.set("new value");
        // Now remove should work
        iterator.remove();
        assertThrows(IllegalStateException.class, () -> {
            // Should throw IllegalStateException as it's already removed
            iterator.set("another value");
        });
    }

    @Test
    public void testRemoveDoesNotAffectHasNext() {
        // Call next to set nextCalled to true
        iterator.next();
        // Now remove should work
        iterator.remove();
        assertFalse(iterator.hasNext(), "hasNext should return false after remove");
    }
}
