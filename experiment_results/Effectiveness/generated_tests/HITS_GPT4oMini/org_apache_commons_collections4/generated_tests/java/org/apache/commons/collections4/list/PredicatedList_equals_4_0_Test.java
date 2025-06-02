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

    @Test
    public void testEquals_SameInstance() {
        PredicatedList<Integer> list = new PredicatedList<>(new ArrayList<>(), (Predicate<Integer>) object -> true);
        assertTrue(list.equals(list), "The list should be equal to itself.");
    }

    @Test
    public void testEquals_Null() {
        PredicatedList<Integer> list = new PredicatedList<>(new ArrayList<>(), (Predicate<Integer>) object -> true);
        assertFalse(list.equals(null), "The list should not be equal to null.");
    }

    @Test
    public void testEquals_DifferentType() {
        PredicatedList<Integer> list = new PredicatedList<>(new ArrayList<>(), (Predicate<Integer>) object -> true);
        String nonListObject = "Not a list";
        assertFalse(list.equals(nonListObject), "The list should not be equal to an object of a different type.");
    }

    @Test
    public void testEquals_EqualLists() {
        List<Integer> baseList1 = new ArrayList<>();
        List<Integer> baseList2 = new ArrayList<>();
        baseList1.add(1);
        baseList2.add(1);
        PredicatedList<Integer> list1 = new PredicatedList<>(baseList1, (Predicate<Integer>) object -> true);
        PredicatedList<Integer> list2 = new PredicatedList<>(baseList2, (Predicate<Integer>) object -> true);
        assertTrue(list1.equals(list2), "Two predicated lists with the same elements should be equal.");
    }

    @Test
    public void testEquals_NotEqualLists() {
        List<Integer> baseList1 = new ArrayList<>();
        List<Integer> baseList2 = new ArrayList<>();
        baseList1.add(1);
        baseList2.add(2);
        PredicatedList<Integer> list1 = new PredicatedList<>(baseList1, (Predicate<Integer>) object -> true);
        PredicatedList<Integer> list2 = new PredicatedList<>(baseList2, (Predicate<Integer>) object -> true);
        assertFalse(list1.equals(list2), "Two predicated lists with different elements should not be equal.");
    }
}
