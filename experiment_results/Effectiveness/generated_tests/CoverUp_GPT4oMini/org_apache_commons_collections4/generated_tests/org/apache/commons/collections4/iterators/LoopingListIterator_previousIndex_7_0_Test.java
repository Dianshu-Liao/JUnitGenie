package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.lang.reflect.Field;
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
        list = Arrays.asList("A", "B", "C");
        loopingListIterator = new LoopingListIterator<>(list);
        // Use reflection to set the iterator to a specific position for testing
        // Point to "B"
        setIteratorPosition(1);
    }

    @Test
    public void testPreviousIndexWhenListIsEmpty() {
        loopingListIterator = new LoopingListIterator<>(Arrays.asList());
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            loopingListIterator.previousIndex();
        });
        assertEquals("There are no elements for this iterator to loop on", exception.getMessage());
    }

    @Test
    public void testPreviousIndexWhenIteratorHasPrevious() {
        // Point to "B"
        setIteratorPosition(1);
        int index = loopingListIterator.previousIndex();
        // Previous index of "B" is "A"
        assertEquals(0, index);
    }

    @Test
    public void testPreviousIndexWhenIteratorHasNoPrevious() {
        // Point to "A"
        setIteratorPosition(0);
        int index = loopingListIterator.previousIndex();
        // Previous index of "A" should wrap around to "C"
        assertEquals(2, index);
    }

    private void setIteratorPosition(int position) {
        try {
            ListIterator<String> iterator = (ListIterator<String>) getPrivateField(loopingListIterator, "iterator");
            for (int i = 0; i < position; i++) {
                iterator.next();
            }
        } catch (Exception e) {
            fail("Failed to set iterator position: " + e.getMessage());
        }
    }

    private Object getPrivateField(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
