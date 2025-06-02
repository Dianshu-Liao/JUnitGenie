package org.apache.commons.collections4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Collection;
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

public class IterableUtils_get_24_0_Test {

    @Test
    public void testGetFromList() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        Assertions.assertEquals("A", IterableUtils.get(list, 0));
        Assertions.assertEquals("B", IterableUtils.get(list, 1));
        Assertions.assertEquals("C", IterableUtils.get(list, 2));
        Assertions.assertEquals("D", IterableUtils.get(list, 3));
    }

    @Test
    public void testGetFromEmptyList() {
        List<String> emptyList = Collections.emptyList();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            IterableUtils.get(emptyList, 0);
        });
    }

    @Test
    public void testGetFromSet() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        Iterable<String> setIterable = new HashSet<>(list);
        Assertions.assertTrue(setIterable instanceof Collection);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            IterableUtils.get(setIterable, 4);
        });
        Assertions.assertEquals("A", IterableUtils.get(setIterable, 0));
    }

    @Test
    public void testGetWithNegativeIndex() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            IterableUtils.get(list, -1);
        });
    }

    @Test
    public void testGetWithOutOfBoundsIndex() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            IterableUtils.get(list, 5);
        });
    }
}
