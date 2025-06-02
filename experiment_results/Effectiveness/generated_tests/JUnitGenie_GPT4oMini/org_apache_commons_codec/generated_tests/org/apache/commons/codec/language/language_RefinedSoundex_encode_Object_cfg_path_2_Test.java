package org.apache.commons.codec.language;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.RefinedSoundex;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_RefinedSoundex_encode_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEncodeWithNonStringParameter() {
        RefinedSoundex refinedSoundex = new RefinedSoundex();
        Object nonStringInput = 123; // Example of a non-string input

        try {
            refinedSoundex.encode(nonStringInput);
            fail("Expected EncoderException to be thrown");
        } catch (EncoderException e) {
            assertEquals("Parameter supplied to RefinedSoundex encode is not of type java.lang.String", e.getMessage());
        }
    }

}