package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class ReaderBasedJsonParser__checkMatchEnd_70_0_Test {

    private ReaderBasedJsonParser parser;

    private IOContext ioContext;

    private CharsToNameCanonicalizer symbols;

    @BeforeEach
    public void setUp() {
        ioContext = new IOContext(null, null, null, null, null, false);
        symbols = CharsToNameCanonicalizer.createRoot();
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader(""), null, symbols);
    }

    private void checkMatchEnd(String matchStr, int i, int c) throws IOException {
        try {
            java.lang.reflect.Method method = ReaderBasedJsonParser.class.getDeclaredMethod("_checkMatchEnd", String.class, int.class, int.class);
            method.setAccessible(true);
            method.invoke(parser, matchStr, i, c);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new IOException("Reflection error: " + e.getMessage(), e);
        } catch (Throwable t) {
            throw new IOException("Unexpected error: " + t.getMessage(), t);
        }
    }

    @Test
    public void testCheckMatchEnd_ValidCharacter() {
        assertDoesNotThrow(() -> {
            checkMatchEnd("valid", 5, 'a');
        });
    }

    @Test
    public void testCheckMatchEnd_InvalidCharacter() {
        assertThrows(IOException.class, () -> {
            checkMatchEnd("invalid", 7, ' ');
        });
        assertThrows(IOException.class, () -> {
            checkMatchEnd("invalid", 7, '!');
        });
        assertThrows(IOException.class, () -> {
            checkMatchEnd("invalid", 7, '@');
        });
    }

    @Test
    public void testCheckMatchEnd_NumericCharacter() {
        assertDoesNotThrow(() -> {
            checkMatchEnd("valid123", 8, '1');
        });
    }

    @Test
    public void testCheckMatchEnd_EmptyString() {
        assertDoesNotThrow(() -> {
            checkMatchEnd("", 0, 'a');
        });
    }
}
