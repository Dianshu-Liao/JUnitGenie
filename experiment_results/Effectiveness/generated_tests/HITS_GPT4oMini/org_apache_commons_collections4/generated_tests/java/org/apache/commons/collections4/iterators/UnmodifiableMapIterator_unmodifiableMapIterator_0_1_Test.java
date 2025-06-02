package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Unmodifiable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

class UnmodifiableMapIterator_unmodifiableMapIterator_0_1_Test {

    private static class MapEntryIterator<K, V> implements MapIterator<K, V> {

        private final Iterator<Map.Entry<K, V>> iterator;

        private Map.Entry<K, V> currentEntry;

        public MapEntryIterator(Iterator<Map.Entry<K, V>> iterator) {
            this.iterator = iterator;
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public K next() {
            currentEntry = iterator.next();
            return currentEntry.getKey();
        }

        @Override
        public V getValue() {
            return currentEntry.getValue();
        }

        @Override
        public void remove() {
            iterator.remove();
        }

        @Override
        public K getKey() {
            if (currentEntry == null) {
                throw new IllegalStateException("No current entry");
            }
            return currentEntry.getKey();
        }

        @Override
        public V setValue(V value) {
            throw new UnsupportedOperationException("This iterator is unmodifiable");
        }
    }

    @Test
    void testUnmodifiableMapIterator_withNullIterator() {
        assertThrows(NullPointerException.class, () -> {
            UnmodifiableMapIterator.unmodifiableMapIterator(null);
        });
    }

    @Test
    void testUnmodifiableMapIterator_withUnmodifiableIterator() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        MapIterator<String, String> unmodifiableIterator = UnmodifiableMapIterator.unmodifiableMapIterator(new MapEntryIterator<>(map.entrySet().iterator()));
        MapIterator<String, String> result = UnmodifiableMapIterator.unmodifiableMapIterator(unmodifiableIterator);
        assertSame(unmodifiableIterator, result, "Should return the same unmodifiable iterator");
    }

    @Test
    void testUnmodifiableMapIterator_withModifiableIterator() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        MapIterator<String, String> modifiableIterator = new MapEntryIterator<>(map.entrySet().iterator());
        MapIterator<String, String> result = UnmodifiableMapIterator.unmodifiableMapIterator(modifiableIterator);
        assertNotSame(modifiableIterator, result, "Should return a new UnmodifiableMapIterator instance");
        assertTrue(result instanceof UnmodifiableMapIterator, "Result should be an instance of UnmodifiableMapIterator");
    }
}
