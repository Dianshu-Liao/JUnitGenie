package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.AllPredicate;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.FunctorUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class functors_AllPredicate_allPredicate_Predicate_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAllPredicateWithNonEmptyArray() {
        Predicate<String> predicate1 = s -> s.length() > 0; // Non-empty string
        Predicate<String> predicate2 = s -> s.contains("test"); // Contains "test"
        Predicate<String>[] predicates = new Predicate[] { predicate1, predicate2 };

        try {
            Predicate<String> result = AllPredicate.allPredicate(predicates);
            assertNotNull(result);
            assertTrue(result.test("test")); // Should pass both predicates
            assertFalse(result.test("")); // Should fail the first predicate
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAllPredicateWithSinglePredicate() {
        Predicate<String> predicate = s -> s.length() > 0; // Non-empty string
        Predicate<String>[] predicates = new Predicate[] { predicate };

        try {
            Predicate<String> result = AllPredicate.allPredicate(predicates);
            assertNotNull(result);
            assertTrue(result.test("test")); // Should pass
            assertFalse(result.test("")); // Should fail
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAllPredicateWithEmptyArray() {
        Predicate<String>[] predicates = new Predicate[0];

        try {
            Predicate<String> result = AllPredicate.allPredicate(predicates);
            assertNotNull(result);
            assertTrue(result.test("anyString")); // Should return true for any input
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(expected = NullPointerException.class)
    public void testAllPredicateWithNullArray() {
        Predicate<String>[] predicates = null;

        try {
            AllPredicate.allPredicate(predicates);
        } catch (NullPointerException e) {
            // Expected exception
            throw e;
        }
    }

}