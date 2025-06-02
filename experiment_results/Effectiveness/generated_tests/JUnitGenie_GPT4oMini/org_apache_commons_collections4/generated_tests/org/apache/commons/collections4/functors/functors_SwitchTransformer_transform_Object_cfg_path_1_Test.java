package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.SwitchTransformer;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class functors_SwitchTransformer_transform_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testTransformWithMatchingPredicate() {
        // Arrange
        Predicate<Object>[] predicates = new Predicate[] {
            input -> input.equals("test"), // Predicate that matches "test"
            input -> input.equals("example") // Another predicate
        };
        
        Transformer<Object, Object>[] transformers = new Transformer[] {
            input -> "Matched: " + input, // Transformer for the first predicate
            input -> "Not matched" // Transformer for the second predicate
        };
        
        Transformer<Object, Object> defaultTransformer = input -> "Default: " + input;

        SwitchTransformer switchTransformer = new SwitchTransformer(predicates, transformers, defaultTransformer);
        
        // Act
        Object result = null;
        try {
            result = switchTransformer.transform("test");
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertEquals("Matched: test", result);
    }

    @Test(timeout = 4000)
    public void testTransformWithNoMatchingPredicate() {
        // Arrange
        Predicate<Object>[] predicates = new Predicate[] {
            input -> input.equals("test"),
            input -> input.equals("example")
        };
        
        Transformer<Object, Object>[] transformers = new Transformer[] {
            input -> "Matched: " + input,
            input -> "Not matched"
        };
        
        Transformer<Object, Object> defaultTransformer = input -> "Default: " + input;

        SwitchTransformer switchTransformer = new SwitchTransformer(predicates, transformers, defaultTransformer);
        
        // Act
        Object result = null;
        try {
            result = switchTransformer.transform("no match");
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertEquals("Default: no match", result);
    }

}