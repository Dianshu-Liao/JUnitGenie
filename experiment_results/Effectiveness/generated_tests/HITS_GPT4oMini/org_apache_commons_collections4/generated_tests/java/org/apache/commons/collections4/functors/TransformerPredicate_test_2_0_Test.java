package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;

public class TransformerPredicate_test_2_0_Test {

    private Transformer<Object, Boolean> transformer;

    private TransformerPredicate<Object> transformerPredicate;

    @BeforeEach
    public void setUp() {
        transformer = mock(Transformer.class);
        transformerPredicate = new TransformerPredicate<>(transformer);
    }

    @Test
    public void test_TransformerReturnsTrue() {
        when(transformer.apply(any())).thenReturn(true);
        assertTrue(transformerPredicate.test(new Object()));
    }

    @Test
    public void test_TransformerReturnsFalse() {
        when(transformer.apply(any())).thenReturn(false);
        assertFalse(transformerPredicate.test(new Object()));
    }

    @Test
    public void test_TransformerReturnsNull() {
        when(transformer.apply(any())).thenReturn(null);
        Exception exception = assertThrows(FunctorException.class, () -> {
            transformerPredicate.test(new Object());
        });
        assertEquals("Transformer must return an instanceof Boolean, it was a null object", exception.getMessage());
    }

    @Test
    public void test_TransformerReturnsBooleanFalse() {
        when(transformer.apply(any())).thenReturn(Boolean.FALSE);
        assertFalse(transformerPredicate.test(new Object()));
    }

    @Test
    public void test_TransformerReturnsBooleanTrue() {
        when(transformer.apply(any())).thenReturn(Boolean.TRUE);
        assertTrue(transformerPredicate.test(new Object()));
    }
}
