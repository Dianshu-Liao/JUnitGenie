package org.apache.commons.jxpath.ri.parser;

import org.apache.commons.jxpath.ri.Compiler;
import java.util.ArrayList;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class XPathParser_CoreFunctionCall_20_2_Test {

    private XPathParser parser;

    private Compiler mockCompiler;

    @BeforeEach
    public void setUp() {
        mockCompiler = Mockito.mock(Compiler.class);
        parser = new XPathParser(new XPathParserTokenManager(new SimpleCharStream(System.in, 1, 1)));
        parser.setCompiler(mockCompiler);
    }

    @Test
    public void testCoreFunctionCallWithNullArgs() throws ParseException {
        when(mockCompiler.function(Compiler.FUNCTION_LAST, null)).thenReturn("Function Last Result");
        parser.token = new Token();
        // Simulate FUNCTION_LAST token
        parser.token.kind = Compiler.FUNCTION_LAST;
        // Simulate the token for closing parenthesis
        parser.jj_nt.kind = 82;
        Object result = parser.CoreFunctionCall();
        assertEquals("Function Last Result", result);
    }

    @Test
    public void testCoreFunctionCallWithArgs() throws ParseException {
        ArrayList<Object> args = new ArrayList<>();
        args.add("arg1");
        args.add("arg2");
        when(mockCompiler.function(Compiler.FUNCTION_COUNT, args.toArray())).thenReturn("Function Count Result");
        parser.token = new Token();
        // Simulate FUNCTION_COUNT token
        parser.token.kind = Compiler.FUNCTION_COUNT;
        // Simulate the token for open parenthesis
        parser.jj_nt.kind = 81;
        // Simulate the next token
        parser.jj_nt.next = new Token();
        // Simulate the token for closing parenthesis
        parser.jj_nt.next.kind = 82;
        Object result = parser.CoreFunctionCall();
        assertEquals("Function Count Result", result);
    }

    @Test
    public void testCoreFunctionCallWithInvalidFunction() {
        parser.token = new Token();
        // Invalid function token
        parser.token.kind = -1;
        assertThrows(ParseException.class, () -> {
            parser.CoreFunctionCall();
        });
    }

    @Test
    public void testCoreFunctionCallWithUnexpectedError() {
        parser.token = new Token();
        // Simulate FUNCTION_NAME token
        parser.token.kind = Compiler.FUNCTION_NAME;
        // Simulate the token for open parenthesis
        parser.jj_nt.kind = 81;
        // Simulate the next token
        parser.jj_nt.next = new Token();
        // Simulate the token for closing parenthesis
        parser.jj_nt.next.kind = 82;
        assertThrows(Error.class, () -> {
            parser.CoreFunctionCall();
        });
    }
}
