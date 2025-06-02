package org.apache.commons.codec.net;
import org.apache.commons.codec.net.PercentCodec;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.BitSet;
import static org.junit.Assert.assertEquals;

public class net_PercentCodec_insertAlwaysEncodeChar_byte_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testInsertAlwaysEncodeChar() {
        try {
            // Create an instance of PercentCodec
            PercentCodec codec = new PercentCodec();

            // Access the private method using reflection
            Method method = PercentCodec.class.getDeclaredMethod("insertAlwaysEncodeChar", byte.class);
            method.setAccessible(true);

            // Test with a valid byte value
            byte testByte = 5;
            method.invoke(codec, testByte);

            // Verify the state of alwaysEncodeChars, alwaysEncodeCharsMin, and alwaysEncodeCharsMax
            BitSet alwaysEncodeChars = (BitSet) PercentCodec.class.getDeclaredField("alwaysEncodeChars").get(codec);
            int alwaysEncodeCharsMin = (int) PercentCodec.class.getDeclaredField("alwaysEncodeCharsMin").get(codec);
            int alwaysEncodeCharsMax = (int) PercentCodec.class.getDeclaredField("alwaysEncodeCharsMax").get(codec);

            // Assertions
            assertEquals(true, alwaysEncodeChars.get(testByte));
            assertEquals(testByte, alwaysEncodeCharsMin);
            assertEquals(testByte, alwaysEncodeCharsMax);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertAlwaysEncodeCharThrowsException() {
        try {
            // Create an instance of PercentCodec
            PercentCodec codec = new PercentCodec();

            // Access the private method using reflection
            Method method = PercentCodec.class.getDeclaredMethod("insertAlwaysEncodeChar", byte.class);
            method.setAccessible(true);

            // Test with an invalid byte value
            byte testByte = -1;
            method.invoke(codec, testByte);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}