package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.SerializedString;
import org.junit.Test;
import java.nio.ByteBuffer;
import static org.junit.Assert.assertEquals;

public class io_SerializedString_putUnquotedUTF8_ByteBuffer_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testPutUnquotedUTF8() {
        // Arrange
        SerializedString serializedString = new SerializedString("test");
        ByteBuffer buffer = ByteBuffer.allocate(10);
        
        // Act
        int result = serializedString.putUnquotedUTF8(buffer);
        
        // Assert
        assertEquals(4, result); // "test" has a length of 4
        buffer.flip(); // Prepare buffer for reading
        byte[] expected = "test".getBytes(); // Expected byte array
        byte[] actual = new byte[4];
        buffer.get(actual); // Read from buffer
        assertEquals(new String(expected), new String(actual)); // Verify content
    }

    @Test(timeout = 4000)
    public void testPutUnquotedUTF8BufferTooSmall() {
        // Arrange
        SerializedString serializedString = new SerializedString("test");
        ByteBuffer buffer = ByteBuffer.allocate(2); // Buffer too small
        
        // Act
        int result = serializedString.putUnquotedUTF8(buffer);
        
        // Assert
        assertEquals(-1, result); // Should return -1 since buffer is too small
    }

}