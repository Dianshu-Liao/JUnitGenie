// Change this to the appropriate package name
package org.apache.commons.collections4;

import java.util.Arrays;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.util.ArrayList;
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
import org.apache.commons.collections4.functors.TruePredicate;
import org.apache.commons.collections4.iterators.CollatingIterator;
import org.apache.commons.collections4.iterators.PermutationIterator;

public class CollectionUtils_forAllButLastDo_27_1_Test {

    @Test
    public void testForAllButLastDo_withValidInput() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        StringBuilder result = new StringBuilder();
        CollectionUtils.forAllButLastDo(numbers, new Closure<Integer>() {

            @Override
            public void execute(Integer input) {
                result.append(input).append(" ");
            }
        });
        assertEquals("1 2 3 4 ", result.toString());
    }

    @Test
    public void testForAllButLastDo_withEmptyCollection() {
        List<Integer> numbers = Arrays.asList();
        StringBuilder result = new StringBuilder();
        CollectionUtils.forAllButLastDo(numbers, new Closure<Integer>() {

            @Override
            public void execute(Integer input) {
                result.append(input).append(" ");
            }
        });
        assertEquals("", result.toString());
    }

    @Test
    public void testForAllButLastDo_withSingleElement() {
        List<Integer> numbers = Arrays.asList(1);
        StringBuilder result = new StringBuilder();
        CollectionUtils.forAllButLastDo(numbers, new Closure<Integer>() {

            @Override
            public void execute(Integer input) {
                result.append(input).append(" ");
            }
        });
        assertEquals("", result.toString());
    }

    @Test
    public void testForAllButLastDo_withNullClosure() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        assertNull(CollectionUtils.forAllButLastDo(numbers, null));
    }

    @Test
    public void testForAllButLastDo_withMultipleElements() {
        List<String> strings = Arrays.asList("A", "B", "C", "D");
        StringBuilder result = new StringBuilder();
        CollectionUtils.forAllButLastDo(strings, new Closure<String>() {

            @Override
            public void execute(String input) {
                result.append(input).append(" ");
            }
        });
        assertEquals("A B C ", result.toString());
    }
}

interface Closure<T> {

    void execute(T input);
}
