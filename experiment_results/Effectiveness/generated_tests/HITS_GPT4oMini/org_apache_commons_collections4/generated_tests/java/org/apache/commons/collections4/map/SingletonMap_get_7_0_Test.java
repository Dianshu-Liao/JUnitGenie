package org.apache.commons.collections4.map;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.BoundedMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.SingletonIterator;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;

public class SingletonMap_get_7_0_Test {

    private SingletonMap<String, String> singletonMap;

    @BeforeEach
    public void setUp() {
        singletonMap = new SingletonMap<>("key", "value");
    }

    @Test
    public void testGetReturnsValueForEqualKey() {
        String result = singletonMap.get("key");
        assertEquals("value", result, "Expected to return the value for the equal key.");
    }

    @Test
    public void testGetReturnsNullForDifferentKey() {
        String result = singletonMap.get("differentKey");
        assertNull(result, "Expected to return null for a different key.");
    }

    @Test
    public void testGetReturnsNullForNullKeyWhenKeyIsNotNull() {
        singletonMap = new SingletonMap<>("key", "value");
        String result = singletonMap.get(null);
        assertNull(result, "Expected to return null when the key is null and the map key is not null.");
    }

    @Test
    public void testGetReturnsValueForNullKeyWhenKeyIsNull() {
        singletonMap = new SingletonMap<>(null, "value");
        String result = singletonMap.get(null);
        assertEquals("value", result, "Expected to return the value when both keys are null.");
    }
}
