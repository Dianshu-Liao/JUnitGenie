package org.apache.commons.collections4.iterators;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import java.util.Objects;

public class PeekingIterator_fill_2_1_Test {

    private PeekingIterator<Integer> peekingIterator;

    private Iterator<Integer> iterator;

    @BeforeEach
    public void setUp() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        iterator = list.iterator();
        peekingIterator = new PeekingIterator<>(iterator);
    }

    @Test
    public void testFill_WhenNotExhaustedAndSlotNotFilled_ShouldFillSlot() throws Exception {
        // Invoke the private method fill
        invokeFill();
        // Test that the slot is filled with the first element
        assertEquals(1, getSlot());
    }

    @Test
    public void testFill_WhenSlotAlreadyFilled_ShouldNotChangeSlot() throws Exception {
        // Fill the slot with first element
        invokeFill();
        // Invoke fill again
        invokeFill();
        // Slot should still be filled with the first element
        assertEquals(1, getSlot());
    }

    @Test
    public void testFill_WhenExhausted_ShouldSetExhaustedFlagAndClearSlot() throws Exception {
        // Fill the slot until exhausted
        // Fill with 1
        invokeFill();
        // Fill with 2
        invokeFill();
        // Fill with 3
        invokeFill();
        // Should exhaust the iterator
        invokeFill();
        // Check if exhausted
        assertTrue(isExhausted());
        assertNull(getSlot());
    }

    private void invokeFill() throws Exception {
        Method fillMethod = PeekingIterator.class.getDeclaredMethod("fill");
        fillMethod.setAccessible(true);
        fillMethod.invoke(peekingIterator);
    }

    private Integer getSlot() throws Exception {
        Field slotField = PeekingIterator.class.getDeclaredField("slot");
        slotField.setAccessible(true);
        return (Integer) slotField.get(peekingIterator);
    }

    private boolean isExhausted() throws Exception {
        Field exhaustedField = PeekingIterator.class.getDeclaredField("exhausted");
        exhaustedField.setAccessible(true);
        return (boolean) exhaustedField.get(peekingIterator);
    }
}
