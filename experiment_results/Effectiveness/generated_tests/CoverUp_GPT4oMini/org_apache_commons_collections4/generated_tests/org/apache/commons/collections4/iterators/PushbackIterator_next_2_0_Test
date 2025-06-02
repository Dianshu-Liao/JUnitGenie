package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
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

class PushbackIterator_next_2_0_Test {

    private PushbackIterator<String> pushbackIterator;

    @BeforeEach
    void setUp() {
        Iterator<String> iterator = Arrays.asList("A", "B", "C").iterator();
        pushbackIterator = new PushbackIterator<>(iterator);
    }

    @Test
    void testNextReturnsItemFromIterator() {
        assertEquals("A", pushbackIterator.next());
        assertEquals("B", pushbackIterator.next());
        assertEquals("C", pushbackIterator.next());
    }

    @Test
    void testNextThrowsExceptionWhenNoMoreElements() {
        // A
        pushbackIterator.next();
        // B
        pushbackIterator.next();
        // C
        pushbackIterator.next();
        assertThrows(NoSuchElementException.class, () -> {
            pushbackIterator.next();
        });
    }

    @Test
    void testNextReturnsItemFromPushbackStack() throws Exception {
        // Use reflection to access private field 'items' and add an item to it
        pushbackIterator.getClass().getDeclaredField("items").setAccessible(true);
        Deque<String> items = (Deque<String>) pushbackIterator.getClass().getDeclaredField("items").get(pushbackIterator);
        items.push("D");
        assertEquals("D", pushbackIterator.next());
        assertEquals("A", pushbackIterator.next());
    }
}
