package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.ChainedTransformer;
import org.apache.commons.collections4.functors.FunctorUtils;
import org.apache.commons.collections4.functors.NOPTransformer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

class ChainedTransformer_chainedTransformer_1_0_Test {

    @Test
    void testChainedTransformerWithNoTransformers() {
        Transformer<Object, Object> result = ChainedTransformer.chainedTransformer();
        assertSame(NOPTransformer.nopTransformer(), result);
    }

    @Test
    void testChainedTransformerWithSingleTransformer() {
        Transformer<String, String> transformer = input -> input.toUpperCase();
        Transformer<String, String> result = ChainedTransformer.chainedTransformer(transformer);
        assertNotNull(result);
        assertEquals("HELLO", result.transform("hello"));
    }

    @Test
    void testChainedTransformerWithMultipleTransformers() {
        Transformer<String, String> transformer1 = input -> input + " World";
        Transformer<String, String> transformer2 = input -> input.toUpperCase();
        Transformer<String, String> result = ChainedTransformer.chainedTransformer(transformer1, transformer2);
        assertNotNull(result);
        assertEquals("HELLO WORLD", result.transform("hello"));
    }

    @Test
    void testChainedTransformerWithNullTransformer() {
        Transformer<String, String> transformer1 = input -> input + " World";
        assertThrows(NullPointerException.class, () -> {
            ChainedTransformer.chainedTransformer(transformer1, null);
        });
    }

    @Test
    void testChainedTransformerWithEmptyArray() {
        Transformer<String, String> result = ChainedTransformer.chainedTransformer(new Transformer[0]);
        assertSame(NOPTransformer.nopTransformer(), result);
    }

    @Test
    void testChainedTransformerWithClone() throws Exception {
        Transformer<String, String> transformer = input -> input + "!";
        ChainedTransformer chainedTransformer = (ChainedTransformer) ChainedTransformer.class.getDeclaredConstructors()[1].newInstance(transformer);
        assertNotNull(chainedTransformer);
        assertArrayEquals(new Transformer[] { transformer }, chainedTransformer.getTransformers());
    }
}
