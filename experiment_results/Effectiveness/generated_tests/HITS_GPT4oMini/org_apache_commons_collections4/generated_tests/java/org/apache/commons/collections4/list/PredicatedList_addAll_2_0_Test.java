package org.apache.commons.collections4.list;

import org.apache.commons.collections4.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ListIterator;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;

public class PredicatedList_addAll_2_0_Test {

    private PredicatedList<String> predicatedList;

    @BeforeEach
    public void setUp() {
        // Define a simple predicate that allows non-null strings
        Predicate<String> predicate = new Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                return object != null;
            }
        };
        List<String> list = new ArrayList<>();
        predicatedList = new PredicatedList<>(list, predicate);
    }

    @Test
    public void testAddAll_ValidCollection() {
        Collection<String> collection = Arrays.asList("A", "B", "C");
        boolean result = predicatedList.addAll(0, collection);
        assertTrue(result);
        assertEquals(3, predicatedList.size());
        assertEquals("A", predicatedList.get(0));
        assertEquals("B", predicatedList.get(1));
        assertEquals("C", predicatedList.get(2));
    }

    @Test
    public void testAddAll_EmptyCollection() {
        Collection<String> collection = new ArrayList<>();
        boolean result = predicatedList.addAll(0, collection);
        assertTrue(result);
        assertEquals(0, predicatedList.size());
    }

    @Test
    public void testAddAll_NullElement() {
        Collection<String> collection = Arrays.asList("A", null, "C");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            predicatedList.addAll(0, collection);
        });
        assertEquals("Cannot add Object 'null' - Predicate 'org.apache.commons.collections4.Predicate$1@...' rejected it", exception.getMessage());
    }

    @Test
    public void testAddAll_InvalidElement() {
        Predicate<String> invalidPredicate = new Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                // Only allow strings longer than 1 character
                return object.length() > 1;
            }
        };
        PredicatedList<String> invalidPredicatedList = new PredicatedList<>(new ArrayList<>(), invalidPredicate);
        Collection<String> collection = Arrays.asList("A", "BB", "C");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            invalidPredicatedList.addAll(0, collection);
        });
        assertEquals("Cannot add Object 'A' - Predicate 'org.apache.commons.collections4.Predicate$1@...' rejected it", exception.getMessage());
    }
}
