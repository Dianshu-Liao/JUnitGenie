package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.NullIsExceptionPredicate;
import org.apache.commons.collections4.FunctorException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class functors_NullIsExceptionPredicate_test_Object_cfg_path_2_Test {

    @Test(expected = FunctorException.class)
    public void testNullObjectThrowsException() {
        NullIsExceptionPredicate predicate = new NullIsExceptionPredicate(null);
        try {
            predicate.test(null);
        } catch (FunctorException e) {
            // Verify the exception message
            assertEquals("Input Object must not be null", e.getMessage());
            throw e; // Rethrow to satisfy the expected exception
        }
    }


}