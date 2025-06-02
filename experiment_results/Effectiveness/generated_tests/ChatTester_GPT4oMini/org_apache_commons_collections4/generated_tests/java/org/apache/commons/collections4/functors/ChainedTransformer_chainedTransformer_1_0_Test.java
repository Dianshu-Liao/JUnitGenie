package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.NOPTransformer;
import org.apache.commons.collections4.functors.FunctorUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

public class ChainedTransformer_chainedTransformer_1_0_Test {

    @Test
    public void testChainedTransformerWithNoTransformers() {
        // Test case when no transformers are provided
        Transformer<Object, Object> result = ChainedTransformer.chainedTransformer();
        assertNotNull(result);
        assertEquals(NOPTransformer.nopTransformer(), result);
    }

    @Test
    public void testChainedTransformerWithSingleTransformer() {
        // Test case with a single transformer
        Transformer<String, String> transformer = input -> input.toUpperCase();
        Transformer<String, String> result = ChainedTransformer.chainedTransformer(transformer);
        assertNotNull(result);
        assertEquals("HELLO", result.transform("hello"));
    }

    @Test
    public void testChainedTransformerWithMultipleTransformers() {
        // Test case with multiple transformers
        Transformer<String, String> transformer1 = input -> input + " World";
        Transformer<String, String> transformer2 = input -> input.toUpperCase();
        Transformer<String, String> chained = ChainedTransformer.chainedTransformer(transformer1, transformer2);
        assertNotNull(chained);
        assertEquals("HELLO WORLD", chained.transform("hello"));
    }

    @Test
    public void testChainedTransformerWithNullTransformers() {
        // Test case with null transformers
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ChainedTransformer.chainedTransformer((Transformer<String, String>[]) null);
        });
        assertEquals("Transformers cannot be null", exception.getMessage());
    }

    @Test
    public void testChainedTransformerWithEmptyArray() {
        // Test case with an empty array
        Transformer<String, String> result = ChainedTransformer.chainedTransformer(new Transformer[0]);
        assertNotNull(result);
        assertEquals(NOPTransformer.nopTransformer(), result);
    }

    @Test
    public void testChainedTransformerWithArrayOfTransformers() {
        // Test case with an array of transformers
        Transformer<String, String> transformer1 = input -> input.trim();
        Transformer<String, String> transformer2 = input -> input + "!";
        Transformer<String, String> transformer3 = input -> input.toUpperCase();
        Transformer<String, String> chained = ChainedTransformer.chainedTransformer(transformer1, transformer2, transformer3);
        assertNotNull(chained);
        assertEquals("HELLO!", chained.transform(" hello "));
    }
}
