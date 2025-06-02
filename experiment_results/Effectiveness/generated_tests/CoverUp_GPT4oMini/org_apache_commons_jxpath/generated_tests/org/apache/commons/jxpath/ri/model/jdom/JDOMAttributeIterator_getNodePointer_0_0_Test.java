package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.jdom.JDOMAttributeIterator;
import org.jdom.Attribute;
import org.jdom.Element;
import org.jdom.Namespace;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import org.apache.commons.jxpath.ri.model.NodeIterator;

class JDOMAttributeIterator_getNodePointer_0_0_Test {

    private NodePointer mockParent;

    private QName mockQName;

    private JDOMAttributeIterator iterator;

    private List<Attribute> attributes;

    @BeforeEach
    void setUp() {
        mockParent = mock(NodePointer.class);
        mockQName = new QName("testAttr");
        attributes = new ArrayList<>();
        // Create a mock Element and set it to return the mock attributes
        Element mockElement = mock(Element.class);
        when(mockParent.getNode()).thenReturn(mockElement);
        when(mockElement.getAttribute("testAttr", Namespace.NO_NAMESPACE)).thenReturn(new Attribute("testAttr", "value"));
        when(mockElement.getAttributes()).thenReturn(attributes);
        iterator = new JDOMAttributeIterator(mockParent, mockQName);
    }

    @Test
    void testGetNodePointerWhenPositionIsZeroAndSetPositionFails() {
        // Simulate failure of setPosition
        // Ensure it returns a valid element
        when(mockParent.getNode()).thenReturn(mock(Element.class));
        assertNull(iterator.getNodePointer());
    }

    @Test
    void testGetNodePointerWhenPositionIsZeroAndSetPositionSucceeds() {
        // Set position to a valid index
        iterator.setPosition(1);
        NodePointer nodePointer = iterator.getNodePointer();
        assertNotNull(nodePointer);
        assertTrue(nodePointer instanceof JDOMAttributePointer);
    }

    @Test
    void testGetNodePointerWithValidPosition() {
        // Set position to a valid index
        iterator.setPosition(1);
        NodePointer nodePointer = iterator.getNodePointer();
        assertNotNull(nodePointer);
        assertTrue(nodePointer instanceof JDOMAttributePointer);
        // Verify that the correct attribute is returned
        assertEquals("testAttr", ((Attribute) ((JDOMAttributePointer) nodePointer).getNode()).getName());
    }

    @Test
    void testGetNodePointerWithNegativeIndex() {
        iterator.setPosition(1);
        // Set position to an invalid index
        iterator.setPosition(0);
        NodePointer nodePointer = iterator.getNodePointer();
        assertNotNull(nodePointer);
        assertTrue(nodePointer instanceof JDOMAttributePointer);
    }

    @Test
    void testGetNodePointerWithEmptyAttributes() {
        // Simulate no attributes
        attributes.clear();
        // Wildcard for attributes
        iterator = new JDOMAttributeIterator(mockParent, new QName("*"));
        NodePointer nodePointer = iterator.getNodePointer();
        // Should return null as there are no attributes
        assertNull(nodePointer);
    }
}
