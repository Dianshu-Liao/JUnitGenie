package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.SerializedString;
import org.junit.Test;
import java.nio.ByteBuffer;
import static org.junit.Assert.assertEquals;

public class io_SerializedString_putUnquotedUTF8_ByteBuffer_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testPutUnquotedUTF8_whenResultIsNull_thenReturnsNegativeOne() {
        // Arrange
        SerializedString serializedString = new SerializedString("test");
        ByteBuffer buffer = ByteBuffer.allocate(4);
        
        // Act
        int result = serializedString.putUnquotedUTF8(buffer);

        // Assert
        assertEquals(-1, result);
    }

    @Test(timeout = 4000)
    public void testPutUnquotedUTF8_whenBufferHasSufficientSpace_thenWritesToBuffer() {
        // Arrange
        SerializedString serializedString = new SerializedString("test");
        ByteBuffer buffer = ByteBuffer.allocate(10); // Larger than the result.
        
        // Act
        int result = serializedString.putUnquotedUTF8(buffer);

        // Assert
        assertEquals(4, result); // Assuming "test" is encoded to a 4-byte UTF-8 representation.
        // Checking buffer content
        buffer.flip(); // Prepare buffer for reading
        byte[] bytes = new byte[result];
        buffer.get(bytes);
        assertEquals("test", new String(bytes, java.nio.charset.StandardCharsets.UTF_8));
    }

}