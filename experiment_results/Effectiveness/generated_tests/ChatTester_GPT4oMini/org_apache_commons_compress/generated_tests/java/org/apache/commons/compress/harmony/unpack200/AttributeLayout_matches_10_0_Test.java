package org.apache.commons.compress.harmony.unpack200;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.apache.commons.lang3.StringUtils;

public class AttributeLayout_matches_10_0_Test {

    private AttributeLayout attributeLayout;

    @BeforeEach
    public void setUp() throws Exception {
        // Initialize the AttributeLayout with a sample mask value
        attributeLayout = new AttributeLayout("Test", AttributeLayout.CONTEXT_CLASS, "layout", 0);
        // Using reflection to set the private mask field
        java.lang.reflect.Field maskField = AttributeLayout.class.getDeclaredField("mask");
        maskField.setAccessible(true);
        // Example mask value for testing
        maskField.setLong(attributeLayout, 0b1010);
    }

    @Test
    public void testMatchesWithMatchingValue() {
        long value = 0b1010;
        assertTrue(attributeLayout.matches(value), "Expected matches to return true for matching value");
    }

    @Test
    public void testMatchesWithNonMatchingValue() {
        long value = 0b0001;
        assertFalse(attributeLayout.matches(value), "Expected matches to return false for non-matching value");
    }

    @Test
    public void testMatchesWithZeroValue() {
        long value = 0b0000;
        assertFalse(attributeLayout.matches(value), "Expected matches to return false for zero value");
    }

    @Test
    public void testMatchesWithAllBitsSet() {
        long value = 0b1111;
        assertTrue(attributeLayout.matches(value), "Expected matches to return true for all bits set");
    }

    @Test
    public void testMatchesWithPartialMatch() {
        // Only one bit matches
        long value = 0b1000;
        assertTrue(attributeLayout.matches(value), "Expected matches to return true for partial match");
    }

    @Test
    public void testMatchesWithDifferentMask() throws Exception {
        // Change the mask to a different value
        java.lang.reflect.Field maskField = AttributeLayout.class.getDeclaredField("mask");
        maskField.setAccessible(true);
        // New mask value
        maskField.setLong(attributeLayout, 0b0011);
        // This should match with the new mask
        long value = 0b0010;
        assertTrue(attributeLayout.matches(value), "Expected matches to return true for value matching new mask");
    }

    @Test
    public void testMatchesWithNoBitsSet() {
        // No bits set
        long value = 0b0000;
        assertFalse(attributeLayout.matches(value), "Expected matches to return false for no bits set");
    }
}
