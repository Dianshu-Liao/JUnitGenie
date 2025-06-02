package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

class XPathParser_jj_3R_49_157_0_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    private static final int FUNCTION_NULL = 1;

    private static final int SOME_OTHER_TOKEN = 2;

    @BeforeEach
    void setUp() {
        SimpleCharStream charStream = new SimpleCharStream(new StringReader(""));
        tokenManager = new XPathParserTokenManager(charStream);
        parser = new XPathParser(tokenManager);
    }

    @Test
    void testJj_3R_49_FunctionNullToken() throws Exception {
        Token functionNullToken = new Token();
        setPrivateField(functionNullToken, "kind", FUNCTION_NULL);
        setCurrentToken(parser, functionNullToken);
        boolean result = invokePrivateMethod(parser, "jj_3R_49");
        assertTrue(result, "Expected true when the current token is FUNCTION_NULL");
    }

    @Test
    void testJj_3R_49_NonFunctionNullToken() throws Exception {
        Token otherToken = new Token();
        setPrivateField(otherToken, "kind", SOME_OTHER_TOKEN);
        setCurrentToken(parser, otherToken);
        boolean result = invokePrivateMethod(parser, "jj_3R_49");
        assertFalse(result, "Expected false when the current token is not FUNCTION_NULL");
    }

    private void setCurrentToken(XPathParser parser, Token token) throws Exception {
        Field jj_scanposField = parser.getClass().getDeclaredField("jj_scanpos");
        jj_scanposField.setAccessible(true);
        jj_scanposField.set(parser, token);
        Field jj_lastposField = parser.getClass().getDeclaredField("jj_lastpos");
        jj_lastposField.setAccessible(true);
        jj_lastposField.set(parser, token);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private boolean invokePrivateMethod(Object obj, String methodName) throws Exception {
        java.lang.reflect.Method method = obj.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        return (boolean) method.invoke(obj);
    }
}
