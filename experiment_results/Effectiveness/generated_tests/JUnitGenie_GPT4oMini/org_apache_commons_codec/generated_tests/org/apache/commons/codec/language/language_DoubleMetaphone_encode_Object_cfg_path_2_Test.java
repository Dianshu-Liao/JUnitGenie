package org.apache.commons.codec.language;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_DoubleMetaphone_encode_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEncode_WithNonStringParameter_ShouldThrowEncoderException() {
        DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        Object nonStringInput = new Object(); // Non-string object

        try {
            doubleMetaphone.encode(nonStringInput);
            fail("Expected EncoderException not thrown");
        } catch (EncoderException e) {
            assertEquals("DoubleMetaphone encode parameter is not of type String", e.getMessage());
        }
    }

}