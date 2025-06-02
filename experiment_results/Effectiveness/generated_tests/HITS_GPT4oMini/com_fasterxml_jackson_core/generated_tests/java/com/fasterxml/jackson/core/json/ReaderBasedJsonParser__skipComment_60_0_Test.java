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

public class ReaderBasedJsonParser__skipComment_60_0_Test {

    private ReaderBasedJsonParser parser;

    private IOContext ioContext;

    private CharsToNameCanonicalizer symbols;

    @BeforeEach
    public void setUp() {
        ioContext = new IOContext(StreamReadConstraints.defaults(), null, null, null, null, false);
        symbols = CharsToNameCanonicalizer.createRoot();
        char[] inputBuffer = new char[1024];
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader(""), null, symbols, inputBuffer, 0, 0, true);
    }

    @Test
    public void testSkipComment_throwsException_whenJavaCommentsNotAllowed() {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("// This is a comment"), null, symbols, new char[1024], 0, 0, true);
        assertThrows(JsonParseException.class, () -> {
            parser.nextToken();
        });
    }

    @Test
    public void testSkipComment_doesNotThrowException_whenJavaCommentsAllowed() throws IOException {
        parser = new ReaderBasedJsonParser(ioContext, ReaderBasedJsonParser.FEAT_MASK_ALLOW_JAVA_COMMENTS, new StringReader("// This is a comment\n"), null, symbols, new char[1024], 0, 0, true);
        parser.nextToken();
        // Check the state of the parser after skipping the comment
        assertEquals(0, getInputPtr(parser));
    }

    @Test
    public void testSkipComment_throwsException_onUnexpectedChar() {
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("/ unexpected character"), null, symbols, new char[1024], 0, 0, true);
        assertThrows(JsonParseException.class, () -> {
            parser.nextToken();
        });
    }

    // Helper method to expose the protected _inputPtr for testing
    private int getInputPtr(ReaderBasedJsonParser parser) {
        try {
            java.lang.reflect.Field field = ReaderBasedJsonParser.class.getDeclaredField("_inputPtr");
            field.setAccessible(true);
            return (int) field.get(parser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
