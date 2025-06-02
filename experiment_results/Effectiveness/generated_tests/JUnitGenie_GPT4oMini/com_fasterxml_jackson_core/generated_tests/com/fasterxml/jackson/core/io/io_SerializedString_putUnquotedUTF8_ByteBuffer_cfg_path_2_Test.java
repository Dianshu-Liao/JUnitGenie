package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.SerializedString;
import java.nio.ByteBuffer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.UnsupportedEncodingException;

public class io_SerializedString_putUnquotedUTF8_ByteBuffer_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPutUnquotedUTF8() throws UnsupportedEncodingException {
        // Arrange
        String testValue = "test";
        SerializedString serializedString = new SerializedString(testValue);
        ByteBuffer buffer = ByteBuffer.allocate(1024); // Allocate a buffer with sufficient size

        // Act
        int result = serializedString.putUnquotedUTF8(buffer);

        // Assert
        assertEquals(testValue.getBytes("UTF-8").length, result);
        buffer.flip(); // Prepare buffer for reading
        byte[] byteArray = new byte[result];
        buffer.get(byteArray);
        assertEquals(testValue, new String(byteArray, "UTF-8"));
    }

    @Test(timeout = 4000)
    public void testPutUnquotedUTF8BufferTooSmall() throws UnsupportedEncodingException {
        // Arrange
        String testValue = "test";
        SerializedString serializedString = new SerializedString(testValue);
        ByteBuffer buffer = ByteBuffer.allocate(2); // Allocate a buffer smaller than the string

        // Act
        int result = serializedString.putUnquotedUTF8(buffer);

        // Assert
        assertEquals(-1, result);
    }


}