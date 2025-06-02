package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

public class XPathParser_jj_3R_50_154_1_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    private static final int FUNCTION_LANG = 1;

    private static final int OTHER_TOKEN_TYPE = 2;

    @BeforeEach
    public void setUp() {
        StringReader stringReader = new StringReader("functionLang");
        SimpleCharStream charStream = new SimpleCharStream(stringReader);
        tokenManager = new XPathParserTokenManager(charStream);
        parser = new XPathParser(tokenManager);
    }

    @Test
    public void testJj_3R_50_ReturnsTrue_WhenFunctionLangTokenIsMatched() throws Exception {
        setPrivateField(parser, "jj_scanpos", createToken(FUNCTION_LANG));
        boolean result = invokePrivateMethod(parser, "jj_3R_50");
        assertTrue(result, "Expected jj_3R_50 to return true when FUNCTION_LANG is matched.");
    }

    @Test
    public void testJj_3R_50_ReturnsFalse_WhenFunctionLangTokenIsNotMatched() throws Exception {
        setPrivateField(parser, "jj_scanpos", createToken(OTHER_TOKEN_TYPE));
        boolean result = invokePrivateMethod(parser, "jj_3R_50");
        assertFalse(result, "Expected jj_3R_50 to return false when FUNCTION_LANG is not matched.");
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private boolean invokePrivateMethod(Object obj, String methodName) throws Exception {
        java.lang.reflect.Method method = obj.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        return (boolean) method.invoke(obj);
    }

    private Token createToken(int tokenType) {
        // Create a new Token object based on the token type
        Token token = new Token();
        token.kind = tokenType;
        return token;
    }
}
