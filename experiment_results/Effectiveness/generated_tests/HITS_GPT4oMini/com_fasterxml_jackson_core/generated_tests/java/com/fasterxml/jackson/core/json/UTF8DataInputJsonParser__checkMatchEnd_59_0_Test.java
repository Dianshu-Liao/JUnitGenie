package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import java.lang.reflect.Method;
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
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8DataInputJsonParser__checkMatchEnd_59_0_Test {

    private UTF8DataInputJsonParser parser;

    private ByteQuadsCanonicalizer symbols;

    private DataInput inputData;

    @BeforeEach
    public void setUp() {
        symbols = ByteQuadsCanonicalizer.createRoot();
        inputData = new DataInputStream(new ByteArrayInputStream(new byte[0]));
        IOContext context = new IOContext(null, inputData, true);
        parser = new UTF8DataInputJsonParser(context, 0, inputData, null, symbols, 0);
    }

    private void invokeCheckMatchEnd(String matchStr, int i, int ch) throws Exception {
        Method method = UTF8DataInputJsonParser.class.getDeclaredMethod("_checkMatchEnd", String.class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(parser, matchStr, i, ch);
    }

    @Test
    public void testCheckMatchEnd_WithValidIdentifierPart() {
        assertThrows(IOException.class, () -> {
            invokeCheckMatchEnd("validToken", 5, 'a');
        });
    }

    @Test
    public void testCheckMatchEnd_WithInvalidIdentifierPart() {
        assertThrows(IOException.class, () -> {
            invokeCheckMatchEnd("invalidToken", 5, ' ');
        });
    }

    @Test
    public void testCheckMatchEnd_WithSpecialCharacter() {
        assertThrows(IOException.class, () -> {
            invokeCheckMatchEnd("specialToken", 6, '!');
        });
    }

    @Test
    public void testCheckMatchEnd_WithDigit() {
        assertThrows(IOException.class, () -> {
            invokeCheckMatchEnd("digitToken", 4, '1');
        });
    }

    @Test
    public void testCheckMatchEnd_WithUnderscore() {
        assertThrows(IOException.class, () -> {
            invokeCheckMatchEnd("underscoreToken", 6, '_');
        });
    }
}
