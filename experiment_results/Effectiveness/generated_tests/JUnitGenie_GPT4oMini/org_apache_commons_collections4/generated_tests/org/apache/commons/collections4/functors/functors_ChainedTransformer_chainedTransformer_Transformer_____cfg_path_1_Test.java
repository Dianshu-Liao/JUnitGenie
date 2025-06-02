package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.ChainedTransformer;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.FunctorUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class functors_ChainedTransformer_chainedTransformer_Transformer_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testChainedTransformerWithValidTransformers() {
        // Arrange
        Transformer<String, String> transformer1 = new Transformer<String, String>() {
            @Override
            public String transform(String input) {
                return input.toUpperCase();
            }
        };
        
        Transformer<String, String> transformer2 = new Transformer<String, String>() {
            @Override
            public String transform(String input) {
                return input + "!";
            }
        };
        
        Transformer<String, String>[] transformers = new Transformer[] { transformer1, transformer2 };

        // Act
        Transformer<String, String> result = null;
        try {
            result = ChainedTransformer.chainedTransformer(transformers);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testChainedTransformerWithNoTransformers() {
        // Arrange
        Transformer<String, String>[] transformers = new Transformer[0];

        // Act
        Transformer<String, String> result = null;
        try {
            result = ChainedTransformer.chainedTransformer(transformers);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testChainedTransformerWithNullTransformers() {
        // Arrange
        Transformer<String, String>[] transformers = null;

        // Act
        try {
            ChainedTransformer.chainedTransformer(transformers);
            fail("Expected an exception to be thrown");
        } catch (NullPointerException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected NullPointerException but got: " + e.getClass().getSimpleName());
        }
    }


}