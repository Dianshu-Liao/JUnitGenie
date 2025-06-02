package org.apache.commons.jxpath.ri.parser;

import java.io.InputStream;
import java.io.Reader;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class XPathParser_WildcardName_36_0_Test {

    private XPathParser parser;

    private Compiler mockCompiler;

    private XPathParserTokenManager mockTokenManager;

    @BeforeEach
    public void setUp() {
        mockCompiler = mock(Compiler.class);
        mockTokenManager = mock(XPathParserTokenManager.class);
        parser = new XPathParser(mockTokenManager);
        try {
            setPrivateField("compiler", mockCompiler);
        } catch (Exception e) {
            fail("Failed to set private field: " + e.getMessage());
        }
        // Set up tokens for testing
        parser.token = new Token();
        parser.jj_nt = new Token();
    }

    @Test
    public void testWildcardName_withSingleNCName() throws Exception {
        // Setup
        parser.jj_nt.kind = XPathParserTokenManager.NCName;
        parser.token.image = "localName";
        // Mock the behavior of the compiler
        when(mockCompiler.qname(null, "localName")).thenReturn("qname:localName");
        // Invoke the method using reflection
        Object result = invokePrivateMethod("WildcardName");
        // Verify
        assertEquals("qname:localName", result);
        verify(mockCompiler).qname(null, "localName");
    }

    @Test
    public void testWildcardName_withTwoNCNames() throws Exception {
        // Setup
        parser.jj_nt.kind = XPathParserTokenManager.NCName;
        parser.token.image = "localName1";
        // Assuming 80 corresponds to some valid token for the second NCName
        parser.jj_nt.kind = 80;
        parser.token.image = "localName2";
        // Mock the behavior of the compiler
        when(mockCompiler.qname("localName1", "localName2")).thenReturn("qname:localName1:localName2");
        // Invoke the method using reflection
        Object result = invokePrivateMethod("WildcardName");
        // Verify
        assertEquals("qname:localName1:localName2", result);
        verify(mockCompiler).qname("localName1", "localName2");
    }

    @Test
    public void testWildcardName_invalidToken() {
        // Setup
        // Invalid token
        parser.jj_nt.kind = -1;
        // Assert exception
        assertThrows(ParseException.class, () -> {
            invokePrivateMethod("WildcardName");
        });
    }

    private Object invokePrivateMethod(String methodName) throws Exception {
        java.lang.reflect.Method method = XPathParser.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return method.invoke(parser);
    }

    private void setPrivateField(String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = XPathParser.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(parser, value);
    }
}
