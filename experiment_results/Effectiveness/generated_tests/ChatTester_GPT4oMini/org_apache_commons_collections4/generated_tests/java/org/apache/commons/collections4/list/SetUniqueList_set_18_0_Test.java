package org.apache.commons.collections4.list;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;
import org.apache.commons.collections4.set.UnmodifiableSet;

class SetUniqueList_set_18_0_Test {

    private SetUniqueList<String> setUniqueList;

    private List<String> backingList;

    private Set<String> backingSet;

    @BeforeEach
    void setUp() {
        backingList = new ArrayList<>();
        backingSet = new HashSet<>();
        setUniqueList = new SetUniqueList<>(backingList, backingSet);
    }

    @Test
    void testSet_NewElement() throws Exception {
        backingList.add("A");
        setUniqueList.set(0, "B");
        assertEquals("B", backingList.get(0));
        assertTrue(backingSet.contains("B"));
        assertFalse(backingSet.contains("A"));
    }

    @Test
    void testSet_ReplaceWithExistingElement() throws Exception {
        backingList.add("A");
        backingList.add("B");
        backingSet.add("A");
        backingSet.add("B");
        String removed = setUniqueList.set(0, "B");
        assertEquals("A", removed);
        assertEquals("B", backingList.get(0));
        assertTrue(backingSet.contains("B"));
        assertFalse(backingSet.contains("A"));
    }

    @Test
    void testSet_SwapWithItself() throws Exception {
        backingList.add("A");
        backingSet.add("A");
        String removed = setUniqueList.set(0, "A");
        assertEquals("A", removed);
        assertEquals("A", backingList.get(0));
        assertTrue(backingSet.contains("A"));
    }

    @Test
    void testSet_RemoveDuplicate() throws Exception {
        backingList.add("A");
        backingList.add("B");
        backingSet.add("A");
        backingSet.add("B");
        String removed = setUniqueList.set(1, "A");
        assertEquals("B", removed);
        assertEquals("A", backingList.get(1));
        assertTrue(backingSet.contains("A"));
        assertFalse(backingSet.contains("B"));
    }

    @Test
    void testSet_EmptyList() throws Exception {
        String removed = setUniqueList.set(0, "A");
        assertNull(removed);
        assertEquals("A", backingList.get(0));
        assertTrue(backingSet.contains("A"));
    }

    @Test
    void testSet_AddsUniqueElement() throws Exception {
        backingList.add("A");
        backingSet.add("A");
        String removed = setUniqueList.set(1, "B");
        // No element was removed since index 1 is out of bounds
        assertNull(removed);
        // Should be added at index 1
        assertEquals("B", backingList.get(1));
        // Set should contain "B"
        assertTrue(backingSet.contains("B"));
        // List size should be 2
        assertEquals(2, backingList.size());
    }

    // Reflection to invoke private methods if necessary
    private Object invokePrivateMethod(String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        Method method = SetUniqueList.class.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method.invoke(setUniqueList, args);
    }
}
