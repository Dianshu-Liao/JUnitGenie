package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.dom.DOMAttributeIterator;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.w3c.dom.Node;

class DOMAttributeIterator_setPosition_4_0_Test {

    private NodePointer parent;

    private QName name;

    private DOMAttributeIterator iterator;

    @BeforeEach
    void setUp() {
        parent = Mockito.mock(NodePointer.class);
        name = new QName("testName");
        iterator = new DOMAttributeIterator(parent, name);
    }

    @Test
    void testSetPosition_ValidPosition() {
        // Prepare mock attributes
        List<Attr> attributes = new ArrayList<>();
        Attr mockAttr = mock(Attr.class);
        attributes.add(mockAttr);
        // Reflectively set the attributes field
        setAttributes(iterator, attributes);
        boolean result = iterator.setPosition(1);
        assertTrue(result);
        assertEquals(1, iterator.getPosition());
    }

    @Test
    void testSetPosition_InvalidPositionBelowRange() {
        boolean result = iterator.setPosition(0);
        assertFalse(result);
        assertEquals(0, iterator.getPosition());
    }

    @Test
    void testSetPosition_InvalidPositionAboveRange() {
        // Prepare mock attributes
        List<Attr> attributes = new ArrayList<>();
        attributes.add(mock(Attr.class));
        // Reflectively set the attributes field
        setAttributes(iterator, attributes);
        boolean result = iterator.setPosition(2);
        assertFalse(result);
        assertEquals(0, iterator.getPosition());
    }

    @Test
    void testSetPosition_EmptyAttributes() {
        // Reflectively set the attributes field to an empty list
        setAttributes(iterator, new ArrayList<>());
        boolean result = iterator.setPosition(1);
        assertFalse(result);
        assertEquals(0, iterator.getPosition());
    }

    private void setAttributes(DOMAttributeIterator iterator, List<Attr> attributes) {
        try {
            java.lang.reflect.Field field = DOMAttributeIterator.class.getDeclaredField("attributes");
            field.setAccessible(true);
            field.set(iterator, attributes);
        } catch (Exception e) {
            fail("Failed to set attributes: " + e.getMessage());
        }
    }
}
