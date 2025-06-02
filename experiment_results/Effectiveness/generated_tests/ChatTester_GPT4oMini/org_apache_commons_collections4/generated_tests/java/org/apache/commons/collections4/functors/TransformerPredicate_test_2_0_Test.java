package org.apache.commons.collections4.functors;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

class TransformerPredicate_test_2_0_Test {

    private Transformer<Object, Boolean> transformerMock;

    private TransformerPredicate<Object> transformerPredicate;

    @BeforeEach
    void setUp() {
        transformerMock = mock(Transformer.class);
        transformerPredicate = new TransformerPredicate<>(transformerMock);
    }

    @Test
    void testWithTrueResult() {
        when(transformerMock.apply(any())).thenReturn(true);
        assertTrue(transformerPredicate.test(new Object()));
    }

    @Test
    void testWithFalseResult() {
        when(transformerMock.apply(any())).thenReturn(false);
        assertFalse(transformerPredicate.test(new Object()));
    }

    @Test
    void testWithNullResult() {
        when(transformerMock.apply(any())).thenReturn(null);
        Exception exception = assertThrows(FunctorException.class, () -> {
            transformerPredicate.test(new Object());
        });
        assertEquals("Transformer must return an instanceof Boolean, it was a null object", exception.getMessage());
    }

    @Test
    void testWithDifferentObject() {
        when(transformerMock.apply(any())).thenReturn(true);
        assertTrue(transformerPredicate.test(new String("Test")));
        when(transformerMock.apply(any())).thenReturn(false);
        assertFalse(transformerPredicate.test(new String("Test")));
    }
}
