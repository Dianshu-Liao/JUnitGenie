package org.apache.commons.collections4.list;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.list.PredicatedList;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.ListIterator;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;

class // Additional tests can be added here for further coverage
PredicatedList_equals_4_0_Test {

    private PredicatedList<String> predicatedList;

    @BeforeEach
    void setUp() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        Predicate<String> predicate = new Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                // Simple predicate for testing
                return object != null;
            }
        };
        predicatedList = new PredicatedList<>(list, predicate);
    }

    @Test
    void testEquals_SameInstance() {
        assertTrue(predicatedList.equals(predicatedList), "PredicatedList should equal itself");
    }

    @Test
    void testEquals_Null() {
        assertFalse(predicatedList.equals(null), "PredicatedList should not equal null");
    }

    @Test
    void testEquals_DifferentClass() {
        assertFalse(predicatedList.equals("Some String"), "PredicatedList should not equal a different class");
    }

    @Test
    void testEquals_EqualLists() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        Predicate<String> predicate = new Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                return object != null;
            }
        };
        PredicatedList<String> otherPredicatedList = new PredicatedList<>(list, predicate);
        assertTrue(predicatedList.equals(otherPredicatedList), "PredicatedList should equal another PredicatedList with the same content");
    }

    @Test
    void testEquals_DifferentContent() {
        List<String> list = new ArrayList<>(Arrays.asList("x", "y", "z"));
        Predicate<String> predicate = new Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                return object != null;
            }
        };
        PredicatedList<String> otherPredicatedList = new PredicatedList<>(list, predicate);
        assertFalse(predicatedList.equals(otherPredicatedList), "PredicatedList should not equal another PredicatedList with different content");
    }
}
