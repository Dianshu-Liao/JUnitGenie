package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.ChainedTransformer;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.FunctorUtils;
import org.junit.Test;
import java.util.function.Function;
import static org.junit.Assert.assertNotNull;

public class functors_ChainedTransformer_chainedTransformer_Transformer_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testChainedTransformerWithValidTransformers() {
        // Arrange
        Transformer<Function<String, String>, Function<String, String>> transformer1 = 
            input -> (Function<String, String>) (s -> s.toUpperCase());
        Transformer<Function<String, String>, Function<String, String>> transformer2 = 
            input -> (Function<String, String>) (s -> s + " World");

        Transformer<? super Function<String, String>, ? extends Function<String, String>>[] transformers = 
            new Transformer[] { transformer1, transformer2 };

        // Act
        Transformer<Function<String, String>, Function<String, String>> result = 
            ChainedTransformer.chainedTransformer(transformers);

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testChainedTransformerWithNoTransformers() {
        // Act
        Transformer<?, ?> result = ChainedTransformer.chainedTransformer(new Transformer[0]);

        // Assert
        assertNotNull(result);
    }

    @Test(expected = NullPointerException.class)
    public void testChainedTransformerWithNullTransformers() {
        // Act
        ChainedTransformer.chainedTransformer((Transformer<? super Function<String, String>, ? extends Function<String, String>>[]) null);
    }

    @Test(timeout = 4000)
    public void testChainedTransformerWithInvalidFunctionArray() {
        // Arrange
        Transformer<Function<String, String>, Function<String, String>> transformer = 
            input -> (Function<String, String>) (s -> s.toLowerCase());

        // Act
        Transformer<? super Function<String, String>, ? extends Function<String, String>> result = 
            ChainedTransformer.chainedTransformer(new Transformer[] { transformer });

        // Assert
        assertNotNull(result);
    }

}