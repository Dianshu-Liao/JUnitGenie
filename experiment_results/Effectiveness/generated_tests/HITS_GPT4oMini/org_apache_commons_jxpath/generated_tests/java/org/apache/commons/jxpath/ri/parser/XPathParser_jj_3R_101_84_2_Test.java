package org.apache.commons.jxpath.ri.parser;

import org.apache.commons.jxpath.ri.parser.XPathParserTokenManager;
import org.apache.commons.jxpath.ri.parser.Token;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

public class XPathParser_jj_3R_101_84_2_Test {

    private XPathParser parser;

    private Token mockToken;

    @BeforeEach
    public void setUp() {
        XPathParserTokenManager tokenManager = mock(XPathParserTokenManager.class);
        parser = new XPathParser(tokenManager);
        mockToken = mock(Token.class);
    }

    @Test
    public void testJj_3R_101_WithChildAxis() throws Exception {
        setPrivateField(parser, "jj_scanpos", mockToken);
        setPrivateField(parser, "jj_lastpos", mockToken);
        setPrivateField(parser, "jj_kind", XPathParser.AXIS_CHILD);
        boolean result = invokePrivateJj_3R_101(parser);
        assertTrue(result, "Expected jj_3R_101 to return true when AXIS_CHILD is scanned.");
    }

    @Test
    public void testJj_3R_101_WithoutChildAxis() throws Exception {
        setPrivateField(parser, "jj_scanpos", mockToken);
        setPrivateField(parser, "jj_lastpos", mockToken);
        setPrivateField(parser, "jj_kind", -1);
        boolean result = invokePrivateJj_3R_101(parser);
        assertFalse(result, "Expected jj_3R_101 to return false when AXIS_CHILD is not scanned.");
    }

    private boolean invokePrivateJj_3R_101(XPathParser parser) {
        try {
            java.lang.reflect.Method method = XPathParser.class.getDeclaredMethod("jj_3R_101");
            method.setAccessible(true);
            return (boolean) method.invoke(parser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
