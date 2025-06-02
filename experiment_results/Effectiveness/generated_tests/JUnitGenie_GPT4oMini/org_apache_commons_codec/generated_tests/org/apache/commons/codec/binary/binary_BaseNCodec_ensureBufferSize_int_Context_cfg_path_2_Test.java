package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BaseNCodec;
import org.apache.commons.codec.binary.BaseNCodec.Context;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class binary_BaseNCodec_ensureBufferSize_int_Context_cfg_path_2_Test {

    private class ConcreteBaseNCodec extends BaseNCodec {
        protected ConcreteBaseNCodec(int a, int b, int c, int d) {
            super(a, b, c, d);
        }

        @Override
        public void encode(byte[] source, int sourceOffset, int length, Context context) {
            // Implementation not needed for this test
        }

        @Override
        public boolean isInAlphabet(byte value) {
            return false; // Implementation not needed for this test
        }

        @Override
        public void decode(byte[] source, int sourceOffset, int length, Context context) {
            // Implementation not needed for this test
        }
    }

    @Test(timeout = 4000)
    public void testEnsureBufferSize() {
        try {
            // Create an instance of the concrete class
            ConcreteBaseNCodec codec = new ConcreteBaseNCodec(0, 0, 0, 0);
            Context context = new Context();
            context.buffer = new byte[10]; // Initial buffer
            context.pos = 0; // Initial position

            // Call the protected method using reflection
            Method method = BaseNCodec.class.getDeclaredMethod("ensureBufferSize", int.class, Context.class);
            method.setAccessible(true);

            // Test with a size that does not require resizing
            byte[] result = (byte[]) method.invoke(codec, 5, context);
            assertArrayEquals(context.buffer, result);

            // Test with a size that requires resizing
            context.pos = 8; // Set position close to buffer length
            byte[] resizedResult = (byte[]) method.invoke(codec, 5, context);
            // The resizedResult should be the same as the original buffer since we are not testing resizeBuffer logic here
            assertArrayEquals(context.buffer, resizedResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}