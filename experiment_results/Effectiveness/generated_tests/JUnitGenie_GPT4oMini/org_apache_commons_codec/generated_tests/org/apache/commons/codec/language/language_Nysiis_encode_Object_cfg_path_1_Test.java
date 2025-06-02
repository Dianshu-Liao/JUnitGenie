package org.apache.commons.codec.language;
import org.apache.commons.codec.language.Nysiis;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_Nysiis_encode_Object_cfg_path_1_Test {

    private final Nysiis nysiis = new Nysiis();



    @Test(timeout = 4000)
    public void testEncodeWithNull() {
        String input = null; // Null input
        try {
            nysiis.encode(input);
            fail("Expected EncoderException for null input");
        } catch (ClassCastException e) {
            assertEquals("Parameter supplied to Nysiis encode is not of type java.lang.String", e.getMessage());
        }
    }



}
