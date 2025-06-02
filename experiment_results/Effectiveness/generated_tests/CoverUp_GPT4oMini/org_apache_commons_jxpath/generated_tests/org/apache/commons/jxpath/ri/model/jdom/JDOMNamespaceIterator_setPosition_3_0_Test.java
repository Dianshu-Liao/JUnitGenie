package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.model.NodePointer;
import org.jdom.Namespace;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.jdom.Document;
import org.jdom.Element;

class JDOMNamespaceIterator_setPosition_3_0_Test {

    private NodePointer mockNodePointer;

    private JDOMNamespaceIterator iterator;

    @BeforeEach
    void setUp() {
        mockNodePointer = mock(NodePointer.class);
        iterator = new JDOMNamespaceIterator(mockNodePointer);
    }

    @Test
    void testSetPositionWithNullNamespaces() {
        // Simulate no namespaces
        assertFalse(invokeSetPosition(iterator, 1));
    }

    @Test
    void testSetPositionWithValidPosition() {
        // Prepare namespaces
        List<Namespace> namespaces = new ArrayList<>();
        namespaces.add(Namespace.getNamespace("prefix1", "uri1"));
        namespaces.add(Namespace.getNamespace("prefix2", "uri2"));
        // Use reflection to set private field 'namespaces'
        setPrivateField(iterator, "namespaces", namespaces);
        assertTrue(invokeSetPosition(iterator, 1));
        assertEquals(1, iterator.getPosition());
        assertTrue(invokeSetPosition(iterator, 2));
        assertEquals(2, iterator.getPosition());
    }

    @Test
    void testSetPositionWithOutOfBoundsPosition() {
        // Prepare namespaces
        List<Namespace> namespaces = new ArrayList<>();
        namespaces.add(Namespace.getNamespace("prefix1", "uri1"));
        // Use reflection to set private field 'namespaces'
        setPrivateField(iterator, "namespaces", namespaces);
        assertFalse(invokeSetPosition(iterator, 0));
        assertEquals(0, iterator.getPosition());
        assertFalse(invokeSetPosition(iterator, 2));
        assertEquals(0, iterator.getPosition());
    }

    private boolean invokeSetPosition(JDOMNamespaceIterator iterator, int position) {
        try {
            Method method = JDOMNamespaceIterator.class.getDeclaredMethod("setPosition", int.class);
            method.setAccessible(true);
            return (boolean) method.invoke(iterator, position);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setPrivateField(JDOMNamespaceIterator iterator, String fieldName, Object value) {
        try {
            Field field = JDOMNamespaceIterator.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(iterator, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
