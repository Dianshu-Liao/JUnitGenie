package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;

public class CollectionPointerFactory_createNodePointer_2_2_Test {

    private final CollectionPointerFactory factory = new CollectionPointerFactory();

    @Test
    public void testCreateNodePointer_WithCollection() {
        List<String> collection = new ArrayList<>();
        QName name = new QName("testPrefix", "testName");
        // Assuming a null parent for simplicity
        NodePointer parent = null;
        NodePointer result = factory.createNodePointer(parent, name, collection);
        assertNotNull(result, "Expected a non-null NodePointer for a collection.");
    }

    @Test
    public void testCreateNodePointer_WithArray() {
        String[] array = new String[] { "item1", "item2" };
        QName name = new QName("testPrefix", "testName");
        // Assuming a null parent for simplicity
        NodePointer parent = null;
        NodePointer result = factory.createNodePointer(parent, name, array);
        assertNotNull(result, "Expected a non-null NodePointer for an array.");
    }

    @Test
    public void testCreateNodePointer_WithNonCollection() {
        String nonCollectionObject = "Not a collection";
        QName name = new QName("testPrefix", "testName");
        // Assuming a null parent for simplicity
        NodePointer parent = null;
        NodePointer result = factory.createNodePointer(parent, name, nonCollectionObject);
        assertNull(result, "Expected a null NodePointer for a non-collection object.");
    }

    @Test
    public void testCreateNodePointer_WithNull() {
        QName name = new QName("testPrefix", "testName");
        // Assuming a null parent for simplicity
        NodePointer parent = null;
        NodePointer result = factory.createNodePointer(parent, name, null);
        assertNull(result, "Expected a null NodePointer for a null bean.");
    }

    @Test
    public void testCreateNodePointer_WithEmptyCollection() {
        List<String> emptyCollection = Collections.emptyList();
        QName name = new QName("testPrefix", "testName");
        // Assuming a null parent for simplicity
        NodePointer parent = null;
        NodePointer result = factory.createNodePointer(parent, name, emptyCollection);
        assertNotNull(result, "Expected a non-null NodePointer for an empty collection.");
    }
}
