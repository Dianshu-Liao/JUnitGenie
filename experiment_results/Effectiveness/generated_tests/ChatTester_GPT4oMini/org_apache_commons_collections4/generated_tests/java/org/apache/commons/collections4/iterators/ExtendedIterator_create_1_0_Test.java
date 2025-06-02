package org.apache.commons.collections4.iterators;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.apache.commons.collections4.IteratorUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ExtendedIterator_create_1_0_Test {

    @Test
    public void testCreate() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange
        Stream<String> stream = Stream.of("one", "two", "three");
        // Act
        ExtendedIterator<String> extendedIterator = ExtendedIterator.create(stream);
        // Assert
        assertNotNull(extendedIterator);
    }

    @Test
    public void testCreateWithEmptyStream() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange
        Stream<String> emptyStream = Stream.empty();
        // Act
        ExtendedIterator<String> extendedIterator = ExtendedIterator.create(emptyStream);
        // Assert
        assertNotNull(extendedIterator);
    }

    @Test
    public void testCreateWithNullStream() {
        // Repair the buggy line by casting null to the appropriate type
        assertThrows(NullPointerException.class, () -> ExtendedIterator.create((Stream<String>) null));
    }

    @Test
    public void testIteratorHasNext() throws Exception {
        // Arrange
        Stream<String> stream = Stream.of("one", "two", "three");
        ExtendedIterator<String> extendedIterator = ExtendedIterator.create(stream);
        // Use reflection to access the private base iterator
        Iterator<String> iterator = (Iterator<String>) getPrivateField(extendedIterator, "base");
        // Act & Assert
        assertTrue(iterator.hasNext());
    }

    @Test
    public void testIteratorNext() throws Exception {
        // Arrange
        Stream<String> stream = Stream.of("one", "two", "three");
        ExtendedIterator<String> extendedIterator = ExtendedIterator.create(stream);
        // Use reflection to access the private base iterator
        Iterator<String> iterator = (Iterator<String>) getPrivateField(extendedIterator, "base");
        // Act
        String firstElement = iterator.next();
        // Assert
        assertEquals("one", firstElement);
    }

    @Test
    public void testIteratorNextThrowsExceptionOnEmpty() throws Exception {
        // Arrange
        Stream<String> emptyStream = Stream.empty();
        ExtendedIterator<String> extendedIterator = ExtendedIterator.create(emptyStream);
        // Use reflection to access the private base iterator
        Iterator<String> iterator = (Iterator<String>) getPrivateField(extendedIterator, "base");
        // Act & Assert
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    private Object getPrivateField(ExtendedIterator<?> extendedIterator, String fieldName) throws Exception {
        java.lang.reflect.Field field = ExtendedIterator.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(extendedIterator);
    }
}
