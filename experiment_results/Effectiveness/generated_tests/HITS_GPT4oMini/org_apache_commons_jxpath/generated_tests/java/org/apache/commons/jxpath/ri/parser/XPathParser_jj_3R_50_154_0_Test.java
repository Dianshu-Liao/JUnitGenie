package org.apache.commons.jxpath.ri.parser;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.StringReader;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

@ExtendWith(MockitoExtension.class)
public class XPathParser_jj_3R_50_154_0_Test {

    private XPathParser parser;

    @Mock
    private XPathParserTokenManager tokenManager;

    @BeforeEach
    public void setUp() {
        // Create a StringReader for SimpleCharStream
        StringReader stringReader = new StringReader("some input");
        SimpleCharStream charStream = new SimpleCharStream(stringReader);
        tokenManager = new XPathParserTokenManager(charStream);
        parser = new XPathParser(tokenManager);
    }

    @Test
    public void testJj_3R_50_FunctionLangTokenPresent() {
        // Create a Token instance using the no-argument constructor
        Token token = new Token();
        // Assuming 1 represents FUNCTION_LANG
        token.kind = 1;
        token.image = "functionLang";
        // Mock the token_source to return FUNCTION_LANG token
        when(tokenManager.getNextToken()).thenReturn(token);
        parser.token = tokenManager.getNextToken();
        assertTrue(invokeJj_3R_50(parser), "Expected jj_3R_50 to return true when FUNCTION_LANG token is present.");
    }

    @Test
    public void testJj_3R_50_FunctionLangTokenAbsent() {
        // Create a Token instance using the no-argument constructor
        Token token = new Token();
        // Assuming 2 represents OTHER_TOKEN
        token.kind = 2;
        token.image = "otherToken";
        // Mock the token_source to return a different token
        when(tokenManager.getNextToken()).thenReturn(token);
        parser.token = tokenManager.getNextToken();
        assertFalse(invokeJj_3R_50(parser), "Expected jj_3R_50 to return false when FUNCTION_LANG token is absent.");
    }

    private boolean invokeJj_3R_50(XPathParser parser) {
        try {
            java.lang.reflect.Method method = XPathParser.class.getDeclaredMethod("jj_3R_50");
            method.setAccessible(true);
            return (boolean) method.invoke(parser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
