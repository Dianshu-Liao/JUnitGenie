package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash3_hash64_25_0_Test {

    @Test
    public void testHash64_NegativeValue() {
        long input = -1L;
        // Replace with the actual expected value
        long expected = -3532033222105563584L;
        long result = MurmurHash3.hash64(input);
        assertEquals(expected, result);
    }

    @Test
    public void testHash64_ZeroValue() {
        long input = 0L;
        // Replace with the actual expected value
        long expected = -4688810639253650230L;
        long result = MurmurHash3.hash64(input);
        assertEquals(expected, result);
    }

    @Test
    public void testHash64_PositiveValue() {
        long input = 123456789L;
        // Replace with the actual expected value
        long expected = 2445383085716350457L;
        long result = MurmurHash3.hash64(input);
        assertEquals(expected, result);
    }

    @Test
    public void testHash64_LargeValue() {
        long input = Long.MAX_VALUE;
        // Replace with the actual expected value
        long expected = 1587215603314226326L;
        long result = MurmurHash3.hash64(input);
        assertEquals(expected, result);
    }

    @Test
    public void testHash64_SmallValue() {
        long input = Long.MIN_VALUE;
        // Replace with the actual expected value
        long expected = 1035043774739931970L;
        long result = MurmurHash3.hash64(input);
        assertEquals(expected, result);
    }
}
