package org.apache.commons.jxpath.ri.model;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.Variables;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.ValueUtils;

public class VariablePointer_getBaseValue_2_0_Test {

    private VariablePointer variablePointer;

    private Variables variables;

    private QName name;

    @BeforeEach
    public void setUp() {
        name = new QName("testVariable");
        variables = mock(Variables.class);
        variablePointer = new VariablePointer(variables, name);
    }

    private void setActual(boolean actual) throws Exception {
        Field actualField = VariablePointer.class.getDeclaredField("actual");
        actualField.setAccessible(true);
        actualField.set(variablePointer, actual);
    }

    @Test
    public void testGetBaseValue_ThrowsJXPathException_WhenActualIsFalse() throws Exception {
        // Arrange
        setActual(false);
        // Act & Assert
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            variablePointer.getBaseValue();
        });
        // Verify the exception message
        assertEquals("Undefined variable: testVariable", exception.getMessage());
    }
}
