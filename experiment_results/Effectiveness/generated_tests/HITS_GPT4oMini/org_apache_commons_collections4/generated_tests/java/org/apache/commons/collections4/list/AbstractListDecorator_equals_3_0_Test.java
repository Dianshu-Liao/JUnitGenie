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

    private TestListDecorator listDecorator1;

    private TestListDecorator listDecorator2;

    private TestListDecorator listDecorator3;

    private static class TestListDecorator extends AbstractListDecorator {

        private final List<String> list;

        public TestListDecorator(List<String> list) {
            super(list);
            this.list = list;
        }

        @Override
        protected List<String> decorated() {
            return list;
        }
    }

    @BeforeEach
    void setUp() {
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        listDecorator1 = new TestListDecorator(list1);
        List<String> list2 = new ArrayList<>(list1);
        listDecorator2 = new TestListDecorator(list2);
        List<String> list3 = new ArrayList<>();
        listDecorator3 = new TestListDecorator(list3);
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(listDecorator1.equals(listDecorator1), "Should be equal to itself");
    }

    @Test
    void testEquals_EqualDecoratedLists() {
        assertTrue(listDecorator1.equals(listDecorator2), "Should be equal to another decorator with the same list");
    }

    @Test
    void testEquals_Null() {
        assertFalse(listDecorator1.equals(null), "Should not be equal to null");
    }

    @Test
    void testEquals_DifferentType() {
        assertFalse(listDecorator1.equals("Some String"), "Should not be equal to an object of a different type");
    }

    @Test
    void testEquals_DifferentDecoratedLists() {
        assertFalse(listDecorator1.equals(listDecorator3), "Should not be equal to a decorator with a different list");
    }

    @Test
    void testEquals_EqualListsDifferentOrder() {
        List<String> list4 = new ArrayList<>();
        list4.add("C");
        list4.add("A");
        list4.add("B");
        TestListDecorator listDecorator4 = new TestListDecorator(list4);
        assertFalse(listDecorator1.equals(listDecorator4), "Should not be equal to a decorator with a different order of elements");
    }
}
