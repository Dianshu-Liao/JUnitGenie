package org.apache.commons.collections4.set;

import org.apache.commons.collections4.set.ListOrderedSet;
import java.lang.reflect.Method;
import java.util.HashSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.list.UnmodifiableList;

class ListOrderedSet_add_3_0_Test {

    private ListOrderedSet<String> listOrderedSet;

    @BeforeEach
    void setUp() {
        listOrderedSet = new ListOrderedSet<>(new HashSet<>());
    }

    @Test
    void testAddUniqueElement() {
        assertTrue(listOrderedSet.add("element1"), "Should return true when adding a unique element");
        assertTrue(listOrderedSet.add("element2"), "Should return true when adding another unique element");
    }

    @Test
    void testAddDuplicateElement() {
        listOrderedSet.add("element1");
        assertFalse(listOrderedSet.add("element1"), "Should return false when adding a duplicate element");
    }

    @Test
    void testAddNullElement() {
        assertTrue(listOrderedSet.add(null), "Should return true when adding a null element");
        assertFalse(listOrderedSet.add(null), "Should return false when adding a duplicate null element");
    }

    @Test
    void testAddMultipleElements() {
        assertTrue(listOrderedSet.add("element1"));
        assertTrue(listOrderedSet.add("element2"));
        assertTrue(listOrderedSet.add("element3"));
        assertEquals(3, listOrderedSet.size(), "Size should be 3 after adding three unique elements");
    }

    @Test
    void testAddWithInitialSet() {
        HashSet<String> initialSet = new HashSet<>();
        initialSet.add("element1");
        listOrderedSet = new ListOrderedSet<>(initialSet);
        assertFalse(listOrderedSet.add("element1"), "Should return false when adding an existing element from the initial set");
        assertTrue(listOrderedSet.add("element2"), "Should return true when adding a new element");
    }

    @Test
    void testAddWithReflection() throws Exception {
        Method addMethod = ListOrderedSet.class.getDeclaredMethod("add", Object.class);
        addMethod.setAccessible(true);
        assertTrue((Boolean) addMethod.invoke(listOrderedSet, "element1"), "Should return true when adding a unique element via reflection");
        assertFalse((Boolean) addMethod.invoke(listOrderedSet, "element1"), "Should return false when adding a duplicate element via reflection");
    }
}
