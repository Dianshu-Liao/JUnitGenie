package org.apache.commons.collections4;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Collection;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
import org.apache.commons.collections4.multimap.TransformedMultiValuedMap;
import org.apache.commons.collections4.multimap.UnmodifiableMultiValuedMap;

public class MultiMapUtils_getValuesAsSet_5_0_Test {

    @Test
    public void testGetValuesAsSet_NullMap() {
        // Test case where the map is null
        Set<Object> result = MultiMapUtils.getValuesAsSet(null, "key");
        Assertions.assertNull(result);
    }

    @Test
    public void testGetValuesAsSet_EmptyMap() {
        // Test case where the map is empty
        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
        Set<String> result = MultiMapUtils.getValuesAsSet(map, "key");
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testGetValuesAsSet_CollectionToSet() {
        // Test case where the map contains a collection
        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
        map.put("key", "value1");
        map.put("key", "value2");
        Set<String> result = MultiMapUtils.getValuesAsSet(map, "key");
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.contains("value1"));
        Assertions.assertTrue(result.contains("value2"));
    }

    @Test
    public void testGetValuesAsSet_SetAsCollection() {
        // Test case where the map contains a Set
        MultiValuedMap<String, String> map = Mockito.mock(MultiValuedMap.class);
        Set<String> mockSet = new HashSet<>();
        mockSet.add("value1");
        mockSet.add("value2");
        Mockito.when(map.get("key")).thenReturn(mockSet);
        Set<String> result = MultiMapUtils.getValuesAsSet(map, "key");
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.contains("value1"));
        Assertions.assertTrue(result.contains("value2"));
    }
}
