package org.apache.commons.collections4.keyvalue;

import org.apache.commons.collections4.keyvalue.DefaultKeyValue;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.KeyValue;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class DefaultKeyValue_setKey_2_2_Test {

    @Test
    void testSetKey_ValidKey() throws Exception {
        DefaultKeyValue<String, String> keyValue = new DefaultKeyValue<>("initialKey", "value");
        String oldKey = keyValue.setKey("newKey");
        assertEquals("initialKey", oldKey);
        assertEquals("newKey", keyValue.getKey());
    }

    @Test
    void testSetKey_SelfReference() {
        DefaultKeyValue<String, String> keyValue = new DefaultKeyValue<>("key", "value");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // Pass the key as a String
            keyValue.setKey(keyValue.getKey());
        });
        assertEquals("DefaultKeyValue may not contain itself as a key.", exception.getMessage());
    }

    @Test
    void testSetKey_NullKey() throws Exception {
        DefaultKeyValue<String, String> keyValue = new DefaultKeyValue<>("key", "value");
        String oldKey = keyValue.setKey(null);
        assertEquals("key", oldKey);
        assertNull(keyValue.getKey());
    }

    @Test
    void testSetKey_SameKey() throws Exception {
        DefaultKeyValue<String, String> keyValue = new DefaultKeyValue<>("key", "value");
        String oldKey = keyValue.setKey("key");
        assertEquals("key", oldKey);
        assertEquals("key", keyValue.getKey());
    }

    @Test
    void testSetKey_EmptyStringKey() throws Exception {
        DefaultKeyValue<String, String> keyValue = new DefaultKeyValue<>("key", "value");
        String oldKey = keyValue.setKey("");
        assertEquals("key", oldKey);
        assertEquals("", keyValue.getKey());
    }
}
