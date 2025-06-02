package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.TransformerPredicate;
import org.apache.commons.collections4.FunctorException;
import org.junit.Test;
import static org.junit.Assert.*;

public class functors_TransformerPredicate_test_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testTransformerReturnsNull() {
        // Arrange
        Transformer<Object, Boolean> transformer = new Transformer<Object, Boolean>() {
            @Override
            public Boolean transform(Object input) {
                return null; // This will trigger the exception
            }
        };
        TransformerPredicate<Object> predicate = new TransformerPredicate<>(transformer);
        
        // Act
        try {
            predicate.evaluate(new Object());
            fail("Expected FunctorException to be thrown");
        } catch (FunctorException e) {
            // Assert
            assertEquals("Transformer must return an instanceof Boolean, it was a null object", e.getMessage());
        }
    }

}