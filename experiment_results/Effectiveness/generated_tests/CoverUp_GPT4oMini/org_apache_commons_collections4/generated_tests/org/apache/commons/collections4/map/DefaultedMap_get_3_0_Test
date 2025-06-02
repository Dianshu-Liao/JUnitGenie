package org.apache.commons.collections4.map;

import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.ConstantTransformer;
import java.util.HashMap;
import java.util.Map;
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
import java.util.Objects;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.functors.FactoryTransformer;

class DefaultedMap_get_3_0_Test {

    private DefaultedMap<String, String> defaultedMap;

    private Transformer<String, String> transformer;

    @BeforeEach
    void setUp() {
        transformer = ConstantTransformer.constantTransformer("default");
        defaultedMap = new DefaultedMap<>(transformer);
    }

    @Test
    void testGetReturnsDefaultForNullKey() {
        assertEquals("default", defaultedMap.get(null));
    }

    @Test
    void testGetReturnsDefaultForUnknownKey() {
        assertEquals("default", defaultedMap.get("unknownKey"));
    }

    @Test
    void testGetReturnsValueForKnownKey() {
        Map<String, String> map = new HashMap<>();
        map.put("knownKey", "value");
        defaultedMap = new DefaultedMap<>(map, transformer);
        assertEquals("value", defaultedMap.get("knownKey"));
    }

    @Test
    void testGetReturnsDefaultForKeyNotInMap() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        defaultedMap = new DefaultedMap<>(map, transformer);
        assertEquals("default", defaultedMap.get("key2"));
    }

    @Test
    void testGetReturnsValueForKeyInMap() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        defaultedMap = new DefaultedMap<>(map, transformer);
        assertEquals("value1", defaultedMap.get("key1"));
    }

    @Test
    void testGetReturnsDefaultForKeyInMapWithNullValue() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", null);
        defaultedMap = new DefaultedMap<>(map, transformer);
        assertEquals("default", defaultedMap.get("key1"));
    }

    @Test
    void testGetReturnsDefaultForKeyWithNullTransformer() {
        defaultedMap = new DefaultedMap<>(ConstantTransformer.NULL_INSTANCE);
        assertNull(defaultedMap.get("anyKey"));
    }
}
