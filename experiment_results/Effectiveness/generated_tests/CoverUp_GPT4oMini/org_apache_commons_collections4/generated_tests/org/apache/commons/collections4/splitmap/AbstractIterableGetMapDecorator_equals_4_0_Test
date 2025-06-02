package org.apache.commons.collections4.splitmap;

import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.IterableGet;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter;

class AbstractIterableGetMapDecorator_equals_4_0_Test {

    private AbstractIterableGetMapDecorator<String, String> decoratorWithMap;

    private AbstractIterableGetMapDecorator<String, String> decoratorWithSameMap;

    private AbstractIterableGetMapDecorator<String, String> decoratorWithDifferentMap;

    private Map<String, String> map1;

    private Map<String, String> map2;

    @BeforeEach
    void setUp() {
        map1 = new HashMap<>();
        map1.put("key1", "value1");
        map1.put("key2", "value2");
        map2 = new HashMap<>();
        map2.put("keyA", "valueA");
        map2.put("keyB", "valueB");
        decoratorWithMap = new AbstractIterableGetMapDecorator<>(map1);
        decoratorWithSameMap = new AbstractIterableGetMapDecorator<>(map1);
        decoratorWithDifferentMap = new AbstractIterableGetMapDecorator<>(map2);
    }

    @Test
    void testEquals_SameInstance() {
        assertTrue(decoratorWithMap.equals(decoratorWithMap));
    }

    @Test
    void testEquals_SameContent() {
        assertTrue(decoratorWithMap.equals(decoratorWithSameMap));
    }

    @Test
    void testEquals_DifferentContent() {
        assertFalse(decoratorWithMap.equals(decoratorWithDifferentMap));
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(decoratorWithMap.equals(null));
    }

    @Test
    void testEquals_DifferentClass() {
        assertFalse(decoratorWithMap.equals("Some String"));
    }
}
