package org.apache.commons.collections4.keyvalue;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.KeyValue;

public class DefaultKeyValue_setKey_2_0_Test {

    private DefaultKeyValue<Object, Object> defaultKeyValue;

    @BeforeEach
    public void setUp() {
        defaultKeyValue = new DefaultKeyValue<>();
    }

    @Test
    public void testSetKey_withValidKey() {
        Object key = new Object();
        defaultKeyValue.setKey(key);
        // Assuming there's a way to retrieve the key, which is not shown in the provided code.
        assertEquals(key, defaultKeyValue.getKey());
    }

    @Test
    public void testSetKey_withSelfReference() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            defaultKeyValue.setKey(defaultKeyValue);
        });
        assertEquals("DefaultKeyValue may not contain itself as a key.", exception.getMessage());
    }

    @Test
    public void testSetKey_withNullKey() {
        defaultKeyValue.setKey(null);
        // Assuming there's a way to retrieve the key, which is not shown in the provided code.
        assertNull(defaultKeyValue.getKey());
    }
}
