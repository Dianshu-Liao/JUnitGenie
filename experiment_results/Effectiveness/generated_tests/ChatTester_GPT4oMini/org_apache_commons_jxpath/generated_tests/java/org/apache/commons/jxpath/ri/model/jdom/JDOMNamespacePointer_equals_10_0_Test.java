package org.apache.commons.jxpath.ri.model.jdom;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;

public class JDOMNamespacePointer_equals_10_0_Test {

    private JDOMNamespacePointer pointer1;

    private JDOMNamespacePointer pointer2;

    private JDOMNamespacePointer pointer3;

    @BeforeEach
    public void setUp() {
        pointer1 = new JDOMNamespacePointer(null, "prefix1");
        pointer2 = new JDOMNamespacePointer(null, "prefix1");
        pointer3 = new JDOMNamespacePointer(null, "prefix2");
    }

    @Test
    public void testEquals_SameInstance() {
        assertTrue(pointer1.equals(pointer1), "An instance should be equal to itself.");
    }

    @Test
    public void testEquals_SamePrefix() {
        assertTrue(pointer1.equals(pointer2), "Two JDOMNamespacePointer instances with the same prefix should be equal.");
    }

    @Test
    public void testEquals_DifferentPrefix() {
        assertFalse(pointer1.equals(pointer3), "Two JDOMNamespacePointer instances with different prefixes should not be equal.");
    }

    @Test
    public void testEquals_NullObject() {
        assertFalse(pointer1.equals(null), "A JDOMNamespacePointer instance should not be equal to null.");
    }

    @Test
    public void testEquals_DifferentClass() {
        assertFalse(pointer1.equals("Some String"), "A JDOMNamespacePointer instance should not be equal to an object of a different class.");
    }
}
