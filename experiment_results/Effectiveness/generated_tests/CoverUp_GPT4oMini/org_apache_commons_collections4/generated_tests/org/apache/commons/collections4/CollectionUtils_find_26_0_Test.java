package org.apache.commons.collections4;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.functors.TruePredicate;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.collection.SynchronizedCollection;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.collection.UnmodifiableBoundedCollection;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.apache.commons.collections4.iterators.PermutationIterator;

public class CollectionUtils_find_26_0_Test {

    @Test
    public void testFindWithMatchingElement() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        // Using a predicate that matches the number 2
        Integer result = invokeFindMethod(list, element -> element.equals(2));
        assertEquals(2, result);
    }

    @Test
    public void testFindWithNoMatchingElement() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        // Using a predicate that does not match any element
        Integer result = invokeFindMethod(list, element -> element.equals(2));
        assertNull(result);
    }

    @Test
    public void testFindWithNullPredicate() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        // Passing a null predicate
        Integer result = invokeFindMethod(list, null);
        assertNull(result);
    }

    private <T> T invokeFindMethod(Iterable<T> collection, Predicate<? super T> predicate) throws Exception {
        Method method = CollectionUtils.class.getDeclaredMethod("find", Iterable.class, Predicate.class);
        method.setAccessible(true);
        return (T) method.invoke(null, collection, predicate);
    }
}
