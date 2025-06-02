package org.apache.commons.collections4.map;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.AbstractHashedMap.HashEntry;

public class MultiKeyMap_removeMultiKey_36_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value1");
        multiKeyMap.put(new MultiKey<>("key5", "key6", "key7", "key8"), "value2");
    }

    @Test
    public void testRemoveMultiKey_ExistingKeys() throws Exception {
        String result = invokeRemoveMultiKey("key1", "key2", "key3", "key4");
        assertEquals("value1", result);
        assertNull(multiKeyMap.get(new MultiKey<>("key1", "key2", "key3", "key4")));
    }

    @Test
    public void testRemoveMultiKey_NonExistingKeys() throws Exception {
        String result = invokeRemoveMultiKey("nonExistentKey1", "nonExistentKey2", "nonExistentKey3", "nonExistentKey4");
        assertNull(result);
    }

    @Test
    public void testRemoveMultiKey_PartialMatch() throws Exception {
        String result = invokeRemoveMultiKey("key1", "key2", null, "key4");
        assertNull(result);
    }

    private String invokeRemoveMultiKey(Object key1, Object key2, Object key3, Object key4) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod("removeMultiKey", Object.class, Object.class, Object.class, Object.class);
        method.setAccessible(true);
        return (String) method.invoke(multiKeyMap, key1, key2, key3, key4);
    }
}
