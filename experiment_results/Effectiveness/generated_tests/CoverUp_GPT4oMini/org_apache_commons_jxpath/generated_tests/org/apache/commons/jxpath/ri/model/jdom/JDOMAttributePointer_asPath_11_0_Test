package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.jdom.Attribute;
import org.jdom.Element;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.util.TypeUtils;

public class JDOMAttributePointer_asPath_11_0_Test {

    private JDOMAttributePointer pointer;

    private NodePointer parentPointer;

    private Attribute attribute;

    @BeforeEach
    public void setUp() {
        // Mocking the attribute and parent NodePointer
        attribute = mock(Attribute.class);
        when(attribute.getNamespaceURI()).thenReturn("http://example.com");
        when(attribute.getValue()).thenReturn("value");
        when(attribute.getName()).thenReturn("attrName");
        parentPointer = mock(NodePointer.class);
        when(parentPointer.asPath()).thenReturn("parentPath");
        pointer = new JDOMAttributePointer(parentPointer, attribute);
    }

    @Test
    public void testAsPathWithParent() {
        String expectedPath = "parentPath/@attrName";
        assertEquals(expectedPath, pointer.asPath());
    }

    @Test
    public void testAsPathWithoutParent() {
        // Create a new pointer without a parent
        JDOMAttributePointer pointerWithoutParent = new JDOMAttributePointer(null, attribute);
        String expectedPath = "@attrName";
        assertEquals(expectedPath, pointerWithoutParent.asPath());
    }

    @Test
    public void testAsPathWithEmptyParentPath() {
        // Test with an empty parent path
        when(parentPointer.asPath()).thenReturn("");
        String expectedPath = "@attrName";
        assertEquals(expectedPath, pointer.asPath());
    }

    @Test
    public void testAsPathWithTrailingSlashInParentPath() {
        // Test with a parent path that ends with a slash
        when(parentPointer.asPath()).thenReturn("parentPath/");
        String expectedPath = "parentPath/@attrName";
        assertEquals(expectedPath, pointer.asPath());
    }

    @Test
    public void testAsPathWithNonEmptyNamespaceURI() {
        when(attribute.getNamespaceURI()).thenReturn("http://example.com");
        when(attribute.getName()).thenReturn("attrName");
        String expectedPath = "parentPath/@attrName";
        assertEquals(expectedPath, pointer.asPath());
    }

    @Test
    public void testAsPathWithEmptyNamespaceURI() {
        when(attribute.getNamespaceURI()).thenReturn("");
        when(attribute.getName()).thenReturn("attrName");
        String expectedPath = "parentPath/@attrName";
        assertEquals(expectedPath, pointer.asPath());
    }
}
