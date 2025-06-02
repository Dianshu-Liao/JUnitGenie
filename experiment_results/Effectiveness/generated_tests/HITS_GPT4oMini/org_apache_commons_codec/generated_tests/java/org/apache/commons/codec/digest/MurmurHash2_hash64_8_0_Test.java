package org.apache.commons.codec.digest;

import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash2_hash64_8_0_Test {

    @Test
    public void testHash64_NullInput() {
        // This is an example; the actual expected value should be calculated based on the implementation.
        long expected = 0xc6a4a7935bd1e995L;
        long result = MurmurHash2.hash64(null);
        assertEquals(expected, result);
    }

    @Test
    public void testHash64_EmptyString() {
        // Example expected value for empty string
        long expected = 0xc6a4a7935bd1e995L;
        long result = MurmurHash2.hash64("");
        assertEquals(expected, result);
    }

    @Test
    public void testHash64_SingleCharacter() {
        // Example expected value for single character
        long expected = 0x5bd1e995;
        long result = MurmurHash2.hash64("a");
        assertEquals(expected, result);
    }

    @Test
    public void testHash64_MultipleCharacters() {
        // Example expected value for multiple characters
        long expected = 0x5bd1e995;
        long result = MurmurHash2.hash64("hello");
        assertEquals(expected, result);
    }

    @Test
    public void testHash64_SpecialCharacters() {
        // Example expected value for special characters
        long expected = 0x5bd1e995;
        long result = MurmurHash2.hash64("!@#$%^&*()");
        assertEquals(expected, result);
    }
}
