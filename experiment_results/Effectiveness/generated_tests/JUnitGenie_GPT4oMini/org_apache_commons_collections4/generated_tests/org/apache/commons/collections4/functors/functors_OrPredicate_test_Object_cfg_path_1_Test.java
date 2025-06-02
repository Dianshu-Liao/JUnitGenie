package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.OrPredicate;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class functors_OrPredicate_test_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWithTrueFirstPredicate() {
        Predicate<Object> predicate1 = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object object) {
                return true;
            }
        };

        Predicate<Object> predicate2 = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object object) {
                return false;
            }
        };

        OrPredicate<Object> orPredicate = new OrPredicate<>(predicate1, predicate2);
        Object testObject = new Object(); // Sample object to test
        boolean result = false;
        try {
            result = orPredicate.evaluate(testObject);
        } catch (Exception e) {
            // Handle exception if needed
        }
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testWithFalseBothPredicates() {
        Predicate<Object> predicate1 = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object object) {
                return false;
            }
        };

        Predicate<Object> predicate2 = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object object) {
                return false;
            }
        };

        OrPredicate<Object> orPredicate = new OrPredicate<>(predicate1, predicate2);
        Object testObject = new Object(); // Sample object to test
        boolean result = false;
        try {
            result = orPredicate.evaluate(testObject);
        } catch (Exception e) {
            // Handle exception if needed
        }
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testWithTrueSecondPredicate() {
        Predicate<Object> predicate1 = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object object) {
                return false;
            }
        };

        Predicate<Object> predicate2 = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object object) {
                return true;
            }
        };

        OrPredicate<Object> orPredicate = new OrPredicate<>(predicate1, predicate2);
        Object testObject = new Object(); // Sample object to test
        boolean result = false;
        try {
            result = orPredicate.evaluate(testObject);
        } catch (Exception e) {
            // Handle exception if needed
        }
        assertTrue(result);
    }


}