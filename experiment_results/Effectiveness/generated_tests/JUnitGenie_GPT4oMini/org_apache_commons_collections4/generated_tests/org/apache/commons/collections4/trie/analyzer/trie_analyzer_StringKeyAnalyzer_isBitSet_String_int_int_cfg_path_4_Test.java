package org.apache.commons.collections4.trie.analyzer;
import org.apache.commons.collections4.trie.analyzer.StringKeyAnalyzer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class trie_analyzer_StringKeyAnalyzer_isBitSet_String_int_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testIsBitSet_KeyIsNull() {
        StringKeyAnalyzer analyzer = new StringKeyAnalyzer();
        String key = null;
        int bitIndex = 1;
        int lengthInBits = 10;

        try {
            boolean result = analyzer.isBitSet(key, bitIndex, lengthInBits);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}