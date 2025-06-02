package org.apache.commons.codec.language;
import org.apache.commons.codec.language.Caverphone;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_Caverphone_encode_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEncodeWithNull() {
        Caverphone caverphone = new Caverphone();
        try {
            Object result = caverphone.encode(null);
            assertNotNull(result); // Assuming caverphone(null) returns a non-null value
        } catch (Exception e) { // Catching a more general Exception
            fail("Exception should not be thrown for null input");
        }
    }

    @Test(timeout = 4000)
    public void testEncodeWithNonString() {
        Caverphone caverphone = new Caverphone();
        try {
            caverphone.encode(123); // Passing an Integer instead of a String
            fail("Expected EncoderException for non-String input");
        } catch (EncoderException e) {
            assertEquals("Parameter supplied to Caverphone encode is not of type java.lang.String", e.getMessage());
        } catch (Exception e) { // Catching a more general Exception
            fail("Unexpected exception thrown for non-String input");
        }
    }


}