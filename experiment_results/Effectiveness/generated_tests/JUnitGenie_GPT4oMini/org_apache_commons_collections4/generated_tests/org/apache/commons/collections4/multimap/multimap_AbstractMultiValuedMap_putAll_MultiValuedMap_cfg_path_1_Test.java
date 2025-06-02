package org.apache.commons.collections4.multimap;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.AbstractMultiValuedMap;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.AbstractMap;

public class multimap_AbstractMultiValuedMap_putAll_MultiValuedMap_cfg_path_1_Test {

    // Concrete implementation of AbstractMultiValuedMap for testing
    private static class TestMultiValuedMap<K, V> extends AbstractMultiValuedMap<K, V> {
        private final Map<K, Collection<V>> map = new HashMap<>();

        @Override
        protected Collection<V> createCollection() {
            return new ArrayList<>();
        }

        @Override
        public Collection<V> get(Object key) {
            return map.get(key);
        }

        @Override
        public boolean put(K key, V value) {
            return map.computeIfAbsent(key, k -> createCollection()).add(value);
        }

        @Override
        public boolean removeMapping(Object key, Object value) {
            Collection<V> collection = map.get(key);
            return collection != null && collection.remove(value);
        }

        @Override
        public boolean containsKey(Object key) {
            return map.containsKey(key);
        }

        @Override
        public boolean containsValue(Object value) {
            return map.values().stream().anyMatch(collection -> collection.contains(value));
        }

        @Override
        public int size() {
            return map.values().stream().mapToInt(Collection::size).sum();
        }

        @Override
        public boolean isEmpty() {
            return map.isEmpty();
        }

        @Override
        public void clear() {
            map.clear();
        }

        @Override
        public Map<K, Collection<V>> asMap() {
            return map;
        }

        @Override
        public Collection<V> values() {
            Collection<V> allValues = new ArrayList<>();
            for (Collection<V> collection : map.values()) {
                allValues.addAll(collection);
            }
            return allValues;
        }

        @Override
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> entries = new ArrayList<>();
            for (Map.Entry<K, Collection<V>> entry : map.entrySet()) {
                for (V value : entry.getValue()) {
                    entries.add(new AbstractMap.SimpleEntry<>(entry.getKey(), value));
                }
            }
            return entries;
        }
    }

    @Test(timeout = 4000)
    public void testPutAll() {
        TestMultiValuedMap<String, String> testMap = new TestMultiValuedMap<>();
        MultiValuedMap<String, String> inputMap = new TestMultiValuedMap<>();

        // Prepare inputMap with some entries
        inputMap.put("key1", "value1");
        inputMap.put("key2", "value2");

        // Test putAll method
        boolean changed = false;
        try {
            changed = testMap.putAll(inputMap);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Verify that the map has changed
        assertTrue(changed);
        assertEquals(2, testMap.size());
        assertTrue(testMap.containsKey("key1"));
        assertTrue(testMap.containsKey("key2"));
        assertTrue(testMap.containsValue("value1"));
        assertTrue(testMap.containsValue("value2"));
    }


}