package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNamespaceIterator;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.Document;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.jxpath.ri.model.NodeIterator;

class JDOMNamespaceIterator_getNodePointer_1_3_Test {

    private JDOMNamespaceIterator jdomNamespaceIterator;

    private NodePointer mockParent;

    @BeforeEach
    void setUp() {
        mockParent = mock(NodePointer.class);
        jdomNamespaceIterator = new JDOMNamespaceIterator(mockParent);
    }

    @Test
    void testGetNodePointerWhenPositionIsZeroAndSetPositionFails() {
        // Arrange
        when(mockParent.getNode()).thenReturn(new Document(new Element("root")));
        setNamespaces(new ArrayList<>());
        // Ensure position is zero
        jdomNamespaceIterator.setPosition(0);
        // Act
        NodePointer result = jdomNamespaceIterator.getNodePointer();
        // Assert
        assertNull(result, "Expected null when position is 0 and setPosition fails");
    }

    @Test
    void testGetNodePointerWhenPositionIsZeroAndSetPositionSucceeds() {
        // Arrange
        Namespace ns = Namespace.getNamespace("prefix", "uri");
        List<Namespace> namespaces = new ArrayList<>();
        namespaces.add(ns);
        setNamespaces(namespaces);
        // Ensure position is zero
        jdomNamespaceIterator.setPosition(0);
        // Act
        NodePointer result = jdomNamespaceIterator.getNodePointer();
        // Assert
        assertNotNull(result, "Expected non-null result when position is 0 and setPosition succeeds");
    }

    @Test
    void testGetNodePointerWithValidPosition() {
        // Arrange
        Namespace ns1 = Namespace.getNamespace("prefix1", "uri1");
        Namespace ns2 = Namespace.getNamespace("prefix2", "uri2");
        List<Namespace> namespaces = new ArrayList<>();
        namespaces.add(ns1);
        namespaces.add(ns2);
        setNamespaces(namespaces);
        // Set position to valid index
        jdomNamespaceIterator.setPosition(2);
        // Act
        NodePointer result = jdomNamespaceIterator.getNodePointer();
        // Assert
        assertNotNull(result, "Expected non-null result for valid position");
    }

    @Test
    void testGetNodePointerWithInvalidPosition() {
        // Arrange
        Namespace ns = Namespace.getNamespace("prefix", "uri");
        List<Namespace> namespaces = new ArrayList<>();
        namespaces.add(ns);
        setNamespaces(namespaces);
        // Set to an invalid position
        jdomNamespaceIterator.setPosition(3);
        // Act
        NodePointer result = jdomNamespaceIterator.getNodePointer();
        // Assert
        assertNotNull(result, "Expected non-null result even with invalid position due to fallback");
    }

    private void setNamespaces(List<Namespace> namespaces) {
        try {
            java.lang.reflect.Field field = JDOMNamespaceIterator.class.getDeclaredField("namespaces");
            field.setAccessible(true);
            field.set(jdomNamespaceIterator, namespaces);
        } catch (Exception e) {
            fail("Failed to set namespaces field: " + e.getMessage());
        }
    }
}
