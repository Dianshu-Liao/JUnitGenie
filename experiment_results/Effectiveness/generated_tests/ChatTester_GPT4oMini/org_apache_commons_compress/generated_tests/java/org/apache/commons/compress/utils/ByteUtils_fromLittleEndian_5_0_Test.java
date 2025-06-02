package org.apache.commons.compress.utils;

import org.junit.jupiter.api.function.Executable;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.OutputStream;

class ByteUtils_fromLittleEndian_5_0_Test {

    @Test
    void testFromLittleEndian_ValidInput() throws IOException {
        // Arrange
        // Represents the long value 67305985 (0x04030201)
        byte[] inputBytes = { 1, 2, 3, 4 };
        InputStream inputStream = new ByteArrayInputStream(inputBytes);
        int length = 4;
        // Act
        long result = ByteUtils.fromLittleEndian(inputStream, length);
        // Assert
        assertEquals(67305985L, result);
    }

    @Test
    void testFromLittleEndian_PrematureEndOfData() {
        // Arrange
        // Not enough bytes
        byte[] inputBytes = { 1, 2 };
        InputStream inputStream = new ByteArrayInputStream(inputBytes);
        int length = 4;
        // Act
        Executable executable = () -> ByteUtils.fromLittleEndian(inputStream, length);
        // Assert
        IOException exception = assertThrows(IOException.class, executable);
        assertEquals("Premature end of data", exception.getMessage());
    }

    @Test
    void testFromLittleEndian_ZeroLength() throws IOException {
        // Arrange
        byte[] inputBytes = { 1, 2, 3, 4 };
        InputStream inputStream = new ByteArrayInputStream(inputBytes);
        int length = 0;
        // Act
        long result = ByteUtils.fromLittleEndian(inputStream, length);
        // Assert
        assertEquals(0L, result);
    }

    @Test
    void testFromLittleEndian_NegativeLength() {
        // Arrange
        InputStream inputStream = new ByteArrayInputStream(new byte[] { 1, 2, 3, 4 });
        int length = -1;
        // Act
        Executable executable = () -> ByteUtils.fromLittleEndian(inputStream, length);
        // Assert
        assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    void testFromLittleEndian_EmptyInputStream() {
        // Arrange
        InputStream inputStream = new ByteArrayInputStream(new byte[] {});
        int length = 1;
        // Act
        Executable executable = () -> ByteUtils.fromLittleEndian(inputStream, length);
        // Assert
        IOException exception = assertThrows(IOException.class, executable);
        assertEquals("Premature end of data", exception.getMessage());
    }
}
