package org.apache.commons.collections4.iterators;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;
import java.util.Objects;

class PeekingIterator_fill_2_0_Test {

    private PeekingIterator<Integer> peekingIterator;

    @BeforeEach
    void setUp() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Iterator<Integer> iterator = list.iterator();
        peekingIterator = new PeekingIterator<>(iterator);
    }

    @Test
    void testFillWhenNotExhaustedAndSlotNotFilled() throws Exception {
        invokeFill(peekingIterator);
        assertTrue(getPrivateField(peekingIterator, "slotFilled"));
        assertEquals(Integer.valueOf(1), getPrivateField(peekingIterator, "slot"));
    }

    @Test
    void testFillWhenExhausted() throws Exception {
        List<Integer> emptyList = Arrays.asList();
        Iterator<Integer> emptyIterator = emptyList.iterator();
        peekingIterator = new PeekingIterator<>(emptyIterator);
        invokeFill(peekingIterator);
        assertFalse(getPrivateField(peekingIterator, "slotFilled"));
        assertNull(getPrivateField(peekingIterator, "slot"));
        assertTrue(getPrivateField(peekingIterator, "exhausted"));
    }

    @Test
    void testFillWhenSlotAlreadyFilled() throws Exception {
        // Fill first time
        invokeFill(peekingIterator);
        assertTrue(getPrivateField(peekingIterator, "slotFilled"));
        // Try to fill again
        invokeFill(peekingIterator);
        // Should remain filled
        assertTrue(getPrivateField(peekingIterator, "slotFilled"));
        // Slot should still be the same
        assertEquals(Integer.valueOf(1), getPrivateField(peekingIterator, "slot"));
    }

    private void invokeFill(PeekingIterator<?> iterator) throws Exception {
        Method fillMethod = PeekingIterator.class.getDeclaredMethod("fill");
        fillMethod.setAccessible(true);
        fillMethod.invoke(iterator);
    }

    private <T> T getPrivateField(PeekingIterator<?> iterator, String fieldName) throws Exception {
        Field field = PeekingIterator.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return (T) field.get(iterator);
    }
}
