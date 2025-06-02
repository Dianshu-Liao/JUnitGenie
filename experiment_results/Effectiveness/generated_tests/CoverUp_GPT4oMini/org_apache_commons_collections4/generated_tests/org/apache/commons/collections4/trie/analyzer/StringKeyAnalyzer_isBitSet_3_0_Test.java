package org.apache.commons.collections4.trie.analyzer;

import org.apache.commons.collections4.trie.analyzer.StringKeyAnalyzer;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.trie.KeyAnalyzer;

class StringKeyAnalyzer_isBitSet_3_0_Test {

    private final StringKeyAnalyzer analyzer = StringKeyAnalyzer.INSTANCE;

    @Test
    void testIsBitSet_NullKey() {
        assertFalse(analyzer.isBitSet(null, 0, 16));
    }

    @Test
    void testIsBitSet_BitIndexOutOfBounds() {
        assertFalse(analyzer.isBitSet("test", 32, 16));
    }

    @Test
    void testIsBitSet_BitNotSet() {
        // 't' is 01110100 in binary
        assertFalse(analyzer.isBitSet("test", 0, 16));
    }

    @Test
    void testIsBitSet_BitSet() {
        // 't' is 01110100 in binary
        assertTrue(analyzer.isBitSet("test", 1, 16));
    }

    @Test
    void testIsBitSet_CharAtIndex() {
        // 'A' is 01000001 in binary
        assertTrue(analyzer.isBitSet("A", 0, 16));
        // 'A' is 01000001 in binary
        assertFalse(analyzer.isBitSet("A", 1, 16));
    }

    @Test
    void testIsBitSet_EmptyString() {
        assertFalse(analyzer.isBitSet("", 0, 16));
    }

    @Test
    void testMaskMethod() throws Exception {
        Method maskMethod = StringKeyAnalyzer.class.getDeclaredMethod("mask", int.class);
        maskMethod.setAccessible(true);
        // Test the mask method for different bit values
        // MSB >>> 0
        assertEquals(0x8000, maskMethod.invoke(analyzer, 0));
        // MSB >>> 1
        assertEquals(0x4000, maskMethod.invoke(analyzer, 1));
        // MSB >>> 2
        assertEquals(0x2000, maskMethod.invoke(analyzer, 2));
        // MSB >>> 3
        assertEquals(0x1000, maskMethod.invoke(analyzer, 3));
    }
}
