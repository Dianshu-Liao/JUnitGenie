package org.apache.commons.collections4.iterators;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.Transformer;

class ObjectGraphIterator_findNext_0_0_Test {

    private ObjectGraphIterator<Object> objectGraphIterator;

    @BeforeEach
    void setUp() {
        // Initialize the ObjectGraphIterator with a mock transformer
        objectGraphIterator = new ObjectGraphIterator<>(new ArrayList<>(), Mockito.mock(Transformer.class));
    }

    @Test
    void testFindNextWithIterator() throws Exception {
        // Prepare a mock iterator
        List<Object> elements = new ArrayList<>();
        elements.add("child1");
        elements.add("child2");
        Iterator<Object> mockIterator = elements.iterator();
        // Use reflection to access the private method
        invokeFindNext(mockIterator);
        // Verify that hasNext is true and currentValue is set to the first element
        assertTrue(getHasNext());
        assertEquals("child1", getCurrentValue());
    }

    @Test
    void testFindNextWithValue() throws Exception {
        // Use reflection to access the private method
        invokeFindNext("someValue");
        // Verify that hasNext is true and currentValue is set
        assertTrue(getHasNext());
        assertEquals("someValue", getCurrentValue());
    }

    @Test
    void testFindNextWithNull() throws Exception {
        // Use reflection to access the private method
        invokeFindNext(null);
        // Verify that hasNext is false and currentValue is null
        assertFalse(getHasNext());
        assertNull(getCurrentValue());
    }

    private void invokeFindNext(Object value) throws Exception {
        java.lang.reflect.Method method = ObjectGraphIterator.class.getDeclaredMethod("findNext", Object.class);
        method.setAccessible(true);
        method.invoke(objectGraphIterator, value);
    }

    private boolean getHasNext() throws Exception {
        java.lang.reflect.Field field = ObjectGraphIterator.class.getDeclaredField("hasNext");
        field.setAccessible(true);
        return (boolean) field.get(objectGraphIterator);
    }

    private Object getCurrentValue() throws Exception {
        java.lang.reflect.Field field = ObjectGraphIterator.class.getDeclaredField("currentValue");
        field.setAccessible(true);
        return field.get(objectGraphIterator);
    }
}
