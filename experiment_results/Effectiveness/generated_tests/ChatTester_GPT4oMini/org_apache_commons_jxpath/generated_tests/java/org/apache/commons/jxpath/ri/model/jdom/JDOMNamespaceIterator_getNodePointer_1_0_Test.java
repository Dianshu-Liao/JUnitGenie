// Test method
package org.apache.commons.jxpath.ri.model.jdom;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class JDOMNamespaceIterator_getNodePointer_1_0_Test {

    private JDOMNamespaceIterator iterator;

    private NodePointer mockParent;

    @BeforeEach
    public void setUp() {
        mockParent = mock(NodePointer.class);
        iterator = new JDOMNamespaceIterator(mockParent);
        // Set up the private fields using reflection
        setPrivateField(iterator, "namespaces", new ArrayList<>());
        setPrivateField(iterator, "prefixes", new HashSet<>());
    }

    @Test
    public void testGetNodePointer_WhenPositionIsZeroAndSetPositionReturnsFalse() throws Exception {
        // Arrange
        setPrivateField(iterator, "position", 0);
        // Mock setPosition to return false
        Method setPositionMethod = JDOMNamespaceIterator.class.getDeclaredMethod("setPosition", int.class);
        setPositionMethod.setAccessible(true);
        when(setPositionMethod.invoke(iterator, 1)).thenReturn(false);
        // Act
        NodePointer result = iterator.getNodePointer();
        // Assert
        assertNull(result);
    }

    @Test
    public void testGetNodePointer_WhenPositionIsZeroAndSetPositionReturnsTrue() throws Exception {
        // Arrange
        setPrivateField(iterator, "position", 0);
        // Mock setPosition to return true
        Method setPositionMethod = JDOMNamespaceIterator.class.getDeclaredMethod("setPosition", int.class);
        setPositionMethod.setAccessible(true);
        when(setPositionMethod.invoke(iterator, 1)).thenReturn(true);
        // Act
        NodePointer result = iterator.getNodePointer();
        // Assert
        assertNotNull(result);
    }

    @Test
    public void testGetNodePointer_WhenPositionIsGreaterThanZero() throws Exception {
        // Arrange
        Namespace ns = mock(Namespace.class);
        when(ns.getPrefix()).thenReturn("prefix");
        when(ns.getURI()).thenReturn("uri");
        List<Namespace> namespaceList = new ArrayList<>();
        namespaceList.add(ns);
        setPrivateField(iterator, "namespaces", namespaceList);
        setPrivateField(iterator, "position", 1);
        // Act
        NodePointer result = iterator.getNodePointer();
        // Assert
        assertNotNull(result);
        assertEquals("prefix", ((JDOMNamespacePointer) result).getName().getPrefix());
        assertEquals("uri", ((JDOMNamespacePointer) result).getNamespaceURI());
    }

    @Test
    public void testGetNodePointer_WhenPositionIsNegative() throws Exception {
        // Arrange
        setPrivateField(iterator, "position", -1);
        Namespace ns = mock(Namespace.class);
        when(ns.getPrefix()).thenReturn("prefix");
        when(ns.getURI()).thenReturn("uri");
        List<Namespace> namespaceList = new ArrayList<>();
        namespaceList.add(ns);
        setPrivateField(iterator, "namespaces", namespaceList);
        // Act
        NodePointer result = iterator.getNodePointer();
        // Assert
        assertNotNull(result);
        assertEquals("prefix", ((JDOMNamespacePointer) result).getName().getPrefix());
        assertEquals("uri", ((JDOMNamespacePointer) result).getNamespaceURI());
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            // Fixed the buggy line
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
