package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.OrPredicate;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class functors_OrPredicate_test_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWithTruePredicate() {
        // Create predicates
        Predicate<Object> truePredicate = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object object) {
                return true; // Always returns true
            }
        };

        Predicate<Object> falsePredicate = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object object) {
                return false; // Always returns false
            }
        };

        // Create an instance of OrPredicate with one true and one false predicate
        OrPredicate orPredicate = new OrPredicate(truePredicate, falsePredicate);

        // Test the method with an arbitrary object
        Object testObject = new Object();
        try {
            boolean result = orPredicate.test(testObject);
            assertTrue(result); // Expecting true since one predicate returns true
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

}