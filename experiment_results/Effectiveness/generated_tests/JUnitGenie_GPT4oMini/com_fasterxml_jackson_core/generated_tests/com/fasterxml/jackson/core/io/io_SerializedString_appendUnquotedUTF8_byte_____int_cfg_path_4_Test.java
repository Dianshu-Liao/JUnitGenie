package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.SerializedString;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.UnsupportedEncodingException;

public class io_SerializedString_appendUnquotedUTF8_byte_____int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testAppendUnquotedUTF8() throws UnsupportedEncodingException {
        // Arrange
        String testValue = "test";
        SerializedString serializedString = new SerializedString(testValue);
        byte[] buffer = new byte[100];
        int offset = 0;

        // Act
        int result = serializedString.appendUnquotedUTF8(buffer, offset);

        // Assert
        assertEquals(testValue.getBytes("UTF-8").length, result);
    }

    @Test(timeout = 4000)
    public void testAppendUnquotedUTF8BufferTooSmall() throws UnsupportedEncodingException {
        // Arrange
        String testValue = "test";
        SerializedString serializedString = new SerializedString(testValue);
        byte[] buffer = new byte[5]; // Smaller than needed
        int offset = 0;

        // Act
        int result = serializedString.appendUnquotedUTF8(buffer, offset);

        // Assert
        assertEquals(-1, result);
    }


}