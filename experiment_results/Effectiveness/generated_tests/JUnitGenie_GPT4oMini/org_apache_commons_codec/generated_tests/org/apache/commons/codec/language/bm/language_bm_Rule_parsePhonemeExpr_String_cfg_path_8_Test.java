package org.apache.commons.codec.language.bm;
import org.apache.commons.codec.language.bm.Rule;
import org.apache.commons.codec.language.bm.Rule.PhonemeExpr;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_bm_Rule_parsePhonemeExpr_String_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testParsePhonemeExprThrowsExceptionWhenStartsWithBracketAndDoesNotEndWithBracket() {
        String input = "(phoneme"; // Input that starts with '(' but does not end with ')'
        
        try {
            // Accessing the private static method using reflection
            java.lang.reflect.Method method = Rule.class.getDeclaredMethod("parsePhonemeExpr", String.class);
            method.setAccessible(true);
            method.invoke(null, input); // Invoking the method with the test input
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Phoneme starts with '(' so must end with ')'", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

}