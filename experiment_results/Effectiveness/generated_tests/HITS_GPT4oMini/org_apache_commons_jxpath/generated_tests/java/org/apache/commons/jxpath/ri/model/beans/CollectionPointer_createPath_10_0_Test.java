package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;

public class CollectionPointer_createPath_10_0_Test {

    private CollectionPointer collectionPointer;

    private JXPathContext context;

    @BeforeEach
    public void setUp() {
        List<String> collection = new ArrayList<>();
        collectionPointer = new CollectionPointer(collection, Locale.getDefault());
        context = JXPathContext.newContext(collection);
    }

    @Test
    public void testCreatePath_EmptyCollection() {
        NodePointer result = collectionPointer.createPath(context);
        assertNotNull(result);
        assertEquals(0, collectionPointer.getLength());
    }

    @Test
    public void testCreatePath_ExpandCollection() {
        // Set index to a value greater than current size
        collectionPointer.setIndex(2);
        NodePointer result = collectionPointer.createPath(context);
        assertNotNull(result);
        assertEquals(3, collectionPointer.getLength());
    }

    @Test
    public void testCreatePath_AddValueToExpandedCollection() {
        // Set index to 1
        collectionPointer.setIndex(1);
        collectionPointer.createPath(context);
        collectionPointer.setValue("Test Value");
        assertEquals("Test Value", collectionPointer.getImmediateNode());
    }

    @Test
    public void testCreatePath_ExpandToArray() {
        String[] array = new String[2];
        collectionPointer = new CollectionPointer(array, Locale.getDefault());
        // Set index to expand
        collectionPointer.setIndex(3);
        NodePointer result = collectionPointer.createPath(context);
        assertNotNull(result);
        assertEquals(4, collectionPointer.getLength());
    }

    @Test
    public void testCreatePath_ExpandCollectionWithNull() {
        List<String> collection = new ArrayList<>();
        collectionPointer = new CollectionPointer(collection, Locale.getDefault());
        // Set index to 0
        collectionPointer.setIndex(0);
        NodePointer result = collectionPointer.createPath(context);
        assertNotNull(result);
        assertEquals(1, collectionPointer.getLength());
        assertNull(collectionPointer.getImmediateNode());
    }

    @Test
    public void testCreatePath_InvalidIndex() {
        // Set an invalid index
        collectionPointer.setIndex(-1);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            collectionPointer.createPath(context);
        });
    }
}
