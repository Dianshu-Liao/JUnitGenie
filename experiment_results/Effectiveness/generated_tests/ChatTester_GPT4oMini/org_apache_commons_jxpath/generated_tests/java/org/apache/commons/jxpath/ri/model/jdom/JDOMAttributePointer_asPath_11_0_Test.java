package org.apache.commons.jxpath.ri.model.jdom;

import org.w3c.dom.Node;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.TypeUtils;
import org.jdom.Attribute;

public class JDOMAttributePointer_asPath_11_0_Test {

    private JDOMAttributePointer jdomAttributePointer;

    private NodePointer parentMock;

    private Attribute attributeMock;

    @BeforeEach
    public void setUp() {
        parentMock = mock(NodePointer.class);
        attributeMock = mock(Attribute.class);
        jdomAttributePointer = new JDOMAttributePointer(parentMock, attributeMock);
    }

    @Test
    public void testAsPath_WithParent() {
        when(parentMock.asPath()).thenReturn("parentNode");
        when(attributeMock.getName()).thenReturn("attributeName");
        String result = jdomAttributePointer.asPath();
        assertEquals("parentNode/@attributeName", result);
    }

    @Test
    public void testAsPath_WithoutParent() {
        // Simulate no parent by setting parentMock to null
        jdomAttributePointer = new JDOMAttributePointer(null, attributeMock);
        when(attributeMock.getName()).thenReturn("attributeName");
        String result = jdomAttributePointer.asPath();
        assertEquals("@attributeName", result);
    }

    @Test
    public void testAsPath_ParentPathWithoutTrailingSlash() {
        when(parentMock.asPath()).thenReturn("parentNode");
        when(attributeMock.getName()).thenReturn("attributeName");
        String result = jdomAttributePointer.asPath();
        assertEquals("parentNode/@attributeName", result);
    }

    @Test
    public void testAsPath_ParentPathWithTrailingSlash() {
        when(parentMock.asPath()).thenReturn("parentNode/");
        when(attributeMock.getName()).thenReturn("attributeName");
        String result = jdomAttributePointer.asPath();
        assertEquals("parentNode/@attributeName", result);
    }
}
