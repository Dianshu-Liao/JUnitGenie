package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import org.apache.commons.jxpath.ri.model.NodeIterator;

class JDOMNodeIterator_next_4_1_Test {

    private NodePointer parent;

    private NodeTest nodeTest;

    private JDOMNodeIterator iterator;

    private NodePointer startWith;

    @BeforeEach
    void setUp() throws Exception {
        parent = mock(NodePointer.class);
        nodeTest = mock(NodeTest.class);
        String xml = "<root><child1/><child2/><child3/></root>";
        Document document = new SAXBuilder().build(new StringReader(xml));
        when(parent.getNode()).thenReturn(document);
        iterator = new JDOMNodeIterator(parent, nodeTest, false, null);
    }

    @Test
    void testNextForward() {
        assertTrue(invokeNext(iterator));
        assertEquals(1, iterator.getPosition());
        assertTrue(invokeNext(iterator));
        assertEquals(2, iterator.getPosition());
        assertTrue(invokeNext(iterator));
        assertEquals(3, iterator.getPosition());
        assertFalse(invokeNext(iterator));
        assertEquals(3, iterator.getPosition());
    }

    @Test
    void testNextReverse() {
        iterator = new JDOMNodeIterator(parent, nodeTest, true, null);
        assertTrue(invokeNext(iterator));
        assertEquals(1, iterator.getPosition());
        assertFalse(invokeNext(iterator));
        assertEquals(1, iterator.getPosition());
    }

    @Test
    void testNextWithChild() {
        startWith = mock(NodePointer.class);
        when(startWith.getNode()).thenReturn(new Element("child2"));
        iterator = new JDOMNodeIterator(parent, nodeTest, false, startWith);
        assertTrue(invokeNext(iterator));
        assertEquals(2, iterator.getPosition());
        assertFalse(invokeNext(iterator));
        assertEquals(2, iterator.getPosition());
    }

    private boolean invokeNext(JDOMNodeIterator iterator) {
        try {
            Method nextMethod = JDOMNodeIterator.class.getDeclaredMethod("next");
            nextMethod.setAccessible(true);
            return (boolean) nextMethod.invoke(iterator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
