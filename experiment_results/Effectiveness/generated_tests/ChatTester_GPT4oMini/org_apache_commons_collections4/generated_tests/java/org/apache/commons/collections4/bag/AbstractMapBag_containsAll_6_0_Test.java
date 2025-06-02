package org.apache.commons.collections4.bag;

import java.util.Collection;
import java.util.HashSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.set.UnmodifiableSet;

class AbstractMapBag_containsAll_6_0_Test {

    private AbstractMapBag<Object> abstractMapBag;

    @BeforeEach
    void setUp() {
        abstractMapBag = Mockito.mock(AbstractMapBag.class, Mockito.CALLS_REAL_METHODS);
    }

    @Test
    void testContainsAllWithBag() {
        Bag<Object> bag = mock(Bag.class);
        when(bag.size()).thenReturn(3);
        when(abstractMapBag.containsAll(bag)).thenReturn(true);
        assertTrue(abstractMapBag.containsAll(bag));
        verify(abstractMapBag).containsAll(bag);
    }

    @Test
    void testContainsAllWithCollection() {
        Collection<Object> collection = new HashSet<>();
        Object obj1 = new Object();
        Object obj2 = new Object();
        collection.add(obj1);
        collection.add(obj2);
        // Assuming HashBag constructor handles the collection correctly
        HashBag<Object> hashBag = new HashBag<>(collection);
        when(abstractMapBag.containsAll(eq(hashBag))).thenReturn(true);
        assertTrue(abstractMapBag.containsAll(collection));
        verify(abstractMapBag).containsAll(eq(hashBag));
    }

    @Test
    void testContainsAllWithEmptyCollection() {
        Collection<Object> emptyCollection = new HashSet<>();
        assertTrue(abstractMapBag.containsAll(emptyCollection));
    }

    @Test
    void testContainsAllWithNullCollection() {
        assertThrows(NullPointerException.class, () -> abstractMapBag.containsAll(null));
    }

    @Test
    void testContainsAllWithNonBagCollection() {
        Collection<Object> collection = new HashSet<>();
        collection.add(new Object());
        // Assuming the HashBag constructor handles the collection correctly
        HashBag<Object> hashBag = new HashBag<>(collection);
        when(abstractMapBag.containsAll(eq(hashBag))).thenReturn(false);
        assertFalse(abstractMapBag.containsAll(collection));
        verify(abstractMapBag).containsAll(eq(hashBag));
    }
}
