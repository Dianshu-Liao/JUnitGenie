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

public class XPathParser_jj_3R_111_71_0_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    public void setUp() {
        SimpleCharStream charStream = new SimpleCharStream(new StringReader(""));
        tokenManager = Mockito.mock(XPathParserTokenManager.class);
        parser = new XPathParser(tokenManager);
    }

    @Test
    public void testJj_3R_111_WhenAxisPrecedingSiblingTokenIsFound() {
        // Arrange: Create a mock Token for AXIS_PRECEDING_SIBLING
        // Using the default constructor
        Token axisPrecedingSiblingToken = new Token();
        // Assuming 'kind' is the field for token type
        axisPrecedingSiblingToken.kind = XPathParserTokenManager.AXIS_PRECEDING_SIBLING;
        Mockito.when(tokenManager.getNextToken()).thenReturn(axisPrecedingSiblingToken);
        // Act: Call the method under test using reflection
        boolean result = invokePrivateMethod("jj_3R_111");
        // Assert: Verify that the method returns true
        assertTrue(result, "Expected true when AXIS_PRECEDING_SIBLING token is found");
    }

    @Test
    public void testJj_3R_111_WhenAxisPrecedingSiblingTokenIsNotFound() {
        // Arrange: Create a mock Token for a different token
        // Using the default constructor
        Token differentToken = new Token();
        // Assuming this is a valid alternative token
        differentToken.kind = XPathParserTokenManager.AXIS_FOLLOWING_SIBLING;
        Mockito.when(tokenManager.getNextToken()).thenReturn(differentToken);
        // Act: Call the method under test using reflection
        boolean result = invokePrivateMethod("jj_3R_111");
        // Assert: Verify that the method returns false
        assertFalse(result, "Expected false when AXIS_PRECEDING_SIBLING token is not found");
    }

    private boolean invokePrivateMethod(String methodName) {
        try {
            java.lang.reflect.Method method = XPathParser.class.getDeclaredMethod(methodName);
            method.setAccessible(true);
            return (boolean) method.invoke(parser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
