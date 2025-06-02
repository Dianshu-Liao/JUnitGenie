package org.apache.commons.collections4.set;

import org.apache.commons.collections4.Transformer;
import java.util.HashSet;
import java.util.Set;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.collection.TransformedCollection;

class TransformedSet_transformedSet_0_0_Test {

    @Test
    void testTransformedSetWithNonEmptySet() {
        Set<Integer> originalSet = new HashSet<>();
        originalSet.add(1);
        originalSet.add(2);
        originalSet.add(3);
        Transformer<Integer, Integer> transformer = input -> input * 2;
        Set<Integer> transformedSet = TransformedSet.transformedSet(originalSet, transformer);
        assertEquals(3, transformedSet.size());
        assertTrue(transformedSet.contains(2));
        assertTrue(transformedSet.contains(4));
        assertTrue(transformedSet.contains(6));
        // original set should be cleared
        assertTrue(originalSet.isEmpty());
    }

    @Test
    void testTransformedSetWithEmptySet() {
        Set<Integer> originalSet = new HashSet<>();
        Transformer<Integer, Integer> transformer = input -> input * 2;
        Set<Integer> transformedSet = TransformedSet.transformedSet(originalSet, transformer);
        assertTrue(transformedSet.isEmpty());
        // original set should remain empty
        assertTrue(originalSet.isEmpty());
    }

    @Test
    void testTransformedSetWithNullTransformer() {
        Set<Integer> originalSet = new HashSet<>();
        originalSet.add(1);
        originalSet.add(2);
        assertThrows(NullPointerException.class, () -> {
            TransformedSet.transformedSet(originalSet, null);
        });
    }

    @Test
    void testTransformedSetWithSingleElement() {
        Set<Integer> originalSet = new HashSet<>();
        originalSet.add(5);
        Transformer<Integer, Integer> transformer = input -> input + 5;
        Set<Integer> transformedSet = TransformedSet.transformedSet(originalSet, transformer);
        assertEquals(1, transformedSet.size());
        assertTrue(transformedSet.contains(10));
        // original set should be cleared
        assertTrue(originalSet.isEmpty());
    }
}
