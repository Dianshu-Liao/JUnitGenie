package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.collections4.Unmodifiable;

public class UnmodifiableIterator_unmodifiableIterator_0_0_Test {

    @Test
    public void testUnmodifiableIteratorWithNullIterator() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            UnmodifiableIterator.unmodifiableIterator(null);
        });
        assertEquals("iterator", exception.getMessage());
    }

    @Test
    public void testUnmodifiableIteratorWithUnmodifiableIterator() {
        List<String> list = Arrays.asList("a", "b", "c");
        Iterator<String> originalIterator = Collections.unmodifiableList(list).iterator();
        Iterator<String> resultIterator = UnmodifiableIterator.unmodifiableIterator(originalIterator);
        assertSame(originalIterator, resultIterator);
    }

    @Test
    public void testUnmodifiableIteratorWithModifiableIterator() {
        List<String> list = Arrays.asList("a", "b", "c");
        Iterator<String> originalIterator = list.iterator();
        Iterator<String> resultIterator = UnmodifiableIterator.unmodifiableIterator(originalIterator);
        assertNotSame(originalIterator, resultIterator);
        assertThrows(UnsupportedOperationException.class, () -> {
            resultIterator.remove();
        });
        // Verify iteration works
        assertTrue(resultIterator.hasNext());
        assertEquals("a", resultIterator.next());
        assertTrue(resultIterator.hasNext());
        assertEquals("b", resultIterator.next());
        assertTrue(resultIterator.hasNext());
        assertEquals("c", resultIterator.next());
        assertFalse(resultIterator.hasNext());
    }

    @Test
    public void testUnmodifiableIteratorWithEmptyIterator() {
        // Fixed the type here
        Iterator<Object> emptyIterator = Collections.emptyList().iterator();
        Iterator<Object> resultIterator = UnmodifiableIterator.unmodifiableIterator(emptyIterator);
        assertSame(emptyIterator, resultIterator);
        assertFalse(resultIterator.hasNext());
    }

    @Test
    public void testUnmodifiableIteratorWithSingleElementIterator() {
        List<String> list = Collections.singletonList("single");
        Iterator<String> singleElementIterator = list.iterator();
        Iterator<String> resultIterator = UnmodifiableIterator.unmodifiableIterator(singleElementIterator);
        assertNotSame(singleElementIterator, resultIterator);
        assertTrue(resultIterator.hasNext());
        assertEquals("single", resultIterator.next());
        assertFalse(resultIterator.hasNext());
    }
}
