package org.apache.commons.collections4.functors;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

public class IdentityPredicate_test_2_0_Test {

    @Test
    public void testEqualityWithSameObject() {
        Object obj = new Object();
        IdentityPredicate<Object> predicate = new IdentityPredicate<>(obj);
        assertTrue(predicate.test(obj), "Predicate should return true for the same object");
    }

    @Test
    public void testInequalityWithDifferentObject() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        IdentityPredicate<Object> predicate = new IdentityPredicate<>(obj1);
        assertFalse(predicate.test(obj2), "Predicate should return false for a different object");
    }

    @Test
    public void testEqualityWithNull() {
        Object obj = null;
        IdentityPredicate<Object> predicate = new IdentityPredicate<>(obj);
        assertTrue(predicate.test(null), "Predicate should return true for null when initialized with null");
    }

    @Test
    public void testInequalityWithNull() {
        Object obj = new Object();
        IdentityPredicate<Object> predicate = new IdentityPredicate<>(obj);
        assertFalse(predicate.test(null), "Predicate should return false for null when initialized with a non-null object");
    }

    @Test
    public void testSameReferenceEquality() {
        String str = "test";
        IdentityPredicate<String> predicate = new IdentityPredicate<>(str);
        assertTrue(predicate.test(str), "Predicate should return true for the same reference of string");
    }

    @Test
    public void testDifferentReferencesEquality() {
        String str1 = new String("test");
        String str2 = new String("test");
        IdentityPredicate<String> predicate = new IdentityPredicate<>(str1);
        assertFalse(predicate.test(str2), "Predicate should return false for different references of the same string content");
    }
}
