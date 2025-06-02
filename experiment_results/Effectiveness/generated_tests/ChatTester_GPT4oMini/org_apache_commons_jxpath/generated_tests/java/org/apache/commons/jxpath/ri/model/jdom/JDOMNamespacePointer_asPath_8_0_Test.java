package org.apache.commons.jxpath.ri.model.jdom;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;

public class JDOMNamespacePointer_asPath_8_0_Test {

    private JDOMNamespacePointer jdomNamespacePointer;

    private NodePointer mockParent;

    @BeforeEach
    public void setUp() {
        mockParent = mock(NodePointer.class);
    }

    @Test
    public void testAsPath_WithParent() {
        // Arrange
        when(mockParent.asPath()).thenReturn("parentPath");
        jdomNamespacePointer = new JDOMNamespacePointer(mockParent, "prefix");
        // Act
        String result = jdomNamespacePointer.asPath();
        // Assert
        assertEquals("parentPath/namespace::prefix", result);
    }

    @Test
    public void testAsPath_WithoutParent() {
        // Arrange
        jdomNamespacePointer = new JDOMNamespacePointer(null, "prefix");
        // Act
        String result = jdomNamespacePointer.asPath();
        // Assert
        assertEquals("namespace::prefix", result);
    }

    @Test
    public void testAsPath_ParentPathWithoutTrailingSlash() {
        // Arrange
        when(mockParent.asPath()).thenReturn("parentPathWithoutSlash");
        jdomNamespacePointer = new JDOMNamespacePointer(mockParent, "prefix");
        // Act
        String result = jdomNamespacePointer.asPath();
        // Assert
        assertEquals("parentPathWithoutSlash/namespace::prefix", result);
    }

    @Test
    public void testAsPath_ParentPathEmpty() {
        // Arrange
        when(mockParent.asPath()).thenReturn("");
        jdomNamespacePointer = new JDOMNamespacePointer(mockParent, "prefix");
        // Act
        String result = jdomNamespacePointer.asPath();
        // Assert
        assertEquals("namespace::prefix", result);
    }

    @Test
    public void testAsPath_ParentPathNull() {
        // Arrange
        when(mockParent.asPath()).thenReturn(null);
        jdomNamespacePointer = new JDOMNamespacePointer(mockParent, "prefix");
        // Act
        String result = jdomNamespacePointer.asPath();
        // Assert
        assertEquals("namespace::prefix", result);
    }
}
