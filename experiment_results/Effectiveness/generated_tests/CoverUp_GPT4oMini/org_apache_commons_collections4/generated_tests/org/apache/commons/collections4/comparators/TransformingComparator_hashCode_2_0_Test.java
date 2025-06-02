package org.apache.commons.collections4.comparators;

import org.apache.commons.collections4.comparators.TransformingComparator;
import org.apache.commons.collections4.Transformer;
import java.util.Comparator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.ComparatorUtils;

class TransformingComparator_hashCode_2_0_Test {

    private TransformingComparator<String, Integer> comparatorWithNulls;

    private TransformingComparator<String, Integer> comparatorWithDecorated;

    private TransformingComparator<String, Integer> comparatorWithTransformer;

    private Transformer<String, Integer> transformer;

    private Comparator<Integer> decorated;

    @BeforeEach
    void setUp() {
        // A simple transformer that transforms a String to its length
        transformer = String::length;
        // A simple comparator for Integers
        decorated = Integer::compareTo;
        comparatorWithNulls = new TransformingComparator<>(null);
        comparatorWithDecorated = new TransformingComparator<>(transformer, decorated);
        comparatorWithTransformer = new TransformingComparator<>(transformer);
    }

    @Test
    void testHashCodeWithNulls() {
        // Since both transformer and decorated are null
        int expectedHashCode = 17;
        assertEquals(expectedHashCode, comparatorWithNulls.hashCode());
    }

    @Test
    void testHashCodeWithTransformerOnly() {
        int expectedHashCode = 17 * 37 + transformer.hashCode();
        assertEquals(expectedHashCode, comparatorWithTransformer.hashCode());
    }

    @Test
    void testHashCodeWithDecoratorOnly() {
        int expectedHashCode = 17 * 37 + decorated.hashCode();
        assertEquals(expectedHashCode, comparatorWithDecorated.hashCode());
    }

    @Test
    void testHashCodeWithBoth() {
        int expectedHashCode = 17 * 37 + decorated.hashCode();
        expectedHashCode = expectedHashCode * 37 + transformer.hashCode();
        assertEquals(expectedHashCode, comparatorWithDecorated.hashCode());
    }
}
