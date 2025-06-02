package org.apache.commons.jxpath.ri.parser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.Compiler;

class XPathParser_ReInit_190_0_Test {

    private XPathParser parser;

    private XPathParserTokenManager tokenManager;

    @BeforeEach
    void setUp() {
        tokenManager = new XPathParserTokenManager(new SimpleCharStream(new ByteArrayInputStream(new byte[0])));
        parser = new XPathParser(tokenManager);
    }

    @Test
    void testReInitWithValidInputStream() throws Exception {
        String input = "sample input";
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        // Use reflection to invoke the private ReInit method
        Method reInitMethod = XPathParser.class.getDeclaredMethod("ReInit", InputStream.class);
        reInitMethod.setAccessible(true);
        reInitMethod.invoke(parser, stream);
        // Validate that the internal state has been updated
        assertNotNull(getFieldValue(parser, "jj_input_stream"));
        assertNotNull(parser.token_source);
        assertEquals(0, getFieldValue(parser, "jj_gen"));
    }

    @Test
    void testReInitWithEmptyInputStream() throws Exception {
        InputStream stream = new ByteArrayInputStream(new byte[0]);
        // Use reflection to invoke the private ReInit method
        Method reInitMethod = XPathParser.class.getDeclaredMethod("ReInit", InputStream.class);
        reInitMethod.setAccessible(true);
        reInitMethod.invoke(parser, stream);
        // Validate that the internal state has been updated
        assertNotNull(getFieldValue(parser, "jj_input_stream"));
        assertNotNull(parser.token_source);
        assertEquals(0, getFieldValue(parser, "jj_gen"));
    }

    @Test
    void testReInitWithNullInputStream() throws Exception {
        // Use reflection to invoke the private ReInit method with null
        Method reInitMethod = XPathParser.class.getDeclaredMethod("ReInit", InputStream.class);
        reInitMethod.setAccessible(true);
        // Expecting an exception when passing null
        Exception exception = assertThrows(NullPointerException.class, () -> {
            reInitMethod.invoke(parser, (InputStream) null);
        });
        assertNotNull(exception);
    }

    private Object getFieldValue(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
