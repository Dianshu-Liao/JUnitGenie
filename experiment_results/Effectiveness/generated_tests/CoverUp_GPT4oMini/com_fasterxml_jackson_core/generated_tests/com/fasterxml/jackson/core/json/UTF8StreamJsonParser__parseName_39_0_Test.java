package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8StreamJsonParser__parseName_39_0_Test {

    private UTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer symbols;

    private byte[] inputBuffer;

    @BeforeEach
    public void setUp() {
        symbols = ByteQuadsCanonicalizer.createRoot();
        inputBuffer = new byte[128];
        IOContext ioContext = new IOContext(new BufferRecycler(), null, true);
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(inputBuffer), null, symbols, inputBuffer, 0, inputBuffer.length, true);
    }

    @Test
    public void testParseNameWithQuote() throws Exception {
        inputBuffer[0] = (byte) '"';
        inputBuffer[1] = 't';
        inputBuffer[2] = 'e';
        inputBuffer[3] = 's';
        inputBuffer[4] = 't';
        inputBuffer[5] = (byte) '"';
        setInputPtrAndEnd(0, 6);
        String name = invokeParseName(34);
        assertEquals("test", name);
    }

    @Test
    public void testParseNameWithOddCharacter() throws Exception {
        inputBuffer[0] = (byte) 't';
        inputBuffer[1] = (byte) 'e';
        inputBuffer[2] = (byte) 's';
        inputBuffer[3] = (byte) 't';
        setInputPtrAndEnd(0, 4);
        String name = invokeParseName('t');
        assertEquals("test", name);
    }

    @Test
    public void testParseNameEmpty() throws Exception {
        inputBuffer[0] = (byte) '"';
        inputBuffer[1] = (byte) '"';
        setInputPtrAndEnd(0, 2);
        String name = invokeParseName(34);
        assertEquals("", name);
    }

    private void setInputPtrAndEnd(int ptr, int end) throws Exception {
        java.lang.reflect.Field inputPtrField = UTF8StreamJsonParser.class.getDeclaredField("_inputPtr");
        java.lang.reflect.Field inputEndField = UTF8StreamJsonParser.class.getDeclaredField("_inputEnd");
        inputPtrField.setAccessible(true);
        inputEndField.setAccessible(true);
        inputPtrField.setInt(parser, ptr);
        inputEndField.setInt(parser, end);
    }

    private String invokeParseName(int i) throws Exception {
        java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_parseName", int.class);
        method.setAccessible(true);
        return (String) method.invoke(parser, i);
    }
}
