package org.apache.commons.collections4.keyvalue;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.KeyValue;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TiedMapEntry_hashCode_3_0_Test {

    private TiedMapEntry<String, String> entryWithNonNullKeyValue;

    private TiedMapEntry<String, String> entryWithNullKey;

    private TiedMapEntry<String, String> entryWithNullValue;

    private TiedMapEntry<String, String> entryWithBothNull;

    private Map<String, String> map;

    @BeforeEach
    public void setUp() {
        map = new HashMap<>();
        map.put("key1", "value1");
        entryWithNonNullKeyValue = new TiedMapEntry<>(map, "key1");
        entryWithNullKey = new TiedMapEntry<>(map, null);
        entryWithNullValue = new TiedMapEntry<>(map, "key1");
        // Set value to null using reflection
        try {
            // Corrected the usage of 'var' to 'Method'
            java.lang.reflect.Method method = TiedMapEntry.class.getDeclaredMethod("setValue", Object.class);
            method.setAccessible(true);
            method.invoke(entryWithNullValue, (Object) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        entryWithBothNull = new TiedMapEntry<>(map, null);
    }

    @Test
    public void testHashCodeWithNonNullKeyAndValue() throws Exception {
        int expectedHashCode = "key1".hashCode() ^ "value1".hashCode();
        assertEquals(expectedHashCode, invokeHashCode(entryWithNonNullKeyValue));
    }

    @Test
    public void testHashCodeWithNullKey() throws Exception {
        int expectedHashCode = 0 ^ "value1".hashCode();
        assertEquals(expectedHashCode, invokeHashCode(entryWithNullKey));
    }

    @Test
    public void testHashCodeWithNullValue() throws Exception {
        int expectedHashCode = "key1".hashCode() ^ 0;
        assertEquals(expectedHashCode, invokeHashCode(entryWithNullValue));
    }

    @Test
    public void testHashCodeWithBothNull() throws Exception {
        int expectedHashCode = 0 ^ 0;
        assertEquals(expectedHashCode, invokeHashCode(entryWithBothNull));
    }

    private int invokeHashCode(TiedMapEntry<String, String> entry) throws Exception {
        // Corrected the usage of 'var' to 'Method'
        java.lang.reflect.Method method = TiedMapEntry.class.getDeclaredMethod("hashCode");
        method.setAccessible(true);
        return (int) method.invoke(entry);
    }
}
