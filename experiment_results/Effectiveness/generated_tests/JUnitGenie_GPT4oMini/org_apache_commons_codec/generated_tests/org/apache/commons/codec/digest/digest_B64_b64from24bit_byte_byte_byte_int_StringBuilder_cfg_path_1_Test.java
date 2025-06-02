package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.B64;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_B64_b64from24bit_byte_byte_byte_int_StringBuilder_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testB64from24bit() {
        // Prepare the input parameters
        byte b2 = (byte) 0b11111111; // Example byte value
        byte b1 = (byte) 0b11111111; // Example byte value
        byte b0 = (byte) 0b11111111; // Example byte value
        int outLen = 4; // Example output length
        StringBuilder buffer = new StringBuilder();

        // Call the focal method
        B64.b64from24bit(b2, b1, b0, outLen, buffer);

        // Expected output based on the input values
        String expectedOutput = "////"; // Replace with the expected output based on the B64T_ARRAY mapping

        // Validate the output
        assertEquals(expectedOutput, buffer.toString());
    }

}