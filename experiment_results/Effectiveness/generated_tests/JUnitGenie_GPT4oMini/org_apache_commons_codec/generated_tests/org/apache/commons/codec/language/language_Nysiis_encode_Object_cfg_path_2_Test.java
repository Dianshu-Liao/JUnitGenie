package org.apache.commons.codec.language;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.Nysiis;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_Nysiis_encode_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEncodeWithNonStringParameter() {
        Nysiis nysiis = new Nysiis();
        Object nonStringInput = 123; // Non-string input to trigger the exception

        try {
            nysiis.encode(nonStringInput);
        } catch (EncoderException e) {
            // Verify that the exception message is as expected
            assertEquals("Parameter supplied to Nysiis encode is not of type java.lang.String", e.getMessage());
        }
    }


}