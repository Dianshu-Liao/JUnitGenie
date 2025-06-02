package org.apache.commons.collections4;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.IterableUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.ReverseListIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;

class IterableUtils_get_24_0_Test {

    @Test
    void testGetFromList() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        assertEquals("a", IterableUtils.get(list, 0));
        assertEquals("b", IterableUtils.get(list, 1));
        assertEquals("c", IterableUtils.get(list, 2));
    }

    @Test
    void testGetFromEmptyList() {
        List<String> list = new ArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> IterableUtils.get(list, 0));
    }

    @Test
    void testGetFromArray() {
        Iterable<String> iterable = Arrays.asList("x", "y", "z");
        assertEquals("x", IterableUtils.get(iterable, 0));
        assertEquals("y", IterableUtils.get(iterable, 1));
        assertEquals("z", IterableUtils.get(iterable, 2));
    }

    @Test
    void testGetFromEmptyIterable() {
        Iterable<String> iterable = new ArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> IterableUtils.get(iterable, 0));
    }

    @Test
    void testGetWithNegativeIndex() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        assertThrows(IndexOutOfBoundsException.class, () -> IterableUtils.get(list, -1));
    }

    @Test
    void testGetWithOutOfBoundsIndex() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        assertThrows(IndexOutOfBoundsException.class, () -> IterableUtils.get(list, 3));
    }
}
