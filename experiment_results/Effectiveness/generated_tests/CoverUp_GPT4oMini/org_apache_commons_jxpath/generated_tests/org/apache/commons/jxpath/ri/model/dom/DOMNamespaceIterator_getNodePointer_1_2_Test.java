package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.model.NodePointer;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.w3c.dom.NamedNodeMap;

@ExtendWith(MockitoExtension.class)
class DOMNamespaceIterator_getNodePointer_1_2_Test {

    private DOMNamespaceIterator iterator;

    private NodePointer parent;

    private List<Attr> attributes;

    @BeforeEach
    void setUp() {
        parent = mock(NodePointer.class);
        attributes = new ArrayList<>();
        iterator = new DOMNamespaceIterator(parent);
        // Mock the parent NodePointer to return a mock Node
        Document mockDocument = mock(Document.class);
        Element mockElement = mock(Element.class);
        when(mockElement.getNodeType()).thenReturn(Node.ELEMENT_NODE);
        when(mockDocument.getDocumentElement()).thenReturn(mockElement);
        when(parent.getNode()).thenReturn(mockDocument);
    }

    @Test
    void testGetNodePointerWhenPositionIsZeroAndSetPositionFails() {
        // Arrange
        when(iterator.setPosition(1)).thenReturn(false);
        // Act
        NodePointer result = iterator.getNodePointer();
        // Assert
        assertNull(result);
    }

    @Test
    void testGetNodePointerWhenPositionIsZeroAndSetPositionSucceeds() {
        // Arrange
        when(iterator.setPosition(1)).thenReturn(true);
        // Act
        NodePointer result = iterator.getNodePointer();
        // Assert
        assertNotNull(result);
    }

    @Test
    void testGetNodePointerWithAttributes() throws Exception {
        // Arrange
        Attr attr1 = mock(Attr.class);
        when(attr1.getPrefix()).thenReturn("xmlns");
        when(attr1.getValue()).thenReturn("http://www.w3.org/2000/xmlns/");
        Attr attr2 = mock(Attr.class);
        when(attr2.getPrefix()).thenReturn("other");
        when(attr2.getValue()).thenReturn("http://example.com/");
        attributes.add(attr1);
        attributes.add(attr2);
        // Use reflection to set the private attributes field
        setPrivateField(iterator, "attributes", attributes);
        // Set position to 1 to get the first attribute
        iterator.setPosition(1);
        // Act
        NodePointer result = iterator.getNodePointer();
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof NamespacePointer);
    }

    @Test
    void testGetNodePointerWithNonNamespaceAttribute() throws Exception {
        // Arrange
        Attr attr = mock(Attr.class);
        when(attr.getPrefix()).thenReturn("other");
        when(attr.getValue()).thenReturn("http://example.com/");
        attributes.add(attr);
        setPrivateField(iterator, "attributes", attributes);
        // Set position to 1 to get the first attribute
        iterator.setPosition(1);
        // Act
        NodePointer result = iterator.getNodePointer();
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof NamespacePointer);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
