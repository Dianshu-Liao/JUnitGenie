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

public class CompositeMap_put_10_0_Test {

    private CompositeMap<String, Integer> compositeMap;

    private Map<String, Integer> map1;

    private Map<String, Integer> map2;

    @BeforeEach
    public void setUp() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        compositeMap = new CompositeMap<>(map1, map2);
    }

    @Test
    public void testPutNewEntry() {
        compositeMap.put("key1", 1);
        assertEquals(1, map1.get("key1"));
    }

    @Test
    public void testPutOverwritesExistingEntry() {
        compositeMap.put("key1", 1);
        compositeMap.put("key1", 2);
        assertEquals(2, map1.get("key1"));
    }

    @Test
    public void testPutInSecondMap() {
        compositeMap.put("key2", 2);
        assertEquals(2, map2.get("key2"));
    }

    @Test
    public void testPutWithNullMutator() {
        compositeMap.setMutator(null);
        assertThrows(UnsupportedOperationException.class, () -> {
            compositeMap.put("key3", 3);
        });
    }
}
