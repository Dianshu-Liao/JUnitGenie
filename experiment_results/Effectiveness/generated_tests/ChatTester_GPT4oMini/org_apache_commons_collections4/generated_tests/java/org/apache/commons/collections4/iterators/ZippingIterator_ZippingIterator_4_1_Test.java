package org.apache.commons.collections4.iterators;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.collections4.FluentIterable;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ZippingIterator_ZippingIterator_4_1_Test {

    private ZippingIterator<String> zippingIterator;

    @BeforeEach
    void setUp() throws Exception {
        Iterator<String> iterator1 = Arrays.asList("A", "B", "C").iterator();
        Iterator<String> iterator2 = Arrays.asList("1", "2", "3").iterator();
        zippingIterator = createZippingIterator(iterator1, iterator2);
    }

    private ZippingIterator<String> createZippingIterator(Iterator<String> a, Iterator<String> b) throws Exception {
        Constructor<ZippingIterator> constructor = ZippingIterator.class.getDeclaredConstructor(Iterator.class, Iterator.class);
        constructor.setAccessible(true);
        return constructor.newInstance(a, b);
    }

    @Test
    void testZippingIteratorHasNext() {
        assertTrue(zippingIterator.hasNext());
    }

    @Test
    void testZippingIteratorNext() {
        assertEquals("A", zippingIterator.next());
        assertEquals("1", zippingIterator.next());
        assertEquals("B", zippingIterator.next());
        assertEquals("2", zippingIterator.next());
        assertEquals("C", zippingIterator.next());
        assertThrows(NoSuchElementException.class, () -> zippingIterator.next());
    }

    @Test
    void testZippingIteratorEmpty() throws Exception {
        ZippingIterator<String> emptyZippingIterator = createZippingIterator(Arrays.asList("").iterator(), Arrays.asList("").iterator());
        assertFalse(emptyZippingIterator.hasNext());
        assertThrows(NoSuchElementException.class, () -> emptyZippingIterator.next());
    }

    @Test
    void testZippingIteratorDifferentSizes() throws Exception {
        Iterator<String> iterator1 = Arrays.asList("A", "B").iterator();
        Iterator<String> iterator2 = Arrays.asList("1", "2", "3", "4").iterator();
        zippingIterator = createZippingIterator(iterator1, iterator2);
        assertEquals("A", zippingIterator.next());
        assertEquals("1", zippingIterator.next());
        assertEquals("B", zippingIterator.next());
        assertEquals("2", zippingIterator.next());
        assertFalse(zippingIterator.hasNext());
        assertThrows(NoSuchElementException.class, () -> zippingIterator.next());
    }

    @Test
    void testZippingIteratorConstructor() throws Exception {
        Iterator<String> iterator1 = Arrays.asList("X", "Y").iterator();
        Iterator<String> iterator2 = Arrays.asList("1", "2").iterator();
        ZippingIterator<String> newZippingIterator = createZippingIterator(iterator1, iterator2);
        assertTrue(newZippingIterator.hasNext());
        assertEquals("X", newZippingIterator.next());
        assertEquals("1", newZippingIterator.next());
        assertEquals("Y", newZippingIterator.next());
        assertEquals("2", newZippingIterator.next());
        assertFalse(newZippingIterator.hasNext());
        assertThrows(NoSuchElementException.class, () -> newZippingIterator.next());
    }
}
