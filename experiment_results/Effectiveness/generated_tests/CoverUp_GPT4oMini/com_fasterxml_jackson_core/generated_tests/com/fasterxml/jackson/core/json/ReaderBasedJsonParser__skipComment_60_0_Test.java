package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.io.IOContext;
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

    @BeforeEach
    public void setUp() {
        // Setup for the test
        IOContext ioContext = new IOContext(StreamReadConstraints.defaults(), null, null, null, null, true);
        CharsToNameCanonicalizer symbols = CharsToNameCanonicalizer.createRoot();
        String input = "// This is a comment\n{\"key\":\"value\"}";
        StringReader stringReader = new StringReader(input);
        parser = new ReaderBasedJsonParser(ioContext, JsonParser.Feature.ALLOW_COMMENTS.getMask(), stringReader, null, symbols);
    }

    @Test
    public void testSkipLineComment() throws Exception {
        // Invoke the private method _skipComment() using reflection
        invokePrivateMethod("_skipComment");
        // Further assertions can be made based on the parser state if needed
    }

    @Test
    public void testSkipBlockComment() throws Exception {
        // Setup input with block comment
        String input = "/* This is a block comment */ {\"key\":\"value\"}";
        StringReader stringReader = new StringReader(input);
        parser = new ReaderBasedJsonParser(new IOContext(StreamReadConstraints.defaults(), null, null, null, null, true), JsonParser.Feature.ALLOW_COMMENTS.getMask(), stringReader, null, CharsToNameCanonicalizer.createRoot());
        // Invoke the private method _skipComment() using reflection
        invokePrivateMethod("_skipComment");
        // Further assertions can be made based on the parser state if needed
    }

    @Test
    public void testSkipCommentFeatureDisabled() {
        // Setup input with comment but without comment feature enabled
        String input = "// This is a comment\n{\"key\":\"value\"}";
        StringReader stringReader = new StringReader(input);
        parser = new // No comment feature enabled
        // No comment feature enabled
        ReaderBasedJsonParser(new IOContext(StreamReadConstraints.defaults(), null, null, null, null, true), 0, stringReader, null, CharsToNameCanonicalizer.createRoot());
        // Expect an exception when trying to skip comment
        assertThrows(IOException.class, () -> invokePrivateMethod("_skipComment"));
    }

    private void invokePrivateMethod(String methodName) throws Exception {
        java.lang.reflect.Method method = ReaderBasedJsonParser.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(parser);
    }
}
