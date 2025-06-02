package org.apache.commons.collections4.list;

import org.apache.commons.collections4.list.SetUniqueList;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.function.Predicate;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;
import org.apache.commons.collections4.set.UnmodifiableSet;

class SetUniqueList_addAll_3_2_Test {

    private SetUniqueList<String> setUniqueList;

    @BeforeEach
    void setUp() {
        List<String> list = new ArrayList<>();
        setUniqueList = SetUniqueList.setUniqueList(list);
    }

    @Test
    void testAddAllWithEmptyCollection() {
        Collection<String> collection = new ArrayList<>();
        boolean result = setUniqueList.addAll(collection);
        assertFalse(result);
        assertEquals(0, setUniqueList.size());
    }

    @Test
    void testAddAllWithUniqueElements() {
        Collection<String> collection = Arrays.asList("A", "B", "C");
        boolean result = setUniqueList.addAll(collection);
        assertTrue(result);
        assertEquals(3, setUniqueList.size());
        assertTrue(setUniqueList.contains("A"));
        assertTrue(setUniqueList.contains("B"));
        assertTrue(setUniqueList.contains("C"));
    }

    @Test
    void testAddAllWithDuplicateElements() {
        Collection<String> collection = Arrays.asList("A", "B", "A", "C");
        boolean result = setUniqueList.addAll(collection);
        assertTrue(result);
        assertEquals(3, setUniqueList.size());
        assertTrue(setUniqueList.contains("A"));
        assertTrue(setUniqueList.contains("B"));
        assertTrue(setUniqueList.contains("C"));
    }

    @Test
    void testAddAllWithNullElement() {
        Collection<String> collection = Arrays.asList("A", null, "B");
        boolean result = setUniqueList.addAll(collection);
        assertTrue(result);
        assertEquals(3, setUniqueList.size());
        assertTrue(setUniqueList.contains("A"));
        assertTrue(setUniqueList.contains("B"));
        assertTrue(setUniqueList.contains(null));
    }

    @Test
    void testAddAllWithMixedElements() {
        Collection<String> collection = Arrays.asList("A", "B", null, "C", "A");
        boolean result = setUniqueList.addAll(collection);
        assertTrue(result);
        assertEquals(4, setUniqueList.size());
        assertTrue(setUniqueList.contains("A"));
        assertTrue(setUniqueList.contains("B"));
        assertTrue(setUniqueList.contains("C"));
        assertTrue(setUniqueList.contains(null));
    }

    @Test
    void testAddAllWithExistingElements() {
        setUniqueList.addAll(Arrays.asList("A", "B"));
        Collection<String> collection = Arrays.asList("B", "C", "D");
        boolean result = setUniqueList.addAll(collection);
        assertTrue(result);
        assertEquals(4, setUniqueList.size());
        assertTrue(setUniqueList.contains("A"));
        assertTrue(setUniqueList.contains("B"));
        assertTrue(setUniqueList.contains("C"));
        assertTrue(setUniqueList.contains("D"));
    }

    @Test
    void testAddAllWithNullCollection() {
        assertThrows(NullPointerException.class, () -> setUniqueList.addAll(null));
    }

    @Test
    void testPrivateMethodInvocation() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = SetUniqueList.class.getDeclaredMethod("addAll", Collection.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(setUniqueList, Arrays.asList("X", "Y"));
        assertTrue(result);
        assertEquals(2, setUniqueList.size());
        assertTrue(setUniqueList.contains("X"));
        assertTrue(setUniqueList.contains("Y"));
    }
}
