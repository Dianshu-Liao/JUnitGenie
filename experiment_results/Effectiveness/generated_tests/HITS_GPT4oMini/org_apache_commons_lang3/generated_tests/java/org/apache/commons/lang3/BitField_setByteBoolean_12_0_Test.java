package org.apache.commons.lang3;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class BitField_setByteBoolean_12_0_Test {

    private BitField bitField;

    @BeforeEach
    public void setUp() {
        // Initialize BitField with a sample mask, e.g., 0b00000001 (1)
        bitField = new BitField(0b00000001);
    }

    @Test
    public void testSetByteBoolean_WhenFlagIsTrue_ShouldSetByte() {
        // Initial holder value
        byte holder = 0b00000000;
        // Expected value after setting the bit
        byte expected = 0b00000001;
        byte result = bitField.setByteBoolean(holder, true);
        assertEquals(expected, result, "The byte should be set when flag is true.");
    }

    @Test
    public void testSetByteBoolean_WhenFlagIsFalse_ShouldClearByte() {
        // Initial holder value with the bit set
        byte holder = 0b00000001;
        // Expected value after clearing the bit
        byte expected = 0b00000000;
        byte result = bitField.setByteBoolean(holder, false);
        assertEquals(expected, result, "The byte should be cleared when flag is false.");
    }

    @Test
    public void testSetByteBoolean_WhenHolderIsNegativeAndFlagIsTrue_ShouldSetByte() {
        // Initial holder value (negative)
        byte holder = (byte) 0b11111110;
        // Expected value after setting the bit
        byte expected = (byte) 0b11111111;
        byte result = bitField.setByteBoolean(holder, true);
        assertEquals(expected, result, "The byte should be set correctly when holder is negative and flag is true.");
    }

    @Test
    public void testSetByteBoolean_WhenHolderIsNegativeAndFlagIsFalse_ShouldClearByte() {
        // Initial holder value (negative)
        byte holder = (byte) 0b11111111;
        // Expected value after clearing the bit
        byte expected = (byte) 0b11111110;
        byte result = bitField.setByteBoolean(holder, false);
        assertEquals(expected, result, "The byte should be cleared correctly when holder is negative and flag is false.");
    }

    @Test
    public void testSetByteBoolean_WhenHolderIsZeroAndFlagIsTrue_ShouldSetByte() {
        // Initial holder value
        byte holder = 0b00000000;
        // Expected value after setting the bit
        byte expected = 0b00000001;
        byte result = bitField.setByteBoolean(holder, true);
        assertEquals(expected, result, "The byte should be set from zero when flag is true.");
    }

    @Test
    public void testSetByteBoolean_WhenHolderIsZeroAndFlagIsFalse_ShouldRemainZero() {
        // Initial holder value
        byte holder = 0b00000000;
        // Expected value should remain the same
        byte expected = 0b00000000;
        byte result = bitField.setByteBoolean(holder, false);
        assertEquals(expected, result, "The byte should remain zero when flag is false.");
    }
}
