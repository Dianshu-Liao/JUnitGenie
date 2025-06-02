package org.apache.commons.jxpath.ri.parser;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import org.apache.commons.jxpath.ri.Compiler;

public class XPathParser_jj_3R_102_83_0_Test {

    private XPathParser parser;

    private Token axisParentToken;

    private Token anotherToken;

    @BeforeEach
    public void setUp() {
        parser = new XPathParser(new ByteArrayInputStream("test input".getBytes()));
        // Assuming a default constructor exists
        axisParentToken = new Token();
        // Assuming a default constructor exists
        anotherToken = new Token();
    }

    @Test
    public void testJj_3R_102_WhenAxisParentTokenIsPresent() throws Exception {
        // Arrange
        setPrivateField(parser, "jj_scanpos", axisParentToken);
        setPrivateField(parser, "jj_lastpos", axisParentToken);
        // Act
        boolean result = invokePrivateMethod(parser, "jj_3R_102");
        // Assert
        assertTrue(result, "jj_3R_102 should return true when AXIS_PARENT token is present.");
    }

    @Test
    public void testJj_3R_102_WhenAxisParentTokenIsNotPresent() throws Exception {
        // Arrange
        setPrivateField(parser, "jj_scanpos", anotherToken);
        // Act
        boolean result = invokePrivateMethod(parser, "jj_3R_102");
        // Assert
        assertFalse(result, "jj_3R_102 should return false when AXIS_PARENT token is not present.");
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private boolean invokePrivateMethod(Object obj, String methodName) throws Exception {
        java.lang.reflect.Method method = obj.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        return (boolean) method.invoke(obj);
    }
}
