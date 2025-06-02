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

    private DefaultKeyValue<String, String> defaultKeyValue;

    @BeforeEach
    public void setUp() {
        defaultKeyValue = new DefaultKeyValue<>("initialKey", "initialValue");
    }

    @Test
    public void testSetKey_ValidKey() {
        String newKey = "newKey";
        String oldKey = defaultKeyValue.setKey(newKey);
        assertEquals("initialKey", oldKey, "The old key should be the initial key.");
        assertEquals(newKey, defaultKeyValue.getKey(), "The current key should be the new key.");
    }

    @Test
    public void testSetKey_SelfReference() {
        assertThrows(IllegalArgumentException.class, () -> {
            // Pass a string key instead of the instance
            defaultKeyValue.setKey("initialKey");
        }, "Setting the key to itself should throw an IllegalArgumentException.");
    }
}
