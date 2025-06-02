package org.apache.commons.collections4.list;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.Predicate;
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

public class PredicatedList_equals_4_0_Test {

    private PredicatedList<Object> predicatedList;

    private List<Object> mockList;

    @BeforeEach
    public void setUp() {
        mockList = mock(List.class);
        Predicate<Object> mockPredicate = new Predicate<Object>() {

            @Override
            public boolean evaluate(Object obj) {
                return true;
            }
        };
        predicatedList = new PredicatedList<>(mockList, mockPredicate);
    }

    @Test
    public void testEquals_SameInstance() {
        assertTrue(predicatedList.equals(predicatedList), "Should be equal to itself");
    }

    @Test
    public void testEquals_Null() {
        assertFalse(predicatedList.equals(null), "Should not be equal to null");
    }

    @Test
    public void testEquals_DifferentObjectType() {
        assertFalse(predicatedList.equals("Not a PredicatedList"), "Should not be equal to a different type");
    }

    @Test
    public void testEquals_EqualDecoratedList() {
        List<Object> anotherList = new ArrayList<>();
        when(mockList.equals(anotherList)).thenReturn(true);
        PredicatedList<Object> anotherPredicatedList = new PredicatedList<>(anotherList, new Predicate<Object>() {

            @Override
            public boolean evaluate(Object obj) {
                return true;
            }
        });
        // Act
        boolean result = predicatedList.equals(anotherPredicatedList);
        // Assert
        assertTrue(result, "Should be equal to another PredicatedList with equal decorated list");
    }

    @Test
    public void testEquals_NonEqualDecoratedList() {
        List<Object> anotherList = new ArrayList<>();
        when(mockList.equals(anotherList)).thenReturn(false);
        PredicatedList<Object> anotherPredicatedList = new PredicatedList<>(anotherList, new Predicate<Object>() {

            @Override
            public boolean evaluate(Object obj) {
                return true;
            }
        });
        // Act
        boolean result = predicatedList.equals(anotherPredicatedList);
        // Assert
        assertFalse(result, "Should not be equal to another PredicatedList with non-equal decorated list");
    }
}
