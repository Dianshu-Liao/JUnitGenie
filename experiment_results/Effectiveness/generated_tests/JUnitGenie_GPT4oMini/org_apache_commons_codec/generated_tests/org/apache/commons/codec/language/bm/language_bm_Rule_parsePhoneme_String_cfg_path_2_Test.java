package org.apache.commons.codec.language.bm;
import org.apache.commons.codec.language.bm.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_bm_Rule_parsePhoneme_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testParsePhonemeThrowsException() {
        String input = "test[language"; // This input should trigger the exception

        try {
            // Accessing the private static method using reflection
            java.lang.reflect.Method method = Rule.class.getDeclaredMethod("parsePhoneme", String.class);
            method.setAccessible(true);
            method.invoke(null, input);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Phoneme expression contains a '[' but does not end in ']'", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }

}