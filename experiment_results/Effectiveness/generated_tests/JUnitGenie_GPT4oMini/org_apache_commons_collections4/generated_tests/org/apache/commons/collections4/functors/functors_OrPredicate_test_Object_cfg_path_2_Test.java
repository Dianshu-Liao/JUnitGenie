package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.OrPredicate;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import static org.junit.Assert.*;

public class functors_OrPredicate_test_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void test_With_FalseEvaluation() {
        // Creating predicates that evaluate to false for the input object
        Predicate<Object> predicate1 = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object o) {
                return false; // Ensures first predicate returns false
            }
        };
        
        Predicate<Object> predicate2 = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object o) {
                return false; // Ensures second predicate returns false
            }
        };

        OrPredicate<Object> orPredicate = new OrPredicate<>(predicate1, predicate2);
        Object testObject = new Object(); // Input object to evaluate

        try {
            // The expected result is false as both predicates return false
            boolean result = orPredicate.evaluate(testObject);
            assertFalse(result);
        } catch (Exception e) {
            fail("Exception thrown during test method: " + e.getMessage());
        }
    }


}