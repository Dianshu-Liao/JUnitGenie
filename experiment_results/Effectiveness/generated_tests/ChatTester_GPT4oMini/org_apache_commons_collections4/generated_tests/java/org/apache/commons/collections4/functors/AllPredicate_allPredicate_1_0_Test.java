package org.apache.commons.collections4.functors;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.apache.commons.collections4.functors.FunctorUtils.coerce;
import static org.apache.commons.collections4.functors.FunctorUtils.validate;
import static org.apache.commons.collections4.functors.TruePredicate.truePredicate;
import java.util.Collection;
import org.apache.commons.collections4.Predicate;

@ExtendWith(MockitoExtension.class)
class AllPredicate_allPredicate_1_0_Test {

    @Test
    void testAllPredicateWithNoPredicates() {
        Predicate<Object> predicate = AllPredicate.allPredicate();
        // should return true for any input
        assertTrue(predicate.test(new Object()));
    }

    @Test
    void testAllPredicateWithOnePredicate() {
        org.apache.commons.collections4.Predicate<String> singlePredicate = s -> s.length() > 0;
        org.apache.commons.collections4.Predicate<String> predicate = AllPredicate.allPredicate(singlePredicate);
        // should return true
        assertTrue(predicate.test("Hello"));
        // should return false
        assertFalse(predicate.test(""));
    }

    @Test
    void testAllPredicateWithMultiplePredicates() {
        org.apache.commons.collections4.Predicate<String> nonEmpty = s -> s.length() > 0;
        org.apache.commons.collections4.Predicate<String> startsWithA = s -> s.startsWith("A");
        org.apache.commons.collections4.Predicate<String> predicate = AllPredicate.allPredicate(nonEmpty, startsWithA);
        // non-empty but does not start with A
        assertFalse(predicate.test("Hello"));
        // empty string
        assertFalse(predicate.test(""));
        // non-empty and starts with A
        assertTrue(predicate.test("Apple"));
    }

    @Test
    void testAllPredicateWithNullPredicates() {
        Executable executable = () -> AllPredicate.allPredicate((org.apache.commons.collections4.Predicate<String>[]) null);
        assertThrows(NullPointerException.class, executable);
    }

    @Test
    void testAllPredicateWithEmptyArray() {
        org.apache.commons.collections4.Predicate<Object> predicate = AllPredicate.allPredicate(new org.apache.commons.collections4.Predicate[0]);
        // should return true for any input
        assertTrue(predicate.test(new Object()));
    }

    @Test
    void testAllPredicateWithMultiplePredicatesIncludingNull() {
        org.apache.commons.collections4.Predicate<String> nonEmpty = s -> s.length() > 0;
        // null predicate
        org.apache.commons.collections4.Predicate<String> startsWithA = null;
        org.apache.commons.collections4.Predicate<String> predicate = AllPredicate.allPredicate(nonEmpty, startsWithA);
        // empty string
        assertFalse(predicate.test(""));
        assertFalse(predicate.test("Apple"));
    }

    @Test
    void testAllPredicateWithAllFalsePredicates() {
        org.apache.commons.collections4.Predicate<String> alwaysFalse = s -> false;
        org.apache.commons.collections4.Predicate<String> predicate = AllPredicate.allPredicate(alwaysFalse);
        // should return false
        assertFalse(predicate.test("Hello"));
        // should return false
        assertFalse(predicate.test(""));
    }

    @Test
    void testAllPredicateWithMixedPredicates() {
        org.apache.commons.collections4.Predicate<String> nonEmpty = s -> s.length() > 0;
        org.apache.commons.collections4.Predicate<String> alwaysFalse = s -> false;
        org.apache.commons.collections4.Predicate<String> alwaysTrue = s -> true;
        org.apache.commons.collections4.Predicate<String> predicate = AllPredicate.allPredicate(nonEmpty, alwaysFalse, alwaysTrue);
        // empty string
        assertFalse(predicate.test(""));
        // non-empty but has a false predicate
        assertFalse(predicate.test("Hello"));
        // non-empty and all predicates are satisfied
        assertTrue(predicate.test("World"));
    }
}
