package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class binary_BinaryCodec_toByteArray_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToByteArrayWithNullInput() {
        BinaryCodec codec = new BinaryCodec();
        byte[] result = null;
        try {
            result = codec.toByteArray(null);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        assertArrayEquals(new byte[]{}, result);
    }

}