package org.apache.commons.collections4.map;

import java.util.Set;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.keyvalue.DefaultMapEntry;

class AbstractReferenceMap_keySet_18_1_Test {

    private AbstractReferenceMap<Object, Object> map;

    // A concrete implementation of AbstractReferenceMap for testing purposes
    private class TestReferenceMap extends AbstractReferenceMap<Object, Object> {

        public TestReferenceMap() {
            super(ReferenceStrength.WEAK, ReferenceStrength.SOFT, 16, 0.75f, true);
        }
    }

    @BeforeEach
    void setUp() {
        map = new TestReferenceMap();
    }

    @Test
    void testKeySetNotNull() {
        Set<Object> keySet = map.keySet();
        assertNotNull(keySet, "Key set should not be null");
    }

    @Test
    void testKeySetIsInstanceOfReferenceKeySet() {
        Set<Object> keySet = map.keySet();
        assertTrue(keySet instanceof AbstractReferenceMap.ReferenceKeySet, "Key set should be an instance of ReferenceKeySet");
    }

    @Test
    void testKeySetReturnsSameInstance() {
        Set<Object> keySet1 = map.keySet();
        Set<Object> keySet2 = map.keySet();
        assertSame(keySet1, keySet2, "Key set should return the same instance on multiple calls");
    }

    @Test
    void testKeySetIsEmptyInitially() {
        Set<Object> keySet = map.keySet();
        assertTrue(keySet.isEmpty(), "Key set should be empty initially");
    }
}
