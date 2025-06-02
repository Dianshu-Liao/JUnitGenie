package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.QName;

public class JDOMNamespacePointer_equals_10_0_Test {

    @Test
    public void testEquals_SameObject() {
        NodePointer mockNodePointer = Mockito.mock(NodePointer.class);
        JDOMNamespacePointer pointer = new JDOMNamespacePointer(mockNodePointer, "prefix");
        assertTrue(pointer.equals(pointer), "An object should be equal to itself.");
    }

    @Test
    public void testEquals_NullObject() {
        NodePointer mockNodePointer = Mockito.mock(NodePointer.class);
        JDOMNamespacePointer pointer = new JDOMNamespacePointer(mockNodePointer, "prefix");
        assertFalse(pointer.equals(null), "An object should not be equal to null.");
    }

    @Test
    public void testEquals_DifferentClass() {
        NodePointer mockNodePointer = Mockito.mock(NodePointer.class);
        JDOMNamespacePointer pointer = new JDOMNamespacePointer(mockNodePointer, "prefix");
        String differentClassObject = "Not a JDOMNamespacePointer";
        assertFalse(pointer.equals(differentClassObject), "An object should not be equal to an instance of a different class.");
    }

    @Test
    public void testEquals_DifferentPrefix() {
        NodePointer mockNodePointer = Mockito.mock(NodePointer.class);
        JDOMNamespacePointer pointer1 = new JDOMNamespacePointer(mockNodePointer, "prefix1");
        JDOMNamespacePointer pointer2 = new JDOMNamespacePointer(mockNodePointer, "prefix2");
        assertFalse(pointer1.equals(pointer2), "Two JDOMNamespacePointers with different prefixes should not be equal.");
    }

    @Test
    public void testEquals_SamePrefix() {
        NodePointer mockNodePointer = Mockito.mock(NodePointer.class);
        JDOMNamespacePointer pointer1 = new JDOMNamespacePointer(mockNodePointer, "prefix");
        JDOMNamespacePointer pointer2 = new JDOMNamespacePointer(mockNodePointer, "prefix");
        assertTrue(pointer1.equals(pointer2), "Two JDOMNamespacePointers with the same prefix should be equal.");
    }

    @Test
    public void testEquals_SameObjectDifferentReference() {
        NodePointer mockNodePointer = Mockito.mock(NodePointer.class);
        JDOMNamespacePointer pointer1 = new JDOMNamespacePointer(mockNodePointer, "prefix");
        JDOMNamespacePointer pointer2 = pointer1;
        assertTrue(pointer1.equals(pointer2), "Two references pointing to the same object should be equal.");
    }
}
