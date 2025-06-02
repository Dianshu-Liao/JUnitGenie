package org.apache.commons.collections4.functors;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import org.apache.commons.collections4.Transformer;

public class ChainedTransformer_chainedTransformer_1_0_Test {

    @Test
    public void testChainedTransformerWithNoTransformers() {
        Transformer<Object, Object> transformer = ChainedTransformer.chainedTransformer();
        assertNotNull(transformer);
        assertTrue(transformer instanceof NOPTransformer);
    }

    @Test
    public void testChainedTransformerWithSingleTransformer() {
        Transformer<String, String> upperCaseTransformer = String::toUpperCase;
        Transformer<String, String> transformer = ChainedTransformer.chainedTransformer(upperCaseTransformer);
        assertNotNull(transformer);
        assertEquals("HELLO", transformer.transform("hello"));
    }

    @Test
    public void testChainedTransformerWithMultipleTransformers() {
        Transformer<String, String> upperCaseTransformer = String::toUpperCase;
        Transformer<String, String> exclamationTransformer = s -> s + "!";
        Transformer<String, String> transformer = ChainedTransformer.chainedTransformer(upperCaseTransformer, exclamationTransformer);
        assertNotNull(transformer);
        assertEquals("HELLO!", transformer.transform("hello"));
    }

    @Test
    public void testChainedTransformerWithNullTransformer() {
        Transformer<String, String> upperCaseTransformer = String::toUpperCase;
        Transformer<String, String> transformer = ChainedTransformer.chainedTransformer(upperCaseTransformer, null);
        assertNotNull(transformer);
        assertThrows(NullPointerException.class, () -> transformer.transform("hello"));
    }

    @Test
    public void testChainedTransformerWithEmptyArray() {
        Transformer<String, String> transformer = ChainedTransformer.chainedTransformer(new Transformer[0]);
        assertNotNull(transformer);
        assertTrue(transformer instanceof NOPTransformer);
    }
}
