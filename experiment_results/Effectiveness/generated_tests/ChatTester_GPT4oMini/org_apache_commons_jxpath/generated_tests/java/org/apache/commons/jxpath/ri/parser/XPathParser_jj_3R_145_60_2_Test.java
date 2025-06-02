package org.apache.commons.jxpath.ri.parser;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.StringReader;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class XPathParser_jj_3R_145_60_2_Test {

    private XPathParser xPathParser;

    @BeforeEach
    public void setUp() {
        // Fixed line: initialize SimpleCharStream with a valid Reader
        SimpleCharStream simpleCharStream = new SimpleCharStream(new StringReader(""));
        xPathParser = new XPathParser(new XPathParserTokenManager(simpleCharStream));
    }

    @Test
    public void testJj_3R_145_WhenJj_3R_147ReturnsTrue() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        // Corrected Buggy Line: Handle NoSuchFieldException
        setPrivateField(xPathParser, "jj_3R_147ReturnValue", true);
        // Act
        boolean result = invokePrivateMethod(xPathParser, "jj_3R_145");
        // Assert
        assertTrue(result);
    }

    @Test
    public void testJj_3R_145_WhenJj_3R_147ReturnsFalse() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        // Corrected Buggy Line: Handle NoSuchFieldException
        setPrivateField(xPathParser, "jj_3R_147ReturnValue", false);
        // Act
        boolean result = invokePrivateMethod(xPathParser, "jj_3R_145");
        // Assert
        assertFalse(result);
    }

    // Helper method to invoke a private method using reflection
    private boolean invokePrivateMethod(XPathParser instance, String methodName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = XPathParser.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return (boolean) method.invoke(instance);
    }

    // Helper method to set a private field using reflection
    private void setPrivateField(XPathParser instance, String fieldName, boolean value) throws NoSuchFieldException, IllegalAccessException {
        java.lang.reflect.Field field = XPathParser.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.setBoolean(instance, value);
    }
}
