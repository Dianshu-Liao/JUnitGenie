package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BaseNCodec;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class binary_Base64_validateCharacter_int_Context_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testValidateCharacter() {
        try {
            // Create an instance of Base64
            Base64 base64 = new Base64();

            // Prepare the context with ibitWorkArea
            BaseNCodec.Context context = new BaseNCodec.Context();
            context.ibitWorkArea = 1; // Set to a non-zero value to trigger the exception

            // Define the emptyBitsMask
            int emptyBitsMask = 1; // This will ensure the condition is met

            // Access the private method validateCharacter using reflection
            Method method = Base64.class.getDeclaredMethod("validateCharacter", int.class, BaseNCodec.Context.class);
            method.setAccessible(true);

            // Call the method
            method.invoke(base64, emptyBitsMask, context);

            // If no exception is thrown, fail the test
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception, test passes
        } catch (Exception e) {
            // Handle other exceptions
            fail("An unexpected exception was thrown: " + e.getMessage());
        }
    }

}