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

public class AbstractListDecorator_equals_3_1_Test {

    private TestListDecorator listDecorator1;

    private TestListDecorator listDecorator2;

    private TestListDecorator listDecorator3;

    @BeforeEach
    public void setUp() {
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        listDecorator1 = new TestListDecorator(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("A");
        list2.add("B");
        listDecorator2 = new TestListDecorator(list2);
        List<String> list3 = new ArrayList<>();
        list3.add("C");
        list3.add("D");
        listDecorator3 = new TestListDecorator(list3);
    }

    @Test
    public void testEqualsSameInstance() {
        assertTrue(listDecorator1.equals(listDecorator1), "Should be equal to itself");
    }

    @Test
    public void testEqualsEqualDecoratedLists() {
        assertTrue(listDecorator1.equals(listDecorator2), "Should be equal to another decorator with the same content");
    }

    @Test
    public void testEqualsDifferentDecoratedLists() {
        assertFalse(listDecorator1.equals(listDecorator3), "Should not be equal to another decorator with different content");
    }

    @Test
    public void testEqualsNull() {
        assertFalse(listDecorator1.equals(null), "Should not be equal to null");
    }

    @Test
    public void testEqualsDifferentType() {
        assertFalse(listDecorator1.equals("Not a list"), "Should not be equal to an object of a different type");
    }

    private static class TestListDecorator extends AbstractListDecorator<String> {

        protected TestListDecorator(List<String> list) {
            super(list);
        }

        @Override
        protected List<String> decorated() {
            return super.decorated();
        }
    }
}
