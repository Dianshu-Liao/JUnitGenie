package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.AllPredicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.collections4.functors.FunctorUtils.coerce;
import static org.apache.commons.collections4.functors.FunctorUtils.validate;
import static org.apache.commons.collections4.functors.TruePredicate.truePredicate;
import java.util.Collection;

class AllPredicate_allPredicate_1_1_Test {

    @Test
    void testAllPredicateWithNoPredicates() {
        Predicate<Object> result = AllPredicate.allPredicate();
        // Should return true as per the implementation
        assertTrue(result.evaluate(new Object()));
    }

    @Test
    void testAllPredicateWithOnePredicate() {
        Predicate<Integer> isEven = number -> number % 2 == 0;
        Predicate<Integer> result = AllPredicate.allPredicate(isEven);
        // Even number
        assertTrue(result.evaluate(2));
        // Odd number
        assertFalse(result.evaluate(3));
    }

    @Test
    void testAllPredicateWithMultiplePredicates() {
        Predicate<Integer> isEven = number -> number % 2 == 0;
        Predicate<Integer> isPositive = number -> number > 0;
        Predicate<Integer> result = AllPredicate.allPredicate(isEven, isPositive);
        // Even and positive
        assertTrue(result.evaluate(2));
        // Even but not positive
        assertFalse(result.evaluate(-2));
        // Odd but positive
        assertFalse(result.evaluate(3));
        // Odd and not positive
        assertFalse(result.evaluate(-3));
    }

    @Test
    void testAllPredicateWithNullPredicates() {
        assertThrows(NullPointerException.class, () -> {
            AllPredicate.allPredicate((Predicate<Integer>[]) null);
        });
    }

    @Test
    void testAllPredicateWithEmptyArray() {
        Predicate<Object> result = AllPredicate.allPredicate(new Predicate[0]);
        // Should return true as per the implementation
        assertTrue(result.evaluate(new Object()));
    }

    @Test
    void testAllPredicateWithMultipleNullPredicates() {
        Predicate<Object> result = AllPredicate.allPredicate((Predicate<Object>) null, (Predicate<Object>) null);
        assertThrows(NullPointerException.class, () -> {
            result.evaluate(new Object());
        });
    }
}
