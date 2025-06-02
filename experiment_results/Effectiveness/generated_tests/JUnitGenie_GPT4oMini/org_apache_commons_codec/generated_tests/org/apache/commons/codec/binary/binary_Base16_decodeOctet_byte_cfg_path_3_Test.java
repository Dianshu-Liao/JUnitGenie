package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base16;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Base16_decodeOctet_byte_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testDecodeOctetThrowsException() {
        Base16 base16 = new Base16();
        byte invalidOctet = (byte) 255; // Assuming 255 is invalid for the decodeTable

        try {
            // Accessing the private method using reflection
            java.lang.reflect.Method method = Base16.class.getDeclaredMethod("decodeOctet", byte.class);
            method.setAccessible(true);
            method.invoke(base16, invalidOctet);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid octet in encoded value: 255", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

}