package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.AnyPredicate;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.FunctorUtils;
import org.apache.commons.collections4.functors.FalsePredicate;
import org.junit.Test;
import static org.junit.Assert.*;

public class functors_AnyPredicate_anyPredicate_Predicate_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAnyPredicateWithNoPredicates() {
        Predicate<Object> result = AnyPredicate.anyPredicate(new Predicate[0]);
        assertEquals(FalsePredicate.falsePredicate(), result);
    }

    @Test(timeout = 4000)
    public void testAnyPredicateWithOnePredicate() {
        Predicate<String> predicate = s -> s.length() > 0;
        Predicate<String> result = AnyPredicate.anyPredicate(predicate);
        assertEquals(predicate, result);
    }

    @Test(timeout = 4000)
    public void testAnyPredicateWithMultiplePredicates() {
        Predicate<String> predicate1 = s -> s.length() > 0;
        Predicate<String> predicate2 = s -> s.startsWith("A");
        Predicate<String> result = AnyPredicate.anyPredicate(predicate1, predicate2);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAnyPredicateWithNullArray() {
        try {
            AnyPredicate.anyPredicate((Predicate<Object>[]) null); // Cast to resolve ambiguity
            fail("Expected an exception to be thrown");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testAnyPredicateWithInvalidPredicates() {
        Predicate<String>[] predicates = new Predicate[1];
        predicates[0] = null; // Invalid predicate
        try {
            AnyPredicate.anyPredicate(predicates);
            fail("Expected an exception to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }


}