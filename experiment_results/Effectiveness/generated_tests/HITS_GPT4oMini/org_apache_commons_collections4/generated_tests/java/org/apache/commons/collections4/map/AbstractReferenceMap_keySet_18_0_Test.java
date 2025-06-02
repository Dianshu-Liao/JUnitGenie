package org.apache.commons.collections4.map;

import java.util.Set;
import org.apache.commons.collections4.keyvalue.DefaultMapEntry;
// Importing ReferenceKeySet
import org.apache.commons.collections4.map.AbstractReferenceMap.ReferenceKeySet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

public class AbstractReferenceMap_keySet_18_0_Test {

    private AbstractReferenceMap map;

    // Mock subclass to test the abstract class
    private class TestReferenceMap extends AbstractReferenceMap {

        public TestReferenceMap() {
            super(ReferenceStrength.WEAK, ReferenceStrength.SOFT, 16, 0.75f, false);
        }
    }

    @BeforeEach
    public void setUp() {
        map = new TestReferenceMap();
    }

    @Test
    public void testKeySetInitialization() {
        // Ensure keySet is null before calling keySet()
        assertNull(map.keySet);
        // Call keySet() method
        Set<?> keys = map.keySet();
        // Verify that keySet is initialized
        assertNotNull(keys);
        assertTrue(keys instanceof ReferenceKeySet);
    }

    @Test
    public void testKeySetReturnsSameInstance() {
        // Call keySet() multiple times and ensure the same instance is returned
        Set<?> firstCall = map.keySet();
        Set<?> secondCall = map.keySet();
        assertSame(firstCall, secondCall);
    }

    @Test
    public void testKeySetNotNullAfterMultipleCalls() {
        // Call keySet() method
        map.keySet();
        // Ensure that keySet is not null after first call
        assertNotNull(map.keySet);
        // Call keySet() again
        map.keySet();
        // Ensure that keySet remains not null
        assertNotNull(map.keySet);
    }
}
