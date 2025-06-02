package org.apache.commons.jxpath.ri.parser;

import org.apache.commons.jxpath.ri.Compiler;
import java.util.ArrayList;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class XPathParser_CoreFunctionCall_20_0_Test {

    private XPathParser parser;

    private Compiler mockCompiler;

    @BeforeEach
    public void setUp() {
        mockCompiler = mock(Compiler.class);
        parser = new XPathParser(new XPathParserTokenManager(new SimpleCharStream(System.in, 1, 1)));
        parser.setCompiler(mockCompiler);
    }

    @Test
    public void testCoreFunctionCall_WithNoArguments() throws ParseException {
        // Arrange
        when(parser.CoreFunctionName()).thenReturn(Compiler.FUNCTION_COUNT);
        when(parser.ArgumentList()).thenReturn(null);
        when(mockCompiler.function(Compiler.FUNCTION_COUNT, null)).thenReturn("Function Count Result");
        // Act
        Object result = parser.CoreFunctionCall();
        // Assert
        assertEquals("Function Count Result", result);
        verify(mockCompiler).function(Compiler.FUNCTION_COUNT, null);
    }

    @Test
    public void testCoreFunctionCall_WithArguments() throws ParseException {
        // Arrange
        ArrayList<Object> args = new ArrayList<>();
        args.add("arg1");
        args.add("arg2");
        when(parser.CoreFunctionName()).thenReturn(Compiler.FUNCTION_CONCAT);
        when(parser.ArgumentList()).thenReturn(args);
        when(mockCompiler.function(Compiler.FUNCTION_CONCAT, args.toArray())).thenReturn("Function Concat Result");
        // Act
        Object result = parser.CoreFunctionCall();
        // Assert
        assertEquals("Function Concat Result", result);
        verify(mockCompiler).function(Compiler.FUNCTION_CONCAT, args.toArray());
    }

    @Test
    public void testCoreFunctionCall_ThrowsErrorOnMissingReturn() throws ParseException {
        // Arrange
        when(parser.CoreFunctionName()).thenReturn(Compiler.FUNCTION_LAST);
        when(parser.ArgumentList()).thenThrow(new ParseException());
        // Act & Assert
        Exception exception = assertThrows(ParseException.class, () -> parser.CoreFunctionCall());
        assertEquals("Missing return statement in function", exception.getMessage());
    }
}
