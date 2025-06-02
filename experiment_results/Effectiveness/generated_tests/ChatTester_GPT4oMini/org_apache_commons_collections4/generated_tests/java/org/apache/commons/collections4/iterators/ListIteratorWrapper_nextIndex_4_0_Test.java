package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.MessageFormat;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.ResettableListIterator;

public class ListIteratorWrapper_nextIndex_4_0_Test {

    private ListIteratorWrapper<String> listIteratorWrapper;

    private ListIterator<String> mockListIterator;

    @BeforeEach
    public void setUp() {
        // Create a mock ListIterator
        mockListIterator = mock(ListIterator.class);
    }

    @Test
    public void testNextIndex_WhenIteratorIsListIterator() {
        // Arrange
        when(mockListIterator.nextIndex()).thenReturn(2);
        listIteratorWrapper = new ListIteratorWrapper<>(mockListIterator);
        // Act
        int result = listIteratorWrapper.nextIndex();
        // Assert
        assertEquals(2, result);
    }

    @Test
    public void testNextIndex_WhenIteratorIsNotListIterator() {
        // Arrange
        Iterator<String> mockIterator = mock(Iterator.class);
        listIteratorWrapper = new ListIteratorWrapper<>(mockIterator);
        // Act
        int result = listIteratorWrapper.nextIndex();
        // Assert
        // Assuming currentIndex is initialized to 0
        assertEquals(0, result);
    }
}
