package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.AllPredicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.collections4.functors.FunctorUtils.coerce;
import static org.apache.commons.collections4.functors.FunctorUtils.validate;
import static org.apache.commons.collections4.functors.TruePredicate.truePredicate;

class AllPredicate_allPredicate_0_0_Test {

    @Test
    void testAllPredicateWithEmptyCollection() {
        Collection<Predicate<Object>> predicates = new ArrayList<>();
        Predicate<Object> result = AllPredicate.allPredicate(predicates);
        // Should return true
        assertTrue(result.evaluate(new Object()));
    }

    @Test
    void testAllPredicateWithSinglePredicate() {
        Predicate<Integer> isEven = number -> number % 2 == 0;
        Collection<Predicate<Integer>> predicates = Collections.singletonList(isEven);
        Predicate<Integer> result = AllPredicate.allPredicate(predicates);
        // Should return true
        assertTrue(result.evaluate(2));
        // Should return false
        assertFalse(result.evaluate(3));
    }

    @Test
    void testAllPredicateWithMultiplePredicates() {
        Predicate<Integer> isEven = number -> number % 2 == 0;
        Predicate<Integer> isPositive = number -> number > 0;
        Collection<Predicate<Integer>> predicates = new ArrayList<>();
        predicates.add(isEven);
        predicates.add(isPositive);
        Predicate<Integer> result = AllPredicate.allPredicate(predicates);
        // Should return true
        assertTrue(result.evaluate(2));
        // Should return false
        assertFalse(result.evaluate(-2));
        // Should return false
        assertFalse(result.evaluate(3));
    }

    @Test
    void testAllPredicateWithNullPredicates() {
        Collection<Predicate<Object>> predicates = new ArrayList<>();
        predicates.add(null);
        Predicate<Object> result = AllPredicate.allPredicate(predicates);
        assertThrows(NullPointerException.class, () -> result.evaluate(new Object()));
    }

    @Test
    void testAllPredicateWithMixedPredicates() {
        Predicate<Integer> isEven = number -> number % 2 == 0;
        Predicate<Integer> isGreaterThanFive = number -> number > 5;
        Collection<Predicate<Integer>> predicates = new ArrayList<>();
        predicates.add(isEven);
        predicates.add(isGreaterThanFive);
        Predicate<Integer> result = AllPredicate.allPredicate(predicates);
        // Should return false
        assertFalse(result.evaluate(4));
        // Should return false
        assertFalse(result.evaluate(6));
        // Should return true
        assertTrue(result.evaluate(8));
    }
}
