package org.apache.commons.collections4.functors;

import java.util.ArrayList;
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

public class ChainedTransformer_chainedTransformer_0_0_Test {

    @Test
    public void testChainedTransformerWithNonEmptyCollection() {
        // Arrange
        Collection<Transformer<String, String>> transformers = new ArrayList<>();
        transformers.add(input -> input.toUpperCase());
        transformers.add(input -> input + " World");
        // Act
        Transformer<String, String> result = ChainedTransformer.chainedTransformer(transformers);
        String output = result.transform("Hello");
        // Assert
        Assertions.assertEquals("HELLO World", output);
    }

    @Test
    public void testChainedTransformerWithEmptyCollection() {
        // Arrange
        Collection<Transformer<String, String>> transformers = Collections.emptyList();
        // Act
        Transformer<String, String> result = ChainedTransformer.chainedTransformer(transformers);
        String output = result.transform("Hello");
        // Assert
        Assertions.assertEquals("Hello", output);
    }

    @Test
    public void testChainedTransformerWithNullCollection() {
        // Arrange
        Collection<Transformer<String, String>> transformers = null;
        // Act & Assert
        Assertions.assertThrows(NullPointerException.class, () -> {
            ChainedTransformer.chainedTransformer(transformers);
        });
    }

    @Test
    public void testChainedTransformerWithSingleTransformer() {
        // Arrange
        Collection<Transformer<Integer, Integer>> transformers = new ArrayList<>();
        transformers.add(input -> input * 2);
        // Act
        Transformer<Integer, Integer> result = ChainedTransformer.chainedTransformer(transformers);
        Integer output = result.transform(5);
        // Assert
        Assertions.assertEquals(10, output);
    }

    @Test
    public void testChainedTransformerWithMultipleTransformers() {
        // Arrange
        Collection<Transformer<Integer, Integer>> transformers = new ArrayList<>();
        transformers.add(input -> input + 1);
        transformers.add(input -> input * 2);
        transformers.add(input -> input - 3);
        // Act
        Transformer<Integer, Integer> result = ChainedTransformer.chainedTransformer(transformers);
        Integer output = result.transform(5);
        // Assert
        // (5 + 1) * 2 - 3 = 9
        Assertions.assertEquals(9, output);
    }
}
