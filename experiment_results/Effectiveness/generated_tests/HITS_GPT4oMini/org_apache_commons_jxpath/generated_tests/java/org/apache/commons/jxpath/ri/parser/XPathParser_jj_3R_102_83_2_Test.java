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

public class XPathParser_jj_3R_102_83_2_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    public void setUp() {
        tokenManager = Mockito.mock(XPathParserTokenManager.class);
        parser = new XPathParser(tokenManager);
    }

    private boolean invokeJj_3R_102() throws Exception {
        Method method = XPathParser.class.getDeclaredMethod("jj_3R_102");
        method.setAccessible(true);
        return (boolean) method.invoke(parser);
    }

    private void setJjScanToken(boolean returnValue) throws Exception {
        Method method = XPathParser.class.getDeclaredMethod("jj_scan_token", int.class);
        method.setAccessible(true);
        Mockito.when(method.invoke(parser, XPathParser.AXIS_PARENT)).thenReturn(returnValue);
    }

    @Test
    public void testJj_3R_102_ReturnsTrue_WhenAxisParentTokenIsScanned() throws Exception {
        // Arrange
        setJjScanToken(true);
        // Act
        boolean result = invokeJj_3R_102();
        // Assert
        assertTrue(result, "Expected jj_3R_102 to return true when AXIS_PARENT token is scanned.");
    }

    @Test
    public void testJj_3R_102_ReturnsFalse_WhenAxisParentTokenIsNotScanned() throws Exception {
        // Arrange
        setJjScanToken(false);
        // Act
        boolean result = invokeJj_3R_102();
        // Assert
        assertFalse(result, "Expected jj_3R_102 to return false when AXIS_PARENT token is not scanned.");
    }
}
