package org.apache.commons.jxpath.ri.model.dom;

import org.w3c.dom.Attr;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.util.TypeUtils;

public class DOMAttributePointer_equals_14_0_Test {

    private DOMAttributePointer pointer1;

    private DOMAttributePointer pointer2;

    private DOMAttributePointer pointer3;

    private Attr attrMock1;

    private Attr attrMock2;

    private NodePointer nodePointerMock;

    @BeforeEach
    public void setUp() {
        attrMock1 = Mockito.mock(Attr.class);
        attrMock2 = Mockito.mock(Attr.class);
        nodePointerMock = Mockito.mock(NodePointer.class);
        pointer1 = new DOMAttributePointer(nodePointerMock, attrMock1);
        pointer2 = new DOMAttributePointer(nodePointerMock, attrMock1);
        pointer3 = new DOMAttributePointer(nodePointerMock, attrMock2);
    }

    @Test
    public void testEquals_SameInstance() {
        assertTrue(pointer1.equals(pointer1), "Same instance should be equal");
    }

    @Test
    public void testEquals_Null() {
        assertFalse(pointer1.equals(null), "Pointer should not be equal to null");
    }

    @Test
    public void testEquals_DifferentClass() {
        assertFalse(pointer1.equals("Not a DOMAttributePointer"), "Different class should not be equal");
    }

    @Test
    public void testEquals_SameAttributes() {
        assertTrue(pointer1.equals(pointer2), "Pointers with same attributes should be equal");
    }

    @Test
    public void testEquals_DifferentAttributes() {
        assertFalse(pointer1.equals(pointer3), "Pointers with different attributes should not be equal");
    }
}
