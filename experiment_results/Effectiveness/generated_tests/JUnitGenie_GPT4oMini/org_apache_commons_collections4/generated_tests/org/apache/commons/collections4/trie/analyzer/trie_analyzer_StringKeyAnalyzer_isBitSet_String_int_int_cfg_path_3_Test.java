package org.apache.commons.collections4.trie.analyzer;
import org.apache.commons.collections4.trie.analyzer.StringKeyAnalyzer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class trie_analyzer_StringKeyAnalyzer_isBitSet_String_int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsBitSet_KeyIsNull() {
        StringKeyAnalyzer analyzer = new StringKeyAnalyzer();
        boolean result = analyzer.isBitSet(null, 0, 10);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsBitSet_BitIndexGreaterThanLength() {
        StringKeyAnalyzer analyzer = new StringKeyAnalyzer();
        boolean result = analyzer.isBitSet("test", 10, 5);
        assertFalse(result);
    }

}