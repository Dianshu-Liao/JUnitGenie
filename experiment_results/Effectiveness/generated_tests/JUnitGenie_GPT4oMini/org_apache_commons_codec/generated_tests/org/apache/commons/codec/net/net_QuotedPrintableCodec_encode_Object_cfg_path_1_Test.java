package org.apache.commons.codec.net;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.QuotedPrintableCodec;
import org.junit.Test;
import static org.junit.Assert.*;

public class net_QuotedPrintableCodec_encode_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEncodeByteArray() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        byte[] input = {65, 66, 67};  // Example byte array for testing
        try {
            Object result = codec.encode(input);
            assertNotNull(result);
            // You can add assertions here to verify the content of the result
        } catch (Exception e) { // Catching a more general exception
            fail("Encoding failed with Exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testEncodeNull() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        try {
            // Explicitly cast null to byte[] to resolve ambiguity
            Object result = codec.encode((byte[]) null);
            assertNull(result);
        } catch (Exception e) { // Catching a more general exception
            fail("Encoding null should not throw an exception, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testEncodeInvalidType() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        Object invalidInput = new Object(); // An invalid type
        try {
            codec.encode(invalidInput);
            fail("Expected EncoderException for invalid input type.");
        } catch (EncoderException e) {
            assertEquals("Objects of type java.lang.Object cannot be quoted-printable encoded", e.getMessage());
        } catch (Exception e) { // Catching a more general exception
            fail("Expected EncoderException but got: " + e.getMessage());
        }
    }

}