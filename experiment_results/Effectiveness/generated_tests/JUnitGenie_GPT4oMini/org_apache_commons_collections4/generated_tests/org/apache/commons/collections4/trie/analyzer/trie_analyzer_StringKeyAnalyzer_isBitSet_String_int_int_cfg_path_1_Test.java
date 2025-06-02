package org.apache.commons.collections4.trie.analyzer;
import org.apache.commons.collections4.trie.analyzer.StringKeyAnalyzer;
import org.junit.Test;
import static org.junit.Assert.*;

public class trie_analyzer_StringKeyAnalyzer_isBitSet_String_int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsBitSet_whenKeyIsNull() {
        StringKeyAnalyzer analyzer = new StringKeyAnalyzer();
        boolean result = analyzer.isBitSet(null, 0, 16);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsBitSet_whenBitIndexIsOutOfBounds() {
        StringKeyAnalyzer analyzer = new StringKeyAnalyzer();
        boolean result = analyzer.isBitSet("testKey", 16, 16);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsBitSet_whenBitIsNotSet() {
        StringKeyAnalyzer analyzer = new StringKeyAnalyzer();
        // Choose a value for bitIndex that does not correspond to a set bit in 'key'
        boolean result = analyzer.isBitSet("testKey", 0, 16);
        assertFalse(result); // Assuming the first bit is not set
    }

    @Test(timeout = 4000)
    public void testIsBitSet_whenBitIsSet() {
        StringKeyAnalyzer analyzer = new StringKeyAnalyzer();
        // Choose a value for bitIndex that corresponds to a set bit in 'key'
        boolean result = analyzer.isBitSet("testKey", 1, 16); 
        assertTrue(result); // Assuming the first bit is set
    }

    @Test(timeout = 4000)
    public void testIsBitSet_withSpecificBitIndex() {
        StringKeyAnalyzer analyzer = new StringKeyAnalyzer();
        // Testing with isBitSet where the bitIndex is 15
        // Assuming the character at index 0 is such that '32768 >> 15' would not overlap
        boolean result = analyzer.isBitSet("testKey", 15, 16);
        assertFalse(result); // Modify content as per specific test case details
    }

    // Additional tests can be added depending on the understanding of the 'mask' method's specifics.

}