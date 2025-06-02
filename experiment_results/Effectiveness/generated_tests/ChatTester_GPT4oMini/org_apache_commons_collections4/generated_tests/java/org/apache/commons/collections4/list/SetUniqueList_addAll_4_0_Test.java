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

class SetUniqueList_addAll_4_0_Test {

    private SetUniqueList<String> setUniqueList;

    private List<String> initialList;

    private Set<String> uniqueSet;

    @BeforeEach
    void setUp() {
        initialList = new ArrayList<>(Arrays.asList("A", "B", "C"));
        uniqueSet = new HashSet<>(initialList);
        setUniqueList = new SetUniqueList<>(initialList, uniqueSet);
    }

    @Test
    void testAddAllWithUniqueElements() {
        Collection<String> newElements = Arrays.asList("D", "E");
        boolean result = setUniqueList.addAll(1, newElements);
        assertTrue(result);
        assertEquals(Arrays.asList("A", "D", "E", "B", "C"), setUniqueList);
    }

    @Test
    void testAddAllWithDuplicateElements() {
        Collection<String> newElements = Arrays.asList("B", "C", "F");
        boolean result = setUniqueList.addAll(1, newElements);
        assertTrue(result);
        assertEquals(Arrays.asList("A", "B", "C", "F"), setUniqueList);
    }

    @Test
    void testAddAllWithEmptyCollection() {
        Collection<String> newElements = Collections.emptyList();
        boolean result = setUniqueList.addAll(1, newElements);
        assertFalse(result);
        assertEquals(Arrays.asList("A", "B", "C"), setUniqueList);
    }

    @Test
    void testAddAllWithNullCollection() {
        Collection<String> newElements = null;
        Exception exception = assertThrows(NullPointerException.class, () -> {
            setUniqueList.addAll(1, newElements);
        });
        assertNotNull(exception);
    }

    @Test
    void testAddAllAtBeginning() {
        Collection<String> newElements = Arrays.asList("X", "Y");
        boolean result = setUniqueList.addAll(0, newElements);
        assertTrue(result);
        assertEquals(Arrays.asList("X", "Y", "A", "B", "C"), setUniqueList);
    }

    @Test
    void testAddAllAtEnd() {
        Collection<String> newElements = Arrays.asList("Z");
        boolean result = setUniqueList.addAll(initialList.size(), newElements);
        assertTrue(result);
        assertEquals(Arrays.asList("A", "B", "C", "Z"), setUniqueList);
    }
}
