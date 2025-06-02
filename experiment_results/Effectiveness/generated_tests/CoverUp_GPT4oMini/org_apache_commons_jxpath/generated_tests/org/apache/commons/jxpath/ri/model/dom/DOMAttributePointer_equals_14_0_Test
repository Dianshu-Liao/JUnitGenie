package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.model.dom.DOMAttributePointer;
import org.w3c.dom.Attr;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.TypeUtils;

class DOMAttributePointer_equals_14_0_Test {

    private DOMAttributePointer pointer1;

    private DOMAttributePointer pointer2;

    private DOMAttributePointer pointer3;

    private Attr mockAttr;

    @BeforeEach
    void setUp() {
        mockAttr = Mockito.mock(Attr.class);
        pointer1 = new DOMAttributePointer(Mockito.mock(NodePointer.class), mockAttr);
        pointer2 = new DOMAttributePointer(Mockito.mock(NodePointer.class), mockAttr);
        pointer3 = new DOMAttributePointer(Mockito.mock(NodePointer.class), Mockito.mock(Attr.class));
    }

    @Test
    void testEquals_SameInstance() {
        assertTrue(pointer1.equals(pointer1), "An instance should be equal to itself.");
    }

    @Test
    void testEquals_SameAttributes() {
        assertTrue(pointer1.equals(pointer2), "Pointers with the same Attr should be equal.");
    }

    @Test
    void testEquals_DifferentAttributes() {
        assertFalse(pointer1.equals(pointer3), "Pointers with different Attrs should not be equal.");
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(pointer1.equals(null), "Pointer should not be equal to null.");
    }

    @Test
    void testEquals_DifferentClass() {
        assertFalse(pointer1.equals("string"), "Pointer should not be equal to an object of different class.");
    }

    @Test
    void testEquals_AnotherDOMAttributePointerWithSameAttr() {
        DOMAttributePointer anotherPointer = new DOMAttributePointer(Mockito.mock(NodePointer.class), mockAttr);
        assertTrue(pointer1.equals(anotherPointer), "Pointers with the same Attr should be equal.");
    }

    @Test
    void testEquals_AnotherDOMAttributePointerWithDifferentAttr() {
        Attr anotherMockAttr = Mockito.mock(Attr.class);
        DOMAttributePointer anotherPointer = new DOMAttributePointer(Mockito.mock(NodePointer.class), anotherMockAttr);
        assertFalse(pointer1.equals(anotherPointer), "Pointers with different Attrs should not be equal.");
    }
}
