package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BaseNCodec;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Base64_validateCharacter_int_Context_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testValidateCharacter_Success() {
        Base64 base64 = new Base64();
        BaseNCodec.Context context = new BaseNCodec.Context();

        // Setting up context.ibitWorkArea to zero to satisfy the condition
        context.ibitWorkArea = 0;

        // Using reflection to access the private method
        try {
            java.lang.reflect.Method method = Base64.class.getDeclaredMethod("validateCharacter", int.class, BaseNCodec.Context.class);
            method.setAccessible(true);
            method.invoke(base64, 1, context); // Call with emptyBitsMask = 1
        } catch (Exception e) {
            fail("Expected no exception, but got: " + e.getMessage());
        }
    }

}