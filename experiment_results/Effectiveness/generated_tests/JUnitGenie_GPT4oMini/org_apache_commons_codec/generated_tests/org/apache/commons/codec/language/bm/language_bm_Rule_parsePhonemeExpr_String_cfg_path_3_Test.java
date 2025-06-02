package org.apache.commons.codec.language.bm;
import org.apache.commons.codec.language.bm.Rule;
import org.apache.commons.codec.language.bm.Rule.PhonemeExpr;
import org.apache.commons.codec.language.bm.Rule.Phoneme;
import org.apache.commons.codec.language.bm.Languages;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;

public class language_bm_Rule_parsePhonemeExpr_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testParsePhonemeExpr_withValidBracketedString() {
        String input = "(a|b|c)";
        try {
            Method method = Rule.class.getDeclaredMethod("parsePhonemeExpr", String.class);
            method.setAccessible(true);
            PhonemeExpr result = (PhonemeExpr) method.invoke(null, input);
            assertNotNull(result);
            // You can also add more assertions based on the expected structure of the result, if detailed knowledge is available
        } catch (Exception e) {
            fail("Expected method invocation to succeed, but it threw an exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testParsePhonemeExpr_withInvalidBracketedString() {
        String input = "(a|b|c";
        try {
            Method method = Rule.class.getDeclaredMethod("parsePhonemeExpr", String.class);
            method.setAccessible(true);
            method.invoke(null, input);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected IllegalArgumentException but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testParsePhonemeExpr_withStringThatDoesntStartWithBracket() {
        String input = "a";
        try {
            Method method = Rule.class.getDeclaredMethod("parsePhonemeExpr", String.class);
            method.setAccessible(true);
            PhonemeExpr result = (PhonemeExpr) method.invoke(null, input);
            assertNotNull(result);
            // Additional assertions can be made here
        } catch (Exception e) {
            fail("Expected method invocation to succeed, but it threw an exception: " + e.getMessage());
        }
    }

}