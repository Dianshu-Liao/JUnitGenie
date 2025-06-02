package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.AndPredicate;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class functors_AndPredicate_test_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEvaluateFalse() {
        // Create a Predicate that always returns false
        Predicate<Object> falsePredicate = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object object) {
                return false; // Always returns false
            }
        };

        // Create a Predicate that can return true or false based on input
        Predicate<Object> truePredicate = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object object) {
                return true; // Always returns true
            }
        };

        // Instantiate the AndPredicate with the two predicates
        AndPredicate<Object> andPredicate = new AndPredicate<>(falsePredicate, truePredicate);

        // Test the AndPredicate with an object that should return false
        Object testObject = new Object(); // The actual object doesn't matter here
        try {
            boolean result = andPredicate.test(testObject);
            assertFalse(result); // Expecting false since one predicate returns false
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

}