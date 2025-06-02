package org.apache.commons.jxpath.ri.model;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.Variables;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.VariablePointerFactory;
import org.apache.commons.jxpath.ri.model.VariablePointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Locale;

@ExtendWith(MockitoExtension.class)
class VariablePointerFactory_createNodePointer_2_4_Test {

    private VariablePointerFactory variablePointerFactory;

    private NodePointer mockParent;

    private QName mockQName;

    private Object mockObject;

    @BeforeEach
    void setUp() {
        variablePointerFactory = new VariablePointerFactory();
        mockParent = mock(NodePointer.class);
        mockQName = new QName("testPrefix", "testName");
    }

    @Test
    void testCreateNodePointerWithVariableContextWrapper() throws Exception {
        // Arrange
        Variables mockVariables = mock(Variables.class);
        JXPathContext mockContext = mock(JXPathContext.class);
        when(mockContext.getVariables()).thenReturn(mockVariables);
        when(mockVariables.isDeclaredVariable(mockQName.getName())).thenReturn(true);
        // Use mockContext directly
        mockObject = mockContext;
        // Act
        NodePointer result = invokeCreateNodePointer(mockParent, mockQName, mockObject);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof VariablePointer);
    }

    @Test
    void testCreateNodePointerWithUndeclaredVariable() throws Exception {
        // Arrange
        Variables mockVariables = mock(Variables.class);
        JXPathContext mockContext = mock(JXPathContext.class);
        when(mockContext.getVariables()).thenReturn(mockVariables);
        when(mockVariables.isDeclaredVariable(mockQName.getName())).thenReturn(false);
        // Use mockContext directly
        mockObject = mockContext;
        // Act
        NodePointer result = invokeCreateNodePointer(mockParent, mockQName, mockObject);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof VariablePointer);
    }

    @Test
    void testCreateNodePointerWithNullObject() throws Exception {
        // Act
        NodePointer result = invokeCreateNodePointer(mockParent, mockQName, null);
        // Assert
        assertNull(result);
    }

    private NodePointer invokeCreateNodePointer(NodePointer parent, QName name, Object object) throws Exception {
        Method method = VariablePointerFactory.class.getDeclaredMethod("createNodePointer", NodePointer.class, QName.class, Object.class);
        method.setAccessible(true);
        return (NodePointer) method.invoke(variablePointerFactory, parent, name, object);
    }
}
