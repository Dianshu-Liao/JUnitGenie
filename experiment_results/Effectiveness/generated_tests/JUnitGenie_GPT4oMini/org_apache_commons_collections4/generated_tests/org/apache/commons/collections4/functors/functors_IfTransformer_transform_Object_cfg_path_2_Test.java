package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.IfTransformer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class functors_IfTransformer_transform_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testTransformWithFalsePredicate() {
        // Arrange
        Predicate<Object> falsePredicate = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object input) {
                return false; // This will ensure the predicate evaluates to false
            }
        };

        Transformer<Object, String> trueTransformer = new Transformer<Object, String>() {
            @Override
            public String transform(Object input) {
                return "True"; // This transformer will not be called in this test
            }
        };

        Transformer<Object, String> falseTransformer = new Transformer<Object, String>() {
            @Override
            public String transform(Object input) {
                return "False"; // This transformer will be called
            }
        };

        IfTransformer<Object, String> ifTransformer = new IfTransformer<>(falsePredicate, trueTransformer, falseTransformer);

        // Act
        String result = null;
        try {
            result = ifTransformer.transform(new Object()); // Input that will cause the predicate to evaluate to false
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertEquals("False", result); // We expect the false transformer to be applied
    }


}