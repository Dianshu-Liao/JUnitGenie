package org.apache.commons.collections4;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
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
import org.apache.commons.collections4.multimap.UnmodifiableMultiValuedMap;

public class MultiMapUtils_isEmpty_6_0_Test {

    @Test
    public void testIsEmpty_NullMap() {
        // Test with a null map
        MultiValuedMap<?, ?> map = null;
        Assertions.assertTrue(MultiMapUtils.isEmpty(map), "Expected true for null map");
    }

    @Test
    public void testIsEmpty_EmptyMap() {
        // Test with an empty MultiValuedMap
        MultiValuedMap<String, String> emptyMap = new ArrayListValuedHashMap<>();
        Assertions.assertTrue(MultiMapUtils.isEmpty(emptyMap), "Expected true for empty map");
    }

    @Test
    public void testIsEmpty_NonEmptyMap() {
        // Test with a non-empty MultiValuedMap
        MultiValuedMap<String, String> nonEmptyMap = new ArrayListValuedHashMap<>();
        nonEmptyMap.put("key1", "value1");
        Assertions.assertFalse(MultiMapUtils.isEmpty(nonEmptyMap), "Expected false for non-empty map");
    }
}
