package org.apache.commons.collections4.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

class AbstractLinkedList_indexOf_24_0_Test {

    private TestLinkedList testList;

    @BeforeEach
    void setUp() {
        testList = new TestLinkedList();
        testList.addAll(Arrays.asList("A", "B", "C", "D"));
    }

    @Test
    void testIndexOf_existingElement() {
        assertEquals(0, testList.indexOf("A"));
        assertEquals(1, testList.indexOf("B"));
        assertEquals(2, testList.indexOf("C"));
        assertEquals(3, testList.indexOf("D"));
    }

    @Test
    void testIndexOf_nonExistingElement() {
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, testList.indexOf("E"));
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, testList.indexOf(null));
    }

    @Test
    void testIndexOf_multipleOccurrences() {
        testList.add("A");
        // should return the index of the first occurrence
        assertEquals(0, testList.indexOf("A"));
    }

    @Test
    void testIndexOf_emptyList() {
        testList.clear();
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, testList.indexOf("A"));
    }

    private static class TestLinkedList extends AbstractLinkedList<String> {

        private final LinkedList<String> list = new LinkedList<>();

        protected TestLinkedList() {
            super();
        }

        @Override
        public String get(int index) {
            return list.get(index);
        }

        @Override
        public int size() {
            return list.size();
        }

        @Override
        public boolean add(String s) {
            return list.add(s);
        }

        public void addAll(List<String> elements) {
            list.addAll(elements);
        }

        public void clear() {
            list.clear();
        }

        public String remove(int index) {
            return list.remove(index);
        }

        public boolean contains(Object o) {
            return list.contains(o);
        }
    }
}
