package org.apache.commons.jxpath.ri.model.jdom;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.QName;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class JDOMNamespacePointer_asPath_8_0_Test {

    private JDOMNamespacePointer rootPointer;

    private JDOMNamespacePointer childPointer;

    private NodePointer mockParent;

    @BeforeEach
    public void setUp() {
        mockParent = mock(NodePointer.class);
        rootPointer = new JDOMNamespacePointer(mockParent, "rootNamespace");
        childPointer = new JDOMNamespacePointer(mockParent, "childNamespace");
        // Set parent for childPointer through constructor
        childPointer = new JDOMNamespacePointer(rootPointer, "childNamespace");
    }

    @Test
    public void testAsPathForRootPointer() {
        // Test the asPath method for the root pointer
        String expectedPath = "namespace::rootNamespace";
        assertEquals(expectedPath, rootPointer.asPath());
    }

    @Test
    public void testAsPathForChildPointer() {
        // Test the asPath method for the child pointer
        String expectedPath = "namespace::rootNamespace/namespace::childNamespace";
        assertEquals(expectedPath, childPointer.asPath());
    }

    @Test
    public void testAsPathForChildPointerWithEmptyPrefix() {
        // Test the asPath method for a child pointer with an empty prefix
        JDOMNamespacePointer emptyPrefixPointer = new JDOMNamespacePointer(mockParent, "");
        emptyPrefixPointer = new JDOMNamespacePointer(rootPointer, "");
        String expectedPath = "namespace::rootNamespace/namespace::";
        assertEquals(expectedPath, emptyPrefixPointer.asPath());
    }

    @Test
    public void testAsPathForChildPointerWithNullParent() {
        // Test the asPath method for a pointer with null parent
        JDOMNamespacePointer nullParentPointer = new JDOMNamespacePointer(null, "nullParentNamespace");
        String expectedPath = "namespace::nullParentNamespace";
        assertEquals(expectedPath, nullParentPointer.asPath());
    }
}
