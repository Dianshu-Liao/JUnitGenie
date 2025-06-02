package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.BitInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.nio.ByteOrder;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class utils_BitInputStream_readCachedBits_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReadCachedBitsLittleEndian() {
        try {
            // Setup the input stream and BitInputStream instance
            ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[]{0b00001111});
            BitInputStream bitInputStream = new BitInputStream(inputStream, ByteOrder.LITTLE_ENDIAN);
            
            // Set the private fields using reflection
            setPrivateField(bitInputStream, "bitsCached", 0b11110000); // Set bitsCached to a known value
            setPrivateField(bitInputStream, "bitsCachedSize", 8); // Set bitsCachedSize to 8

            // Access the private method using reflection
            Method method = BitInputStream.class.getDeclaredMethod("readCachedBits", int.class);
            method.setAccessible(true);

            // Invoke the method with count = 4
            long result = (long) method.invoke(bitInputStream, 4);

            // Verify the result
            assertEquals(0b00001111, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

}