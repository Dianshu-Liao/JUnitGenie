package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

public class XPathParser_jj_3R_45_163_0_Test {

    private XPathParser parser;

    @BeforeEach
    public void setUp() {
        parser = new XPathParser(new XPathParserTokenManager(new SimpleCharStream(new StringReader(""))));
    }

    @Test
    public void testJj_3R_45_WhenFunctionBooleanTokenIsPresent() throws Exception {
        // Set up the token source to return FUNCTION_BOOLEAN
        XPathParserTokenManager tokenManager = new XPathParserTokenManager(new SimpleCharStream(new StringReader("FUNCTION_BOOLEAN")));
        parser.token_source = tokenManager;
        setPrivateField(parser, "jj_scanpos", tokenManager.getNextToken());
        setPrivateField(parser, "jj_lastpos", tokenManager.getNextToken());
        // Invoke the method under test indirectly
        boolean result = invokePrivateMethod(parser, "jj_3R_45");
        // Assert that the method returns true
        assertTrue(result, "Expected jj_3R_45 to return true when FUNCTION_BOOLEAN token is present.");
    }

    @Test
    public void testJj_3R_45_WhenFunctionBooleanTokenIsNotPresent() throws Exception {
        // Set up the token source to return a different token
        XPathParserTokenManager tokenManager = new XPathParserTokenManager(new SimpleCharStream(new StringReader("SOME_OTHER_TOKEN")));
        parser.token_source = tokenManager;
        setPrivateField(parser, "jj_scanpos", tokenManager.getNextToken());
        setPrivateField(parser, "jj_lastpos", tokenManager.getNextToken());
        // Invoke the method under test indirectly
        boolean result = invokePrivateMethod(parser, "jj_3R_45");
        // Assert that the method returns false
        assertFalse(result, "Expected jj_3R_45 to return false when FUNCTION_BOOLEAN token is not present.");
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private boolean invokePrivateMethod(Object obj, String methodName) throws Exception {
        return (boolean) obj.getClass().getDeclaredMethod(methodName).invoke(obj);
    }
}
