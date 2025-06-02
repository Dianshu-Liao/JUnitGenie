package org.apache.commons.collections4;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
import org.apache.commons.collections4.multimap.UnmodifiableMultiValuedMap;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.multimap.TransformedMultiValuedMap;

class MultiMapUtils_getValuesAsSet_5_0_Test {

    @Test
    void testGetValuesAsSet_NullMap() {
        assertNull(MultiMapUtils.getValuesAsSet(null, "key"));
    }

    @Test
    void testGetValuesAsSet_EmptyMap() {
        MultiValuedMap<String, String> emptyMap = new ArrayListValuedHashMap<>();
        Set<String> result = MultiMapUtils.getValuesAsSet(emptyMap, "key");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetValuesAsSet_WithArrayListValuedHashMap() {
        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
        map.put("key", "value1");
        map.put("key", "value2");
        Set<String> result = MultiMapUtils.getValuesAsSet(map, "key");
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains("value1"));
        assertTrue(result.contains("value2"));
    }

    @Test
    void testGetValuesAsSet_WithHashSetValuedHashMap() {
        MultiValuedMap<String, String> map = new HashSetValuedHashMap<>();
        map.put("key", "value1");
        map.put("key", "value2");
        Set<String> result = MultiMapUtils.getValuesAsSet(map, "key");
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains("value1"));
        assertTrue(result.contains("value2"));
    }

    @Test
    void testGetValuesAsSet_WithUnmodifiableMultiValuedMap() {
        MultiValuedMap<String, String> modifiableMap = new ArrayListValuedHashMap<>();
        modifiableMap.put("key", "value1");
        modifiableMap.put("key", "value2");
        MultiValuedMap<String, String> unmodifiableMap = UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(modifiableMap);
        Set<String> result = MultiMapUtils.getValuesAsSet(unmodifiableMap, "key");
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains("value1"));
        assertTrue(result.contains("value2"));
    }

    @Test
    void testGetValuesAsSet_NonExistentKey() {
        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
        map.put("key", "value1");
        Set<String> result = MultiMapUtils.getValuesAsSet(map, "nonExistentKey");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetValuesAsSet_NullKey() {
        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
        map.put("key", "value1");
        Set<String> result = MultiMapUtils.getValuesAsSet(map, null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
