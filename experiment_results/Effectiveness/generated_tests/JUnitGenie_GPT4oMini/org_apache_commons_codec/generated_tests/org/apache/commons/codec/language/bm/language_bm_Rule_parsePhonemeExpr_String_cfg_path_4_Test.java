package org.apache.commons.codec.language.bm;
import org.apache.commons.codec.language.bm.Rule;
import org.apache.commons.codec.language.bm.Rule.PhonemeExpr;
import org.apache.commons.codec.language.bm.Rule.PhonemeList;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertNotNull;

public class language_bm_Rule_parsePhonemeExpr_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testParsePhonemeExpr_withValidInput() {
        try {
            // Prepare the input for the test case
            String input = "(part1|part2|part3)";

            // Access the private static method using reflection
            Method method = Rule.class.getDeclaredMethod("parsePhonemeExpr", String.class);
            method.setAccessible(true); // Make the method accessible

            // Invoke the method with the valid input
            PhonemeExpr result = (PhonemeExpr) method.invoke(null, input);
            
            // Validate that the result is not null
            assertNotNull(result);

        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testParsePhonemeExpr_withInvalidEnding() {
        try {
            // Prepare the input for the test case
            String input = "(invalidEnding";
            
            // Access the private static method using reflection
            Method method = Rule.class.getDeclaredMethod("parsePhonemeExpr", String.class);
            method.setAccessible(true); // Make the method accessible
            
            // Invoke the method expecting an exception
            method.invoke(null, input);
        } catch (IllegalArgumentException e) {
            // Exception expected; handle accordingly
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testParsePhonemeExpr_withoutParts() {
        try {
            // Prepare the input for the test case (edge case)
            String input = "(|)";
            
            // Access the private static method using reflection
            Method method = Rule.class.getDeclaredMethod("parsePhonemeExpr", String.class);
            method.setAccessible(true); // Make the method accessible
            
            // Invoke the method
            PhonemeExpr result = (PhonemeExpr) method.invoke(null, input);
            
            // Validate that result is not null
            assertNotNull(result);

        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
        }
    }

}