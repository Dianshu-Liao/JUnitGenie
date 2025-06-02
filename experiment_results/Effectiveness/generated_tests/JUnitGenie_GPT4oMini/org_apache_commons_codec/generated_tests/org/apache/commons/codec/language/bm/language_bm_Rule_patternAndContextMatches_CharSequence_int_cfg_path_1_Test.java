package org.apache.commons.codec.language.bm;
import org.apache.commons.codec.language.bm.Rule;
import org.junit.Test;

public class language_bm_Rule_patternAndContextMatches_CharSequence_int_cfg_path_1_Test {

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPatternAndContextMatches_NegativeIndex() {
        Rule rule = new Rule("pattern", "leftContext", "rightContext", null);
        CharSequence input = "testInput";
        int negativeIndex = -1;

        // This should throw an IndexOutOfBoundsException
        rule.patternAndContextMatches(input, negativeIndex);
    }

}