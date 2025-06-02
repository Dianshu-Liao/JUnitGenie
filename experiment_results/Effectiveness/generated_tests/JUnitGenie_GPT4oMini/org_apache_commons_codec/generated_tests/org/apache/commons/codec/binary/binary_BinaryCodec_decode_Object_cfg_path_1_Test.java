package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BinaryCodec;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class binary_BinaryCodec_decode_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testDecodeWithNullInput() {
        BinaryCodec codec = new BinaryCodec();
        try {
            Object result = codec.decode(null);
            assertArrayEquals(new byte[0], (byte[]) result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}