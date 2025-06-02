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

public class VariablePointer_createChild_14_0_Test {

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
    public void testCreateChild() throws Exception {
        // Arrange
        int index = 0;
        Object value = new Object();
        Object mockCollection = new Object();
        // Mocking the behavior of createCollection
        // Using reflection to access the private method
        java.lang.reflect.Method createCollectionMethod = VariablePointer.class.getDeclaredMethod("createCollection", JXPathContext.class, int.class);
        createCollectionMethod.setAccessible(true);
        when(createCollectionMethod.invoke(variablePointer, mockContext, index)).thenReturn(mockCollection);
        // Mocking the clone method
        when(variablePointer.clone()).thenReturn(mockNodePointer);
        // Mocking ValueUtils.setValue
        mockStatic(ValueUtils.class);
        doNothing().when(ValueUtils.class);
        ValueUtils.setValue(mockCollection, index, value);
        // Act
        NodePointer result = variablePointer.createChild(mockContext, mockQName, index, value);
        // Assert
        assertNotNull(result);
        verify(ValueUtils.class);
        ValueUtils.setValue(mockCollection, index, value);
        verify(mockNodePointer).setIndex(index);
    }
}
