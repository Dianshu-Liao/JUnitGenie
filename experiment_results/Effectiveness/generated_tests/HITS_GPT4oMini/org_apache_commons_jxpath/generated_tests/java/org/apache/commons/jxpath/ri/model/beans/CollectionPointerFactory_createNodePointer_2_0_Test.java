package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;

public class CollectionPointerFactory_createNodePointer_2_0_Test {

    private final CollectionPointerFactory factory = new CollectionPointerFactory();

    @Test
    public void testCreateNodePointer_WithCollection() {
        Collection<String> collection = new ArrayList<>();
        QName qName = new QName("testQName");
        NodePointer parent = null;
        NodePointer result = factory.createNodePointer(parent, qName, collection);
        assertNotNull(result, "Expected a non-null NodePointer when a collection is provided.");
        assertTrue(result instanceof NodePointer, "Expected result to be an instance of NodePointer");
    }

    @Test
    public void testCreateNodePointer_WithArray() {
        String[] array = new String[] { "element1", "element2" };
        QName qName = new QName("testQName");
        NodePointer parent = null;
        NodePointer result = factory.createNodePointer(parent, qName, array);
        assertNotNull(result, "Expected a non-null NodePointer when an array is provided.");
        assertTrue(result instanceof NodePointer, "Expected result to be an instance of NodePointer");
    }

    @Test
    public void testCreateNodePointer_WithNonCollection() {
        String nonCollection = "Not a collection";
        QName qName = new QName("testQName");
        NodePointer parent = null;
        NodePointer result = factory.createNodePointer(parent, qName, nonCollection);
        assertNull(result, "Expected a null NodePointer when a non-collection is provided.");
    }

    @Test
    public void testCreateNodePointer_WithNull() {
        QName qName = new QName("testQName");
        NodePointer parent = null;
        NodePointer result = factory.createNodePointer(parent, qName, null);
        assertNull(result, "Expected a null NodePointer when null is provided as the bean.");
    }

    @Test
    public void testCreateNodePointer_WithEmptyCollection() {
        Collection<String> collection = Collections.emptyList();
        QName qName = new QName("testQName");
        NodePointer parent = null;
        NodePointer result = factory.createNodePointer(parent, qName, collection);
        assertNotNull(result, "Expected a non-null NodePointer when an empty collection is provided.");
        assertTrue(result instanceof NodePointer, "Expected result to be an instance of NodePointer");
    }
}
