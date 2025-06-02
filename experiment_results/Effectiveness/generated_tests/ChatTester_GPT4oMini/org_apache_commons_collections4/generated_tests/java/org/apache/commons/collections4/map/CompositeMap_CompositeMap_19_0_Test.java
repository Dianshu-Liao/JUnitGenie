package org.apache.commons.collections4.map;

import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.collection.CompositeCollection;
import org.apache.commons.collections4.set.CompositeSet;

class CompositeMap_CompositeMap_19_0_Test {

    private CompositeMap<String, String> compositeMap;

    @BeforeEach
    void setUp() {
        // Setup the composite map with two sample maps
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        Map<String, String> map2 = new HashMap<>();
        map2.put("key2", "value2");
        compositeMap = new CompositeMap<>(map1, map2);
    }

    @Test
    void testCompositeMapInitialization() {
        assertNotNull(compositeMap, "CompositeMap should not be null after initialization");
    }

    @Test
    void testCompositeMapContainsKeys() {
        assertTrue(compositeMap.containsKey("key1"), "CompositeMap should contain key1 from map1");
        assertTrue(compositeMap.containsKey("key2"), "CompositeMap should contain key2 from map2");
        assertFalse(compositeMap.containsKey("key3"), "CompositeMap should not contain key3");
    }

    @Test
    void testCompositeMapGetValues() {
        assertEquals("value1", compositeMap.get("key1"), "CompositeMap should return value1 for key1");
        assertEquals("value2", compositeMap.get("key2"), "CompositeMap should return value2 for key2");
        assertNull(compositeMap.get("key3"), "CompositeMap should return null for non-existent key");
    }

    @Test
    void testCompositeMapSize() {
        assertEquals(2, compositeMap.size(), "CompositeMap size should be 2 after initialization with two maps");
    }

    @Test
    void testCompositeMapIsEmpty() {
        assertFalse(compositeMap.isEmpty(), "CompositeMap should not be empty after initialization");
    }
}
