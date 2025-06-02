package org.apache.commons.collections4.trie.analyzer;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class StringKeyAnalyzer_isBitSet_3_0_Test {

    private final StringKeyAnalyzer analyzer = StringKeyAnalyzer.INSTANCE;

    @Test
    void testIsBitSet_NullKey() {
        assertFalse(analyzer.isBitSet(null, 0, 16));
    }

    @Test
    void testIsBitSet_BitIndexOutOfBounds() {
        // bitIndex exceeds lengthInBits
        assertFalse(analyzer.isBitSet("test", 32, 16));
    }

    @Test
    void testIsBitSet_ValidBitSet() {
        // Binary: 01000001 01000010
        String key = "AB";
        // Check bit 0 of 'A' (1st char)
        assertTrue(analyzer.isBitSet(key, 0, 16));
        // Check bit 1 of 'A' (1st char)
        assertTrue(analyzer.isBitSet(key, 1, 16));
        // Check bit 7 of 'A' (1st char)
        assertFalse(analyzer.isBitSet(key, 7, 16));
        // Check bit 0 of 'B' (2nd char)
        assertTrue(analyzer.isBitSet(key, 8, 16));
        // Check bit 1 of 'B' (2nd char)
        assertFalse(analyzer.isBitSet(key, 9, 16));
    }

    @Test
    void testIsBitSet_ValidBitSetWithDifferentLength() {
        // Binary: 01000011
        String key = "C";
        // Check bit 0 of 'C'
        assertTrue(analyzer.isBitSet(key, 0, 8));
        // Check bit 1 of 'C'
        assertFalse(analyzer.isBitSet(key, 1, 8));
        // Check bit 6 of 'C'
        assertTrue(analyzer.isBitSet(key, 6, 8));
        // Check bit 7 of 'C'
        assertFalse(analyzer.isBitSet(key, 7, 8));
    }

    @Test
    void testIsBitSet_ZeroLength() {
        // lengthInBits is 0
        assertFalse(analyzer.isBitSet("test", 0, 0));
    }

    @Test
    void testIsBitSet_NegativeBitIndex() {
        // Negative bitIndex
        assertFalse(analyzer.isBitSet("test", -1, 16));
    }

    @Test
    void testIsBitSet_ValidBitSetWithSpecialCharacters() {
        // Binary: 00100001
        String key = "!";
        // Check bit 0 of '!'
        assertTrue(analyzer.isBitSet(key, 0, 8));
        // Check bit 1 of '!'
        assertFalse(analyzer.isBitSet(key, 1, 8));
        // Check bit 6 of '!'
        assertFalse(analyzer.isBitSet(key, 6, 8));
        // Check bit 7 of '!'
        assertFalse(analyzer.isBitSet(key, 7, 8));
    }
}
