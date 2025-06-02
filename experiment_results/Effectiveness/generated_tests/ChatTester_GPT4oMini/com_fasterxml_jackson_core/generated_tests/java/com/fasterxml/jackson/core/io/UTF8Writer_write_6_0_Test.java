package com.fasterxml.jackson.core.io;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class UTF8Writer_write_6_0_Test {

    private UTF8Writer utf8Writer;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        // Assuming IOContext has a suitable constructor with required parameters
        IOContext context = new IOContext(null, null, null, null, null, false);
        utf8Writer = new UTF8Writer(context, outputStream);
    }

    @Test
    public void testWriteValidString() throws IOException {
        String input = "Hello, World!";
        utf8Writer.write(input);
        byte[] expectedOutput = input.getBytes("UTF-8");
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteEmptyString() throws IOException {
        String input = "";
        utf8Writer.write(input);
        assertArrayEquals(new byte[0], outputStream.toByteArray());
    }

    @Test
    public void testWriteNullString() {
        assertThrows(NullPointerException.class, () -> {
            // Fixed the ambiguous method call by using reflection to access the private method
            java.lang.reflect.Method writeMethod = UTF8Writer.class.getDeclaredMethod("write", String.class);
            writeMethod.setAccessible(true);
            writeMethod.invoke(utf8Writer, (String) null);
        });
    }

    @Test
    public void testWriteStringWithSpecialCharacters() throws IOException {
        String input = "Hello, 世界!";
        utf8Writer.write(input);
        byte[] expectedOutput = input.getBytes("UTF-8");
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }
}
