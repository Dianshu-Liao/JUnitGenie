package org.apache.commons.collections4.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

public class CompositeSet_hashCode_11_0_Test {

    @Test
    public void testHashCodeWithEmptySet() {
        CompositeSet<String> compositeSet = new CompositeSet<>();
        assertEquals(0, compositeSet.hashCode(), "Hash code of an empty CompositeSet should be 0.");
    }

    @Test
    public void testHashCodeWithSingleElementSet() {
        Set<String> singleElementSet = new HashSet<>(Arrays.asList("element1"));
        CompositeSet<String> compositeSet = new CompositeSet<>(singleElementSet);
        assertEquals("element1".hashCode(), compositeSet.hashCode(), "Hash code should match the hash code of the single element.");
    }

    @Test
    public void testHashCodeWithMultipleElementsSet() {
        Set<String> firstSet = new HashSet<>(Arrays.asList("element1", "element2"));
        Set<String> secondSet = new HashSet<>(Arrays.asList("element3"));
        CompositeSet<String> compositeSet = new CompositeSet<>(firstSet, secondSet);
        int expectedHashCode = "element1".hashCode() + "element2".hashCode() + "element3".hashCode();
        assertEquals(expectedHashCode, compositeSet.hashCode(), "Hash code should be the sum of hash codes of all elements.");
    }

    @Test
    public void testHashCodeWithNullElement() {
        Set<String> setWithNull = new HashSet<>(Arrays.asList("element1", null, "element2"));
        CompositeSet<String> compositeSet = new CompositeSet<>(setWithNull);
        int expectedHashCode = "element1".hashCode() + 0 + "element2".hashCode();
        assertEquals(expectedHashCode, compositeSet.hashCode(), "Hash code should treat null element as 0.");
    }

    @Test
    public void testHashCodeWithAllNullElements() {
        Set<String> allNullSet = new HashSet<>(Arrays.asList(null, null));
        CompositeSet<String> compositeSet = new CompositeSet<>(allNullSet);
        assertEquals(0, compositeSet.hashCode(), "Hash code of a CompositeSet with all null elements should be 0.");
    }

    @Test
    public void testHashCodeWithDifferentSets() {
        Set<String> set1 = new HashSet<>(Arrays.asList("a", "b"));
        Set<String> set2 = new HashSet<>(Arrays.asList("c", "d"));
        CompositeSet<String> compositeSet1 = new CompositeSet<>(set1);
        CompositeSet<String> compositeSet2 = new CompositeSet<>(set2);
        assertNotEquals(compositeSet1.hashCode(), compositeSet2.hashCode(), "Hash codes of different CompositeSets should not be equal.");
    }
}
