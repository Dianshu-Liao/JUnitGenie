package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Predicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;

public class AnyPredicate_anyPredicate_1_0_Test {

    @Test
    public void testAnyPredicateWithNoPredicates() {
        Predicate<Object> predicate = AnyPredicate.anyPredicate();
        assertNotNull(predicate);
        assertFalse(predicate.evaluate(new Object()));
    }

    @Test
    public void testAnyPredicateWithOnePredicate() {
        Predicate<String> predicate = s -> s.equals("test");
        Predicate<String> result = AnyPredicate.anyPredicate(predicate);
        assertNotNull(result);
        assertTrue(result.evaluate("test"));
        assertFalse(result.evaluate("not_test"));
    }

    @Test
    public void testAnyPredicateWithMultiplePredicates() {
        Predicate<String> predicate1 = s -> s.equals("test1");
        Predicate<String> predicate2 = s -> s.equals("test2");
        Predicate<String> result = AnyPredicate.anyPredicate(predicate1, predicate2);
        assertNotNull(result);
        assertTrue(result.evaluate("test1"));
        assertTrue(result.evaluate("test2"));
        assertFalse(result.evaluate("test3"));
    }

    @Test
    public void testAnyPredicateWithMultiplePredicatesAllFalse() {
        Predicate<String> predicate1 = s -> s.equals("test1");
        Predicate<String> predicate2 = s -> s.equals("test2");
        Predicate<String> result = AnyPredicate.anyPredicate(predicate1, predicate2);
        assertNotNull(result);
        assertFalse(result.evaluate("test3"));
    }

    @Test
    public void testAnyPredicateWithNullPredicates() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AnyPredicate.anyPredicate((Predicate<String>[]) null);
        });
        assertEquals("Predicates cannot be null", exception.getMessage());
    }
}
