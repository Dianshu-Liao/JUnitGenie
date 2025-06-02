package org.apache.commons.collections4.list;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.list.PredicatedList;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ListIterator;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;

@ExtendWith(MockitoExtension.class)
public class PredicatedList_addAll_2_2_Test {

    private PredicatedList<String> predicatedList;

    private List<String> list;

    private Predicate<String> predicate;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>();
        predicate = Mockito.mock(Predicate.class);
        predicatedList = new PredicatedList<>(list, predicate);
    }

    @Test
    public void testAddAll_ValidElements() {
        Collection<String> elementsToAdd = Arrays.asList("a", "b", "c");
        when(predicate.test("a")).thenReturn(true);
        when(predicate.test("b")).thenReturn(true);
        when(predicate.test("c")).thenReturn(true);
        boolean result = predicatedList.addAll(0, elementsToAdd);
        assertTrue(result);
        assertEquals(3, predicatedList.size());
        assertTrue(predicatedList.contains("a"));
        assertTrue(predicatedList.contains("b"));
        assertTrue(predicatedList.contains("c"));
    }

    @Test
    public void testAddAll_InvalidElement_ThrowsException() {
        Collection<String> elementsToAdd = Arrays.asList("a", "b", "c");
        when(predicate.test("a")).thenReturn(true);
        when(predicate.test("b")).thenReturn(false);
        when(predicate.test("c")).thenReturn(true);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            predicatedList.addAll(0, elementsToAdd);
        });
        assertEquals("Cannot add Object 'b' - Predicate '" + predicate + "' rejected it", thrown.getMessage());
    }

    @Test
    public void testAddAll_EmptyCollection() {
        Collection<String> elementsToAdd = new ArrayList<>();
        boolean result = predicatedList.addAll(0, elementsToAdd);
        assertTrue(result);
        assertEquals(0, predicatedList.size());
    }

    @Test
    public void testAddAll_CollectionWithNullElement() {
        Collection<String> elementsToAdd = Arrays.asList("a", null, "c");
        when(predicate.test("a")).thenReturn(true);
        when(predicate.test(null)).thenReturn(false);
        when(predicate.test("c")).thenReturn(true);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            predicatedList.addAll(0, elementsToAdd);
        });
        assertEquals("Cannot add Object 'null' - Predicate '" + predicate + "' rejected it", thrown.getMessage());
    }

    // Reflection test for private methods if needed
    private void invokePrivateMethod(String methodName, Class<?>... parameterTypes) throws Exception {
        Method method = PredicatedList.class.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        method.invoke(predicatedList);
    }
}
