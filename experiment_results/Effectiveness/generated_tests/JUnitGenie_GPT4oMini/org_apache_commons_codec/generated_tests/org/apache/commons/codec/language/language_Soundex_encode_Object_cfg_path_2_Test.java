package org.apache.commons.codec.language;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.Soundex;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_Soundex_encode_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEncodeWithNonStringParameter() {
        Soundex soundex = new Soundex();
        Object nonStringInput = 123; // Non-string input to trigger the exception

        try {
            soundex.encode(nonStringInput);
            fail("Expected EncoderException to be thrown");
        } catch (EncoderException e) {
            assertEquals("Parameter supplied to Soundex encode is not of type java.lang.String", e.getMessage());
        }
    }

}