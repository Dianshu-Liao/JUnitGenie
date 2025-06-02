package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharTypes;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class ReaderBasedJsonParser__skipLine_63_0_Test {

    private ReaderBasedJsonParser parser;

    private IOContext ioContext;

    private CharsToNameCanonicalizer canonicalizer;

    @BeforeEach
    public void setUp() {
        ioContext = new IOContext(StreamReadConstraints.defaults(), null, null, true);
        // Using the static method to create a root instance
        canonicalizer = CharsToNameCanonicalizer.createRoot();
        String input = "First line\nSecond line\nThird line";
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader(input), null, canonicalizer);
    }

    @Test
    public void testSkipLine() throws Exception {
        // Use reflection to access the private _skipLine method
        invokePrivateMethod(parser, "_skipLine");
        assertEquals(1, getCurrentRow(parser));
        invokePrivateMethod(parser, "_skipLine");
        assertEquals(2, getCurrentRow(parser));
        invokePrivateMethod(parser, "_skipLine");
        assertEquals(3, getCurrentRow(parser));
    }

    private void invokePrivateMethod(ReaderBasedJsonParser parser, String methodName) throws Exception {
        java.lang.reflect.Method method = ReaderBasedJsonParser.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(parser);
    }

    private int getCurrentRow(ReaderBasedJsonParser parser) throws Exception {
        java.lang.reflect.Field field = ReaderBasedJsonParser.class.getDeclaredField("_currInputRow");
        field.setAccessible(true);
        return (int) field.get(parser);
    }
}
