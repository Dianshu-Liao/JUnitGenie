package org.apache.commons.jxpath.ri.model.jdom;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Field;
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

class JDOMNamespaceIterator_setPosition_3_1_Test {

    private JDOMNamespaceIterator iterator;

    private NodePointer mockNodePointer;

    @BeforeEach
    void setUp() {
        mockNodePointer = Mockito.mock(NodePointer.class);
        Mockito.when(mockNodePointer.getNode()).thenReturn(new Document(new Element("root")));
        iterator = new JDOMNamespaceIterator(mockNodePointer);
    }

    @Test
    void testSetPosition_NullNamespaces() throws Exception {
        // Arrange
        // Simulate a null parent
        iterator = new JDOMNamespaceIterator(null);
        // Act
        boolean result = iterator.setPosition(1);
        // Assert
        assertFalse(result, "setPosition should return false when namespaces are null");
    }

    @Test
    void testSetPosition_ValidPosition() throws Exception {
        // Arrange
        Namespace ns1 = Namespace.getNamespace("ns1", "http://namespace1.com");
        Namespace ns2 = Namespace.getNamespace("ns2", "http://namespace2.com");
        List<Namespace> namespaces = new ArrayList<>();
        namespaces.add(ns1);
        namespaces.add(ns2);
        // Use reflection to set the private field
        Field namespacesField = JDOMNamespaceIterator.class.getDeclaredField("namespaces");
        namespacesField.setAccessible(true);
        namespacesField.set(iterator, namespaces);
        // Act
        boolean result = iterator.setPosition(1);
        // Assert
        assertTrue(result, "setPosition should return true for valid position 1");
        assertEquals(1, iterator.getPosition(), "Position should be set to 1");
        // Act
        result = iterator.setPosition(2);
        // Assert
        assertTrue(result, "setPosition should return true for valid position 2");
        assertEquals(2, iterator.getPosition(), "Position should be set to 2");
    }
}
