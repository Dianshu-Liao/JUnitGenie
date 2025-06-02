package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.io.input.BoundedInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.*;

public class harmony_pack200_Codec_check_int_InputStream_cfg_path_3_Test {

    private class ConcreteCodec extends Codec {
        @Override
        public byte[] encode(int a, int b) {
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

        @Override
        public byte[] encode(int a) {
            return new byte[0];
        }
    }

    @Test(timeout = 4000)
    public void testCheckWithValidBoundedInputStream() {
        try {
            ConcreteCodec codec = new ConcreteCodec();
            InputStream in = new BoundedInputStream(new ByteArrayInputStream(new byte[10]), 10);
            int result = codec.check(5, in);
            assertEquals(5, result);
        } catch (Pack200Exception e) {
            fail("Exception should not have been thrown for valid input.");
        }
    }

    @Test(timeout = 4000)
    public void testCheckWithInvalidBoundedInputStream() {
        try {
            ConcreteCodec codec = new ConcreteCodec();
            InputStream in = new BoundedInputStream(new ByteArrayInputStream(new byte[10]), 10);
            codec.check(15, in);
            fail("Pack200Exception should have been thrown for n > remaining.");
        } catch (Pack200Exception e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testCheckWithCountLessThanZero() {
        try {
            ConcreteCodec codec = new ConcreteCodec();
            InputStream in = new BoundedInputStream(new ByteArrayInputStream(new byte[10]), 10);
            codec.check(-1, in);
            fail("Pack200Exception should have been thrown for count < -1.");
        } catch (Pack200Exception e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testCheckWithNonBoundedInputStream() {
        try {
            ConcreteCodec codec = new ConcreteCodec();
            InputStream in = new ByteArrayInputStream(new byte[10]);
            int result = codec.check(5, in);
            assertEquals(5, result);
        } catch (Pack200Exception e) {
            fail("Exception should not have been thrown for non-bounded input stream.");
        }
    }

}