package org.apache.commons.collections4.collection;

import java.util.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.Transformer;

public class TransformedCollection_transform_4_0_Test {

    private TransformedCollection<String> transformedCollection;

    private Transformer<String, String> mockTransformer;

    @BeforeEach
    public void setUp() {
        mockTransformer = mock(Transformer.class);
        transformedCollection = new TransformedCollection<>(new ArrayList<>(), mockTransformer);
    }

    @Test
    public void testTransform_withEmptyCollection() {
        Collection<String> input = Collections.emptyList();
        Collection<String> result = transformedCollection.transform(input);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testTransform_withSingleElement() {
        Collection<String> input = Collections.singletonList("test");
        when(mockTransformer.transform("test")).thenReturn("TEST");
        Collection<String> result = transformedCollection.transform(input);
        assertEquals(1, result.size());
        assertTrue(result.contains("TEST"));
    }

    @Test
    public void testTransform_withMultipleElements() {
        Collection<String> input = Arrays.asList("one", "two", "three");
        when(mockTransformer.transform("one")).thenReturn("ONE");
        when(mockTransformer.transform("two")).thenReturn("TWO");
        when(mockTransformer.transform("three")).thenReturn("THREE");
        Collection<String> result = transformedCollection.transform(input);
        assertEquals(3, result.size());
        assertTrue(result.contains("ONE"));
        assertTrue(result.contains("TWO"));
        assertTrue(result.contains("THREE"));
    }

    @Test
    public void testTransform_withNullElement() {
        Collection<String> input = Arrays.asList("one", null, "three");
        when(mockTransformer.transform("one")).thenReturn("ONE");
        when(mockTransformer.transform(null)).thenReturn("NULL");
        when(mockTransformer.transform("three")).thenReturn("THREE");
        Collection<String> result = transformedCollection.transform(input);
        assertEquals(3, result.size());
        assertTrue(result.contains("ONE"));
        assertTrue(result.contains("NULL"));
        assertTrue(result.contains("THREE"));
    }

    @Test
    public void testTransform_withUntransformableElement() {
        Collection<String> input = Collections.singletonList("test");
        when(mockTransformer.transform("test")).thenThrow(new RuntimeException("Transformation error"));
        Exception exception = assertThrows(RuntimeException.class, () -> {
            transformedCollection.transform(input);
        });
        assertEquals("Transformation error", exception.getMessage());
    }
}
