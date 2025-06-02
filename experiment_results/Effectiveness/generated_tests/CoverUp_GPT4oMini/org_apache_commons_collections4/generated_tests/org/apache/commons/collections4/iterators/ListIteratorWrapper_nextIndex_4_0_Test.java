package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.ResettableListIterator;

class ListIteratorWrapper_nextIndex_4_0_Test {

    private ListIteratorWrapper<String> listIteratorWrapper;

    private List<String> testList;

    @BeforeEach
    void setUp() {
        testList = Arrays.asList("A", "B", "C");
    }

    @Test
    void testNextIndexWithListIterator() {
        ListIterator<String> listIterator = testList.listIterator();
        // Move to the first element
        listIterator.next();
        listIteratorWrapper = new ListIteratorWrapper(listIterator);
        int nextIndex = listIteratorWrapper.nextIndex();
        assertEquals(1, nextIndex, "The next index should be 1 after moving to the first element.");
    }

    @Test
    void testNextIndexWithoutListIterator() {
        Iterator<String> iterator = testList.iterator();
        listIteratorWrapper = new ListIteratorWrapper(iterator);
        int nextIndex = listIteratorWrapper.nextIndex();
        assertEquals(0, nextIndex, "The next index should be 0 when using a regular iterator.");
    }

    @Test
    void testNextIndexAtEnd() {
        ListIterator<String> listIterator = testList.listIterator(testList.size());
        listIteratorWrapper = new ListIteratorWrapper(listIterator);
        int nextIndex = listIteratorWrapper.nextIndex();
        assertEquals(3, nextIndex, "The next index should be equal to the size of the list at the end.");
    }
}
