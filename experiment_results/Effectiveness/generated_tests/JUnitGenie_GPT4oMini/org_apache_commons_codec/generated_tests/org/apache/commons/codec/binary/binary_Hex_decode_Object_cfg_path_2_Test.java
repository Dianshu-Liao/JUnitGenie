package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Hex_decode_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDecodeWithByteArray() {
        Hex hex = new Hex();
        byte[] input = new byte[]{0x01, 0x02, 0x03}; // Example byte array input
        
        try {
            Object result = hex.decode(input);
            assertNotNull(result); // Check that the result is not null
            // Additional assertions can be made based on expected behavior of decode
        } catch (DecoderException e) {
            fail("DecoderException should not have been thrown");
        }
    }
    
    @Test(timeout = 4000)
    public void testDecodeWithInvalidObject() {
        Hex hex = new Hex();
        Object invalidInput = new Object(); // Invalid type
        
        try {
            hex.decode(invalidInput);
            fail("Expected DecoderException to be thrown");
        } catch (DecoderException e) {
            // Expected exception
            assertNotNull(e.getMessage());
        }
    }

}