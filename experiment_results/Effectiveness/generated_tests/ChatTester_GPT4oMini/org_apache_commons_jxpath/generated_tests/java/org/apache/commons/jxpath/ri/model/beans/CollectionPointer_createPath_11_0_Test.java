package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.util.ValueUtils;

@ExtendWith(MockitoExtension.class)
public class CollectionPointer_createPath_11_0_Test {

    private CollectionPointer collectionPointer;

    private JXPathContext context;

    private NodePointer mockNodePointer;

    @BeforeEach
    public void setUp() {
        // Mock dependencies
        context = Mockito.mock(JXPathContext.class);
        mockNodePointer = Mockito.mock(NodePointer.class);
        // Initialize the CollectionPointer instance
        collectionPointer = new CollectionPointer(new Object(), Locale.getDefault());
    }

    @Test
    public void testCreatePath() {
        when(context.createPath(anyString())).thenReturn(mockNodePointer);
        Object value = new Object();
        // Act
        NodePointer result = collectionPointer.createPath(context, value);
        // Assert
        assertNotNull(result);
        verify(mockNodePointer).setValue(value);
        assertSame(result, mockNodePointer);
    }

    @Test
    public void testCreatePathWithNullValue() {
        when(context.createPath(anyString())).thenReturn(mockNodePointer);
        Object value = null;
        // Act
        NodePointer result = collectionPointer.createPath(context, value);
        // Assert
        assertNotNull(result);
        verify(mockNodePointer).setValue(value);
        assertSame(result, mockNodePointer);
    }

    @Test
    public void testCreatePathWithDifferentValue() {
        when(context.createPath(anyString())).thenReturn(mockNodePointer);
        Object value = new String("Test Value");
        // Act
        NodePointer result = collectionPointer.createPath(context, value);
        // Assert
        assertNotNull(result);
        verify(mockNodePointer).setValue(value);
        assertSame(result, mockNodePointer);
    }
}
