package org.apache.commons.codec.language.bm;
import org.apache.commons.codec.language.bm.Rule;
import org.apache.commons.codec.language.bm.Rule.Phoneme;
import org.apache.commons.codec.language.bm.Rule.PhonemeExpr;
import org.apache.commons.codec.language.bm.Rule.PhonemeList;
import org.apache.commons.codec.language.bm.Languages;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class language_bm_Rule_parsePhonemeExpr_String_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testParsePhonemeExpr_withValidBracketedInput() {
        String input = "(a|b|c)";
        try {
            Method method = Rule.class.getDeclaredMethod("parsePhonemeExpr", String.class);
            method.setAccessible(true);
            PhonemeExpr result = (PhonemeExpr) method.invoke(null, input);
            assertNotNull(result);
            assertTrue(result instanceof PhonemeList);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testParsePhonemeExpr_withInvalidBracketedInput() {
        String input = "(a|b|c";
        try {
            Method method = Rule.class.getDeclaredMethod("parsePhonemeExpr", String.class);
            method.setAccessible(true);
            method.invoke(null, input);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testParsePhonemeExpr_withEmptyBracketedInput() {
        String input = "(()|)";
        try {
            Method method = Rule.class.getDeclaredMethod("parsePhonemeExpr", String.class);
            method.setAccessible(true);
            PhonemeExpr result = (PhonemeExpr) method.invoke(null, input);
            assertNotNull(result);
            assertTrue(result instanceof PhonemeList);
            PhonemeList phonemeList = (PhonemeList) result;
            assertEquals(1, phonemeList.size()); // Expecting one empty phoneme
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}