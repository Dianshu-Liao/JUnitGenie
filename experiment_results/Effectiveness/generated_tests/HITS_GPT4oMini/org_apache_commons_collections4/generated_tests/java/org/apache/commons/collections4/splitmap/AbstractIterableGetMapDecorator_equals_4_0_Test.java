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

public class AbstractIterableGetMapDecorator_equals_4_0_Test {

    private static class TestMapDecorator extends AbstractIterableGetMapDecorator<String, String> {

        public TestMapDecorator(Map<String, String> map) {
            super(map);
        }
    }

    @Test
    public void testEquals_SameInstance() {
        Map<String, String> map = new HashMap<>();
        TestMapDecorator decorator = new TestMapDecorator(map);
        assertTrue(decorator.equals(decorator), "Should be equal to itself");
    }

    @Test
    public void testEquals_Null() {
        Map<String, String> map = new HashMap<>();
        TestMapDecorator decorator = new TestMapDecorator(map);
        assertFalse(decorator.equals(null), "Should not be equal to null");
    }

    @Test
    public void testEquals_DifferentClass() {
        Map<String, String> map = new HashMap<>();
        TestMapDecorator decorator = new TestMapDecorator(map);
        assertFalse(decorator.equals("Not a Map"), "Should not be equal to an object of different class");
    }

    @Test
    public void testEquals_EqualMaps() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        Map<String, String> map2 = new HashMap<>(map1);
        TestMapDecorator decorator1 = new TestMapDecorator(map1);
        TestMapDecorator decorator2 = new TestMapDecorator(map2);
        assertTrue(decorator1.equals(decorator2), "Should be equal if maps are equal");
    }

    @Test
    public void testEquals_NonEqualMaps() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        Map<String, String> map2 = new HashMap<>();
        map2.put("key2", "value2");
        TestMapDecorator decorator1 = new TestMapDecorator(map1);
        TestMapDecorator decorator2 = new TestMapDecorator(map2);
        assertFalse(decorator1.equals(decorator2), "Should not be equal if maps are not equal");
    }
}
