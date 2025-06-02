package org.apache.commons.collections4.list;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.ListIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;

@ExtendWith(MockitoExtension.class)
class PredicatedList_addAll_2_0_Test {

    private PredicatedList<String> predicatedList;

    @BeforeEach
    void setUp() {
        List<String> list = new ArrayList<>();
        Predicate<String> predicate = s -> s != null && !s.isEmpty();
        predicatedList = new PredicatedList<>(list, new org.apache.commons.collections4.Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                return predicate.test(object);
            }
        });
    }

    @Test
    void testAddAll_ValidElements() throws Exception {
        Collection<String> elementsToAdd = Arrays.asList("A", "B", "C");
        boolean result = invokeAddAll(0, elementsToAdd);
        assertTrue(result);
        assertEquals(3, predicatedList.size());
        assertTrue(predicatedList.contains("A"));
        assertTrue(predicatedList.contains("B"));
        assertTrue(predicatedList.contains("C"));
    }

    @Test
    void testAddAll_ContainsNull() {
        Collection<String> elementsToAdd = Arrays.asList("A", null, "C");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeAddAll(0, elementsToAdd);
        });
        // Assuming validate throws this message
        String expectedMessage = "Element cannot be null";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    void testAddAll_EmptyCollection() throws Exception {
        Collection<String> elementsToAdd = new ArrayList<>();
        boolean result = invokeAddAll(0, elementsToAdd);
        assertFalse(result);
        assertEquals(0, predicatedList.size());
    }

    private boolean invokeAddAll(int index, Collection<? extends String> coll) throws Exception {
        Method method = PredicatedList.class.getDeclaredMethod("addAll", int.class, Collection.class);
        method.setAccessible(true);
        return (boolean) method.invoke(predicatedList, index, coll);
    }
}
