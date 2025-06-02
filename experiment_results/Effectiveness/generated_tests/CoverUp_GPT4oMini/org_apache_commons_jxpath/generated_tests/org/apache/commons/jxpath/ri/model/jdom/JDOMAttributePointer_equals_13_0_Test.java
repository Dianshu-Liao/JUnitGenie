package org.apache.commons.jxpath.ri.model.jdom;

import org.jdom.Attribute;
import org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.util.TypeUtils;

class JDOMAttributePointer_equals_13_0_Test {

    private JDOMAttributePointer pointer1;

    private JDOMAttributePointer pointer2;

    private JDOMAttributePointer pointer3;

    private Attribute attribute;

    @BeforeEach
    void setUp() {
        attribute = new Attribute("testAttribute", "testValue");
        pointer1 = new JDOMAttributePointer(null, attribute);
        pointer2 = new JDOMAttributePointer(null, attribute);
        pointer3 = new JDOMAttributePointer(null, new Attribute("anotherAttribute", "anotherValue"));
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(pointer1.equals(pointer1), "Should be equal to itself");
    }

    @Test
    void testEquals_SameAttribute() {
        assertTrue(pointer1.equals(pointer2), "Should be equal to another pointer with the same attribute");
    }

    @Test
    void testEquals_DifferentAttribute() {
        assertFalse(pointer1.equals(pointer3), "Should not be equal to another pointer with a different attribute");
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(pointer1.equals(null), "Should not be equal to null");
    }

    @Test
    void testEquals_DifferentClass() {
        assertFalse(pointer1.equals(new Object()), "Should not be equal to an object of a different class");
    }

    @Test
    void testEquals_DifferentTypePointer() {
        JDOMAttributePointer pointer4 = new JDOMAttributePointer(null, new Attribute("testAttribute", "testValue"));
        assertTrue(pointer1.equals(pointer4), "Should be equal to another pointer with the same attribute");
    }
}
