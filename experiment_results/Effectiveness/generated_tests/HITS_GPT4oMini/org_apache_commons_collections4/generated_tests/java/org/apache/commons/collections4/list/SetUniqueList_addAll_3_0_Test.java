package org.apache.commons.collections4.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;
import org.apache.commons.collections4.set.UnmodifiableSet;

public class SetUniqueList_addAll_3_0_Test {

    private SetUniqueList<String> setUniqueList;

    @BeforeEach
    public void setUp() {
        List<String> list = new ArrayList<>();
        setUniqueList = SetUniqueList.setUniqueList(list);
    }

    @Test
    public void testAddAll_EmptyCollection() {
        Collection<String> collection = new ArrayList<>();
        boolean result = setUniqueList.addAll(collection);
        assertFalse(result);
        assertEquals(0, setUniqueList.size());
    }

    @Test
    public void testAddAll_NonEmptyCollection_NoDuplicates() {
        Collection<String> collection = Arrays.asList("A", "B", "C");
        boolean result = setUniqueList.addAll(collection);
        assertTrue(result);
        assertEquals(3, setUniqueList.size());
        assertTrue(setUniqueList.contains("A"));
        assertTrue(setUniqueList.contains("B"));
        assertTrue(setUniqueList.contains("C"));
    }

    @Test
    public void testAddAll_NonEmptyCollection_WithDuplicates() {
        Collection<String> collection = Arrays.asList("A", "B", "A", "C");
        boolean result = setUniqueList.addAll(collection);
        assertTrue(result);
        assertEquals(3, setUniqueList.size());
        assertTrue(setUniqueList.contains("A"));
        assertTrue(setUniqueList.contains("B"));
        assertTrue(setUniqueList.contains("C"));
    }

    @Test
    public void testAddAll_SomeExistingElements() {
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
    public void testAddAll_NullCollection() {
        assertThrows(NullPointerException.class, () -> {
            setUniqueList.addAll(null);
        });
    }

    @Test
    public void testAddAll_CollectionWithNulls() {
        Collection<String> collection = Arrays.asList("A", null, "B", null);
        boolean result = setUniqueList.addAll(collection);
        assertTrue(result);
        assertEquals(3, setUniqueList.size());
        assertTrue(setUniqueList.contains("A"));
        assertTrue(setUniqueList.contains("B"));
        assertTrue(setUniqueList.contains(null));
    }
}
