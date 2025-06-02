package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.iterators.ReverseListIterator;
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

    private List<String> list;

    private ReverseListIterator<String> reverseListIterator;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        reverseListIterator = new ReverseListIterator<>(list);
    }

    @Test
    void testAdd_ValidCase() {
        // Arrange
        String elementToAdd = "Test Element";
        // Act
        reverseListIterator.add(elementToAdd);
        // Assert
        assertEquals(1, list.size());
        assertEquals("Test Element", list.get(0));
    }

    @Test
    void testAdd_InvalidState() {
        // Arrange
        String elementToAdd = "Test Element";
        reverseListIterator.add(elementToAdd);
        // Act & Assert
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            reverseListIterator.add("Another Element");
        });
        assertEquals("Cannot add to list until next() or previous() called", exception.getMessage());
    }

    @Test
    void testAdd_ValidAfterNext() {
        // Arrange
        String firstElement = "First Element";
        reverseListIterator.add(firstElement);
        // Move back to the added element
        reverseListIterator.previous();
        // Act
        String secondElement = "Second Element";
        reverseListIterator.add(secondElement);
        // Assert
        assertEquals(2, list.size());
        assertEquals("First Element", list.get(0));
        assertEquals("Second Element", list.get(1));
    }

    @Test
    void testAdd_AfterSet() {
        // Arrange
        String firstElement = "First Element";
        reverseListIterator.add(firstElement);
        // Move back to the added element
        reverseListIterator.previous();
        reverseListIterator.set("Updated Element");
        // Act
        String secondElement = "Second Element";
        reverseListIterator.add(secondElement);
        // Assert
        assertEquals(2, list.size());
        assertEquals("Second Element", list.get(1));
    }
}
