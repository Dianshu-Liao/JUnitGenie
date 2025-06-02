package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.BaseNCodec;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class binary_Base32_validateCharacter_long_Context_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testValidateCharacter() {
        Base32 base32 = new Base32();
        BaseNCodec.Context context = new BaseNCodec.Context();
        context.lbitWorkArea = 1L; // Set to a non-zero value to trigger the exception
        long emptyBitsMask = 1L; // Set to a value that will cause the condition to be true

        try {
            // Accessing the private method using reflection
            Method method = Base32.class.getDeclaredMethod("validateCharacter", long.class, BaseNCodec.Context.class);
            method.setAccessible(true);
            method.invoke(base32, emptyBitsMask, context);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

}