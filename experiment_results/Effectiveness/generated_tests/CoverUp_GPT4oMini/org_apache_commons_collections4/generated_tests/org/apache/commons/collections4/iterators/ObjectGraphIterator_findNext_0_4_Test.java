package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.Transformer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayDeque;
import java.util.Deque;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ObjectGraphIterator_findNext_0_4_Test {

    private ObjectGraphIterator<Integer> iterator;

    @BeforeEach
    void setUp() {
        // simple transformer for testing
        Transformer<Integer, Integer> transformer = input -> input + 1;
        iterator = new ObjectGraphIterator<>(1, transformer);
    }

    @Test
    void testFindNextWithIterator() throws Exception {
        Iterator<Integer> testIterator = Arrays.asList(2, 3, 4).iterator();
        invokeFindNext(testIterator);
        assertTrue(getFieldValue("hasNext"));
        assertEquals(Integer.valueOf(2), getFieldValue("currentValue"));
    }

    @Test
    void testFindNextWithValue() throws Exception {
        invokeFindNext(5);
        assertTrue(getFieldValue("hasNext"));
        assertEquals(Integer.valueOf(5), getFieldValue("currentValue"));
    }

    @Test
    void testFindNextWithNull() throws Exception {
        invokeFindNext(null);
        assertFalse(getFieldValue("hasNext"));
        assertNull(getFieldValue("currentValue"));
    }

    private void invokeFindNext(Object value) throws Exception {
        Method method = ObjectGraphIterator.class.getDeclaredMethod("findNext", Object.class);
        method.setAccessible(true);
        method.invoke(iterator, value);
    }

    private <T> T getFieldValue(String fieldName) throws Exception {
        Field field = ObjectGraphIterator.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return (T) field.get(iterator);
    }
}
