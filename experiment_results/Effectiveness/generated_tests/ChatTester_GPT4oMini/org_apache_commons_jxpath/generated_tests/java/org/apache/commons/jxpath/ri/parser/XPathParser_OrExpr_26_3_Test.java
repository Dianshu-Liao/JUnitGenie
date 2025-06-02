package org.apache.commons.jxpath.ri.parser;

import java.util.ArrayList;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.Compiler;

public class XPathParser_OrExpr_26_3_Test {

    @Mock
    private Compiler compiler;

    @Mock
    private XPathParserTokenManager tokenManager;

    @InjectMocks
    private XPathParser xpathParser;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // Initialize the token for testing
        xpathParser.jj_nt = new Token();
        // Ensure there's a next token
        xpathParser.jj_nt.next = new Token();
    }

    @Test
    public void testOrExprWithSingleAndExpr() throws Exception {
        // Arrange
        // Set kind to OR
        xpathParser.jj_nt.kind = XPathParser.OR;
        // Mock AndExpr
        when(xpathParser.AndExpr()).thenReturn("expr1");
        // Act
        Object result = invokePrivateMethod("OrExpr");
        // Assert
        assertEquals("expr1", result);
        verify(compiler, never()).or(any());
    }

    @Test
    public void testOrExprWithMultipleAndExpr() throws Exception {
        // Arrange
        // Set kind to OR
        xpathParser.jj_nt.kind = XPathParser.OR;
        // Mock AndExpr
        when(xpathParser.AndExpr()).thenReturn("expr1").thenReturn("expr2");
        // Act
        Object result = invokePrivateMethod("OrExpr");
        // Assert
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("expr1");
        expectedList.add("expr2");
        verify(compiler).or(expectedList.toArray());
        assertEquals(expectedList.get(0), result);
    }

    @Test
    public void testOrExprWithNoOrToken() throws Exception {
        // Arrange
        // Simulating no OR token
        xpathParser.jj_nt.kind = -1;
        // Mock AndExpr
        when(xpathParser.AndExpr()).thenReturn("expr1");
        // Act
        Object result = invokePrivateMethod("OrExpr");
        // Assert
        assertEquals("expr1", result);
        verify(compiler, never()).or(any());
    }

    private Object invokePrivateMethod(String methodName) throws Exception {
        java.lang.reflect.Method method = XPathParser.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return method.invoke(xpathParser);
    }
}
