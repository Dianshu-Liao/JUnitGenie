package org.apache.commons.codec.language;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.Caverphone;
import org.junit.Test;
import static org.junit.Assert.fail;

public class language_Caverphone_encode_Object_cfg_path_2_Test {

    private Caverphone caverphone = new Caverphone();

    @Test(timeout = 4000)
    public void testEncode_NonStringInput() {
        Object nonStringInput = 123; // Input that is not of type String

        try {
            caverphone.encode(nonStringInput);
            fail("Expected EncoderException to be thrown");
        } catch (EncoderException ex) {
            // Verify that the exception message is as expected
            if (!"Parameter supplied to Caverphone encode is not of type java.lang.String".equals(ex.getMessage())) {
                fail("Unexpected exception message: " + ex.getMessage());
            }
        }
    }

}