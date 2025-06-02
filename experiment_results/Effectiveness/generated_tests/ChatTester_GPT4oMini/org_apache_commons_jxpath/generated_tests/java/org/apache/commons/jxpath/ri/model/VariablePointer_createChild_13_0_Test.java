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

public class VariablePointer_createChild_13_0_Test {

    private VariablePointer variablePointer;

    private Variables mockVariables;

    private QName mockQName;

    private JXPathContext mockContext;

    private AbstractFactory mockFactory;

    private NodePointer mockNodePointer;

    @BeforeEach
    public void setUp() {
        mockVariables = mock(Variables.class);
        mockQName = mock(QName.class);
        mockContext = mock(JXPathContext.class);
        mockFactory = mock(AbstractFactory.class);
        mockNodePointer = mock(NodePointer.class);
        variablePointer = new VariablePointer(mockVariables, mockQName);
    }

    @Test
    public void testCreateChild_WhenNotActualAndIndexIsNotZeroOrWholeCollection() {
        // Arrange
        when(variablePointer.isActual()).thenReturn(false);
        when(mockFactory.createObject(mockContext, variablePointer, null, mockQName.toString(), 1)).thenReturn(true);
        when(variablePointer.getAbstractFactory(mockContext)).thenReturn(mockFactory);
        when(variablePointer.clone()).thenReturn(mockNodePointer);
        // Act
        NodePointer result = variablePointer.createChild(mockContext, mockQName, 1);
        // Assert
        assertNotNull(result);
        assertEquals(mockNodePointer, result);
        verify(mockNodePointer).setIndex(1);
    }

    @Test
    public void testCreateChild_WhenSuccess() {
        // Arrange
        when(variablePointer.isActual()).thenReturn(true);
        when(variablePointer.clone()).thenReturn(mockNodePointer);
        // Act
        NodePointer result = variablePointer.createChild(mockContext, mockQName, 0);
        // Assert
        assertNotNull(result);
        assertEquals(variablePointer, result);
    }

    @Test
    public void testCreateChild_WhenFactoryFails() {
        // Arrange
        when(variablePointer.isActual()).thenReturn(false);
        when(mockFactory.createObject(mockContext, variablePointer, null, mockQName.toString(), 1)).thenReturn(false);
        when(variablePointer.getAbstractFactory(mockContext)).thenReturn(mockFactory);
        // Act & Assert
        JXPathAbstractFactoryException exception = assertThrows(JXPathAbstractFactoryException.class, () -> {
            variablePointer.createChild(mockContext, mockQName, 1);
        });
        assertEquals("Factory could not create object path: " + variablePointer.asPath(), exception.getMessage());
    }

    @Test
    public void testCreateChild_WhenIndexIsWholeCollection() {
        // Arrange
        when(variablePointer.isActual()).thenReturn(true);
        when(variablePointer.clone()).thenReturn(mockNodePointer);
        // Act
        NodePointer result = variablePointer.createChild(mockContext, mockQName, VariablePointer.WHOLE_COLLECTION);
        // Assert
        assertNotNull(result);
        assertEquals(variablePointer, result);
    }
}
