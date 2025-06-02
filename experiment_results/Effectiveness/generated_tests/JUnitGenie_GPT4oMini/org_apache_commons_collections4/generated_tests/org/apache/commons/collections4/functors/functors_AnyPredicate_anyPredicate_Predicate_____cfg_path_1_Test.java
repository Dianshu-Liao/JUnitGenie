package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.AnyPredicate;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.FunctorUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class functors_AnyPredicate_anyPredicate_Predicate_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAnyPredicateWithValidPredicates() {
        Predicate<String> predicate1 = s -> s.length() > 0;
        Predicate<String> predicate2 = s -> s.contains("test");
        Predicate<String>[] predicates = new Predicate[]{predicate1, predicate2};

        try {
            Predicate<String> result = AnyPredicate.anyPredicate(predicates);
            assertNotNull(result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAnyPredicateWithEmptyArray() {
        Predicate<String>[] predicates = new Predicate[0];

        try {
            Predicate<String> result = AnyPredicate.anyPredicate(predicates);
            assertNotNull(result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAnyPredicateWithSinglePredicate() {
        Predicate<String> predicate = s -> s.length() > 0;
        Predicate<String>[] predicates = new Predicate[]{predicate};

        try {
            Predicate<String> result = AnyPredicate.anyPredicate(predicates);
            assertNotNull(result);
            assertEquals(predicate, result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAnyPredicateWithNullArray() {
        Predicate<String>[] predicates = null;

        try {
            AnyPredicate.anyPredicate(predicates);
            fail("Exception should have been thrown for null predicates array");
        } catch (Exception e) {
            // Expected exception
        }
    }

}