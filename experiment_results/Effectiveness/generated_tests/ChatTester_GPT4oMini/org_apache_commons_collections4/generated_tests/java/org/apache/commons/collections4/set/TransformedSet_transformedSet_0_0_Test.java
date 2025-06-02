package org.apache.commons.collections4.set;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TransformedSet_transformedSet_0_0_Test {

    private Set<String> originalSet;

    // Changed to Transformer
    private Transformer<String, String> transformer;

    @BeforeEach
    void setUp() {
        originalSet = new HashSet<>();
        // Changed to Transformer
        transformer = Mockito.mock(Transformer.class);
    }

    @Test
    void testTransformedSet_EmptySet() {
        Set<String> transformed = TransformedSet.transformedSet(originalSet, transformer);
        assertNotNull(transformed);
        assertTrue(transformed.isEmpty());
        verify(transformer, never()).transform(any());
    }

    @Test
    void testTransformedSet_NonEmptySet() {
        originalSet.add("one");
        originalSet.add("two");
        originalSet.add("three");
        // Changed to transform
        when(transformer.transform("one")).thenReturn("ONE");
        // Changed to transform
        when(transformer.transform("two")).thenReturn("TWO");
        // Changed to transform
        when(transformer.transform("three")).thenReturn("THREE");
        Set<String> transformed = TransformedSet.transformedSet(originalSet, transformer);
        assertNotNull(transformed);
        assertEquals(3, transformed.size());
        assertTrue(transformed.contains("ONE"));
        assertTrue(transformed.contains("TWO"));
        assertTrue(transformed.contains("THREE"));
        // Changed to transform
        verify(transformer).transform("one");
        // Changed to transform
        verify(transformer).transform("two");
        // Changed to transform
        verify(transformer).transform("three");
    }

    @Test
    void testTransformedSet_NullTransformer() {
        assertThrows(NullPointerException.class, () -> {
            TransformedSet.transformedSet(originalSet, null);
        });
    }

    @Test
    void testTransformedSet_TransformerReturnsNull() {
        originalSet.add("one");
        // Changed to transform
        when(transformer.transform("one")).thenReturn(null);
        Set<String> transformed = TransformedSet.transformedSet(originalSet, transformer);
        assertNotNull(transformed);
        assertEquals(1, transformed.size());
        assertTrue(transformed.contains(null));
        // Changed to transform
        verify(transformer).transform("one");
    }

    @Test
    void testTransformedSet_TransformerReturnsSameValue() {
        originalSet.add("one");
        // Changed to transform
        when(transformer.transform("one")).thenReturn("one");
        Set<String> transformed = TransformedSet.transformedSet(originalSet, transformer);
        assertNotNull(transformed);
        assertEquals(1, transformed.size());
        assertTrue(transformed.contains("one"));
        // Changed to transform
        verify(transformer).transform("one");
    }
}
