package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.AndPredicate;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class functors_AndPredicate_test_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWithFalsePredicate() {
        // Create predicates that will return false for the test input
        Predicate<Object> falsePredicate1 = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object object) {
                return false; // This predicate always returns false
            }
        };

        Predicate<Object> falsePredicate2 = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object object) {
                return true; // This predicate can return true
            }
        };

        // Instantiate AndPredicate with the two predicates
        AndPredicate andPredicate = new AndPredicate(falsePredicate1, falsePredicate2);

        // Test input that meets the constraints
        Object testInput = new Object(); // The actual object doesn't matter since the first predicate will return false

        // Execute the test method and assert the result
        try {
            boolean result = andPredicate.test(testInput);
            assertFalse(result); // We expect the result to be false
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

}