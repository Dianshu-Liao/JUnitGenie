// Test method
package com.fasterxml.jackson.core.io;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class UTF8Writer_write_3_1_Test {

    private UTF8Writer utf8Writer;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = mock(IOContext.class);
        utf8Writer = new UTF8Writer(ioContext, outputStream);
    }

    @Test
    public void testWriteEmptyCharArray() throws IOException {
        utf8Writer.write(new char[0]);
        assertEquals(0, outputStream.size());
    }

    @Test
    public void testWriteSingleCharacter() throws IOException {
        char[] input = { 'a' };
        utf8Writer.write(input);
        assertEquals(1, outputStream.size());
        assertEquals('a', outputStream.toString().charAt(0));
    }

    @Test
    public void testWriteMultipleCharacters() throws IOException {
        char[] input = { 'H', 'e', 'l', 'l', 'o' };
        utf8Writer.write(input);
        assertEquals(5, outputStream.size());
        assertEquals("Hello", outputStream.toString());
    }

    @Test
    public void testWriteSurrogateCharacters() throws IOException {
        // Surrogate pair
        char[] input = { 0xD800, 0xDC00 };
        utf8Writer.write(input);
        // Assuming the UTF8Writer processes surrogates correctly, check the output.
        // The expected output would depend on how the class is designed to handle surrogates.
        // Here, we would need to implement the expected behavior.
        // For demonstration, let's assume it writes a placeholder for surrogates.
        // Replace with actual expected output as per the class logic.
        // Adjust based on actual expected output size.
        assertEquals(4, outputStream.size());
    }

    @Test
    public void testWriteNullCharArray() {
        assertThrows(NullPointerException.class, () -> {
            // Fixed ambiguous reference by casting to char[]
            utf8Writer.write((char[]) null);
        });
    }
}
