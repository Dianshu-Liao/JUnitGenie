package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.AllPredicate;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.FunctorUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class functors_AllPredicate_allPredicate_Predicate_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAllPredicateWithMultiplePredicates() {
        Predicate<Integer> isEven = new Predicate<Integer>() {
            public boolean evaluate(Integer number) {
                return number % 2 == 0;
            }
        };

        Predicate<Integer> isPositive = new Predicate<Integer>() {
            public boolean evaluate(Integer number) {
                return number > 0;
            }
        };

        Predicate<Integer>[] predicates = new Predicate[] { isEven, isPositive };

        try {
            Predicate<Integer> allPredicates = AllPredicate.allPredicate(predicates);
            assertNotNull(allPredicates);
            assertTrue(allPredicates.evaluate(2)); // Even and positive
            assertFalse(allPredicates.evaluate(-2)); // Even but not positive
            assertFalse(allPredicates.evaluate(1)); // Positive but not even
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAllPredicateWithSinglePredicate() {
        Predicate<Integer> isOdd = new Predicate<Integer>() {
            public boolean evaluate(Integer number) {
                return number % 2 != 0;
            }
        };

        Predicate<Integer>[] predicates = new Predicate[] { isOdd };

        try {
            Predicate<Integer> allPredicates = AllPredicate.allPredicate(predicates);
            assertNotNull(allPredicates);
            assertTrue(allPredicates.evaluate(1)); // Odd
            assertFalse(allPredicates.evaluate(2)); // Not odd
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAllPredicateWithNoPredicates() {
        Predicate<Integer>[] predicates = new Predicate[0];

        try {
            Predicate<Integer> allPredicates = AllPredicate.allPredicate(predicates);
            assertNotNull(allPredicates);
            // Assuming truePredicate() returns a predicate that always returns true
            assertTrue(allPredicates.evaluate(1)); // Should always return true
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}