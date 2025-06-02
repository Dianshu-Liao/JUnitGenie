package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
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
    public void testUnmodifiableIterator_NullIterator() {
        assertThrows(NullPointerException.class, () -> {
            UnmodifiableIterator.unmodifiableIterator(null);
        });
    }

    @Test
    public void testUnmodifiableIterator_EmptyIterator() {
        Iterator<String> emptyIterator = Collections.emptyIterator();
        Iterator<String> unmodifiable = UnmodifiableIterator.unmodifiableIterator(emptyIterator);
        assertFalse(unmodifiable.hasNext());
    }

    @Test
    public void testUnmodifiableIterator_SingleElement() {
        Iterator<String> singleElementIterator = Arrays.asList("element").iterator();
        Iterator<String> unmodifiable = UnmodifiableIterator.unmodifiableIterator(singleElementIterator);
        assertTrue(unmodifiable.hasNext());
        assertEquals("element", unmodifiable.next());
        assertFalse(unmodifiable.hasNext());
    }

    @Test
    public void testUnmodifiableIterator_MultipleElements() {
        Iterator<String> multipleElementsIterator = Arrays.asList("one", "two", "three").iterator();
        Iterator<String> unmodifiable = UnmodifiableIterator.unmodifiableIterator(multipleElementsIterator);
        assertTrue(unmodifiable.hasNext());
        assertEquals("one", unmodifiable.next());
        assertEquals("two", unmodifiable.next());
        assertEquals("three", unmodifiable.next());
        assertFalse(unmodifiable.hasNext());
    }

    @Test
    public void testUnmodifiableIterator_NextOnEmptyIterator() {
        Iterator<String> emptyIterator = Collections.emptyIterator();
        Iterator<String> unmodifiable = UnmodifiableIterator.unmodifiableIterator(emptyIterator);
        assertThrows(NoSuchElementException.class, () -> {
            unmodifiable.next();
        });
    }

    @Test
    public void testUnmodifiableIterator_AlreadyUnmodifiable() {
        Iterator<String> alreadyUnmodifiable = Collections.singletonList("element").iterator();
        Iterator<String> unmodifiable = UnmodifiableIterator.unmodifiableIterator(alreadyUnmodifiable);
        assertSame(unmodifiable, UnmodifiableIterator.unmodifiableIterator(alreadyUnmodifiable));
    }
}
