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

public class XPathParser_jj_3R_111_71_0_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    public void setUp() {
        // Initialize the token manager and parser with a mock SimpleCharStream
        SimpleCharStream stream = mock(SimpleCharStream.class);
        tokenManager = new XPathParserTokenManager(stream);
        parser = new XPathParser(tokenManager);
    }

    @Test
    public void testJj_3R_111_WithToken() throws Exception {
        // Simulate the condition where the token is AXIS_PRECEDING_SIBLING
        InputStream inputStream = new ByteArrayInputStream("preceding-sibling::node()".getBytes());
        parser.ReInit(inputStream);
        // Set the token to simulate the expected condition
        parser.token = new Token();
        parser.token.kind = XPathParser.AXIS_PRECEDING_SIBLING;
        // Use reflection to set private fields
        setPrivateField(parser, "jj_scanpos", parser.token);
        // Invoke the private method using reflection
        boolean result = invokePrivateMethod(parser, "jj_3R_111");
        // Assert that the result is true
        assertTrue(result);
    }

    @Test
    public void testJj_3R_111_WithoutToken() throws Exception {
        // Simulate the condition where the token is not AXIS_PRECEDING_SIBLING
        InputStream inputStream = new ByteArrayInputStream("some-other-node()".getBytes());
        parser.ReInit(inputStream);
        // Set the token to simulate a different condition
        parser.token = new Token();
        // Invalid token type
        parser.token.kind = -1;
        // Use reflection to set private fields
        setPrivateField(parser, "jj_scanpos", parser.token);
        // Invoke the private method using reflection
        boolean result = invokePrivateMethod(parser, "jj_3R_111");
        // Assert that the result is false
        assertFalse(result);
    }

    private boolean invokePrivateMethod(XPathParser parser, String methodName) throws Exception {
        java.lang.reflect.Method method = XPathParser.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return (boolean) method.invoke(parser);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
