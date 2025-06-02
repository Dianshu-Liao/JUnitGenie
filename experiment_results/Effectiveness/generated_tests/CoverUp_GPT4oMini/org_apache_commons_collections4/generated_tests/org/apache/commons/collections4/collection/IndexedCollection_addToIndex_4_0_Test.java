package org.apache.commons.collections4.collection;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.MultiValueMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class IndexedCollection_addToIndex_4_0_Test {

    private IndexedCollection<String, String> indexedCollection;

    private MultiMap<String, String> multiMap;

    private Transformer<String, String> keyTransformer;

    @BeforeEach
    void setUp() {
        multiMap = new MultiValueMap<>();
        // Simple key transformer for testing
        keyTransformer = String::toUpperCase;
    }

    @Test
    void testAddToIndexUnique() throws Exception {
        indexedCollection = new IndexedCollection<>(new ArrayList<>(), keyTransformer, multiMap, true);
        invokeAddToIndex("test");
        assertTrue(multiMap.containsKey("TEST"));
        assertTrue(multiMap.get("TEST") instanceof Collection);
        assertTrue(((Collection<String>) multiMap.get("TEST")).contains("test"));
    }

    @Test
    void testAddToIndexNonUnique() throws Exception {
        indexedCollection = new IndexedCollection<>(new ArrayList<>(), keyTransformer, multiMap, false);
        invokeAddToIndex("test");
        invokeAddToIndex("test");
        assertEquals(2, ((Collection<String>) multiMap.get("TEST")).size());
    }

    @Test
    void testAddToIndexUniqueThrowsExceptionOnDuplicate() throws Exception {
        indexedCollection = new IndexedCollection<>(new ArrayList<>(), keyTransformer, multiMap, true);
        invokeAddToIndex("test");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeAddToIndex("test");
        });
        assertEquals("Duplicate key in uniquely indexed collection.", exception.getMessage());
    }

    private void invokeAddToIndex(String object) throws Exception {
        Method method = IndexedCollection.class.getDeclaredMethod("addToIndex", Object.class);
        method.setAccessible(true);
        method.invoke(indexedCollection, object);
    }
}
