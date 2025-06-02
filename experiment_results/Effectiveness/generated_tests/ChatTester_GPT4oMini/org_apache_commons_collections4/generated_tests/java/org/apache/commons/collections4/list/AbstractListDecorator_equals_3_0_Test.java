package org.apache.commons.collections4.list;

import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.ListIterator;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

class AbstractListDecorator_equals_3_0_Test {

    // A concrete implementation of AbstractListDecorator for testing
    private static class TestListDecorator extends AbstractListDecorator {

        private final List<Object> list;

        TestListDecorator(List<Object> list) {
            super(list);
            this.list = list;
        }

        @Override
        protected List<Object> decorated() {
            return list;
        }
    }

    @Test
    void testEquals_SameInstance() {
        TestListDecorator decorator = new TestListDecorator(new ArrayList<>());
        assertTrue(decorator.equals(decorator), "Should be equal to itself");
    }

    @Test
    void testEquals_Null() {
        TestListDecorator decorator = new TestListDecorator(new ArrayList<>());
        assertFalse(decorator.equals(null), "Should not be equal to null");
    }

    @Test
    void testEquals_DifferentType() {
        TestListDecorator decorator = new TestListDecorator(new ArrayList<>());
        assertFalse(decorator.equals("Not a list"), "Should not be equal to an object of a different type");
    }

    @Test
    void testEquals_EqualToDecoratedList() {
        List<Object> list = new ArrayList<>();
        list.add("item");
        TestListDecorator decorator = new TestListDecorator(list);
        assertTrue(decorator.equals(list), "Should be equal to the decorated list");
    }

    @Test
    void testEquals_NotEqualToDecoratedList() {
        List<Object> list = new ArrayList<>();
        list.add("item");
        TestListDecorator decorator = new TestListDecorator(list);
        assertFalse(decorator.equals(new ArrayList<>()), "Should not be equal to a different list");
    }

    @Test
    void testEquals_EqualToDifferentDecorator() {
        List<Object> list = new ArrayList<>();
        list.add("item");
        TestListDecorator decorator1 = new TestListDecorator(list);
        TestListDecorator decorator2 = new TestListDecorator(list);
        assertTrue(decorator1.equals(decorator2), "Should be equal to another decorator with the same decorated list");
    }
}
