package org.apache.commons.collections4.comparators;

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
import org.apache.commons.collections4.Transformer;

class TransformingComparator_hashCode_2_0_Test {

    private TransformingComparator<Object, Object> comparatorWithNulls;

    private TransformingComparator<Object, Object> comparatorWithDecorator;

    private Transformer<Object, Object> transformerMock;

    private Comparator<Object> decoratedMock;

    @BeforeEach
    void setUp() {
        transformerMock = mock(Transformer.class);
        decoratedMock = mock(Comparator.class);
        comparatorWithNulls = new TransformingComparator<>(transformerMock);
        comparatorWithDecorator = new TransformingComparator<>(transformerMock, decoratedMock);
    }

    @Test
    void testHashCode_withNulls() {
        // Only the base value
        int expected = 17;
        assertEquals(expected, comparatorWithNulls.hashCode());
    }

    @Test
    void testHashCode_withDecorator() {
        int decoratorHashCode = decoratedMock.hashCode();
        int transformerHashCode = transformerMock.hashCode();
        int expected = 17 * 37 + decoratorHashCode;
        expected = expected * 37 + transformerHashCode;
        assertEquals(expected, comparatorWithDecorator.hashCode());
    }

    @Test
    void testHashCode_withNullTransformer() {
        TransformingComparator<Object, Object> comparatorWithNullTransformer = new TransformingComparator<>(null, decoratedMock);
        int decoratorHashCode = decoratedMock.hashCode();
        int expected = 17 * 37 + decoratorHashCode;
        assertEquals(expected, comparatorWithNullTransformer.hashCode());
    }

    @Test
    void testHashCode_withNullDecoratorAndTransformer() {
        TransformingComparator<Object, Object> comparatorWithNullsBoth = new TransformingComparator<>(null);
        // Only the base value
        int expected = 17;
        assertEquals(expected, comparatorWithNullsBoth.hashCode());
    }

    @Test
    void testHashCode_withNullDecoratorAndNonNullTransformer() {
        TransformingComparator<Object, Object> comparatorWithNullDecorator = new TransformingComparator<>(transformerMock, null);
        int transformerHashCode = transformerMock.hashCode();
        int expected = 17 * 37 + transformerHashCode;
        assertEquals(expected, comparatorWithNullDecorator.hashCode());
    }
}
