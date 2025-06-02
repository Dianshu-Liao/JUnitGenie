package org.apache.commons.collections4.functors;

import java.util.Arrays;
import java.util.Collection;
import org.apache.commons.collections4.Predicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.collections4.functors.FunctorUtils.coerce;
import static org.apache.commons.collections4.functors.FunctorUtils.validate;
import static org.apache.commons.collections4.functors.TruePredicate.truePredicate;

public class AllPredicate_allPredicate_0_0_Test {

    @Test
    public void testAllPredicateWithNoPredicates() {
        Collection<Predicate<Object>> predicates = Arrays.asList();
        Predicate<Object> result = AllPredicate.allPredicate(predicates);
        assertNotNull(result);
        // Should return true for any input
        assertTrue(result.test(new Object()));
    }

    @Test
    public void testAllPredicateWithOnePredicate() {
        Predicate<Integer> isEven = (Integer i) -> i % 2 == 0;
        Collection<Predicate<Integer>> predicates = Arrays.asList(isEven);
        Predicate<Integer> result = AllPredicate.allPredicate(predicates);
        assertNotNull(result);
        // Should return true
        assertTrue(result.test(2));
        // Should return false
        assertFalse(result.test(3));
    }

    @Test
    public void testAllPredicateWithMultiplePredicates() {
        Predicate<Integer> isEven = (Integer i) -> i % 2 == 0;
        Predicate<Integer> isPositive = (Integer i) -> i > 0;
        Collection<Predicate<Integer>> predicates = Arrays.asList(isEven, isPositive);
        Predicate<Integer> result = AllPredicate.allPredicate(predicates);
        assertNotNull(result);
        // Should return true
        assertTrue(result.test(2));
        // Should return false
        assertFalse(result.test(-2));
        // Should return false
        assertFalse(result.test(3));
    }

    @Test
    public void testAllPredicateWithMultiplePredicatesAllFalse() {
        Predicate<Integer> isEven = (Integer i) -> i % 2 == 0;
        Predicate<Integer> isPositive = (Integer i) -> i > 0;
        Collection<Predicate<Integer>> predicates = Arrays.asList(isEven, isPositive);
        Predicate<Integer> result = AllPredicate.allPredicate(predicates);
        assertNotNull(result);
        // Should return false
        assertFalse(result.test(-3));
    }
}
