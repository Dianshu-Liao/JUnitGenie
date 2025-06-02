package org.apache.commons.collections4.iterators;

import java.util.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.list.UnmodifiableList;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CollatingIterator_remove_11_4_Test {

    private CollatingIterator<String> collatingIterator;

    private List<Iterator<String>> mockIterators;

    @BeforeEach
    public void setUp() {
        mockIterators = new ArrayList<>();
        mockIterators.add(mock(Iterator.class));
        mockIterators.add(mock(Iterator.class));
        // Fixed Buggy Line: Specify the type argument explicitly
        collatingIterator = new CollatingIterator<>(String::compareTo, (List) mockIterators);
    }

    @Test
    public void testRemove_NoValueReturned_ThrowsIllegalStateException() {
        // Arrange & Act
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            collatingIterator.remove();
        });
        // Assert
        assertEquals("No value can be removed at present", exception.getMessage());
    }

    @Test
    public void testRemove_ValueReturned_RemovesFromIterator() throws Exception {
        // Arrange
        setLastReturnedField(collatingIterator, 0);
        Iterator<String> mockIterator = mockIterators.get(0);
        when(mockIterator.hasNext()).thenReturn(true);
        when(mockIterator.next()).thenReturn("value");
        // Act
        collatingIterator.remove();
        // Assert
        verify(mockIterator).remove();
    }

    @Test
    public void testRemove_ValueReturnedFromSecondIterator_RemovesFromSecondIterator() throws Exception {
        // Arrange
        setLastReturnedField(collatingIterator, 1);
        Iterator<String> mockIterator = mockIterators.get(1);
        when(mockIterator.hasNext()).thenReturn(true);
        when(mockIterator.next()).thenReturn("value");
        // Act
        collatingIterator.remove();
        // Assert
        verify(mockIterator).remove();
    }

    @Test
    public void testRemove_ValueReturned_ThrowsExceptionIfNoNext() throws Exception {
        // Arrange
        setLastReturnedField(collatingIterator, 0);
        Iterator<String> mockIterator = mockIterators.get(0);
        // No next value
        when(mockIterator.hasNext()).thenReturn(false);
        // Act & Assert
        assertThrows(IllegalStateException.class, () -> {
            collatingIterator.remove();
        });
    }

    private void setLastReturnedField(CollatingIterator<String> iterator, int value) throws Exception {
        java.lang.reflect.Field field = CollatingIterator.class.getDeclaredField("lastReturned");
        field.setAccessible(true);
        field.setInt(iterator, value);
    }
}
