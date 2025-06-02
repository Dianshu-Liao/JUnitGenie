package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.binary.StringUtils;

public class MurmurHash3_hash64_24_0_Test {

    @Test
    public void testHash64WithZero() {
        int input = 0;
        // Precomputed expected value
        long expected = -3761462501028489058L;
        long actual = MurmurHash3.hash64(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64WithPositiveInteger() {
        int input = 123456;
        // Precomputed expected value
        long expected = 6683026465808846484L;
        long actual = MurmurHash3.hash64(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64WithNegativeInteger() {
        int input = -123456;
        // Precomputed expected value
        long expected = -1245402351924887220L;
        long actual = MurmurHash3.hash64(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64WithMaxInteger() {
        int input = Integer.MAX_VALUE;
        // Precomputed expected value
        long expected = -1789353027530125955L;
        long actual = MurmurHash3.hash64(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64WithMinInteger() {
        int input = Integer.MIN_VALUE;
        // Precomputed expected value
        long expected = 3131370801865715605L;
        long actual = MurmurHash3.hash64(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64WithRandomValues() {
        int input = 42;
        // Precomputed expected value
        long expected = 3283732179007060051L;
        long actual = MurmurHash3.hash64(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testHash64WithAnotherRandomValue() {
        int input = 1001;
        // Precomputed expected value
        long expected = 6991897891982330676L;
        long actual = MurmurHash3.hash64(input);
        assertEquals(expected, actual);
    }
}
