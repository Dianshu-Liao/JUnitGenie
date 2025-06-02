package org.apache.commons.collections4.functors;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

public final class IdentityPredicate_test_2_0_Test {

    private IdentityPredicate<Object> identityPredicate;

    private Object testObject;

    @BeforeEach
    public void setUp() {
        testObject = new Object();
        identityPredicate = new IdentityPredicate<>(testObject);
    }

    @Test
    public void testSameObject() {
        // Test with the same object
        assertTrue(identityPredicate.test(testObject), "Expected true for the same object reference.");
    }

    @Test
    public void testDifferentObject() {
        // Test with a different object
        Object differentObject = new Object();
        assertFalse(identityPredicate.test(differentObject), "Expected false for different object references.");
    }

    @Test
    public void testNullObject() {
        // Test with null
        assertFalse(identityPredicate.test(null), "Expected false when testing against null.");
    }

    @Test
    public void testIdentityWithNullValue() {
        // Test when iValue is null
        IdentityPredicate<Object> nullPredicate = new IdentityPredicate<>(null);
        assertFalse(nullPredicate.test(new Object()), "Expected false for non-null object when iValue is null.");
        assertTrue(nullPredicate.test(null), "Expected true when both iValue and tested object are null.");
    }
}
