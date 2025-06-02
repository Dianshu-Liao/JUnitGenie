package org.apache.commons.collections4.set;

import java.lang.reflect.Method;
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

public class CompositeSet_addComposited_4_0_Test {

    private CompositeSet<String> compositeSet;

    @BeforeEach
    public void setUp() {
        compositeSet = new CompositeSet<>();
    }

    @Test
    public void testAddCompositedWithNonEmptySets() throws Exception {
        Set<String> set1 = new HashSet<>();
        set1.add("A");
        Set<String> set2 = new HashSet<>();
        set2.add("B");
        invokeAddComposited(set1, set2);
        assertEquals(2, compositeSet.getSets().size());
        assertTrue(compositeSet.getSets().get(0).contains("A"));
        assertTrue(compositeSet.getSets().get(1).contains("B"));
    }

    @Test
    public void testAddCompositedWithEmptySets() throws Exception {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        invokeAddComposited(set1, set2);
        assertEquals(0, compositeSet.getSets().size());
    }

    @Test
    public void testAddCompositedWithNullSets() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            invokeAddComposited(null, null);
        });
    }

    private void invokeAddComposited(Set<String> set1, Set<String> set2) throws Exception {
        Method method = CompositeSet.class.getDeclaredMethod("addComposited", Set.class, Set.class);
        method.setAccessible(true);
        method.invoke(compositeSet, set1, set2);
    }
}
