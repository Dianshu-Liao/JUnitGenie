package org.apache.commons.collections4;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.collections4.multimap.UnmodifiableMultiValuedMap;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
import org.apache.commons.collections4.multimap.TransformedMultiValuedMap;

class MultiMapUtils_isEmpty_6_1_Test {

    @Test
    void testIsEmpty_NullMap() {
        MultiValuedMap<?, ?> map = null;
        assertTrue(MultiMapUtils.isEmpty(map), "Expected isEmpty to return true for null map");
    }

    @Test
    void testIsEmpty_EmptyMap() {
        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
        assertTrue(MultiMapUtils.isEmpty(map), "Expected isEmpty to return true for empty map");
    }

    @Test
    void testIsEmpty_NonEmptyMap() {
        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
        map.put("key1", "value1");
        assertFalse(MultiMapUtils.isEmpty(map), "Expected isEmpty to return false for non-empty map");
    }

    @Test
    void testIsEmpty_UnmodifiableMap() {
        MultiValuedMap<String, String> modifiableMap = new ArrayListValuedHashMap<>();
        modifiableMap.put("key1", "value1");
        MultiValuedMap<String, String> unmodifiableMap = UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(modifiableMap);
        assertFalse(MultiMapUtils.isEmpty(unmodifiableMap), "Expected isEmpty to return false for non-empty unmodifiable map");
    }

    @Test
    void testIsEmpty_EmptyUnmodifiableMap() {
        MultiValuedMap<?, ?> map = UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(new ArrayListValuedHashMap<>(0, 0));
        assertTrue(MultiMapUtils.isEmpty(map), "Expected isEmpty to return true for empty unmodifiable map");
    }
}
