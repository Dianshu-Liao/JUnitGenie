package org.apache.commons.collections4.collection;

import org.apache.commons.collections4.Transformer;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Objects;

class TransformedCollection_transform_4_3_Test {

    private TransformedCollection<String> transformedCollection;

    @BeforeEach
    void setUp() {
        Transformer<String, String> transformer = String::toUpperCase;
        transformedCollection = new TransformedCollection<>(Arrays.asList("a", "b", "c"), transformer);
    }

    @Test
    void testTransformWithValidCollection() throws Exception {
        Collection<String> input = Arrays.asList("a", "b", "c");
        Collection<String> result = invokeTransform(input);
        assertEquals(Arrays.asList("A", "B", "C"), result);
    }

    @Test
    void testTransformWithEmptyCollection() throws Exception {
        Collection<String> input = Collections.emptyList();
        Collection<String> result = invokeTransform(input);
        assertTrue(result.isEmpty());
    }

    @Test
    void testTransformWithNullElement() throws Exception {
        Collection<String> input = Arrays.asList("a", null, "c");
        Collection<String> result = invokeTransform(input);
        assertEquals(Arrays.asList("A", null, "C"), result);
    }

    @Test
    void testTransformWithSingleElement() throws Exception {
        Collection<String> input = Collections.singletonList("a");
        Collection<String> result = invokeTransform(input);
        assertEquals(Collections.singletonList("A"), result);
    }

    @Test
    void testTransformWithLargeCollection() throws Exception {
        Collection<String> input = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
        Collection<String> result = invokeTransform(input);
        assertEquals(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"), result);
    }

    @SuppressWarnings("unchecked")
    private Collection<String> invokeTransform(Collection<String> collection) throws Exception {
        Method method = TransformedCollection.class.getDeclaredMethod("transform", Collection.class);
        method.setAccessible(true);
        return (Collection<String>) method.invoke(transformedCollection, collection);
    }
}
