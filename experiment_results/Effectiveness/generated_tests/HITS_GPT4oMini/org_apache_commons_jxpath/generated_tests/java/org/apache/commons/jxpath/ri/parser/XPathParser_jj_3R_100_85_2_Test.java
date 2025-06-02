package org.apache.commons.jxpath.ri.parser;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

public class XPathParser_jj_3R_100_85_2_Test {

    private XPathParser xpathParser;

    @Mock
    private XPathParserTokenManager tokenManager;

    @Mock
    private Token axisSelfToken;

    @Mock
    private Token nonAxisSelfToken;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        xpathParser = new XPathParser(tokenManager);
    }

    @Test
    public void testJj_3R_100_WithAxisSelfToken() throws Exception {
        // Arrange
        when(axisSelfToken.kind).thenReturn(XPathParser.AXIS_SELF);
        when(tokenManager.getNextToken()).thenReturn(axisSelfToken);
        // Act
        boolean result = invokeJj_3R_100();
        // Assert
        assertTrue(result, "Expected jj_3R_100() to return true when AXIS_SELF token is scanned.");
    }

    @Test
    public void testJj_3R_100_WithoutAxisSelfToken() throws Exception {
        // Arrange
        // Assuming -1 is not AXIS_SELF
        when(nonAxisSelfToken.kind).thenReturn(-1);
        when(tokenManager.getNextToken()).thenReturn(nonAxisSelfToken);
        // Act
        boolean result = invokeJj_3R_100();
        // Assert
        assertFalse(result, "Expected jj_3R_100() to return false when AXIS_SELF token is not scanned.");
    }

    // Helper method to invoke the private method using reflection
    private boolean invokeJj_3R_100() throws Exception {
        java.lang.reflect.Method method = XPathParser.class.getDeclaredMethod("jj_3R_100");
        method.setAccessible(true);
        return (boolean) method.invoke(xpathParser);
    }
}
