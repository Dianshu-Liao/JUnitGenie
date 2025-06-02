package org.apache.commons.jxpath.ri.parser;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

public class XPathParser_jj_3R_38_172_1_Test {

    private XPathParser parser;

    private Token mockTokenContains;

    private Token mockTokenOther;

    @BeforeEach
    public void setUp() throws Exception {
        // Mocking the dependencies
        XPathParserTokenManager tokenManager = mock(XPathParserTokenManager.class);
        parser = new XPathParser(tokenManager);
        // Create mock tokens
        mockTokenContains = mock(Token.class);
        mockTokenOther = mock(Token.class);
        // Set up reflection to access private fields
        Field scanPosField = XPathParser.class.getDeclaredField("jj_scanpos");
        Field lastPosField = XPathParser.class.getDeclaredField("jj_lastpos");
        scanPosField.setAccessible(true);
        lastPosField.setAccessible(true);
        // Assign mock tokens to the private fields
        scanPosField.set(parser, mockTokenContains);
        lastPosField.set(parser, mockTokenOther);
    }

    @Test
    public void testJj_3R_38_FunctionContainsTokenFound() throws Exception {
        // Setup: Simulate FUNCTION_CONTAINS token
        // Assuming 1 represents FUNCTION_CONTAINS
        when(mockTokenContains.kind).thenReturn(1);
        when(parser.token_source.getNextToken()).thenReturn(mockTokenContains);
        // Execute: Call the method under test through a public wrapper
        boolean result = invokeJj_3R_38();
        // Verify: The method should return true
        assertTrue(result, "Expected jj_3R_38 to return true when FUNCTION_CONTAINS token is found.");
    }

    @Test
    public void testJj_3R_38_FunctionContainsTokenNotFound() throws Exception {
        // Setup: Simulate a different token
        // Assuming 2 represents some other token
        when(mockTokenContains.kind).thenReturn(2);
        when(parser.token_source.getNextToken()).thenReturn(mockTokenContains);
        // Execute: Call the method under test through a public wrapper
        boolean result = invokeJj_3R_38();
        // Verify: The method should return false
        assertFalse(result, "Expected jj_3R_38 to return false when FUNCTION_CONTAINS token is not found.");
    }

    private boolean invokeJj_3R_38() throws Exception {
        // Using reflection to invoke the private method
        Field field = XPathParser.class.getDeclaredField("jj_scanpos");
        field.setAccessible(true);
        return (boolean) field.get(parser);
    }
}
