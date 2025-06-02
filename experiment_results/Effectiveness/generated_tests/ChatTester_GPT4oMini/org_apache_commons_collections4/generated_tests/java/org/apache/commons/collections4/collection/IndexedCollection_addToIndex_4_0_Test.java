package org.apache.commons.collections4.collection;

import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.MultiValueMap;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class IndexedCollection_addToIndex_4_0_Test {

    private IndexedCollection<String, String> indexedCollection;

    private Transformer<String, String> keyTransformer;

    private MultiMap<String, String> multiMap;

    @BeforeEach
    void setUp() {
        keyTransformer = mock(Transformer.class);
        multiMap = mock(MultiMap.class);
        indexedCollection = new IndexedCollection<>(Collections.emptyList(), keyTransformer, multiMap, true);
    }

    @Test
    void testAddToIndexWithUniqueKey() {
        String object = "testObject";
        String key = "testKey";
        when(keyTransformer.apply(object)).thenReturn(key);
        when(multiMap.containsKey(key)).thenReturn(false);
        assertDoesNotThrow(() -> invokePrivateMethod("addToIndex", object));
        verify(multiMap).put(key, object);
    }

    @Test
    void testAddToIndexWithDuplicateKey() {
        String object = "testObject";
        String key = "testKey";
        when(keyTransformer.apply(object)).thenReturn(key);
        when(multiMap.containsKey(key)).thenReturn(true);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> invokePrivateMethod("addToIndex", object));
        assertEquals("Duplicate key in uniquely indexed collection.", exception.getMessage());
    }

    private void invokePrivateMethod(String methodName, Object... args) {
        try {
            // Fixed Buggy Line: Changed 'var' to 'Method' to properly declare the method variable
            java.lang.reflect.Method method = IndexedCollection.class.getDeclaredMethod(methodName, String.class);
            method.setAccessible(true);
            method.invoke(indexedCollection, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
