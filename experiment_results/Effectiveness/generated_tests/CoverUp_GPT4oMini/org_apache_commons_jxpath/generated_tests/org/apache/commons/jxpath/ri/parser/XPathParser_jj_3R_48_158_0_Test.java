package org.apache.commons.jxpath.ri.parser;

import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.XPathParserTokenManager;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
class XPathParser_jj_3R_48_158_0_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    void setUp() {
        // Initialize the token manager with a SimpleCharStream
        SimpleCharStream charStream = new SimpleCharStream(new ByteArrayInputStream(new byte[0]), 1, 1);
        tokenManager = new XPathParserTokenManager(charStream);
        // Initialize the parser with the token manager
        parser = new XPathParser(tokenManager);
    }

    @Test
    void testJj_3R_48_FunctionFalse() throws Exception {
        // Mock the token source to return FUNCTION_FALSE token
        InputStream stream = new ByteArrayInputStream("FUNCTION_FALSE".getBytes());
        parser.ReInit(stream);
        // Use reflection to call the private method jj_3R_48
        boolean result = invokeJj3R48(parser);
        // Assert that the method returns true when FUNCTION_FALSE is encountered
        assertTrue(result);
    }

    @Test
    void testJj_3R_48_NotFunctionFalse() throws Exception {
        // Mock the token source to return a different token
        InputStream stream = new ByteArrayInputStream("SOME_OTHER_TOKEN".getBytes());
        parser.ReInit(stream);
        // Use reflection to call the private method jj_3R_48
        boolean result = invokeJj3R48(parser);
        // Assert that the method returns false when FUNCTION_FALSE is not encountered
        assertFalse(result);
    }

    private boolean invokeJj3R48(XPathParser parser) throws Exception {
        java.lang.reflect.Method method = XPathParser.class.getDeclaredMethod("jj_3R_48");
        method.setAccessible(true);
        return (boolean) method.invoke(parser);
    }
}
