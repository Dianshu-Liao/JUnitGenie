package org.apache.commons.collections4.map;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.KeyValue;

public class StaticBucketMap_equals_6_0_Test {

    private StaticBucketMap<String, String> map1;

    private StaticBucketMap<String, String> map2;

    private StaticBucketMap<String, String> map3;

    @BeforeEach
    public void setUp() {
        map1 = new StaticBucketMap<>(10);
        map2 = new StaticBucketMap<>(10);
        map3 = new StaticBucketMap<>(20);
    }

    @Test
    public void testEquals_SameInstance() {
        assertTrue(map1.equals(map1));
    }

    @Test
    public void testEquals_NullObject() {
        assertFalse(map1.equals(null));
    }

    @Test
    public void testEquals_NonMapObject() {
        assertFalse(map1.equals("Not a Map"));
    }

    @Test
    public void testEquals_DifferentSizeMaps() {
        map1.put("key1", "value1");
        map2.put("key2", "value2");
        assertFalse(map1.equals(map2));
    }

    @Test
    public void testEquals_SameContent() {
        map1.put("key1", "value1");
        map2.put("key1", "value1");
        assertTrue(map1.equals(map2));
    }

    @Test
    public void testEquals_DifferentContent() {
        map1.put("key1", "value1");
        map2.put("key1", "value2");
        assertFalse(map1.equals(map2));
    }

    @Test
    public void testEquals_EmptyMaps() {
        assertTrue(map1.equals(map2));
    }

    @Test
    public void testEquals_DifferentBucketSizes() {
        map1.put("key1", "value1");
        map3.put("key1", "value1");
        assertFalse(map1.equals(map3));
    }

    // Reflection test for private method if needed
    @Test
    public void testPrivateMethodReflection() throws Exception {
        Method method = StaticBucketMap.class.getDeclaredMethod("somePrivateMethod");
        method.setAccessible(true);
        // Invoke the private method and assert the expected outcome
        method.invoke(map1);
    }
}
