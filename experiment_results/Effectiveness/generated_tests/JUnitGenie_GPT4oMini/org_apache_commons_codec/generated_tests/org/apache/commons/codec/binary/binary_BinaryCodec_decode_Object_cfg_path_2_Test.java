package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class binary_BinaryCodec_decode_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDecode_withByteArray() {
        BinaryCodec codec = new BinaryCodec();
        byte[] input = new byte[]{65, 66, 67}; // ASCII for 'ABC'
        byte[] expectedOutput = new byte[]{65, 66, 67}; // Example expected output

        byte[] result = codec.decode(input); // Change Object to byte[] 
        assertArrayEquals(expectedOutput, result); // Now both are byte[] 
    }

}