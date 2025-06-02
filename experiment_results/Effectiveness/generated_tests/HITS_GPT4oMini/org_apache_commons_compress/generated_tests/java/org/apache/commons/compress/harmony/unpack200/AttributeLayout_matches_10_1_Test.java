package org.apache.commons.compress.harmony.unpack200;

import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.apache.commons.lang3.StringUtils;

public class AttributeLayout_matches_10_1_Test {

    private AttributeLayout attributeLayout;

    @BeforeEach
    public void setUp() throws Pack200Exception {
        attributeLayout = new AttributeLayout("TestAttribute", AttributeLayout.CONTEXT_CLASS, "layout", 0, true);
        setMaskForTesting(attributeLayout, 0b00000010);
    }

    private void setMaskForTesting(AttributeLayout attributeLayout, long mask) {
        // Using reflection to set the private mask field for testing
        try {
            java.lang.reflect.Field field = AttributeLayout.class.getDeclaredField("mask");
            field.setAccessible(true);
            field.setLong(attributeLayout, mask);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set mask for testing", e);
        }
    }

    @Test
    public void testMatches_WhenValueMatchesMask_ShouldReturnTrue() {
        long value = 0b00000010;
        assertTrue(attributeLayout.matches(value), "Expected matches to return true when value matches mask.");
    }

    @Test
    public void testMatches_WhenValueDoesNotMatchMask_ShouldReturnFalse() {
        long value = 0b00000001;
        assertFalse(attributeLayout.matches(value), "Expected matches to return false when value does not match mask.");
    }

    @Test
    public void testMatches_WhenValueIsZero_ShouldReturnFalse() {
        long value = 0b00000000;
        assertFalse(attributeLayout.matches(value), "Expected matches to return false when value is zero.");
    }

    @Test
    public void testMatches_WhenValueIsNegative_ShouldReturnCorrectResult() {
        long value = -0b00000010;
        assertFalse(attributeLayout.matches(value), "Expected matches to return false for negative values not matching the mask.");
    }

    @Test
    public void testMatches_WhenValueIsGreaterThanMask_ShouldReturnTrue() {
        long value = 0b00000110;
        assertTrue(attributeLayout.matches(value), "Expected matches to return true when value is greater than mask and includes it.");
    }

    @Test
    public void testMatches_WhenMaskIsZero_ShouldReturnFalseForNonZeroValue() throws Pack200Exception {
        attributeLayout = new AttributeLayout("TestAttribute", AttributeLayout.CONTEXT_CLASS, "layout", 0, true);
        setMaskForTesting(attributeLayout, 0b00000000);
        long value = 0b00000001;
        assertFalse(attributeLayout.matches(value), "Expected matches to return false when mask is zero and value is non-zero.");
    }
}
