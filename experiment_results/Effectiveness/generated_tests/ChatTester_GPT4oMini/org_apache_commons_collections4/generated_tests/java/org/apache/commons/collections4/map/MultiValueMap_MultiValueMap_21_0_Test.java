package org.apache.commons.collections4.map;

import java.util.*;
// Added import for Field
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.Factory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;

class MultiValueMap_MultiValueMap_21_0_Test {

    private MultiValueMap<String, String> multiValueMap;

    private Map<String, Collection<String>> testMap;

    private Factory<Collection<String>> collectionFactory;

    @BeforeEach
    void setUp() {
        testMap = new HashMap<>();
        // Using ArrayList as the collection type
        collectionFactory = () -> new ArrayList<>();
        multiValueMap = new MultiValueMap<>(testMap, collectionFactory);
    }

    @Test
    void testConstructorWithNullFactoryThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new MultiValueMap<>(testMap, null);
        });
    }

    @Test
    void testConstructorWithValidParameters() {
        assertNotNull(multiValueMap);
    }

    @Test
    void testConstructorWithEmptyMap() {
        Map<String, Collection<String>> emptyMap = new HashMap<>();
        MultiValueMap<String, String> emptyMultiValueMap = new MultiValueMap<>(emptyMap, collectionFactory);
        assertNotNull(emptyMultiValueMap);
    }

    @Test
    void testConstructorWithNonEmptyMap() {
        Collection<String> values = new ArrayList<>(Arrays.asList("value1", "value2"));
        testMap.put("key1", values);
        MultiValueMap<String, String> nonEmptyMultiValueMap = new MultiValueMap<>(testMap, collectionFactory);
        assertNotNull(nonEmptyMultiValueMap);
        assertEquals(2, nonEmptyMultiValueMap.size("key1"));
    }

    @Test
    void testConstructorWithDifferentCollectionFactory() {
        // Using HashSet as the collection type
        Factory<Collection<String>> differentFactory = () -> new HashSet<>();
        MultiValueMap<String, String> differentMultiValueMap = new MultiValueMap<>(testMap, differentFactory);
        assertNotNull(differentMultiValueMap);
    }

    // Reflection test to access private fields or methods if needed
    @Test
    void testPrivateFieldAccess() throws Exception {
        Field field = MultiValueMap.class.getDeclaredField("collectionFactory");
        field.setAccessible(true);
        Factory<?> factory = (Factory<?>) field.get(multiValueMap);
        assertNotNull(factory);
    }
}
