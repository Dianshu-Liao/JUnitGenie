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

    private JDOMAttributePointer pointer1;

    private JDOMAttributePointer pointer2;

    private JDOMAttributePointer pointer3;

    private Attribute attr1;

    private Attribute attr2;

    @BeforeEach
    public void setUp() {
        attr1 = new Attribute("name1", "value1");
        attr2 = new Attribute("name2", "value2");
        pointer1 = new JDOMAttributePointer(Mockito.mock(NodePointer.class), attr1);
        pointer2 = new JDOMAttributePointer(Mockito.mock(NodePointer.class), attr1);
        pointer3 = new JDOMAttributePointer(Mockito.mock(NodePointer.class), attr2);
    }

    @Test
    public void testEquals_SameInstance() {
        assertTrue(pointer1.equals(pointer1));
    }

    @Test
    public void testEquals_SameAttributes() {
        assertTrue(pointer1.equals(pointer2));
    }

    @Test
    public void testEquals_DifferentAttributes() {
        assertFalse(pointer1.equals(pointer3));
    }

    @Test
    public void testEquals_Null() {
        assertFalse(pointer1.equals(null));
    }

    @Test
    public void testEquals_DifferentClass() {
        assertFalse(pointer1.equals("Not a JDOMAttributePointer"));
    }

    @Test
    public void testEquals_SameObjectReference() {
        JDOMAttributePointer samePointer = pointer1;
        assertTrue(pointer1.equals(samePointer));
    }
}
