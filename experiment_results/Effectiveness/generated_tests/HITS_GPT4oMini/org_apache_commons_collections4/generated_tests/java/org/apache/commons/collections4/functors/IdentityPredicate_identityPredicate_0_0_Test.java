package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Predicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;

public class IdentityPredicate_identityPredicate_0_0_Test {

    @Test
    public void testIdentityPredicateWithNonNullObject() {
        String testString = "test";
        Predicate<String> predicate = IdentityPredicate.identityPredicate(testString);
        assertNotNull(predicate);
        // Test that the predicate returns true for the same object
        assertTrue(predicate.evaluate(testString));
        // Test that the predicate returns false for a different object
        assertFalse(predicate.evaluate("different"));
    }

    @Test
    public void testIdentityPredicateWithNullObject() {
        Predicate<Object> predicate = IdentityPredicate.identityPredicate(null);
        assertNotNull(predicate);
        assertSame(NullPredicate.INSTANCE, predicate);
    }
}
