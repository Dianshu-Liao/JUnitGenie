package com.fasterxml.jackson.core.json;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8DataInputJsonParser__decodeEscaped_69_0_Test {

    private UTF8DataInputJsonParser parser;

    private DataInput mockInputData;

    @BeforeEach
    public void setUp() {
        mockInputData = mock(DataInput.class);
        parser = new UTF8DataInputJsonParser(null, 0, mockInputData, null, null, 0);
    }

    @Test
    public void testDecodeEscaped_Backspace() throws IOException {
        when(mockInputData.readUnsignedByte()).thenReturn((int) 'b');
        assertEquals('\b', parser._decodeEscaped());
    }

    @Test
    public void testDecodeEscaped_Tab() throws IOException {
        when(mockInputData.readUnsignedByte()).thenReturn((int) 't');
        assertEquals('\t', parser._decodeEscaped());
    }

    @Test
    public void testDecodeEscaped_Newline() throws IOException {
        when(mockInputData.readUnsignedByte()).thenReturn((int) 'n');
        assertEquals('\n', parser._decodeEscaped());
    }

    @Test
    public void testDecodeEscaped_FormFeed() throws IOException {
        when(mockInputData.readUnsignedByte()).thenReturn((int) 'f');
        assertEquals('\f', parser._decodeEscaped());
    }

    @Test
    public void testDecodeEscaped_CarriageReturn() throws IOException {
        when(mockInputData.readUnsignedByte()).thenReturn((int) 'r');
        assertEquals('\r', parser._decodeEscaped());
    }

    @Test
    public void testDecodeEscaped_Quote() throws IOException {
        when(mockInputData.readUnsignedByte()).thenReturn((int) '"');
        assertEquals('"', parser._decodeEscaped());
    }

    @Test
    public void testDecodeEscaped_Slash() throws IOException {
        when(mockInputData.readUnsignedByte()).thenReturn((int) '/');
        assertEquals('/', parser._decodeEscaped());
    }

    @Test
    public void testDecodeEscaped_Backslash() throws IOException {
        when(mockInputData.readUnsignedByte()).thenReturn((int) '\\');
        assertEquals('\\', parser._decodeEscaped());
    }

    @Test
    public void testDecodeEscaped_Hexadecimal() throws IOException {
        when(mockInputData.readUnsignedByte()).thenReturn((int) 'u');
        when(mockInputData.readUnsignedByte()).thenReturn((int) '0');
        when(mockInputData.readUnsignedByte()).thenReturn((int) '1');
        when(mockInputData.readUnsignedByte()).thenReturn((int) '0');
        when(mockInputData.readUnsignedByte()).thenReturn((int) '0');
        assertEquals('\u0100', parser._decodeEscaped());
    }

    @Test
    public void testDecodeEscaped_UnrecognizedCharacter() throws IOException {
        when(mockInputData.readUnsignedByte()).thenReturn((int) 'x');
        when(mockInputData.readUnsignedByte()).thenThrow(new IOException("Unexpected character"));
        try {
            parser._decodeEscaped();
        } catch (IOException e) {
            assertEquals("Unexpected character", e.getMessage());
        }
    }
}
