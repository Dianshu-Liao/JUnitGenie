package org.apache.commons.collections4.trie.analyzer;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.trie.KeyAnalyzer;

public class StringKeyAnalyzer_isBitSet_3_0_Test {

    private final StringKeyAnalyzer analyzer = StringKeyAnalyzer.INSTANCE;

    @Test
    public void testIsBitSet_NullKey() {
        assertFalse(analyzer.isBitSet(null, 0, 16), "Expected false for null key");
    }

    @Test
    public void testIsBitSet_BitIndexOutOfBounds() {
        assertFalse(analyzer.isBitSet("test", 16, 16), "Expected false for bit index out of bounds");
    }

    @Test
    public void testIsBitSet_ValidBitSet() {
        assertTrue(analyzer.isBitSet("test", 0, 16), "Expected true for 't' (ASCII 116) at bit index 0");
        assertTrue(analyzer.isBitSet("test", 1, 16), "Expected true for 't' (ASCII 116) at bit index 1");
        assertFalse(analyzer.isBitSet("test", 5, 16), "Expected false for 'test' at bit index 5");
    }

    @Test
    public void testIsBitSet_ValidBitSetWithDifferentCharacters() {
        assertTrue(analyzer.isBitSet("A", 0, 16), "Expected true for 'A' (ASCII 65) at bit index 0");
        assertFalse(analyzer.isBitSet("A", 1, 16), "Expected false for 'A' (ASCII 65) at bit index 1");
        assertTrue(analyzer.isBitSet("B", 1, 16), "Expected true for 'B' (ASCII 66) at bit index 1");
    }

    @Test
    public void testIsBitSet_EmptyString() {
        assertFalse(analyzer.isBitSet("", 0, 16), "Expected false for empty string");
    }

    @Test
    public void testIsBitSet_SingleCharacterString() {
        assertTrue(analyzer.isBitSet("A", 0, 16), "Expected true for 'A' (ASCII 65) at bit index 0");
        assertFalse(analyzer.isBitSet("A", 7, 16), "Expected false for 'A' (ASCII 65) at bit index 7");
    }

    @Test
    public void testIsBitSet_MultipleCharacters() {
        assertTrue(analyzer.isBitSet("abc", 0, 24), "Expected true for 'a' (ASCII 97) at bit index 0");
        assertTrue(analyzer.isBitSet("abc", 8, 24), "Expected true for 'b' (ASCII 98) at bit index 8");
        assertTrue(analyzer.isBitSet("abc", 16, 24), "Expected true for 'c' (ASCII 99) at bit index 16");
        assertFalse(analyzer.isBitSet("abc", 20, 24), "Expected false for 'abc' at bit index 20");
    }
}
