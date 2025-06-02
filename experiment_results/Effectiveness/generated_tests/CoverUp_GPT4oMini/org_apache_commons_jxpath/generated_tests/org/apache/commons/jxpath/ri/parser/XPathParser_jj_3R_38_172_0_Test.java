package org.apache.commons.jxpath.ri.parser;

import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.parser.ParseException;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.XPathParserTokenManager;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
class XPathParser_jj_3R_38_172_0_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    void setUp() {
        // Initialize the token manager and parser with a valid InputStream
        tokenManager = new XPathParserTokenManager(new SimpleCharStream(new ByteArrayInputStream(new byte[0])));
        parser = new XPathParser(tokenManager);
    }

    @Test
    void testJj_3R_38_FunctionContainsToken() throws Exception {
        // Simulate input stream with FUNCTION_CONTAINS token
        String input = "contains";
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        parser.ReInit(stream);
        // Use reflection to invoke the private method
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_38");
        method.setAccessible(true);
        // Simulate the condition where FUNCTION_CONTAINS token is present
        parser.token = new Token();
        parser.token.kind = Compiler.FUNCTION_CONTAINS;
        boolean result = (Boolean) method.invoke(parser);
        assertTrue(result);
    }

    @Test
    void testJj_3R_38_NoFunctionContainsToken() throws Exception {
        // Simulate input stream without FUNCTION_CONTAINS token
        String input = "someOtherFunction";
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        parser.ReInit(stream);
        // Use reflection to invoke the private method
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_38");
        method.setAccessible(true);
        // Simulate the condition where FUNCTION_CONTAINS token is not present
        parser.token = new Token();
        // Not FUNCTION_CONTAINS
        parser.token.kind = Compiler.FUNCTION_LAST;
        boolean result = (Boolean) method.invoke(parser);
        assertFalse(result);
    }
}
