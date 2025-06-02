package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.NullIsExceptionPredicate;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.FunctorException;
import org.junit.Test;
import static org.junit.Assert.*;

public class functors_NullIsExceptionPredicate_test_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWithNullObject() {
        NullIsExceptionPredicate<Object> predicate = new NullIsExceptionPredicate<>(new Predicate<Object>() {
            @Override
            public boolean evaluate(Object obj) { // Changed test to evaluate
                return obj != null;
            }
        });

        try {
            predicate.evaluate(null); // Changed test to evaluate
            fail("Expected FunctorException to be thrown");
        } catch (FunctorException e) {
            assertEquals("Input Object must not be null", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testWithNonNullObject() {
        NullIsExceptionPredicate<Object> predicate = new NullIsExceptionPredicate<>(new Predicate<Object>() {
            @Override
            public boolean evaluate(Object obj) { // Changed test to evaluate
                return obj != null;
            }
        });

        boolean result = predicate.evaluate(new Object()); // Changed test to evaluate
        assertTrue(result);
    }

}