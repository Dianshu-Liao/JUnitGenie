package org.apache.commons.codec.language;
import org.apache.commons.codec.language.ColognePhonetic;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_ColognePhonetic_encode_Object_cfg_path_2_Test {



    @Test(timeout = 4000)
    public void testEncodeWithNull() {
        ColognePhonetic colognePhonetic = new ColognePhonetic();
        String input = null; // Null input
        try {
            colognePhonetic.encode(input);
            fail("Expected EncoderException to be thrown.");
        } catch (NullPointerException e) {
            assertEquals("Input cannot be null", e.getMessage());
        }
    }



}
