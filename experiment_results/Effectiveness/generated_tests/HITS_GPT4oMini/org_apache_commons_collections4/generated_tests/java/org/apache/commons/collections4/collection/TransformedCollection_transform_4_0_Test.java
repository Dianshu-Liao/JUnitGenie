package org.apache.commons.collections4.collection;

import org.apache.commons.collections4.Transformer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TransformedCollection_transform_4_0_Test {

    private TransformedCollection<String> transformedCollection;

    @BeforeEach
    public void setUp() {
        // Setting up a simple transformer that converts strings to uppercase
        Transformer<String, String> upperCaseTransformer = String::toUpperCase;
        transformedCollection = new TransformedCollection<>(Arrays.asList("a", "b", "c"), upperCaseTransformer);
    }

    @Test
    public void testTransformEmptyCollection() {
        Collection<String> result = transformedCollection.transform(Collections.emptyList());
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testTransformSingleElementCollection() {
        Collection<String> result = transformedCollection.transform(Collections.singletonList("a"));
        assertEquals(Collections.singletonList("A"), result);
    }

    @Test
    public void testTransformMultipleElementsCollection() {
        Collection<String> result = transformedCollection.transform(Arrays.asList("a", "b", "c"));
        assertEquals(Arrays.asList("A", "B", "C"), result);
    }

    @Test
    public void testTransformNullElement() {
        Transformer<String, String> nullTransformer = input -> {
            if (input == null) {
                return null;
            }
            return input.toUpperCase();
        };
        TransformedCollection<String> nullTransformedCollection = new TransformedCollection<>(Arrays.asList("a", null, "c"), nullTransformer);
        Collection<String> result = nullTransformedCollection.transform(Arrays.asList("a", null, "c"));
        assertEquals(Arrays.asList("A", null, "C"), result);
    }

    @Test
    public void testTransformWithNullTransformer() {
        assertThrows(NullPointerException.class, () -> {
            new TransformedCollection<>(Arrays.asList("a", "b", "c"), null);
        });
    }

    @Test
    public void testTransformWithDifferentDataTypes() {
        Transformer<Object, String> toStringTransformer = Object::toString;
        TransformedCollection<Object> mixedCollection = new TransformedCollection<>(Arrays.asList(1, 2.5, 'c'), toStringTransformer);
        Collection<Object> result = mixedCollection.transform(Arrays.asList(1, 2.5, 'c'));
        assertEquals(Arrays.asList("1", "2.5", "c"), result);
    }
}
