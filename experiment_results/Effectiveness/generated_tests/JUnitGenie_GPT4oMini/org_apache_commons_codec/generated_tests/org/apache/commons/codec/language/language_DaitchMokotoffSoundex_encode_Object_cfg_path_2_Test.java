package org.apache.commons.codec.language;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.DaitchMokotoffSoundex;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_DaitchMokotoffSoundex_encode_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEncode_NonStringParameter() {
        DaitchMokotoffSoundex soundex = new DaitchMokotoffSoundex();
        Object nonStringInput = new Object(); // Non-string input to trigger the exception

        try {
            soundex.encode(nonStringInput);
        } catch (EncoderException e) {
            // Verify that the exception message is as expected
            assertEquals("Parameter supplied to DaitchMokotoffSoundex encode is not of type java.lang.String", e.getMessage());
        }
    }


}