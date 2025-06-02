package org.apache.commons.codec.language;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.ColognePhonetic;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_ColognePhonetic_encode_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEncodeWithNonStringObject() {
        ColognePhonetic colognePhonetic = new ColognePhonetic();
        Object input = new Integer(123); // Non-String Object to trigger EncoderException
        try {
            colognePhonetic.encode(input);
            fail("Expected EncoderException to be thrown");
        } catch (EncoderException e) {
            assertEquals("This method's parameter was expected to be of the type java.lang.String. But actually it was of the type java.lang.Integer.", e.getMessage());
        }
    }

}