package org.apache.commons.jxpath.ri.model.jdom;

import org.jdom.Attribute;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.util.TypeUtils;

public class JDOMAttributePointer_asPath_11_0_Test {

    private NodePointer parent;

    private Attribute attribute;

    private JDOMAttributePointer attributePointer;

    @BeforeEach
    public void setUp() {
        parent = mock(NodePointer.class);
        attribute = mock(Attribute.class);
        attributePointer = new JDOMAttributePointer(parent, attribute);
    }

    @Test
    public void testAsPath_WithParent() {
        // Arrange
        when(parent.asPath()).thenReturn("parentPath");
        when(attribute.getNamespaceURI()).thenReturn("namespace");
        when(attribute.getValue()).thenReturn("value");
        when(attribute.getName()).thenReturn("attrName");
        // Act
        String path = attributePointer.asPath();
        // Assert
        assertEquals("parentPath/@attrName", path);
    }

    @Test
    public void testAsPath_WithoutParent() {
        // Arrange
        attributePointer = new JDOMAttributePointer(null, attribute);
        when(attribute.getNamespaceURI()).thenReturn("namespace");
        when(attribute.getValue()).thenReturn("value");
        when(attribute.getName()).thenReturn("attrName");
        // Act
        String path = attributePointer.asPath();
        // Assert
        assertEquals("@attrName", path);
    }

    @Test
    public void testAsPath_WithEmptyParentPath() {
        // Arrange
        when(parent.asPath()).thenReturn("");
        when(attribute.getNamespaceURI()).thenReturn("namespace");
        when(attribute.getValue()).thenReturn("value");
        when(attribute.getName()).thenReturn("attrName");
        // Act
        String path = attributePointer.asPath();
        // Assert
        assertEquals("@attrName", path);
    }

    @Test
    public void testAsPath_WithParentPathEndingWithSlash() {
        // Arrange
        when(parent.asPath()).thenReturn("parentPath/");
        when(attribute.getNamespaceURI()).thenReturn("namespace");
        when(attribute.getValue()).thenReturn("value");
        when(attribute.getName()).thenReturn("attrName");
        // Act
        String path = attributePointer.asPath();
        // Assert
        assertEquals("parentPath/@attrName", path);
    }
}
