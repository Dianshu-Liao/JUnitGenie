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

class MultiKeyMap_put_27_2_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap<>();
    }

    @Test
    void testPutWithValidKeyAndValue() {
        MultiKey<String> key = new MultiKey<>("key1", "key2");
        String value = "value1";
        String result = multiKeyMap.put(key, value);
        assertNull(result);
        assertEquals(value, multiKeyMap.get(key));
    }

    @Test
    void testPutWithExistingKey() {
        MultiKey<String> key = new MultiKey<>("key1", "key2");
        String value1 = "value1";
        String value2 = "value2";
        multiKeyMap.put(key, value1);
        String result = multiKeyMap.put(key, value2);
        assertEquals(value1, result);
        assertEquals(value2, multiKeyMap.get(key));
    }

    @Test
    void testPutWithNullKey() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            multiKeyMap.put(null, "value");
        });
        String expectedMessage = "key";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testPutWithNullValue() {
        MultiKey<String> key = new MultiKey<>("key1", "key2");
        String result = multiKeyMap.put(key, null);
        assertNull(result);
        assertNull(multiKeyMap.get(key));
    }

    @Test
    void testPutWithMultipleKeys() {
        MultiKey<String> key1 = new MultiKey<>("key1", "key2");
        MultiKey<String> key2 = new MultiKey<>("key3", "key4");
        String value1 = "value1";
        String value2 = "value2";
        multiKeyMap.put(key1, value1);
        multiKeyMap.put(key2, value2);
        assertEquals(value1, multiKeyMap.get(key1));
        assertEquals(value2, multiKeyMap.get(key2));
    }

    @Test
    void testPrivateMethodInvocation() throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod("checkKey", MultiKey.class);
        method.setAccessible(true);
        MultiKey<String> validKey = new MultiKey<>("key1", "key2");
        assertDoesNotThrow(() -> method.invoke(multiKeyMap, validKey));
        MultiKey<String> nullKey = null;
        Exception exception = assertThrows(NullPointerException.class, () -> {
            method.invoke(multiKeyMap, nullKey);
        });
        String expectedMessage = "key";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
