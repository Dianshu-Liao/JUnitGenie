package org.apache.commons.collections4.functors;

import org.junit.jupiter.api.function.Executable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Transformer;

class ChainedTransformer_chainedTransformer_0_0_Test {

    @Test
    void testChainedTransformerWithNullCollection() {
        // Arrange
        Collection<Transformer<Object, Object>> transformers = null;
        // Act & Assert
        Exception exception = assertThrows(NullPointerException.class, () -> ChainedTransformer.chainedTransformer(transformers));
        assertEquals("transformers", exception.getMessage());
    }

    @Test
    void testChainedTransformerWithEmptyCollection() {
        // Arrange
        Collection<Transformer<Object, Object>> transformers = Collections.emptyList();
        // Act
        Transformer<Object, Object> result = ChainedTransformer.chainedTransformer(transformers);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof NOPTransformer);
    }

    @Test
    void testChainedTransformerWithSingleTransformer() {
        // Arrange
        Transformer<Object, Object> transformer = new SampleTransformer();
        Collection<Transformer<Object, Object>> transformers = Collections.singletonList(transformer);
        // Act
        Transformer<Object, Object> result = ChainedTransformer.chainedTransformer(transformers);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof ChainedTransformer);
    }

    @Test
    void testChainedTransformerWithMultipleTransformers() {
        // Arrange
        Transformer<Object, Object> transformer1 = new SampleTransformer();
        Transformer<Object, Object> transformer2 = new SampleTransformer();
        Collection<Transformer<Object, Object>> transformers = Arrays.asList(transformer1, transformer2);
        // Act
        Transformer<Object, Object> result = ChainedTransformer.chainedTransformer(transformers);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof ChainedTransformer);
    }

    private static class SampleTransformer implements Transformer<Object, Object> {

        @Override
        public Object transform(Object input) {
            // Simple pass-through for testing
            return input;
        }
    }
}
