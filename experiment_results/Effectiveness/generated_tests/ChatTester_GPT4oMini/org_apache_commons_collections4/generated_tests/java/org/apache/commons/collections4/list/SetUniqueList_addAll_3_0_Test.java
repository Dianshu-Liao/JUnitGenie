package org.apache.commons.collections4.list;

import java.util.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Predicate;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;
import org.apache.commons.collections4.set.UnmodifiableSet;

public class SetUniqueList_addAll_3_0_Test {

    private SetUniqueList<String> setUniqueList;

    private List<String> list;

    private Set<String> set;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>();
        set = new HashSet<>();
        setUniqueList = new SetUniqueList<>(list, set);
    }

    @Test
    public void testAddAllWithEmptyCollection() {
        Collection<String> coll = new ArrayList<>();
        boolean result = setUniqueList.addAll(coll);
        assertFalse(result, "Adding an empty collection should return false");
    }

    @Test
    public void testAddAllWithNewElements() {
        Collection<String> coll = Arrays.asList("A", "B", "C");
        boolean result = setUniqueList.addAll(coll);
        assertTrue(result, "Adding new elements should return true");
        assertEquals(3, set.size(), "Set size should be 3 after adding new elements");
        assertTrue(set.containsAll(coll), "Set should contain all added elements");
    }

    @Test
    public void testAddAllWithDuplicateElements() {
        Collection<String> coll = Arrays.asList("A", "B", "A");
        boolean result = setUniqueList.addAll(coll);
        assertTrue(result, "Adding elements with duplicates should return true");
        assertEquals(2, set.size(), "Set size should be 2 after adding duplicates");
        assertTrue(set.contains("A"), "Set should contain 'A'");
        assertTrue(set.contains("B"), "Set should contain 'B'");
    }

    @Test
    public void testAddAllWithNullElements() {
        Collection<String> coll = Arrays.asList("A", null, "B");
        boolean result = setUniqueList.addAll(coll);
        assertTrue(result, "Adding elements including null should return true");
        assertEquals(3, set.size(), "Set size should be 3 after adding null");
        assertTrue(set.contains("A"), "Set should contain 'A'");
        assertTrue(set.contains(null), "Set should contain null");
        assertTrue(set.contains("B"), "Set should contain 'B'");
    }

    @Test
    public void testAddAllWithExistingElements() {
        set.add("A");
        Collection<String> coll = Arrays.asList("A", "B");
        boolean result = setUniqueList.addAll(coll);
        assertTrue(result, "Adding elements where one already exists should return true");
        assertEquals(2, set.size(), "Set size should be 2 after adding existing and new elements");
        assertTrue(set.contains("A"), "Set should still contain 'A'");
        assertTrue(set.contains("B"), "Set should contain 'B'");
    }
}
