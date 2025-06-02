package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class PushbackIterator_next_2_2_Test {

    private PushbackIterator<String> pushbackIterator;

    @BeforeEach
    public void setUp() {
        List<String> items = Arrays.asList("A", "B", "C");
        Iterator<String> iterator = items.iterator();
        pushbackIterator = new PushbackIterator<>(iterator);
    }

    @Test
    public void testNextReturnsNextItem() {
        assertEquals("A", pushbackIterator.next());
        assertEquals("B", pushbackIterator.next());
    }

    @Test
    public void testNextWithoutPush() {
        assertEquals("A", pushbackIterator.next());
        assertEquals("B", pushbackIterator.next());
        assertEquals("C", pushbackIterator.next());
    }

    @Test
    public void testNextAfterExhaustingIterator() {
        assertEquals("A", pushbackIterator.next());
        assertEquals("B", pushbackIterator.next());
        assertEquals("C", pushbackIterator.next());
        assertThrows(NoSuchElementException.class, () -> pushbackIterator.next());
    }

    @Test
    public void testPushAndNextReturnsPushedItem() {
        // Create a new PushbackIterator with additional items
        List<String> items = Arrays.asList("X", "A", "B", "C");
        Iterator<String> iterator = items.iterator();
        pushbackIterator = new PushbackIterator<>(iterator);
        assertEquals("X", pushbackIterator.next());
        assertEquals("A", pushbackIterator.next());
    }

    @Test
    public void testPushMultipleItems() {
        // Create a new PushbackIterator with multiple items
        List<String> items = Arrays.asList("Y", "X", "A", "B", "C");
        Iterator<String> iterator = items.iterator();
        pushbackIterator = new PushbackIterator<>(iterator);
        assertEquals("Y", pushbackIterator.next());
        assertEquals("X", pushbackIterator.next());
        assertEquals("A", pushbackIterator.next());
    }
}
