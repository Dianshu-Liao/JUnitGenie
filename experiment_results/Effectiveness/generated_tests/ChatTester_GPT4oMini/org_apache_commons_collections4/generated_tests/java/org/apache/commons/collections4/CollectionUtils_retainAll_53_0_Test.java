package org.apache.commons.collections4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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

public class CollectionUtils_retainAll_53_0_Test {

    @Test
    public void testRetainAll() {
        // Test with non-empty collections
        Collection<String> collection = Arrays.asList("a", "b", "c", "d");
        Collection<String> retain = Arrays.asList("b", "d");
        Collection<String> result = CollectionUtils.retainAll(collection, retain);
        Assertions.assertEquals(Arrays.asList("b", "d"), result);
        // Test with empty retain collection
        retain = Collections.emptyList();
        result = CollectionUtils.retainAll(collection, retain);
        Assertions.assertEquals(Collections.emptyList(), result);
        // Test with empty original collection
        collection = Collections.emptyList();
        retain = Arrays.asList("b", "d");
        result = CollectionUtils.retainAll(collection, retain);
        Assertions.assertEquals(Collections.emptyList(), result);
        // Test with null collection
        // Making retain effectively final
        Collection<String> finalRetain = retain;
        Assertions.assertThrows(NullPointerException.class, () -> {
            CollectionUtils.retainAll(null, finalRetain);
        });
        // Test with null retain collection
        // Making collection effectively final
        Collection<String> finalCollection = collection;
        Assertions.assertThrows(NullPointerException.class, () -> {
            CollectionUtils.retainAll(finalCollection, null);
        });
    }
}
