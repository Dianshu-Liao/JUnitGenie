package org.apache.commons.jxpath.ri.parser;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

public class XPathParser_jj_3R_27_184_0_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    public void setUp() {
        tokenManager = mock(XPathParserTokenManager.class);
        parser = new XPathParser(tokenManager);
    }

    private boolean invokeJj3R27() throws Exception {
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_27");
        method.setAccessible(true);
        return (boolean) method.invoke(parser);
    }

    private void setJjScanTokenReturnValue(boolean returnValue) throws Exception {
        Method method = XPathParser.class.getDeclaredMethod("jj_scan_token", int.class);
        method.setAccessible(true);
        method.invoke(parser, XPathParserTokenManager.FUNCTION_LAST);
    }

    @Test
    public void testJj_3R_27_FunctionLastToken() throws Exception {
        // Arrange: Set up the token to be FUNCTION_LAST
        setJjScanTokenReturnValue(true);
        // Act: Invoke the method under test
        boolean result = invokeJj3R27();
        // Assert: Verify that the method returns true
        assertTrue(result);
    }

    @Test
    public void testJj_3R_27_NonFunctionLastToken() throws Exception {
        // Arrange: Set up the token to be something other than FUNCTION_LAST
        setJjScanTokenReturnValue(false);
        // Act: Invoke the method under test
        boolean result = invokeJj3R27();
        // Assert: Verify that the method returns false
        assertFalse(result);
    }
}
