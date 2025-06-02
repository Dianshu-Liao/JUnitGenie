package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.TransformerPredicate;
import org.apache.commons.collections4.FunctorException;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class functors_TransformerPredicate_test_Object_cfg_path_1_Test {

    private TransformerPredicate<Object> transformerPredicate; // Corrected type arguments

    @Before
    public void setUp() {
        Transformer<Object, Boolean> transformer = new Transformer<Object, Boolean>() {
            @Override
            public Boolean transform(Object input) {
                return Boolean.TRUE; // Returns a non-null Boolean for testing
            }
        };
        transformerPredicate = new TransformerPredicate<>(transformer);
    }

    @Test(timeout = 4000)
    public void testValidObject() {
        Object testObject = new Object(); // Example non-null object
        boolean result = transformerPredicate.test(testObject);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testNullTransformerOutput() {
        Transformer<Object, Boolean> transformer = new Transformer<Object, Boolean>() {
            @Override
            public Boolean transform(Object input) {
                return null; // Intentionally returns null to test exception
            }
        };
        transformerPredicate = new TransformerPredicate<>(transformer);
        
        try {
            transformerPredicate.test(new Object());
            fail("Expected FunctorException to be thrown");
        } catch (FunctorException e) {
            assertEquals("Transformer must return an instanceof Boolean, it was a null object", e.getMessage());
        }
    }


}