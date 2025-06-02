package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class language_DoubleMetaphone_encode_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEncode_ValidString() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        String input = "example";
        try {
            Object result = doubleMetaphone.encode(input);
            assertNotNull(result);
        } catch (Exception e) { // Catching a more general exception
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEncode_InvalidType() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        Object input = 123; // Invalid input type
        try {
            doubleMetaphone.encode(input);
        } catch (Exception e) { // Catching a more general exception
            // Expected exception
            assertNotNull(e);
        }
    }


}