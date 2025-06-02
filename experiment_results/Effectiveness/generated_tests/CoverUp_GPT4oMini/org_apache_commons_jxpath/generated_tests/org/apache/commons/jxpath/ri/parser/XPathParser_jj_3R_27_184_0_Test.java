package org.apache.commons.jxpath.ri.parser;

import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.XPathParserTokenManager;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class XPathParser_jj_3R_27_184_0_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    public void setUp() {
        // Initialize the token manager and parser with a dummy input stream
        String input = "function:last()";
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        tokenManager = new XPathParserTokenManager(new SimpleCharStream(stream));
        parser = new XPathParser(tokenManager);
    }

    @Test
    public void testJj_3R_27_FunctionLastToken() throws Exception {
        // Set up the initial state of the parser to expect FUNCTION_LAST token
        parser.token = new Token();
        parser.token.kind = XPathParserTokenManager.FUNCTION_LAST;
        // Use reflection to access the private method
        boolean result = invokeJj3R27(parser);
        // Verify that the method returns true for FUNCTION_LAST token
        assertTrue(result);
    }

    @Test
    public void testJj_3R_27_NonFunctionLastToken() throws Exception {
        // Set up the initial state of the parser to expect a different token
        parser.token = new Token();
        // Simulate a different token
        parser.token.kind = -1;
        // Use reflection to access the private method
        boolean result = invokeJj3R27(parser);
        // Verify that the method returns false for non FUNCTION_LAST token
        assertFalse(result);
    }

    private boolean invokeJj3R27(XPathParser parser) throws Exception {
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_27");
        method.setAccessible(true);
        return (boolean) method.invoke(parser);
    }
}
