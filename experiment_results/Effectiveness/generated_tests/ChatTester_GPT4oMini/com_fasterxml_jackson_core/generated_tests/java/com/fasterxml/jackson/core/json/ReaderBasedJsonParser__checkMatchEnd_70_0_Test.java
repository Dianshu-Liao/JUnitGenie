package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class ReaderBasedJsonParser__checkMatchEnd_70_0_Test {

    private ReaderBasedJsonParser parser;

    @BeforeEach
    public void setUp() {
        // Mock dependencies as needed
        IOContext ioContext = mock(IOContext.class);
        ObjectCodec objectCodec = mock(ObjectCodec.class);
        CharsToNameCanonicalizer charsToNameCanonicalizer = mock(CharsToNameCanonicalizer.class);
        Reader reader = mock(Reader.class);
        // Instantiate the ReaderBasedJsonParser with mocked dependencies
        parser = new ReaderBasedJsonParser(ioContext, 0, reader, objectCodec, charsToNameCanonicalizer);
    }

    @Test
    public void testCheckMatchEnd_WithValidIdentifierPart() throws Exception {
        // Prepare the inputs
        String matchStr = "validToken";
        int i = matchStr.length();
        // 'a' is a valid Java identifier part
        int c = 'a';
        Method method = ReaderBasedJsonParser.class.getDeclaredMethod("_checkMatchEnd", String.class, int.class, int.class);
        method.setAccessible(true);
        // This should not throw an exception
        method.invoke(parser, matchStr, i, c);
    }

    @Test
    public void testCheckMatchEnd_WithInvalidIdentifierPart() throws Exception {
        // Prepare the inputs
        String matchStr = "invalidToken";
        int i = matchStr.length();
        // '!' is not a valid Java identifier part
        int c = '!';
        Method method = ReaderBasedJsonParser.class.getDeclaredMethod("_checkMatchEnd", String.class, int.class, int.class);
        method.setAccessible(true);
        // This should throw an IOException
        assertThrows(IOException.class, () -> {
            method.invoke(parser, matchStr, i, c);
        });
    }
}
