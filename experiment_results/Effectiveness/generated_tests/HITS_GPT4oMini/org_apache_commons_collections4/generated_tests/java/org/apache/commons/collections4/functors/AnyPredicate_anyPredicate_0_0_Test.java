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

public class AnyPredicate_anyPredicate_0_0_Test {

    @Test
    public void testAnyPredicateWithEmptyCollection() {
        Collection<Predicate<Object>> predicates = Arrays.asList();
        Predicate<Object> result = AnyPredicate.anyPredicate(predicates);
        assertNotNull(result);
        // Should return false for any input
        assertFalse(result.test(new Object()));
    }

    @Test
    public void testAnyPredicateWithSinglePredicate() {
        Predicate<String> predicate = s -> s.length() > 3;
        Collection<Predicate<String>> predicates = Arrays.asList(predicate);
        Predicate<String> result = AnyPredicate.anyPredicate(predicates);
        assertNotNull(result);
        // Should return true
        assertTrue(result.test("Hello"));
        // Should return false
        assertFalse(result.test("Hi"));
    }

    @Test
    public void testAnyPredicateWithMultiplePredicates() {
        Predicate<String> predicate1 = s -> s.startsWith("A");
        Predicate<String> predicate2 = s -> s.length() > 5;
        Collection<Predicate<String>> predicates = Arrays.asList(predicate1, predicate2);
        Predicate<String> result = AnyPredicate.anyPredicate(predicates);
        assertNotNull(result);
        // Should return true (matches predicate1)
        assertTrue(result.test("Apple"));
        // Should return true (matches predicate2)
        assertTrue(result.test("Banana"));
        // Should return false (matches none)
        assertFalse(result.test("Hi"));
    }

    @Test
    public void testAnyPredicateWithNullPredicates() {
        Collection<Predicate<Object>> predicates = Arrays.asList((Predicate<Object>) null);
        Predicate<Object> result = AnyPredicate.anyPredicate(predicates);
        assertNotNull(result);
        // Should return false for any input
        assertFalse(result.test(new Object()));
    }

    @Test
    public void testAnyPredicateWithAllFalsePredicates() {
        Predicate<String> falsePredicate = s -> false;
        Collection<Predicate<String>> predicates = Arrays.asList(falsePredicate, falsePredicate);
        Predicate<String> result = AnyPredicate.anyPredicate(predicates);
        assertNotNull(result);
        // Should return false
        assertFalse(result.test("AnyString"));
    }
}
