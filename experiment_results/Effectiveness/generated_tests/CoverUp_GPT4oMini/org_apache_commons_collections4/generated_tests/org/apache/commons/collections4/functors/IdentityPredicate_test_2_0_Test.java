package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.functors.IdentityPredicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

class IdentityPredicate_test_2_0_Test {

    private IdentityPredicate<Object> identityPredicate;

    private Object testObject;

    @BeforeEach
    void setUp() {
        testObject = new Object();
        identityPredicate = new IdentityPredicate<>(testObject);
    }

    @Test
    void testEqualObjects() {
        // Test with the same object
        assertTrue(identityPredicate.test(testObject));
    }

    @Test
    void testDifferentObjects() {
        // Test with a different object
        Object differentObject = new Object();
        assertFalse(identityPredicate.test(differentObject));
    }

    @Test
    void testNullObject() {
        // Test with null when iValue is not null
        assertFalse(identityPredicate.test(null));
    }

    @Test
    void testNullValue() {
        // Create IdentityPredicate with null value
        IdentityPredicate<Object> nullPredicate = new IdentityPredicate<>(null);
        // Test with null
        assertTrue(nullPredicate.test(null));
        // Test with a non-null object
        Object nonNullObject = new Object();
        assertFalse(nullPredicate.test(nonNullObject));
    }
}
