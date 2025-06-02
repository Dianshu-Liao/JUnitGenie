package org.apache.commons.codec.binary;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Hex_decode_Object_cfg_path_3_Test {

    private final Hex hex = new Hex();

    @Test(timeout = 4000)
    public void testDecodeWithInvalidObject() {
        Object invalidObject = new Object(); // An object that is not a String, byte[], or ByteBuffer
        try {
            hex.decode(invalidObject);
            fail("Expected DecoderException to be thrown");
        } catch (DecoderException e) {
            // Expected exception
        } catch (ClassCastException e) {
            fail("Expected DecoderException, but got ClassCastException: " + e.getMessage());
        }
    }

}