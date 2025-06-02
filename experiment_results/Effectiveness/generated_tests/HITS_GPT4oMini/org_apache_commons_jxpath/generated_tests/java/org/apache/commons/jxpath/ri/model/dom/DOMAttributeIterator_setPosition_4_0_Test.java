package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class DOMAttributeIterator_setPosition_4_0_Test {

    private NodePointer mockNodePointer;

    private QName mockQName;

    private DOMAttributeIterator iterator;

    @BeforeEach
    public void setUp() {
        mockNodePointer = Mockito.mock(NodePointer.class);
        mockQName = new QName("testAttr");
        iterator = new DOMAttributeIterator(mockNodePointer, mockQName);
    }

    @Test
    public void testSetPosition_ValidPosition() {
        // Simulate adding attributes to the iterator
        iterator.setPosition(1);
        assertTrue(iterator.setPosition(1), "Position should be valid");
        assertTrue(iterator.setPosition(2), "Position should be valid");
    }

    @Test
    public void testSetPosition_InvalidPositionTooLow() {
        assertFalse(iterator.setPosition(0), "Position should be invalid");
    }

    @Test
    public void testSetPosition_InvalidPositionTooHigh() {
        // Simulate adding attributes to the iterator
        iterator.setPosition(1);
        assertFalse(iterator.setPosition(3), "Position should be invalid");
    }

    @Test
    public void testSetPosition_EmptyAttributes() {
        // Create a new iterator with no attributes
        DOMAttributeIterator emptyIterator = new DOMAttributeIterator(mockNodePointer, mockQName);
        assertFalse(emptyIterator.setPosition(1), "Position should be invalid for empty attributes");
    }

    @Test
    public void testGetPosition() {
        assertEquals(0, iterator.getPosition(), "Initial position should be 0");
        iterator.setPosition(1);
        assertEquals(1, iterator.getPosition(), "Position should be updated to 1");
    }

    @Test
    public void testGetNodePointer_AtInitialPosition() {
        assertNull(iterator.getNodePointer(), "NodePointer should be null at initial position");
    }

    @Test
    public void testGetNodePointer_AfterSettingPosition() {
        iterator.setPosition(1);
        assertNotNull(iterator.getNodePointer(), "NodePointer should not be null after valid position set");
    }
}
