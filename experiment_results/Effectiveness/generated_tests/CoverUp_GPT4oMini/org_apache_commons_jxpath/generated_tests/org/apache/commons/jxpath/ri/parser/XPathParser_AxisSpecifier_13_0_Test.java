package org.apache.commons.jxpath.ri.parser;

import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.parser.XPathParser;
import org.apache.commons.jxpath.ri.parser.XPathParserTokenManager;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
class XPathParser_AxisSpecifier_13_0_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    void setUp() {
        String input = "sample input for testing";
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        tokenManager = new XPathParserTokenManager(new SimpleCharStream(stream, 1, 1));
        parser = new XPathParser(tokenManager);
    }

    @Test
    void testAxisSpecifierWithValidAxisNames() throws Exception {
        parser.token = new Token();
        parser.token.kind = Compiler.AXIS_SELF;
        parser.jj_nt = parser.token;
        int result = parser.AxisSpecifier();
        assertEquals(Compiler.AXIS_SELF, result);
    }

    @Test
    void testAxisSpecifierWithDefaultCase() throws Exception {
        parser.token = new Token();
        parser.token.kind = -1;
        parser.jj_nt = parser.token;
        int result = parser.AxisSpecifier();
        assertEquals(Compiler.AXIS_CHILD, result);
    }

    @Test
    void testAxisSpecifierThrowsErrorOnMissingReturn() {
        parser.token = new Token();
        parser.token.kind = -1;
        parser.jj_nt = parser.token;
        Error exception = assertThrows(Error.class, () -> {
            invokeAxisSpecifier(parser);
        });
        String expectedMessage = "Missing return statement in function";
        assertEquals(expectedMessage, exception.getMessage());
    }

    private int invokeAxisSpecifier(XPathParser parser) throws Exception {
        Method method = XPathParser.class.getDeclaredMethod("AxisSpecifier");
        method.setAccessible(true);
        return (int) method.invoke(parser);
    }
}
