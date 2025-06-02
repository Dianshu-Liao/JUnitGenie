package org.apache.commons.jxpath.ri.parser;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.StringReader;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

public class XPathParser_jj_3R_132_48_0_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    public void setUp() {
        SimpleCharStream charStream = new SimpleCharStream(new StringReader(""));
        tokenManager = new XPathParserTokenManager(charStream);
        parser = new XPathParser(tokenManager);
    }

    private boolean invokeJj3R132() throws Exception {
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_132");
        method.setAccessible(true);
        return (boolean) method.invoke(parser);
    }

    @Test
    public void testJj_3R_132_WithMinusToken() throws Exception {
        tokenManager.setDebugStream(System.out);
        parser.token = new Token();
        parser.token.kind = XPathParserTokenManager.MINUS;
        parser.jj_nt = parser.token;
        boolean result = invokeJj3R132();
        assertTrue(result, "Expected true when the token is a minus token");
    }

    @Test
    public void testJj_3R_132_WithNonMinusToken() throws Exception {
        parser.token = new Token();
        parser.token.kind = XPathParserTokenManager.PLUS;
        parser.jj_nt = parser.token;
        boolean result = invokeJj3R132();
        assertFalse(result, "Expected false when the token is not a minus token");
    }

    @Test
    public void testJj_3R_132_WithNullToken() throws Exception {
        parser.token = null;
        parser.jj_nt = null;
        boolean result = invokeJj3R132();
        assertFalse(result, "Expected false when there is no token");
    }

    @Test
    public void testJj_3R_132_WithMultipleTokens() throws Exception {
        parser.token = new Token();
        parser.token.kind = XPathParserTokenManager.MINUS;
        parser.jj_nt = new Token();
        parser.jj_nt.kind = XPathParserTokenManager.PLUS;
        parser.jj_nt.next = null;
        boolean result = invokeJj3R132();
        assertTrue(result, "Expected true when the first token is a minus token");
    }
}
