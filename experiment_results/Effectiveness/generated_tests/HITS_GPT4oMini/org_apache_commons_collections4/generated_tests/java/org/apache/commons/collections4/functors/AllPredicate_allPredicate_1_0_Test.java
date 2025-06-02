package org.apache.commons.collections4.functors;

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
import java.util.Collection;

public class AllPredicate_allPredicate_1_0_Test {

    @Test
    public void testAllPredicateWithNoPredicates() {
        Predicate<Object> result = AllPredicate.allPredicate();
        assertNotNull(result);
        // should return true for any input
        assertTrue(result.evaluate(new Object()));
    }

    @Test
    public void testAllPredicateWithSinglePredicate() {
        Predicate<String> singlePredicate = s -> s.length() > 3;
        Predicate<String> result = AllPredicate.allPredicate(singlePredicate);
        assertNotNull(result);
        // should return true
        assertTrue(result.evaluate("Hello"));
        // should return false
        assertFalse(result.evaluate("Hi"));
    }

    @Test
    public void testAllPredicateWithMultiplePredicates() {
        Predicate<String> lengthPredicate = s -> s.length() > 3;
        Predicate<String> startsWithPredicate = s -> s.startsWith("H");
        Predicate<String> result = AllPredicate.allPredicate(lengthPredicate, startsWithPredicate);
        assertNotNull(result);
        // should return true
        assertTrue(result.evaluate("Hello"));
        // should return false
        assertFalse(result.evaluate("Hi"));
        // should return false
        assertFalse(result.evaluate("Bye"));
    }

    @Test
    public void testAllPredicateWithEmptyArray() {
        Predicate<Object> result = AllPredicate.allPredicate(new Predicate[0]);
        assertNotNull(result);
        // should return true for any input
        assertTrue(result.evaluate(new Object()));
    }

    @Test
    public void testAllPredicateWithNullPredicates() {
        assertThrows(NullPointerException.class, () -> {
            AllPredicate.allPredicate((Predicate<String>[]) null);
        });
    }

    @Test
    public void testAllPredicateWithCopyPredicates() {
        Predicate<String> lengthPredicate = s -> s.length() > 3;
        Predicate<String> startsWithPredicate = s -> s.startsWith("H");
        Predicate<String>[] predicates = new Predicate[] { lengthPredicate, startsWithPredicate };
        Predicate<String> result = AllPredicate.allPredicate(predicates);
        assertNotNull(result);
        // should return true
        assertTrue(result.evaluate("Hello"));
        // should return false
        assertFalse(result.evaluate("Hi"));
    }
}
