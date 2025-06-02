package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.AnyPredicate;
import org.apache.commons.collections4.functors.FalsePredicate;
import org.apache.commons.collections4.functors.FunctorUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class AnyPredicate_anyPredicate_0_0_Test {

    @Test
    void testAnyPredicateWithNoPredicates() {
        Collection<Predicate<Object>> predicates = Collections.emptyList();
        Predicate<Object> result = AnyPredicate.anyPredicate(predicates);
        assertSame(FalsePredicate.falsePredicate(), result);
    }

    @Test
    void testAnyPredicateWithOnePredicate() {
        Predicate<String> predicate = s -> s.length() > 0;
        Collection<Predicate<String>> predicates = Collections.singletonList(predicate);
        Predicate<String> result = AnyPredicate.anyPredicate(predicates);
        assertSame(predicate, result);
    }

    @Test
    void testAnyPredicateWithMultiplePredicates() {
        Predicate<String> predicate1 = s -> s.length() > 0;
        Predicate<String> predicate2 = s -> s.startsWith("A");
        Collection<Predicate<String>> predicates = new ArrayList<>();
        predicates.add(predicate1);
        predicates.add(predicate2);
        Predicate<String> result = AnyPredicate.anyPredicate(predicates);
        assertNotNull(result);
        // Should return true
        assertTrue(result.evaluate("Apple"));
        // Should return false
        assertFalse(result.evaluate(""));
    }

    @Test
    void testAnyPredicateWithNullPredicates() {
        Collection<Predicate<Object>> predicates = null;
        assertThrows(NullPointerException.class, () -> {
            AnyPredicate.anyPredicate(predicates);
        });
    }

    @Test
    void testPrivateConstructor() throws Exception {
        // Using reflection to test the private constructor
        Method constructor = AnyPredicate.class.getDeclaredMethod("AnyPredicate", Predicate[].class);
        constructor.setAccessible(true);
        Predicate<Object> predicate = (Predicate<Object>) constructor.invoke(null, (Object) new Predicate[] { FalsePredicate.falsePredicate() });
        assertNotNull(predicate);
    }
}
