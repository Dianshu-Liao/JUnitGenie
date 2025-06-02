package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.io.input.BoundedInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;

public class harmony_pack200_Codec_check_int_InputStream_cfg_path_2_Test {

    private class ConcreteCodec extends Codec {
        @Override
        public byte[] encode(int a, int b) {
            return new byte[0];
        }

        @Override
        public byte[] encode(int a) {
            return new byte[0];
        }

        @Override
        public int decode(InputStream in, long length) {
            return 0;
        }

        @Override
        public int decode(InputStream in) {
            return 0;
        }
    }

    @Test(timeout = 4000)
    public void testCheck_ValidInput() throws Pack200Exception {
        InputStream in = new BoundedInputStream(new ByteArrayInputStream(new byte[10]), 10);
        ConcreteCodec codec = new ConcreteCodec();
        int result = codec.check(5, in);
        assertEquals(5, result);
    }

    @Test(timeout = 4000)
    public void testCheck_InvalidInput_ThrowsPack200Exception() {
        InputStream in = new BoundedInputStream(new ByteArrayInputStream(new byte[5]), 5);
        ConcreteCodec codec = new ConcreteCodec();
        try {
            codec.check(10, in);
        } catch (Pack200Exception e) {
            String expectedMessage = String.format("Can't read beyond end of stream (n = %,d, count = %,d, maxLength = %,d, remaining = %,d)",
                    10, 5, 5, 0);
            assertEquals(expectedMessage, e.getMessage());
        }
    }

}