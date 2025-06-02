package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.IdentityPredicate;
import org.apache.commons.collections4.functors.NullPredicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;

class IdentityPredicate_identityPredicate_0_0_Test {

    @Test
    void testIdentityPredicateWithNonNullObject() {
        String testValue = "test";
        Predicate<String> predicate = IdentityPredicate.identityPredicate(testValue);
        assertNotNull(predicate);
        assertTrue(predicate.evaluate(testValue));
        assertFalse(predicate.evaluate("other"));
    }

    @Test
    void testIdentityPredicateWithNullObject() {
        Predicate<Object> predicate = IdentityPredicate.identityPredicate(null);
        assertNotNull(predicate);
        assertSame(predicate, NullPredicate.nullPredicate());
    }

    @Test
    void testIdentityPredicateWithDifferentTypes() {
        Integer testValue = 42;
        Predicate<Integer> predicate = IdentityPredicate.identityPredicate(testValue);
        assertNotNull(predicate);
        assertTrue(predicate.evaluate(testValue));
        assertFalse(predicate.evaluate(100));
    }

    @Test
    void testIdentityPredicateWithSameObjectReference() {
        Object testValue = new Object();
        Predicate<Object> predicate = IdentityPredicate.identityPredicate(testValue);
        assertNotNull(predicate);
        assertTrue(predicate.evaluate(testValue));
        assertFalse(predicate.evaluate(new Object()));
    }
}
