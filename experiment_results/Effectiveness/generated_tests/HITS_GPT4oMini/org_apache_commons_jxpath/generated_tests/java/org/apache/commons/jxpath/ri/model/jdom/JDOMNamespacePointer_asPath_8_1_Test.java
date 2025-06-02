package org.apache.commons.jxpath.ri.model.jdom;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;

public class JDOMNamespacePointer_asPath_8_1_Test {

    private JDOMNamespacePointer childPointer;

    private JDOMNamespacePointer parentPointer;

    @BeforeEach
    public void setUp() {
        // Initialize parent and child pointers for the tests
        parentPointer = new JDOMNamespacePointer(null, "parentPrefix");
        childPointer = new JDOMNamespacePointer(parentPointer, "childPrefix");
    }

    @Test
    public void testAsPath_WithParent() {
        // Test when the parent is not null
        String expectedPath = "namespace::parentPrefix/namespace::childPrefix";
        assertEquals(expectedPath, childPointer.asPath());
    }

    @Test
    public void testAsPath_WithoutParent() {
        // Test when the parent is null
        JDOMNamespacePointer noParentPointer = new JDOMNamespacePointer(null, "noParentPrefix");
        String expectedPath = "namespace::noParentPrefix";
        assertEquals(expectedPath, noParentPointer.asPath());
    }

    @Test
    public void testAsPath_EmptyBuffer() {
        // Test when the buffer is empty and ensure '/' is appended correctly
        JDOMNamespacePointer emptyBufferPointer = new JDOMNamespacePointer(null, "emptyBufferPrefix");
        String expectedPath = "namespace::emptyBufferPrefix";
        assertEquals(expectedPath, emptyBufferPointer.asPath());
    }

    @Test
    public void testAsPath_BufferDoesNotEndWithSlash() {
        // Test for a case where the buffer does not end with '/'
        JDOMNamespacePointer parentWithSlashPointer = new JDOMNamespacePointer(null, "parentWithSlashPrefix");
        JDOMNamespacePointer childWithoutSlashPointer = new JDOMNamespacePointer(parentWithSlashPointer, "childWithoutSlashPrefix");
        String expectedPath = "namespace::parentWithSlashPrefix/namespace::childWithoutSlashPrefix";
        assertEquals(expectedPath, childWithoutSlashPointer.asPath());
    }
}
