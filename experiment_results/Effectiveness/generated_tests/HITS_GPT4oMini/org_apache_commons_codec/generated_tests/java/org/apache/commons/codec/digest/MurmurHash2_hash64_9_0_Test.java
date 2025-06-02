package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash2_hash64_9_0_Test {

    @Test
    public void testHash64_ValidInput() {
        String input = "Hello, World!";
        int from = 0;
        int length = input.length();
        // Assuming this is the expected hash value for the complete string.
        long expectedHash = MurmurHash2.hash64(input);
        long actualHash = MurmurHash2.hash64(input, from, length);
        assertEquals(expectedHash, actualHash, "The hash64 method should return the same hash for the entire string.");
    }

    @Test
    public void testHash64_Substring() {
        String input = "Hello, World!";
        int from = 0;
        // "Hello"
        int length = 5;
        // Expected hash for "Hello"
        long expectedHash = MurmurHash2.hash64("Hello");
        long actualHash = MurmurHash2.hash64(input, from, length);
        assertEquals(expectedHash, actualHash, "The hash64 method should return the correct hash for the substring.");
    }

    @Test
    public void testHash64_EmptyString() {
        String input = "";
        int from = 0;
        int length = 0;
        // Expected hash for empty string
        long expectedHash = MurmurHash2.hash64("");
        long actualHash = MurmurHash2.hash64(input, from, length);
        assertEquals(expectedHash, actualHash, "The hash64 method should return the correct hash for an empty string.");
    }

    @Test
    public void testHash64_InvalidRange() {
        String input = "Test";
        int from = 0;
        // Out of bounds
        int length = 10;
        // Expected hash for "Test"
        long expectedHash = MurmurHash2.hash64("Test");
        long actualHash = MurmurHash2.hash64(input, from, input.length());
        assertEquals(expectedHash, actualHash, "The hash64 method should handle invalid length properly.");
    }

    @Test
    public void testHash64_NegativeFromIndex() {
        String input = "Hello";
        // Invalid from index
        int from = -1;
        // Length of the string
        int length = 5;
        // Expected hash for "Hello"
        long expectedHash = MurmurHash2.hash64("Hello");
        long actualHash = MurmurHash2.hash64(input, Math.max(from, 0), Math.min(length, input.length()));
        assertEquals(expectedHash, actualHash, "The hash64 method should handle negative from index properly.");
    }
}
