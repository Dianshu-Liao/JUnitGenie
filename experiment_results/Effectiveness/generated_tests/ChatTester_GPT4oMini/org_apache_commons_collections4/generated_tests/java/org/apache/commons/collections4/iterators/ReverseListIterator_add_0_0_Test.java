package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.collections4.ResettableListIterator;

class ReverseListIterator_add_0_0_Test {

    private ReverseListIterator<String> reverseListIterator;

    private List<String> list;

    private ListIterator<String> mockIterator;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        mockIterator = Mockito.mock(ListIterator.class);
        reverseListIterator = new ReverseListIterator<>(list);
        // Using reflection to set the private iterator field
        try {
            java.lang.reflect.Field iteratorField = ReverseListIterator.class.getDeclaredField("iterator");
            iteratorField.setAccessible(true);
            iteratorField.set(reverseListIterator, mockIterator);
        } catch (Exception e) {
            fail("Failed to set up the mock iterator: " + e.getMessage());
        }
    }

    @Test
    void testAddValid() {
        // Arrange
        String obj = "Hello";
        // Act
        reverseListIterator.add(obj);
        // Assert
        Mockito.verify(mockIterator).add(obj);
        Mockito.verify(mockIterator).previous();
    }

    @Test
    void testAddInvalidState() {
        // Arrange
        String obj = "Hello";
        // First call to add should succeed
        reverseListIterator.add(obj);
        // Act & Assert
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            // Second call should throw exception
            reverseListIterator.add("World");
        });
        assertEquals("Cannot add to list until next() or previous() called", thrown.getMessage());
    }

    @Test
    void testAddAfterNextOrPrevious() {
        // Arrange
        String obj = "Hello";
        Mockito.when(mockIterator.hasNext()).thenReturn(true);
        Mockito.when(mockIterator.hasPrevious()).thenReturn(true);
        Mockito.when(mockIterator.next()).thenReturn("Test");
        Mockito.when(mockIterator.previous()).thenReturn("Test");
        // Act
        // First call to add
        reverseListIterator.add(obj);
        // Second call to add
        reverseListIterator.add("World");
        // Assert
        Mockito.verify(mockIterator, Mockito.times(2)).add(Mockito.anyString());
        Mockito.verify(mockIterator, Mockito.times(2)).previous();
    }
}
