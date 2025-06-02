package org.apache.commons.jxpath.ri.parser;

import org.apache.commons.jxpath.ri.Compiler;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class XPathParser_SubtractiveExpr_31_0_Test {

    private XPathParser parser;

    private Compiler mockCompiler;

    @BeforeEach
    public void setUp() {
        // Create a mock Compiler
        mockCompiler = mock(Compiler.class);
        parser = new XPathParser(new XPathParserTokenManager(new SimpleCharStream(System.in, 1, 1)));
        parser.setCompiler(mockCompiler);
    }

    @Test
    public void testSubtractiveExprSingleMinus() throws Exception {
        // Arrange
        Object leftValue = 10;
        Object rightValue = 5;
        when(parser.MultiplicativeExpr()).thenReturn(leftValue).thenReturn(rightValue);
        when(mockCompiler.minus(leftValue, rightValue)).thenReturn(5);
        // Act
        Object result = parser.SubtractiveExpr();
        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testSubtractiveExprMultipleMinuses() throws Exception {
        // Arrange
        Object firstValue = 20;
        Object secondValue = 5;
        Object thirdValue = 3;
        when(parser.MultiplicativeExpr()).thenReturn(firstValue).thenReturn(secondValue).thenReturn(thirdValue);
        when(mockCompiler.minus(firstValue, secondValue)).thenReturn(15);
        when(mockCompiler.minus(15, thirdValue)).thenReturn(12);
        // Act
        Object result = parser.SubtractiveExpr();
        // Assert
        assertEquals(12, result);
    }

    @Test
    public void testSubtractiveExprNoMinus() throws Exception {
        // Arrange
        Object value = 10;
        when(parser.MultiplicativeExpr()).thenReturn(value);
        // Act
        Object result = parser.SubtractiveExpr();
        // Assert
        assertEquals(value, result);
    }
}
