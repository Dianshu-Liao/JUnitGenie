package org.apache.commons.collections4.list;

import org.apache.commons.collections4.list.SetUniqueList;
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

    private SetUniqueList<String> uniqueList;

    @BeforeEach
    void setUp() {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        uniqueList = new SetUniqueList<>(list, set);
    }

    @Test
    void testSetWhenAddingUniqueElement() {
        uniqueList.add("A");
        uniqueList.add("B");
        uniqueList.add("C");
        String removed = uniqueList.set(1, "D");
        assertEquals("B", removed);
        assertTrue(uniqueList.contains("D"));
        assertFalse(uniqueList.contains("B"));
    }

    @Test
    void testSetWhenReplacingWithExistingElement() {
        uniqueList.add("A");
        uniqueList.add("B");
        uniqueList.add("C");
        String removed = uniqueList.set(1, "A");
        assertEquals("B", removed);
        assertTrue(uniqueList.contains("A"));
        assertFalse(uniqueList.contains("B"));
    }

    @Test
    void testSetWhenReplacingWithSameElement() {
        uniqueList.add("A");
        uniqueList.add("B");
        uniqueList.add("C");
        String removed = uniqueList.set(1, "B");
        assertEquals("B", removed);
        assertTrue(uniqueList.contains("A"));
        assertTrue(uniqueList.contains("B"));
        assertTrue(uniqueList.contains("C"));
    }

    @Test
    void testSetWhenListIsEmpty() {
        String removed = uniqueList.set(0, "A");
        assertNull(removed);
        assertTrue(uniqueList.contains("A"));
    }

    @Test
    void testSetWithNullElement() {
        uniqueList.add("A");
        uniqueList.add("B");
        String removed = uniqueList.set(1, null);
        assertEquals("B", removed);
        assertTrue(uniqueList.contains(null));
        assertFalse(uniqueList.contains("B"));
    }

    @Test
    void testSetWithDuplicateElement() {
        uniqueList.add("A");
        uniqueList.add("B");
        uniqueList.add("C");
        String removed = uniqueList.set(0, "B");
        assertEquals("A", removed);
        assertTrue(uniqueList.contains("B"));
        assertFalse(uniqueList.contains("A"));
    }

    private Object invokePrivateMethod(String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        Method method = SetUniqueList.class.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method.invoke(uniqueList, args);
    }
}
