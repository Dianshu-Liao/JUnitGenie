package org.apache.commons.collections4.map;

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
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.AbstractHashedMap.HashEntry;

public class MultiKeyMap_put_24_1_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
    }

    @Test
    public void testPut_NewEntry() throws Exception {
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String value = "value1";
        String result = invokePut(key1, key2, key3, key4, value);
        assertNull(result);
    }

    @Test
    public void testPut_ExistingEntry() throws Exception {
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String value1 = "value1";
        String value2 = "value2";
        invokePut(key1, key2, key3, key4, value1);
        String result = invokePut(key1, key2, key3, key4, value2);
        assertEquals(value1, result);
    }

    @Test
    public void testPut_DifferentKeys() throws Exception {
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String value1 = "value1";
        String value2 = "value2";
        invokePut(key1, key2, key3, key4, value1);
        String result = invokePut("key5", "key6", "key7", "key8", value2);
        assertNull(result);
    }

    private String invokePut(String key1, String key2, String key3, String key4, String value) throws Exception {
        Method putMethod = MultiKeyMap.class.getDeclaredMethod("put", Object.class, Object.class, Object.class, Object.class, Object.class);
        putMethod.setAccessible(true);
        return (String) putMethod.invoke(multiKeyMap, key1, key2, key3, key4, value);
    }
}
