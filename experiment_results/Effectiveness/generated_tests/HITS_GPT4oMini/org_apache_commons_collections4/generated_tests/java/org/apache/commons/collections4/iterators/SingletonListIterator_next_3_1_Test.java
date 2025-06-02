package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.ResettableListIterator;

public class SingletonListIterator_next_3_1_Test {

    private SingletonListIterator<String> iterator;

    @BeforeEach
    public void setUp() {
        iterator = new SingletonListIterator<>("Test Object");
    }

    @Test
    public void testNext_ReturnsObject_WhenCalledFirstTime() {
        // Act
        String result = iterator.next();
        // Assert
        assertEquals("Test Object", result);
    }

    @Test
    public void testNext_ThrowsNoSuchElementException_WhenCalledAfterNext() {
        // Arrange
        // Call next once
        iterator.next();
        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> {
            // Call next again
            iterator.next();
        });
    }

    @Test
    public void testNext_ThrowsNoSuchElementException_AfterRemoval() {
        // Arrange
        // Call next once
        iterator.next();
        // Simulate removal
        iterator.remove();
        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> {
            // Call next after removal
            iterator.next();
        });
    }

    @Test
    public void testNext_ThrowsNoSuchElementException_BeforeFirstCall() {
        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> {
            // Call next without calling it first
            iterator.next();
        });
    }
}
