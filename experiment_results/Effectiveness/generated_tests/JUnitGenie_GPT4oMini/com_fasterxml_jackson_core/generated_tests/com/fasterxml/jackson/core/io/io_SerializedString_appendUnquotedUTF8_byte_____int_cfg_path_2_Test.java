package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.UnsupportedEncodingException;

public class io_SerializedString_appendUnquotedUTF8_byte_____int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAppendUnquotedUTF8() throws UnsupportedEncodingException {
        // Arrange
        String testValue = "test";
        SerializedString serializedString = new SerializedString(testValue);
        byte[] buffer = new byte[100]; // Ensure buffer is large enough
        int offset = 0;

        // Act
        int result = -1;
        try {
            result = serializedString.appendUnquotedUTF8(buffer, offset);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertEquals(testValue.getBytes("UTF-8").length, result);
    }

    @Test(timeout = 4000)
    public void testAppendUnquotedUTF8WithInsufficientBuffer() {
        // Arrange
        String testValue = "test";
        SerializedString serializedString = new SerializedString(testValue);
        byte[] buffer = new byte[3]; // Buffer too small
        int offset = 0;

        // Act
        int result = -1;
        try {
            result = serializedString.appendUnquotedUTF8(buffer, offset);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertEquals(-1, result);
    }


}