package org.apache.commons.jxpath.ri.model.jdom;

import org.jdom.Attribute;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.TypeUtils;

public class JDOMAttributePointer_equals_13_0_Test {

    @Test
    public void testEquals_SameInstance() {
        Attribute attribute = new Attribute("name", "value");
        NodePointer nodePointer = Mockito.mock(NodePointer.class);
        JDOMAttributePointer pointer = new JDOMAttributePointer(nodePointer, attribute);
        assertTrue(pointer.equals(pointer), "Should be equal to itself");
    }

    @Test
    public void testEquals_NullObject() {
        Attribute attribute = new Attribute("name", "value");
        NodePointer nodePointer = Mockito.mock(NodePointer.class);
        JDOMAttributePointer pointer = new JDOMAttributePointer(nodePointer, attribute);
        assertFalse(pointer.equals(null), "Should not be equal to null");
    }

    @Test
    public void testEquals_DifferentClass() {
        Attribute attribute = new Attribute("name", "value");
        NodePointer nodePointer = Mockito.mock(NodePointer.class);
        JDOMAttributePointer pointer = new JDOMAttributePointer(nodePointer, attribute);
        Object notJDOMAttributePointer = new Object();
        assertFalse(pointer.equals(notJDOMAttributePointer), "Should not be equal to an object of a different class");
    }

    @Test
    public void testEquals_DifferentAttributes() {
        Attribute attribute1 = new Attribute("name", "value1");
        Attribute attribute2 = new Attribute("name", "value2");
        NodePointer nodePointer = Mockito.mock(NodePointer.class);
        JDOMAttributePointer pointer1 = new JDOMAttributePointer(nodePointer, attribute1);
        JDOMAttributePointer pointer2 = new JDOMAttributePointer(nodePointer, attribute2);
        assertFalse(pointer1.equals(pointer2), "Should not be equal to another JDOMAttributePointer with a different attribute");
    }

    @Test
    public void testEquals_SameAttributes() {
        Attribute attribute = new Attribute("name", "value");
        NodePointer nodePointer = Mockito.mock(NodePointer.class);
        JDOMAttributePointer pointer1 = new JDOMAttributePointer(nodePointer, attribute);
        JDOMAttributePointer pointer2 = new JDOMAttributePointer(nodePointer, attribute);
        assertTrue(pointer1.equals(pointer2), "Should be equal to another JDOMAttributePointer with the same attribute");
    }
}
