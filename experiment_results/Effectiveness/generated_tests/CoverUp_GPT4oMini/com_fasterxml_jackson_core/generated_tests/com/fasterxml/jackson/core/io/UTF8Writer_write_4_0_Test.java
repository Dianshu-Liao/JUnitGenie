package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.UTF8Writer;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;

public class UTF8Writer_write_4_0_Test {

    private ByteArrayOutputStream outputStream;

    private UTF8Writer utf8Writer;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = new IOContext(null, null, null, null, null, true);
        utf8Writer = new UTF8Writer(ioContext, outputStream);
    }

    @Test
    public void testWriteSingleAsciiCharacter() throws IOException {
        char[] input = { 'A' };
        utf8Writer.write(input, 0, 1);
        byte[] expected = { 'A' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteMultipleAsciiCharacters() throws IOException {
        char[] input = { 'H', 'e', 'l', 'l', 'o' };
        utf8Writer.write(input, 0, input.length);
        byte[] expected = { 'H', 'e', 'l', 'l', 'o' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteTwoByteCharacter() throws IOException {
        // ©
        char[] input = { (char) 0xC2A9 };
        utf8Writer.write(input, 0, 1);
        byte[] expected = { (byte) 0xC2, (byte) 0xA9 };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteSurrogatePair() throws Exception {
        // 😀
        char[] input = { (char) 0xD83D, (char) 0xDE00 };
        utf8Writer.write(input, 0, 2);
        byte[] expected = { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x80 };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteIllegalSurrogate() {
        // High surrogate
        char[] input = { (char) 0xD800 };
        Exception exception = assertThrows(IOException.class, () -> {
            utf8Writer.write(input, 0, 1);
        });
        assertArrayEquals(new byte[0], outputStream.toByteArray());
    }

    @Test
    public void testWriteEmptyArray() throws IOException {
        char[] input = {};
        utf8Writer.write(input, 0, 0);
        assertArrayEquals(new byte[0], outputStream.toByteArray());
    }

    @Test
    public void testWriteSingleCharacterSurrogate() throws Exception {
        // High surrogate
        char[] input = { (char) 0xD800 };
        utf8Writer.write(input, 0, 1);
        byte[] expected = {};
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    private void invokeIllegalSurrogate(int code) throws Exception {
        Method method = UTF8Writer.class.getDeclaredMethod("illegalSurrogate", int.class);
        method.setAccessible(true);
        method.invoke(utf8Writer, code);
    }

    @Test
    public void testIllegalSurrogateInvocation() throws Exception {
        assertThrows(IOException.class, () -> invokeIllegalSurrogate(0xD800));
    }
}
