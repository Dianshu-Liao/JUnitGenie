package org.apache.commons.jxpath.ri.model.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.w3c.dom.Attr;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.w3c.dom.NamedNodeMap;

public class DOMNamespaceIterator_collectNamespaces_0_0_Test {

    private DocumentBuilderFactory factory;

    private DocumentBuilder builder;

    private Document document;

    @BeforeEach
    public void setUp() throws Exception {
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.newDocument();
    }

    @Test
    public void testCollectNamespaces_EmptyDocument() throws Exception {
        Node rootNode = document.createElement("root");
        document.appendChild(rootNode);
        DOMNamespaceIterator iterator = new DOMNamespaceIterator(new DOMNodePointer(rootNode, null));
        List<Attr> attributes = getAttributes(iterator);
        assertEquals(0, attributes.size());
    }

    @Test
    public void testCollectNamespaces_SingleNamespace() throws Exception {
        Element rootNode = document.createElement("root");
        rootNode.setAttribute("xmlns:test", "http://example.com/test");
        document.appendChild(rootNode);
        DOMNamespaceIterator iterator = new DOMNamespaceIterator(new DOMNodePointer(rootNode, null));
        List<Attr> attributes = getAttributes(iterator);
        assertEquals(1, attributes.size());
        assertEquals("http://example.com/test", attributes.get(0).getValue());
    }

    @Test
    public void testCollectNamespaces_MultipleNamespaces() throws Exception {
        Element rootNode = document.createElement("root");
        rootNode.setAttribute("xmlns:test1", "http://example.com/test1");
        rootNode.setAttribute("xmlns:test2", "http://example.com/test2");
        document.appendChild(rootNode);
        DOMNamespaceIterator iterator = new DOMNamespaceIterator(new DOMNodePointer(rootNode, null));
        List<Attr> attributes = getAttributes(iterator);
        assertEquals(2, attributes.size());
        assertEquals("http://example.com/test1", attributes.get(0).getValue());
        assertEquals("http://example.com/test2", attributes.get(1).getValue());
    }

    @Test
    public void testCollectNamespaces_NamespaceInParent() throws Exception {
        Element parentNode = document.createElement("parent");
        parentNode.setAttribute("xmlns:test", "http://example.com/test");
        document.appendChild(parentNode);
        Element childNode = document.createElement("child");
        parentNode.appendChild(childNode);
        DOMNamespaceIterator iterator = new DOMNamespaceIterator(new DOMNodePointer(childNode, null));
        List<Attr> attributes = getAttributes(iterator);
        assertEquals(1, attributes.size());
        assertEquals("http://example.com/test", attributes.get(0).getValue());
    }

    private List<Attr> getAttributes(DOMNamespaceIterator iterator) throws Exception {
        Field field = DOMNamespaceIterator.class.getDeclaredField("attributes");
        field.setAccessible(true);
        return (List<Attr>) field.get(iterator);
    }
}
