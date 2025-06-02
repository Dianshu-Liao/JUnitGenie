package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BoundedIterator_init_2_0_Test {

    private BoundedIterator<String> boundedIterator;

    private Iterator<String> mockIterator;

    @BeforeEach
    public void setUp() {
        mockIterator = mock(Iterator.class);
    }

    @Test
    public void testInit_WithElementsBeforeOffset() throws Exception {
        // Arrange
        // Two elements, then no more
        when(mockIterator.hasNext()).thenReturn(true, true, false);
        when(mockIterator.next()).thenReturn("element1", "element2");
        boundedIterator = new BoundedIterator<>(mockIterator, 2, 5);
        // Act
        invokeInitMethod(boundedIterator);
        // Assert
        // Should have called next() twice
        verify(mockIterator, times(2)).next();
        // Position should be at offset
        assertEquals(2, getPos(boundedIterator));
    }

    @Test
    public void testInit_ExactlyAtOffset() throws Exception {
        // Arrange
        // Two elements, then no more
        when(mockIterator.hasNext()).thenReturn(true, true, false);
        when(mockIterator.next()).thenReturn("element1", "element2");
        boundedIterator = new BoundedIterator<>(mockIterator, 2, 2);
        // Act
        invokeInitMethod(boundedIterator);
        // Assert
        // Should not have called next() at all
        verify(mockIterator, never()).next();
        // Position should be at offset
        assertEquals(0, getPos(boundedIterator));
    }

    @Test
    public void testInit_NoElementsAvailable() throws Exception {
        // Arrange
        // No elements in iterator
        when(mockIterator.hasNext()).thenReturn(false);
        boundedIterator = new BoundedIterator<>(mockIterator, 5, 10);
        // Act
        invokeInitMethod(boundedIterator);
        // Assert
        // Should not have called next() at all
        verify(mockIterator, never()).next();
        // Position should remain at 0
        assertEquals(0, getPos(boundedIterator));
    }

    @Test
    public void testInit_SkipsToOffsetWithMoreElements() throws Exception {
        // Arrange
        // Three elements, then no more
        when(mockIterator.hasNext()).thenReturn(true, true, true, false);
        when(mockIterator.next()).thenReturn("element1", "element2", "element3");
        boundedIterator = new BoundedIterator<>(mockIterator, 2, 5);
        // Act
        invokeInitMethod(boundedIterator);
        // Assert
        // Should have called next() twice
        verify(mockIterator, times(2)).next();
        // Position should be at offset
        assertEquals(2, getPos(boundedIterator));
    }

    @Test
    public void testInit_WithOffsetGreaterThanIteratorSize() throws Exception {
        // Arrange
        // Three elements, then no more
        when(mockIterator.hasNext()).thenReturn(true, true, true, false);
        when(mockIterator.next()).thenReturn("element1", "element2", "element3");
        boundedIterator = new BoundedIterator<>(mockIterator, 5, 10);
        // Act
        invokeInitMethod(boundedIterator);
        // Assert
        // Should have called next() three times
        verify(mockIterator, times(3)).next();
        // Position should be at the end of available elements
        assertEquals(3, getPos(boundedIterator));
    }

    private void invokeInitMethod(BoundedIterator<String> boundedIterator) throws Exception {
        // Fixed Buggy Line: Changed 'var' to 'java.lang.reflect.Method'
        java.lang.reflect.Method method = BoundedIterator.class.getDeclaredMethod("init");
        method.setAccessible(true);
        method.invoke(boundedIterator);
    }

    private long getPos(BoundedIterator<String> boundedIterator) throws Exception {
        // Fixed Buggy Line: Changed 'var' to 'java.lang.reflect.Field'
        java.lang.reflect.Field field = BoundedIterator.class.getDeclaredField("pos");
        field.setAccessible(true);
        return field.getLong(boundedIterator);
    }
}
