package org.apache.commons.lang3;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class BitField_setByteBoolean_12_0_Test {

    private class BitField {

        private final int mask;

        public BitField(final int mask) {
            this.mask = mask;
        }

        public byte setByte(final byte holder) {
            // Example implementation for setting a bit
            return (byte) (holder | mask);
        }

        public byte clearByte(final byte holder) {
            // Example implementation for clearing a bit
            return (byte) (holder & ~mask);
        }

        public byte setByteBoolean(final byte holder, final boolean flag) {
            return flag ? setByte(holder) : clearByte(holder);
        }
    }

    @Test
    public void testSetByteBoolean() {
        // Example mask to manipulate the second least significant bit
        BitField bitField = new BitField(0b00000010);
        // Test when flag is true
        // Initial byte with no bits set
        byte holderTrue = 0b00000000;
        // Set bit
        boolean flagTrue = true;
        byte resultTrue = bitField.setByteBoolean(holderTrue, flagTrue);
        // Expect the second least significant bit to be set
        assertEquals(0b00000010, resultTrue);
        // Test when flag is false
        // Initial byte with the second least significant bit set
        byte holderFalse = 0b00000010;
        // Clear bit
        boolean flagFalse = false;
        byte resultFalse = bitField.setByteBoolean(holderFalse, flagFalse);
        // Expect all bits to be cleared
        assertEquals(0b00000000, resultFalse);
    }
}
