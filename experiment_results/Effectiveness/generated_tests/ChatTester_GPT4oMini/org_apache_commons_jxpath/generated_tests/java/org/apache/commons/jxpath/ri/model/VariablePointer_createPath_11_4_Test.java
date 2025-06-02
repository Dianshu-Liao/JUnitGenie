package org.apache.commons.jxpath.ri.model;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.Variables;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.util.ValueUtils;

public class VariablePointer_createPath_11_4_Test {

    private VariablePointer variablePointer;

    private Variables mockVariables;

    private QName mockQName;

    private JXPathContext mockContext;

    private NodePointer mockNodePointer;

    @BeforeEach
    public void setUp() {
        mockVariables = mock(Variables.class);
        mockQName = mock(QName.class);
        variablePointer = new VariablePointer(mockVariables, mockQName);
        mockContext = mock(JXPathContext.class);
        mockNodePointer = mock(NodePointer.class);
    }

    @Test
    public void testCreatePath_WhenActualIsTrue_ShouldSetValueAndReturnThis() {
        // Arrange
        setPrivateField(variablePointer, "actual", true);
        Object value = new Object();
        // Act
        NodePointer result = variablePointer.createPath(mockContext, value);
        // Assert
        assertEquals(variablePointer, result);
        verify(mockVariables, times(1)).declareVariable(mockQName.toString(), value);
    }

    @Test
    public void testCreatePath_WhenActualIsFalse_ShouldCreatePathAndSetValue() {
        // Arrange
        setPrivateField(variablePointer, "actual", false);
        Object value = new Object();
        when(mockNodePointer.createPath(mockContext)).thenReturn(mockNodePointer);
        // Act
        NodePointer result = variablePointer.createPath(mockContext, value);
        // Assert
        assertEquals(mockNodePointer, result);
        verify(mockNodePointer).setValue(value);
    }

    @Test
    public void testCreatePath_WhenActualIsFalse_AndNodePointerIsNull_ShouldThrowException() {
        // Arrange
        setPrivateField(variablePointer, "actual", false);
        Object value = new Object();
        when(mockNodePointer.createPath(mockContext)).thenReturn(null);
        // Act & Assert
        Exception exception = assertThrows(JXPathException.class, () -> {
            variablePointer.createPath(mockContext, value);
        });
        assertEquals("Undefined variable: " + mockQName.toString(), exception.getMessage());
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }
}
