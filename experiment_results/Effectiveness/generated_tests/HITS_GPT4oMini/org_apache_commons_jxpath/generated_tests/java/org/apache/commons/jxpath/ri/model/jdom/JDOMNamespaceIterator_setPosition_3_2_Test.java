package org.apache.commons.jxpath.ri.model.jdom;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.jxpath.ri.model.NodeIterator;

@ExtendWith(MockitoExtension.class)
public class JDOMNamespaceIterator_setPosition_3_2_Test {

    private JDOMNamespaceIterator iterator;

    private NodePointer parent;

    @BeforeEach
    public void setUp() {
        // Create a sample XML document
        Element root = new Element("root", Namespace.getNamespace("http://example.com"));
        root.addNamespaceDeclaration(Namespace.getNamespace("ns1", "http://example.com/ns1"));
        root.addNamespaceDeclaration(Namespace.getNamespace("ns2", "http://example.com/ns2"));
        Document document = new Document(root);
        // Create a mock of NodePointer
        parent = mock(NodePointer.class);
        when(parent.getNode()).thenReturn(document);
        iterator = new JDOMNamespaceIterator(parent);
    }

    @Test
    public void testSetPosition_ValidPosition() {
        assertTrue(iterator.setPosition(1), "Should return true for valid position 1");
        assertTrue(iterator.setPosition(2), "Should return true for valid position 2");
    }

    @Test
    public void testSetPosition_InvalidPosition() {
        assertFalse(iterator.setPosition(0), "Should return false for invalid position 0");
        assertFalse(iterator.setPosition(3), "Should return false for invalid position 3");
    }

    @Test
    public void testSetPosition_NullNamespaces() {
        // Create an iterator with no namespaces
        NodePointer emptyParent = mock(NodePointer.class);
        when(emptyParent.getNode()).thenReturn(new Document(new Element("empty")));
        JDOMNamespaceIterator emptyIterator = new JDOMNamespaceIterator(emptyParent);
        assertFalse(emptyIterator.setPosition(1), "Should return false when namespaces are null");
    }
}
