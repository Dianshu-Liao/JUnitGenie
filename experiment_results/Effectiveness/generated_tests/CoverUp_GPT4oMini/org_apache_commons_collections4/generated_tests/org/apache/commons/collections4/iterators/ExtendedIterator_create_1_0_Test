package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.stream.Stream;
import java.lang.reflect.Field;
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
import org.apache.commons.collections4.IteratorUtils;

class ExtendedIterator_create_1_0_Test {

    @Test
    void testCreateWithStream() {
        // Arrange
        Stream<String> stream = Stream.of("A", "B", "C");
        // Act
        ExtendedIterator<String> iterator = ExtendedIterator.create(stream);
        // Assert
        assertNotNull(iterator);
        // Using reflection to access the private fields
        try {
            Field baseField = ExtendedIterator.class.getDeclaredField("base");
            baseField.setAccessible(true);
            Iterator<?> baseIterator = (Iterator<?>) baseField.get(iterator);
            assertTrue(baseIterator.hasNext());
            assertEquals("A", baseIterator.next());
            assertTrue(baseIterator.hasNext());
            assertEquals("B", baseIterator.next());
            assertTrue(baseIterator.hasNext());
            assertEquals("C", baseIterator.next());
            assertFalse(baseIterator.hasNext());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection access failed: " + e.getMessage());
        }
    }
}
