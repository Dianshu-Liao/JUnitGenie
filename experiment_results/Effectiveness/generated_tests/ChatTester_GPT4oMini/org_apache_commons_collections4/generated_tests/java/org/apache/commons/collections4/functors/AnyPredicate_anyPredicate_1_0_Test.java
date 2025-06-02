package org.apache.commons.collections4.functors;

import org.junit.jupiter.api.function.Executable;
// Fixed import to avoid conflict
import org.apache.commons.collections4.Predicate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collection;
import org.apache.commons.collections4.Predicate;

@ExtendWith(MockitoExtension.class)
class AnyPredicate_anyPredicate_1_0_Test {

    @Test
    void testAnyPredicateWithNoPredicates() {
        Predicate<Object> result = AnyPredicate.anyPredicate();
        assertNotNull(result);
        // Assuming FalsePredicate always returns false
        assertFalse(result.test(new Object()));
    }

    @Test
    void testAnyPredicateWithOnePredicate() {
        org.apache.commons.collections4.Predicate<String> predicate = s -> s.equals("test");
        org.apache.commons.collections4.Predicate<String> result = AnyPredicate.anyPredicate(predicate);
        assertNotNull(result);
        assertTrue(result.evaluate("test"));
        assertFalse(result.evaluate("not test"));
    }

    @Test
    void testAnyPredicateWithMultiplePredicates() {
        org.apache.commons.collections4.Predicate<String> predicate1 = s -> s.startsWith("a");
        org.apache.commons.collections4.Predicate<String> predicate2 = s -> s.endsWith("z");
        org.apache.commons.collections4.Predicate<String> result = AnyPredicate.anyPredicate(predicate1, predicate2);
        assertNotNull(result);
        // Should be true for predicate1
        assertTrue(result.evaluate("a test z"));
        // Should be true for predicate2
        assertTrue(result.evaluate("test z"));
        // Should be false for both
        assertFalse(result.evaluate("test"));
    }

    @Test
    void testAnyPredicateWithNullPredicates() {
        Executable executable = () -> AnyPredicate.anyPredicate((org.apache.commons.collections4.Predicate<Object>[]) null);
        assertThrows(NullPointerException.class, executable);
    }

    @Test
    void testAnyPredicateWithEmptyArray() {
        org.apache.commons.collections4.Predicate<Object> result = AnyPredicate.anyPredicate(new org.apache.commons.collections4.Predicate[0]);
        assertNotNull(result);
        assertFalse(result.evaluate(new Object()));
    }

    @Test
    void testAnyPredicateWithSingleNullPredicate() {
        org.apache.commons.collections4.Predicate<Object> result = AnyPredicate.anyPredicate((org.apache.commons.collections4.Predicate<Object>) null);
        assertNotNull(result);
        // Assuming FalsePredicate always returns false
        assertFalse(result.evaluate(new Object()));
    }
}
