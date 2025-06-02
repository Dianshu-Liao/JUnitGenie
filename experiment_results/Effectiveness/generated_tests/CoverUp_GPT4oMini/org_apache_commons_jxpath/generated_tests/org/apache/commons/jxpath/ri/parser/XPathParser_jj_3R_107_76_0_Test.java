package org.apache.commons.jxpath.ri.parser;

import java.io.InputStream;
import java.io.Reader;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class XPathParser_jj_3R_107_76_0_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    public void setUp() {
        tokenManager = Mockito.mock(XPathParserTokenManager.class);
        parser = new XPathParser(tokenManager);
    }

    @Test
    public void testJj_3R_107_ScanTokenFollowing() throws Exception {
        // Setup mock behavior for token manager
        Token token = new Token();
        // Assuming AXIS_FOLLOWING is a constant
        token.kind = XPathParserTokenManager.AXIS_FOLLOWING;
        Mockito.when(tokenManager.getNextToken()).thenReturn(token);
        // Invoke the private method using reflection
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_107");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(parser);
        // Assert the result
        assertTrue(result, "Expected jj_3R_107 to return true when scanning AXIS_FOLLOWING token");
    }

    @Test
    public void testJj_3R_107_ScanTokenNotFollowing() throws Exception {
        // Setup mock behavior for token manager
        Token token = new Token();
        // Assuming AXIS_CHILD is a constant
        token.kind = XPathParserTokenManager.AXIS_CHILD;
        Mockito.when(tokenManager.getNextToken()).thenReturn(token);
        // Invoke the private method using reflection
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_107");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(parser);
        // Assert the result
        assertFalse(result, "Expected jj_3R_107 to return false when scanning non-AXIS_FOLLOWING token");
    }
}
