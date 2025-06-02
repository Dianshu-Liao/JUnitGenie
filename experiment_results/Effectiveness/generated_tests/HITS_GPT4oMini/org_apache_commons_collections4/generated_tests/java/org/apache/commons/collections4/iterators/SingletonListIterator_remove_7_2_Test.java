package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.ResettableListIterator;

public class // This test is removed since we can't access nextCalled directly.
SingletonListIterator_remove_7_2_Test {

    private SingletonListIterator<String> iterator;

    @BeforeEach
    public void setUp() {
        iterator = new SingletonListIterator<>("Test Object");
    }

    @Test
    public void testRemove_ThrowsIllegalStateException_WhenNextNotCalled() {
        assertThrows(IllegalStateException.class, () -> {
            iterator.remove();
        });
    }

    @Test
    public void testRemove_ThrowsIllegalStateException_WhenAlreadyRemoved() {
        // Call next to set nextCalled to true
        iterator.next();
        // First remove should work
        iterator.remove();
        assertThrows(IllegalStateException.class, () -> {
            // Second remove should throw exception
            iterator.remove();
        });
    }

    @Test
    public void testRemove_SuccessfullyRemovesObject_WhenValidState() {
        // Call next to set nextCalled to true
        iterator.next();
        assertDoesNotThrow(() -> {
            // Should execute without throwing exception
            iterator.remove();
        });
        // Additional assertions can be added to check the state after removal if needed
    }

    @Test
    public void testRemove_DoesNotAllowRemove_WhenNextNotCalled() {
        assertThrows(IllegalStateException.class, () -> {
            iterator.remove();
        });
    }
}
