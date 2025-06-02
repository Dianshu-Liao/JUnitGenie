package org.apache.commons.codec.language;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.AbstractCaverphone;
import org.junit.Test;
import static org.junit.Assert.fail;

public class language_AbstractCaverphone_encode_Object_cfg_path_2_Test extends AbstractCaverphone {

    @Override
    public String encode(String source) {
        // Implementation of the abstract method for testing purposes
        return source;
    }

    @Test(timeout = 4000)
    public void testEncode_NonStringParameter() {
        try {
            encode(new Object()); // Pass a non-string parameter
            fail("Expected EncoderException for non-string parameter");
        } catch (EncoderException e) {
            // Expected exception
            if (!"Parameter supplied to Caverphone encode is not of type java.lang.String".equals(e.getMessage())) {
                fail("Unexpected exception message: " + e.getMessage());
            }
        }
    }

}