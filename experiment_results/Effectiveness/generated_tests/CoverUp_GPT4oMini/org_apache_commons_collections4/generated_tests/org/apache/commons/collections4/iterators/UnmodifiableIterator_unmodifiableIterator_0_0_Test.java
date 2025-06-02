package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

class UnmodifiableIterator_unmodifiableIterator_0_0_Test {

    private static class TestIterator<E> implements Iterator<E> {

        private final E[] elements;

        private int index = 0;

        @SuppressWarnings("unchecked")
        public TestIterator(E... elements) {
            this.elements = elements;
        }

        @Override
        public boolean hasNext() {
            return index < elements.length;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements[index++];
        }
    }

    @Test
    void testUnmodifiableIterator_withNullIterator() {
        assertThrows(NullPointerException.class, () -> {
            UnmodifiableIterator.unmodifiableIterator(null);
        });
    }

    @Test
    void testUnmodifiableIterator_withUnmodifiableIterator() {
        TestIterator<String> testIterator = new TestIterator<>("a", "b", "c");
        Iterator<String> unmodifiable = UnmodifiableIterator.unmodifiableIterator(testIterator);
        assertTrue(unmodifiable.hasNext());
        assertEquals("a", unmodifiable.next());
        assertEquals("b", unmodifiable.next());
        assertEquals("c", unmodifiable.next());
        assertFalse(unmodifiable.hasNext());
    }

    @Test
    void testUnmodifiableIterator_withRegularIterator() {
        TestIterator<String> testIterator = new TestIterator<>("x", "y", "z");
        Iterator<String> unmodifiable = UnmodifiableIterator.unmodifiableIterator(testIterator);
        assertTrue(unmodifiable.hasNext());
        assertEquals("x", unmodifiable.next());
        assertEquals("y", unmodifiable.next());
        assertEquals("z", unmodifiable.next());
        assertFalse(unmodifiable.hasNext());
    }

    @Test
    void testUnmodifiableIterator_withEmptyIterator() {
        TestIterator<String> testIterator = new TestIterator<>();
        Iterator<String> unmodifiable = UnmodifiableIterator.unmodifiableIterator(testIterator);
        assertFalse(unmodifiable.hasNext());
    }

    @Test
    void testUnmodifiableIterator_withMultipleCalls() {
        TestIterator<Integer> testIterator = new TestIterator<>(1, 2, 3);
        Iterator<Integer> unmodifiable = UnmodifiableIterator.unmodifiableIterator(testIterator);
        assertTrue(unmodifiable.hasNext());
        assertEquals(1, unmodifiable.next());
        assertTrue(unmodifiable.hasNext());
        assertEquals(2, unmodifiable.next());
        assertTrue(unmodifiable.hasNext());
        assertEquals(3, unmodifiable.next());
        assertFalse(unmodifiable.hasNext());
    }
}
