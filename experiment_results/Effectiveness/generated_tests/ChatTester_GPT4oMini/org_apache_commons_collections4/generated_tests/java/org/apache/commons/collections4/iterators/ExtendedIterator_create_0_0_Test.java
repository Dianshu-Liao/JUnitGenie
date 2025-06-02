package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.apache.commons.collections4.IteratorUtils;

public class ExtendedIterator_create_0_0_Test {

    @Test
    public void testCreateWithExtendedIterator() {
        // Arrange
        Iterator<String> extendedIterator = new Iterator<String>() {

            private int index = 0;

            private final String[] elements = { "one", "two", "three" };

            @Override
            public boolean hasNext() {
                return index < elements.length;
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elements[index++];
            }
        };
        // Act
        ExtendedIterator<String> result = ExtendedIterator.create(extendedIterator);
        // Assert
        assertSame(extendedIterator, result);
    }

    @Test
    public void testCreateWithRegularIterator() {
        // Arrange
        Iterator<String> regularIterator = new Iterator<String>() {

            private int index = 0;

            private final String[] elements = { "one", "two", "three" };

            @Override
            public boolean hasNext() {
                return index < elements.length;
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elements[index++];
            }
        };
        // Act
        ExtendedIterator<String> result = ExtendedIterator.create(regularIterator);
        // Assert
        assertNotNull(result);
        assertNotSame(regularIterator, result);
    }

    @Test
    public void testCreateWithNullIterator() {
        // Arrange
        Iterator<String> nullIterator = null;
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            ExtendedIterator.create(nullIterator);
        });
    }

    @Test
    public void testCreateWithEmptyIterator() {
        // Arrange
        Iterator<String> emptyIterator = new Iterator<String>() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public String next() {
                throw new NoSuchElementException();
            }
        };
        // Act
        ExtendedIterator<String> result = ExtendedIterator.create(emptyIterator);
        // Assert
        assertNotNull(result);
        assertFalse(result.hasNext());
    }
}
