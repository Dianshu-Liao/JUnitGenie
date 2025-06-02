package org.apache.commons.lang3.exception;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class exception_ExceptionUtils_getStackFrames_Throwable_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetStackFramesWithNullThrowable() {
        // Given
        Throwable throwable = null;

        // When
        String[] result = ExceptionUtils.getStackFrames(throwable);

        // Then
        String[] expected = {};
        assertArrayEquals(expected, result);
    }

}