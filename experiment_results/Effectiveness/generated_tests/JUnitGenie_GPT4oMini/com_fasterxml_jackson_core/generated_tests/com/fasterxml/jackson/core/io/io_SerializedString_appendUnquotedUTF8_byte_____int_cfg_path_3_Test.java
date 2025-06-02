package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.SerializedString;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class io_SerializedString_appendUnquotedUTF8_byte_____int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAppendUnquotedUTF8() {
        // Arrange
        SerializedString serializedString = new SerializedString("test");
        byte[] buffer = new byte[10];
        int offset = 0;

        // Act
        int result = serializedString.appendUnquotedUTF8(buffer, offset);

        // Assert
        assertEquals(4, result); // Assuming the length of "test" is 4
    }

    @Test(timeout = 4000)
    public void testAppendUnquotedUTF8BufferTooSmall() {
        // Arrange
        SerializedString serializedString = new SerializedString("test");
        byte[] buffer = new byte[3]; // Buffer too small
        int offset = 0;

        // Act
        int result = serializedString.appendUnquotedUTF8(buffer, offset);

        // Assert
        assertEquals(-1, result); // Expecting -1 since buffer is too small
    }

}