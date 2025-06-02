package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import java.io.StringReader;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;

public class JDOMNodeIterator_next_4_0_Test {

    private JDOMNodeIterator iterator;

    private NodePointer parent;

    private NodeTest nodeTest;

    private Element rootElement;

    @BeforeEach
    public void setUp() throws Exception {
        String xml = "<root><child1/><child2/><child3/></root>";
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(new StringReader(xml));
        rootElement = document.getRootElement();
        parent = Mockito.mock(NodePointer.class);
        Mockito.when(parent.getNode()).thenReturn(document);
        // A simple test that always returns true
        nodeTest = new DummyNodeTest();
        iterator = new JDOMNodeIterator(parent, nodeTest, false, null);
    }

    @Test
    public void testNext_FirstCall() {
        assertTrue(iterator.setPosition(1));
        assertEquals(1, iterator.getPosition());
    }

    @Test
    public void testNext_SecondCall() {
        iterator.setPosition(1);
        assertTrue(iterator.setPosition(2));
        assertEquals(2, iterator.getPosition());
    }

    @Test
    public void testNext_ThirdCall() {
        iterator.setPosition(1);
        iterator.setPosition(2);
        assertTrue(iterator.setPosition(3));
        assertEquals(3, iterator.getPosition());
    }

    @Test
    public void testNext_AfterLastChild() {
        iterator.setPosition(1);
        iterator.setPosition(2);
        iterator.setPosition(3);
        assertFalse(iterator.setPosition(4));
        assertEquals(3, iterator.getPosition());
    }

    @Test
    public void testNext_ReverseIterator() {
        iterator = new JDOMNodeIterator(parent, nodeTest, true, null);
        assertTrue(iterator.setPosition(1));
        assertEquals(1, iterator.getPosition());
        assertTrue(iterator.setPosition(2));
        assertEquals(2, iterator.getPosition());
        assertTrue(iterator.setPosition(3));
        assertEquals(3, iterator.getPosition());
        assertFalse(iterator.setPosition(4));
    }

    @Test
    public void testNext_WithStartChild() {
        NodePointer startWith = Mockito.mock(NodePointer.class);
        Mockito.when(startWith.getNode()).thenReturn(rootElement.getChild("child2"));
        iterator = new JDOMNodeIterator(parent, nodeTest, false, startWith);
        assertTrue(iterator.setPosition(1));
        assertEquals(1, iterator.getPosition());
    }

    private static class DummyNodeTest extends NodeTest {
    }
}
