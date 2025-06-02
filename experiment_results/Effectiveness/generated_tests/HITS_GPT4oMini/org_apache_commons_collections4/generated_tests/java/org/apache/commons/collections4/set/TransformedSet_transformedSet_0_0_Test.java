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

public class TransformedSet_transformedSet_0_0_Test {

    @Test
    public void testTransformedSet_withNonEmptySet() {
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
    public void testTransformedSet_withEmptySet() {
        Set<String> originalSet = new HashSet<>();
        Transformer<String, String> transformer = input -> input.toUpperCase();
        Set<String> transformedSet = TransformedSet.transformedSet(originalSet, transformer);
        assertTrue(transformedSet.isEmpty());
        // original set should remain empty
        assertTrue(originalSet.isEmpty());
    }

    @Test
    public void testTransformedSet_withNullTransformer() {
        Set<String> originalSet = new HashSet<>();
        originalSet.add("a");
        originalSet.add("b");
        assertThrows(NullPointerException.class, () -> {
            TransformedSet.transformedSet(originalSet, null);
        });
    }

    @Test
    public void testTransformedSet_withSingleElement() {
        Set<String> originalSet = new HashSet<>();
        originalSet.add("hello");
        Transformer<String, String> transformer = String::toUpperCase;
        Set<String> transformedSet = TransformedSet.transformedSet(originalSet, transformer);
        assertEquals(1, transformedSet.size());
        assertTrue(transformedSet.contains("HELLO"));
        // original set should be cleared
        assertTrue(originalSet.isEmpty());
    }

    @Test
    public void testTransformedSet_withDifferentTypes() {
        Set<Object> originalSet = new HashSet<>();
        originalSet.add(1);
        originalSet.add("two");
        originalSet.add(3.0);
        Transformer<Object, String> transformer = Object::toString;
        Set<Object> transformedSet = TransformedSet.transformedSet(originalSet, transformer);
        assertEquals(3, transformedSet.size());
        assertTrue(transformedSet.contains("1"));
        assertTrue(transformedSet.contains("two"));
        assertTrue(transformedSet.contains("3.0"));
        // original set should be cleared
        assertTrue(originalSet.isEmpty());
    }
}
