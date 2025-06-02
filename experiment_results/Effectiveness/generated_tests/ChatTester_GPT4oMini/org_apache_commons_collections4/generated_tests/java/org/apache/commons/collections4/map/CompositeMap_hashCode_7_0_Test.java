package org.apache.commons.collections4.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.collection.CompositeCollection;
import org.apache.commons.collections4.set.CompositeSet;

class // Reflection test for private method if needed
// This is an example if you had a private method to test.
// @Test
// void testPrivateMethod() throws Exception {
// Method privateMethod = CompositeMap.class.getDeclaredMethod("privateMethodName");
// privateMethod.setAccessible(true);
// Object result = privateMethod.invoke(compositeMap);
// // assert statements based on expected result
// }
CompositeMap_hashCode_7_0_Test {

    private CompositeMap<String, String> compositeMap;

    @BeforeEach
    void setUp() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        map1.put("key2", "value2");
        Map<String, String> map2 = new HashMap<>();
        map2.put("key3", "value3");
        map2.put("key4", "value4");
        compositeMap = new CompositeMap<>(map1, map2);
    }

    @Test
    void testHashCode() {
        int expectedHashCode = 0;
        for (Map.Entry<String, String> entry : compositeMap.entrySet()) {
            expectedHashCode += entry.hashCode();
        }
        int actualHashCode = compositeMap.hashCode();
        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCodeWithEmptyMap() {
        CompositeMap<String, String> emptyCompositeMap = new CompositeMap<>();
        assertEquals(0, emptyCompositeMap.hashCode());
    }

    @Test
    void testHashCodeWithSingleMap() {
        Map<String, String> singleMap = new HashMap<>();
        singleMap.put("key1", "value1");
        CompositeMap<String, String> singleMapComposite = new CompositeMap<>(singleMap);
        int expectedHashCode = singleMap.hashCode();
        assertEquals(expectedHashCode, singleMapComposite.hashCode());
    }

    @Test
    void testHashCodeWithDifferentEntries() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        Map<String, String> map2 = new HashMap<>();
        map2.put("key2", "value2");
        CompositeMap<String, String> compositeMap = new CompositeMap<>(map1, map2);
        int expectedHashCode = map1.hashCode() + map2.hashCode();
        assertEquals(expectedHashCode, compositeMap.hashCode());
    }
}
