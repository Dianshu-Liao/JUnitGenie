package org.apache.commons.lang3.exception;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

public class exception_ExceptionUtils_getStackFrames_Throwable_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetStackFramesWithNullThrowable() {
        // Test case where throwable is null
        String[] result = ExceptionUtils.getStackFrames((Throwable) null); // Cast to Throwable to resolve ambiguity
        assertArrayEquals(new String[0], result); // Expecting an empty array
    }

    @Test(timeout = 4000)
    public void testGetStackFramesWithValidThrowable() {
        // Test case where throwable is a valid Throwable object
        Throwable throwable = new Exception("Test Exception");
        String[] result = null;
        try {
            result = ExceptionUtils.getStackFrames(throwable); // Use the throwable directly
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
        // Validate that the result is not null and has at least one element
        assertNotNull(result); // Use assertNotNull for better clarity
        assert result.length > 0; // Ensure the result has elements
    }


}