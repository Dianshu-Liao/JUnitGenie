package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.util.ClassUtil;
import org.junit.Test;
import java.io.Closeable;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class util_ClassUtil_closeOnFailAndThrowAsIOE_JsonGenerator_Closeable_Exception_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testCloseOnFailAndThrowAsIOE() {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Closeable mockCloseable = mock(Closeable.class);
        Exception fail = new Exception("Initial failure");

        // Act
        try {
            ClassUtil.closeOnFailAndThrowAsIOE(mockGenerator, mockCloseable, fail);
        } catch (IOException e) {
            // Handle IOException if thrown
        } catch (RuntimeException e) {
            // Assert that the RuntimeException is thrown with the correct cause
            assert e.getCause() == fail;
        }

        // Verify interactions
        try {
            verify(mockGenerator).disable(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
            verify(mockGenerator).close();
            verify(mockCloseable).close();
        } catch (IOException e) {
            // Handle IOException if thrown during verification
        }
    }

}