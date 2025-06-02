package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BaseNCodec;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class binary_Base64_validateCharacter_int_Context_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testValidateCharacterThrowsException() {
        // Arrange
        Base64 base64 = new Base64();
        BaseNCodec.Context context = new BaseNCodec.Context();
        context.ibitWorkArea = 1; // Set to a value that will trigger the exception
        int emptyBitsMask = 1; // Set to a value that will cause the condition to be true

        // Act
        try {
            // Access the private method using reflection
            Method method = Base64.class.getDeclaredMethod("validateCharacter", int.class, BaseNCodec.Context.class);
            method.setAccessible(true);
            method.invoke(base64, emptyBitsMask, context);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Assert
            // Exception is expected, test passes
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

}