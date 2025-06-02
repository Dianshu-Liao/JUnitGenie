package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.apache.commons.collections4.IteratorUtils;

public class ExtendedIterator_create_0_0_Test {

    @Test
    public void testCreate_WithExtendedIterator() {
        // Arrange
        Iterator<String> baseIterator = Arrays.asList("a", "b", "c").iterator();
        ExtendedIterator<String> extendedIterator = ExtendedIterator.create(baseIterator);
        // Act
        ExtendedIterator<String> result = ExtendedIterator.create(extendedIterator);
        // Assert
        assertSame(extendedIterator, result, "Should return the same ExtendedIterator instance");
    }

    @Test
    public void testCreate_WithRegularIterator() {
        // Arrange
        Iterator<String> baseIterator = Arrays.asList("a", "b", "c").iterator();
        // Act
        ExtendedIterator<String> result = ExtendedIterator.create(baseIterator);
        // Assert
        assertTrue(result instanceof ExtendedIterator, "Should return an instance of ExtendedIterator");
    }

    @Test
    public void testCreate_WithEmptyIterator() {
        // Arrange
        Iterator<String> emptyIterator = Collections.emptyIterator();
        // Act
        ExtendedIterator<String> result = ExtendedIterator.create(emptyIterator);
        // Assert
        assertTrue(result instanceof ExtendedIterator, "Should return an instance of ExtendedIterator for empty iterator");
    }

    @Test
    public void testCreate_WithNullIterator() {
        // Arrange
        Iterator<String> nullIterator = null;
        // Act
        ExtendedIterator<String> result = ExtendedIterator.create(nullIterator);
        // Assert
        assertTrue(result instanceof ExtendedIterator, "Should return an instance of ExtendedIterator for null iterator");
    }
}
