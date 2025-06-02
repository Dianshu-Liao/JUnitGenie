package org.apache.commons.codec.language.bm;
import org.apache.commons.codec.language.bm.Rule;
import org.apache.commons.codec.language.bm.Rule.PhonemeExpr;
import org.apache.commons.codec.language.bm.Rule.PhonemeList;
import org.apache.commons.codec.language.bm.Rule.Phoneme;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class language_bm_Rule_parsePhonemeExpr_String_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testParsePhonemeExprWithValidInput() {
        String input = "(part1|part2|)";
        try {
            Method method = Rule.class.getDeclaredMethod("parsePhonemeExpr", String.class);
            method.setAccessible(true);
            PhonemeExpr result = (PhonemeExpr) method.invoke(null, input);
            assertNotNull(result);
            assertTrue(result instanceof PhonemeList);
            PhonemeList phonemeList = (PhonemeList) result;
            List<Phoneme> phonemes = phonemeList.getPhonemes(); // Assuming getPhonemes() method exists
            assertEquals(3, phonemes.size()); // Expecting 3 phonemes
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testParsePhonemeExprWithInvalidInput() {
        String input = "(part1|part2"; // Missing closing bracket
        try {
            Method method = Rule.class.getDeclaredMethod("parsePhonemeExpr", String.class);
            method.setAccessible(true);
            method.invoke(null, input);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Phoneme starts with '(' so must end with ')'", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getMessage());
        }
    }

}