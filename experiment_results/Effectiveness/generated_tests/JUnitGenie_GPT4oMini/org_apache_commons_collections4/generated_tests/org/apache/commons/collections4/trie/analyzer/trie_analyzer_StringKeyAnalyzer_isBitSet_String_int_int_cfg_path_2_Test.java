package org.apache.commons.collections4.trie.analyzer;
import org.apache.commons.collections4.trie.analyzer.StringKeyAnalyzer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class trie_analyzer_StringKeyAnalyzer_isBitSet_String_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsBitSetWithNullKey() {
        StringKeyAnalyzer analyzer = new StringKeyAnalyzer();
        boolean result = analyzer.isBitSet(null, 0, 16);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsBitSetWithBitIndexGreaterThanLength() {
        StringKeyAnalyzer analyzer = new StringKeyAnalyzer();
        boolean result = analyzer.isBitSet("test", 20, 16);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsBitSetWithValidParameters() {
        StringKeyAnalyzer analyzer = new StringKeyAnalyzer();
        int lengthInBits = 16;
        int bitIndex = 8; // Example value that is within bounds
        String key = "    "; // Makes sure charAt will pick a space character

        // The expected behavior of mask(int) with the specific bit value
        // Let's assume that mask(0) returns a value that when AND-ed with key.charAt(0) generates 0.
        boolean result = analyzer.isBitSet(key, bitIndex, lengthInBits);
        assertFalse(result); // Expecting false since space character (0) & mask(0) should be 0
    }

}