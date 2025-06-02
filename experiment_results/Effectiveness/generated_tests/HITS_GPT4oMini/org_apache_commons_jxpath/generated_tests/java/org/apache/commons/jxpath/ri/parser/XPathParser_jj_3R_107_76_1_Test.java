package org.apache.commons.jxpath.ri.parser;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.ByteArrayInputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

public class XPathParser_jj_3R_107_76_1_Test {

    private XPathParser parser;

    // Mocked TokenType for testing
    enum TokenType {

        AXIS_FOLLOWING, OTHER
    }

    // Mocked Token class for testing
    static class Token {

        TokenType type;

        String value;

        Token(TokenType type, String value) {
            this.type = type;
            this.value = value;
        }
    }

    @BeforeEach
    public void setUp() {
        parser = new XPathParser(new ByteArrayInputStream("AXIS_FOLLOWING".getBytes()));
        parser.token_source = new XPathParserTokenManager(new SimpleCharStream(new ByteArrayInputStream("AXIS_FOLLOWING".getBytes()), 1, 1, 1));
    }

    @Test
    public void testJj_3R_107_WithAxisFollowingToken() throws Exception {
        Token axisFollowingToken = new Token(TokenType.AXIS_FOLLOWING, "AXIS_FOLLOWING");
        setPrivateField(parser, "jj_scanpos", axisFollowingToken);
        setPrivateField(parser, "jj_lastpos", axisFollowingToken);
        boolean result = invokePrivateMethod(parser, "jj_3R_107");
        assertTrue(result, "Expected jj_3R_107 to return true when AXIS_FOLLOWING token is present.");
    }

    @Test
    public void testJj_3R_107_WithoutAxisFollowingToken() throws Exception {
        Token otherToken = new Token(TokenType.OTHER, "OTHER_TOKEN");
        setPrivateField(parser, "jj_scanpos", otherToken);
        setPrivateField(parser, "jj_lastpos", otherToken);
        boolean result = invokePrivateMethod(parser, "jj_3R_107");
        assertFalse(result, "Expected jj_3R_107 to return false when AXIS_FOLLOWING token is not present.");
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
}
