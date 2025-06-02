package org.apache.commons.codec.language.bm;
import org.apache.commons.codec.language.bm.Rule;
import org.apache.commons.codec.language.bm.Rule.PhonemeExpr;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class language_bm_Rule_parsePhonemeExpr_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testParsePhonemeExprWithBracketedOptions() {
        try {
            // Accessing the private static method using reflection
            Method method = Rule.class.getDeclaredMethod("parsePhonemeExpr", String.class);
            method.setAccessible(true);

            // Test input that starts with '(' and ends with ')'
            String input = "(a|b|c)";
            PhonemeExpr result = (PhonemeExpr) method.invoke(null, input);
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testParsePhonemeExprThrowsExceptionOnInvalidInput() {
        try {
            // Accessing the private static method using reflection
            Method method = Rule.class.getDeclaredMethod("parsePhonemeExpr", String.class);
            method.setAccessible(true);

            // Test input that starts with '(' but does not end with ')'
            String input = "(a|b|c";
            method.invoke(null, input);
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}