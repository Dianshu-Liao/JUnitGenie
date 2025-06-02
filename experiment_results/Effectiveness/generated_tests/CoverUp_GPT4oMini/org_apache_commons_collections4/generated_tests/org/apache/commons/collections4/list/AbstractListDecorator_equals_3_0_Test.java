package org.apache.commons.collections4.list;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.Collection;
import java.util.ListIterator;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

@ExtendWith(MockitoExtension.class)
public class AbstractListDecorator_equals_3_0_Test {

    private AbstractListDecorator<String> listDecorator;

    private List<String> decoratedList;

    @BeforeEach
    public void setUp() {
        decoratedList = new ArrayList<>();
        decoratedList.add("Test");
        listDecorator = new AbstractListDecorator<String>(decoratedList) {
        };
    }

    @Test
    public void testEquals_SameInstance() {
        assertTrue(listDecorator.equals(listDecorator));
    }

    @Test
    public void testEquals_Null() {
        assertFalse(listDecorator.equals(null));
    }

    @Test
    public void testEquals_DifferentType() {
        assertFalse(listDecorator.equals("Some String"));
    }

    @Test
    public void testEquals_EqualDecoratedList() {
        AbstractListDecorator<String> anotherListDecorator = new AbstractListDecorator<String>(decoratedList) {
        };
        assertTrue(listDecorator.equals(anotherListDecorator));
    }

    @Test
    public void testEquals_DifferentDecoratedList() {
        List<String> anotherList = new ArrayList<>();
        anotherList.add("Different");
        AbstractListDecorator<String> anotherListDecorator = new AbstractListDecorator<String>(anotherList) {
        };
        assertFalse(listDecorator.equals(anotherListDecorator));
    }

    @Test
    public void testEquals_EqualWithDifferentDecoratedListContents() throws Exception {
        List<String> anotherList = new ArrayList<>();
        anotherList.add("Test");
        AbstractListDecorator<String> anotherListDecorator = new AbstractListDecorator<String>(anotherList) {
        };
        // Using reflection to set the decorated list
        Field decoratedField = AbstractListDecorator.class.getDeclaredField("decorated");
        decoratedField.setAccessible(true);
        decoratedField.set(anotherListDecorator, decoratedList);
        assertTrue(listDecorator.equals(anotherListDecorator));
    }
}
