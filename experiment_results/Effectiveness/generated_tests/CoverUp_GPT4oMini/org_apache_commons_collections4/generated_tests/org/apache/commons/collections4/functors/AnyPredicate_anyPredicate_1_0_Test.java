package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.AnyPredicate;
import org.apache.commons.collections4.functors.FalsePredicate;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;

class AnyPredicate_anyPredicate_1_0_Test {

    @Test
    void testAnyPredicateWithNoPredicates() {
        Predicate<Object> result = AnyPredicate.anyPredicate();
        assertSame(FalsePredicate.<Object>falsePredicate(), result);
    }

    @Test
    void testAnyPredicateWithOnePredicate() {
        Predicate<String> predicate = s -> s.length() > 0;
        Predicate<String> result = AnyPredicate.anyPredicate(predicate);
        assertSame(predicate, result);
    }

    @Test
    void testAnyPredicateWithMultiplePredicates() {
        Predicate<String> predicate1 = s -> s.isEmpty();
        Predicate<String> predicate2 = s -> s.length() > 5;
        Predicate<String> result = AnyPredicate.anyPredicate(predicate1, predicate2);
        assertNotNull(result);
        // should match predicate1
        assertTrue(result.evaluate(""));
        // should not match either predicate
        assertFalse(result.evaluate("abc"));
        // should match predicate2
        assertTrue(result.evaluate("abcdef"));
    }

    @Test
    void testAnyPredicateWithNullPredicates() {
        Predicate<String> result = AnyPredicate.anyPredicate((Predicate<String>[]) null);
        assertSame(FalsePredicate.<String>falsePredicate(), result);
    }

    @Test
    void testAnyPredicateWithEmptyArray() {
        Predicate<String> result = AnyPredicate.anyPredicate(new Predicate[0]);
        assertSame(FalsePredicate.<String>falsePredicate(), result);
    }

    @Test
    void testAnyPredicateWithMixedPredicates() {
        Predicate<String> predicate1 = s -> s.length() < 3;
        Predicate<String> predicate2 = s -> s.contains("test");
        Predicate<String> result = AnyPredicate.anyPredicate(predicate1, predicate2);
        assertNotNull(result);
        // should match predicate1
        assertTrue(result.evaluate("te"));
        // should match predicate2
        assertTrue(result.evaluate("this is a test"));
        // should not match either predicate
        assertFalse(result.evaluate("abc"));
    }
}
