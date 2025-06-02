package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.text.MessageFormat;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.ResettableListIterator;

class ListIteratorWrapper_previousIndex_6_0_Test {

    private ListIteratorWrapper listIteratorWrapper;

    private ListIterator<String> mockListIterator;

    @BeforeEach
    void setUp() {
        // Create a mock ListIterator
        mockListIterator = mock(ListIterator.class);
    }

    @Test
    void testPreviousIndexWithListIterator() {
        // Arrange
        when(mockListIterator.previousIndex()).thenReturn(2);
        listIteratorWrapper = new ListIteratorWrapper(mockListIterator);
        // Act
        int index = listIteratorWrapper.previousIndex();
        // Assert
        assertEquals(2, index);
        verify(mockListIterator).previousIndex();
    }

    @Test
    void testPreviousIndexWithoutListIterator() {
        // Arrange
        Iterator<String> simpleIterator = new ArrayList<String>().iterator();
        listIteratorWrapper = new ListIteratorWrapper(simpleIterator);
        // Act
        int index = listIteratorWrapper.previousIndex();
        // Assert
        // currentIndex is initialized to 0
        assertEquals(-1, index);
    }

    @Test
    void testPreviousIndexWithCurrentIndexSet() {
        // Arrange
        Iterator<String> simpleIterator = new ArrayList<String>().iterator();
        listIteratorWrapper = new ListIteratorWrapper(simpleIterator);
        // Use reflection to set currentIndex
        setPrivateField(listIteratorWrapper, "currentIndex", 3);
        // Act
        int index = listIteratorWrapper.previousIndex();
        // Assert
        // currentIndex is 3, so previousIndex should return 2
        assertEquals(2, index);
    }

    @Test
    void testPreviousIndexWithNegativeCurrentIndex() {
        // Arrange
        Iterator<String> simpleIterator = new ArrayList<String>().iterator();
        listIteratorWrapper = new ListIteratorWrapper(simpleIterator);
        // Use reflection to set currentIndex to a negative value
        setPrivateField(listIteratorWrapper, "currentIndex", -1);
        // Act
        int index = listIteratorWrapper.previousIndex();
        // Assert
        // currentIndex is -1, so previousIndex should return -1
        assertEquals(-1, index);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            // Fixed the buggy line by replacing 'var' with 'java.lang.reflect.Field'
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }
}
