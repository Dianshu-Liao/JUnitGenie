package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.Transformer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

class ObjectGraphIterator_updateCurrentIterator_5_0_Test {

    private ObjectGraphIterator<Integer> iteratorWithoutTransformer;

    private ObjectGraphIterator<Integer> iteratorWithTransformer;

    private Transformer<Integer, Integer> transformer;

    @BeforeEach
    void setUp() {
        transformer = mock(Transformer.class);
        when(transformer.apply(1)).thenReturn(2);
        when(transformer.apply(2)).thenReturn(3);
        when(transformer.apply(3)).thenReturn(null);
    }

    private boolean getHasNext(ObjectGraphIterator<?> iterator) throws Exception {
        Field field = ObjectGraphIterator.class.getDeclaredField("hasNext");
        field.setAccessible(true);
        return (boolean) field.get(iterator);
    }

    private Object getCurrentValue(ObjectGraphIterator<?> iterator) throws Exception {
        Field field = ObjectGraphIterator.class.getDeclaredField("currentValue");
        field.setAccessible(true);
        return field.get(iterator);
    }

    @Test
    void testUpdateCurrentIteratorWithNullRoot() throws Exception {
        ObjectGraphIterator<Integer> iterator = new ObjectGraphIterator<>(null, null);
        iterator.updateCurrentIterator();
        assertFalse(getHasNext(iterator));
    }

    @Test
    void testUpdateCurrentIteratorWithRootValue() throws Exception {
        iteratorWithoutTransformer = new ObjectGraphIterator<>(1, null);
        iteratorWithoutTransformer.updateCurrentIterator();
        assertTrue(getHasNext(iteratorWithoutTransformer));
        assertEquals(1, getCurrentValue(iteratorWithoutTransformer));
    }

    @Test
    void testUpdateCurrentIteratorWithTransformer() throws Exception {
        iteratorWithTransformer = new ObjectGraphIterator<>(1, transformer);
        iteratorWithTransformer.updateCurrentIterator();
        assertTrue(getHasNext(iteratorWithTransformer));
        assertEquals(2, getCurrentValue(iteratorWithTransformer));
    }

    @Test
    void testUpdateCurrentIteratorWithIterator() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Iterator<Integer> listIterator = list.iterator();
        iteratorWithoutTransformer = new ObjectGraphIterator<>(listIterator);
        iteratorWithoutTransformer.updateCurrentIterator();
        assertTrue(getHasNext(iteratorWithoutTransformer));
        assertEquals(1, getCurrentValue(iteratorWithoutTransformer));
    }

    @Test
    void testUpdateCurrentIteratorWithEmptyIterator() throws Exception {
        List<Integer> emptyList = Arrays.asList();
        Iterator<Integer> emptyIterator = emptyList.iterator();
        iteratorWithoutTransformer = new ObjectGraphIterator<>(emptyIterator);
        iteratorWithoutTransformer.updateCurrentIterator();
        assertFalse(getHasNext(iteratorWithoutTransformer));
    }

    @Test
    void testUpdateCurrentIteratorWithNoNextValue() throws Exception {
    }
}
