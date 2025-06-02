package org.apache.commons.collections4.iterators;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.collections4.ResettableListIterator;

public class LoopingListIterator_previousIndex_7_0_Test {

    private LoopingListIterator<String> loopingListIterator;

    private List<String> list;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        loopingListIterator = new LoopingListIterator<>(list);
    }

    @Test
    public void testPreviousIndex_EmptyList() {
        LoopingListIterator<String> emptyIterator = new LoopingListIterator<>(new ArrayList<>());
        Exception exception = assertThrows(NoSuchElementException.class, emptyIterator::previousIndex);
        assertEquals("There are no elements for this iterator to loop on", exception.getMessage());
    }

    @Test
    public void testPreviousIndex_NoPrevious() {
        // Set the iterator to the start
        ListIterator<String> iterator = list.listIterator();
        setIterator(iterator);
        assertEquals(2, loopingListIterator.previousIndex());
    }

    @Test
    public void testPreviousIndex_HasPrevious() {
        // Set the iterator to the second element
        ListIterator<String> iterator = list.listIterator(1);
        setIterator(iterator);
        assertEquals(0, loopingListIterator.previousIndex());
    }

    @Test
    public void testPreviousIndex_AtStart() {
        // Set the iterator to the start
        ListIterator<String> iterator = list.listIterator();
        setIterator(iterator);
        assertEquals(2, loopingListIterator.previousIndex());
    }

    @Test
    public void testPreviousIndex_AtEnd() {
        // Set the iterator to the end
        ListIterator<String> iterator = list.listIterator(list.size());
        setIterator(iterator);
        assertEquals(2, loopingListIterator.previousIndex());
    }

    private void setIterator(ListIterator<String> iterator) {
        // Use reflection to set the private iterator field
        try {
            Field field = LoopingListIterator.class.getDeclaredField("iterator");
            field.setAccessible(true);
            field.set(loopingListIterator, iterator);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }
}
