package org.apache.commons.codec.language;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.Metaphone;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_Metaphone_encode_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEncodeWithNonStringParameter() {
        Metaphone metaphone = new Metaphone();
        Object nonStringInput = new Object(); // Non-string input to trigger the exception

        try {
            metaphone.encode(nonStringInput);
            fail("Expected EncoderException to be thrown");
        } catch (EncoderException e) {
            assertEquals("Parameter supplied to Metaphone encode is not of type java.lang.String", e.getMessage());
        }
    }

}