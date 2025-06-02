package com.fasterxml.jackson.core.json;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;

class UTF8JsonGenerator__writeGenericEscape_78_1_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    private byte[] outputBuffer;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        // Initialize with the max buffer size
        outputBuffer = new byte[512];
        generator = new UTF8JsonGenerator(null, 0, null, outputStream, '"', outputBuffer, 0, true);
    }

    @Test
    void testWriteGenericEscape() throws Exception {
        // Prepare the inputs for the escape method
        // Control character
        int charToEscape = 0x1F;
        int outputPtr = 0;
        // Use reflection to invoke the private method
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeGenericEscape", int.class, int.class);
        method.setAccessible(true);
        // Call the method
        outputPtr = (int) method.invoke(generator, charToEscape, outputPtr);
        // Expected output buffer after escaping the character
        byte[] expectedOutput = new byte[] { (byte) '\\', (byte) 'u', (byte) '0', (byte) '0', (byte) '1', (byte) 'f' };
        // Validate the output buffer
        assertArrayEquals(expectedOutput, outputBuffer);
    }

    @Test
    void testWriteGenericEscapeWithHighChar() throws Exception {
        // Prepare the inputs for the escape method
        // Character outside the ASCII range
        int charToEscape = 0x0100;
        int outputPtr = 0;
        // Use reflection to invoke the private method
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeGenericEscape", int.class, int.class);
        method.setAccessible(true);
        // Call the method
        outputPtr = (int) method.invoke(generator, charToEscape, outputPtr);
        // Expected output buffer after escaping the character
        byte[] expectedOutput = new byte[] { (byte) '\\', (byte) 'u', (byte) '0', (byte) '1', (byte) '0', (byte) '0' };
        // Validate the output buffer
        assertArrayEquals(expectedOutput, outputBuffer);
    }

    @Test
    void testWriteGenericEscapeWithZeroChar() throws Exception {
        // Prepare the inputs for the escape method
        // Null character
        int charToEscape = 0x00;
        int outputPtr = 0;
        // Use reflection to invoke the private method
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeGenericEscape", int.class, int.class);
        method.setAccessible(true);
        // Call the method
        outputPtr = (int) method.invoke(generator, charToEscape, outputPtr);
        // Expected output buffer after escaping the character
        byte[] expectedOutput = new byte[] { (byte) '\\', (byte) 'u', (byte) '0', (byte) '0', (byte) '0', (byte) '0' };
        // Validate the output buffer
        assertArrayEquals(expectedOutput, outputBuffer);
    }
}
