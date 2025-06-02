package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash3_hash64_21_0_Test {

    @Test
    public void testHash64_EmptyArray() {
        byte[] input = new byte[0];
        // Expected value for an empty array
        long expected = MurmurHash3.NULL_HASHCODE;
        long actual = MurmurHash3.hash64(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_SingleByte() {
        byte[] input = new byte[] { 1 };
        // Example expected value
        long expected = 0x2c7c0b6b4f8c8a47L;
        long actual = MurmurHash3.hash64(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_TwoBytes() {
        byte[] input = new byte[] { 1, 2 };
        // Example expected value
        long expected = 0x2c7c0b6b4f8c8a47L;
        long actual = MurmurHash3.hash64(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_MultipleBytes() {
        byte[] input = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        // Example expected value
        long expected = 0x5a4c1f4a1c5bb5c2L;
        long actual = MurmurHash3.hash64(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_NonStandardLength() {
        byte[] input = new byte[] { 1, 2, 3, 4, 5 };
        // Example expected value
        long expected = 0x3b5b9c4b2c0e4b3eL;
        long actual = MurmurHash3.hash64(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_LargeArray() {
        // Array of 1000 bytes
        byte[] input = new byte[1000];
        for (int i = 0; i < input.length; i++) {
            input[i] = (byte) i;
        }
        // Example expected value
        long expected = 0x123456789abcdef0L;
        long actual = MurmurHash3.hash64(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64_SameInputDifferentOrder() {
        byte[] input1 = new byte[] { 1, 2, 3 };
        byte[] input2 = new byte[] { 3, 2, 1 };
        long hash1 = MurmurHash3.hash64(input1);
        long hash2 = MurmurHash3.hash64(input2);
        // The hashes should not be equal for different order inputs
        assertNotEquals(hash1, hash2);
    }

    @Test
    public void testHash64_NullInput() {
        byte[] input = null;
        Exception exception = assertThrows(NullPointerException.class, () -> {
            MurmurHash3.hash64(input);
        });
        String expectedMessage = "data is null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
