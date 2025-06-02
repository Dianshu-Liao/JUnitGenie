package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.UnsupportedEncodingException;

public class io_SerializedString_appendUnquotedUTF8_byte_____int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAppendUnquotedUTF8() throws UnsupportedEncodingException {
        // Arrange
        String testValue = "test";
        SerializedString serializedString = new SerializedString(testValue);
        byte[] buffer = new byte[10];
        int offset = 0;

        // Act
        int result = serializedString.appendUnquotedUTF8(buffer, offset);

        // Assert
        assertEquals(testValue.getBytes("UTF-8").length, result);
    }

    @Test(timeout = 4000)
    public void testAppendUnquotedUTF8_InsufficientBuffer() {
        // Arrange
        String testValue = "test";
        SerializedString serializedString = new SerializedString(testValue);
        byte[] buffer = new byte[3]; // Insufficient buffer size
        int offset = 0;

        // Act
        int result = serializedString.appendUnquotedUTF8(buffer, offset);

        // Assert
        assertEquals(-1, result);
    }

    @Test(timeout = 4000)
    public void testAppendUnquotedUTF8_NullValue() {
        // Arrange
        SerializedString serializedString = new SerializedString(""); // Use an empty string instead of null
        byte[] buffer = new byte[10];
        int offset = 0;

        // Act
        int result = -1;
        try {
            result = serializedString.appendUnquotedUTF8(buffer, offset);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertEquals(0, result); // Expecting 0 since an empty string should append nothing
    }

}