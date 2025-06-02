package org.apache.commons.jxpath.ri.model.dom;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class DOMNamespaceIterator_getNodePointer_1_0_Test {

    private DOMNamespaceIterator domNamespaceIterator;

    private NodePointer mockParent;

    private List<Attr> mockAttributes;

    @BeforeEach
    void setUp() {
        mockParent = mock(NodePointer.class);
        mockAttributes = new ArrayList<>();
        domNamespaceIterator = new DOMNamespaceIterator(mockParent);
    }

    @Test
    void testGetNodePointer_WhenPositionIsZeroAndSetPositionReturnsFalse() {
        // Set position to 0
        invokePrivateSetPosition(0);
        // Act
        NodePointer result = domNamespaceIterator.getNodePointer();
        // Assert
        assertNull(result);
    }

    @Test
    void testGetNodePointer_WhenPositionIsZeroAndSetPositionReturnsTrue() {
        // Set position to 0
        invokePrivateSetPosition(0);
        // Prepare a mock attribute
        Attr mockAttr = mock(Attr.class);
        when(mockAttr.getPrefix()).thenReturn("xmlns");
        when(mockAttr.getValue()).thenReturn("value");
        mockAttributes.add(mockAttr);
        setAttributes(mockAttributes);
        // Act
        NodePointer result = domNamespaceIterator.getNodePointer();
        // Assert
        assertNotNull(result);
        assertEquals("value", ((NamespacePointer) result).getValue());
    }

    @Test
    void testGetNodePointer_WhenPositionIsGreaterThanZero() {
        // Set position to 1
        invokePrivateSetPosition(1);
        Attr mockAttr = mock(Attr.class);
        when(mockAttr.getPrefix()).thenReturn("xmlns");
        when(mockAttr.getValue()).thenReturn("value");
        mockAttributes.add(mockAttr);
        setAttributes(mockAttributes);
        // Act
        NodePointer result = domNamespaceIterator.getNodePointer();
        // Assert
        assertNotNull(result);
        assertEquals("value", ((NamespacePointer) result).getValue());
    }

    @Test
    void testGetNodePointer_WhenAttrPrefixIsNotXmlns() {
        // Set position to 1
        invokePrivateSetPosition(1);
        Attr mockAttr = mock(Attr.class);
        when(mockAttr.getPrefix()).thenReturn("not-xmlns");
        when(mockAttr.getValue()).thenReturn("value");
        mockAttributes.add(mockAttr);
        setAttributes(mockAttributes);
        // Act
        NodePointer result = domNamespaceIterator.getNodePointer();
        // Assert
        assertNotNull(result);
        assertEquals("value", ((NamespacePointer) result).getValue());
    }

    private void setAttributes(List<Attr> attributes) {
        try {
            java.lang.reflect.Field field = DOMNamespaceIterator.class.getDeclaredField("attributes");
            field.setAccessible(true);
            field.set(domNamespaceIterator, attributes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void invokePrivateSetPosition(int position) {
        try {
            java.lang.reflect.Method method = DOMNamespaceIterator.class.getDeclaredMethod("setPosition", int.class);
            method.setAccessible(true);
            method.invoke(domNamespaceIterator, position);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
