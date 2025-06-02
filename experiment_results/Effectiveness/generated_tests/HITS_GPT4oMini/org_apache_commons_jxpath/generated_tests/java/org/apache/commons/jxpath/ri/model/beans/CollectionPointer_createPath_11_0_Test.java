package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.util.ArrayList;
import java.util.Locale;
import java.util.List;
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
import org.apache.commons.jxpath.util.ValueUtils;

class CollectionPointer_createPath_11_0_Test {

    private CollectionPointer collectionPointer;

    private JXPathContext context;

    @BeforeEach
    void setUp() {
        List<String> testList = new ArrayList<>();
        collectionPointer = new CollectionPointer(testList, Locale.getDefault());
        context = JXPathContext.newContext(collectionPointer);
    }

    @Test
    void testCreatePathWithNewValue() {
        NodePointer pointer = collectionPointer.createPath(context, "New Value");
        assertNotNull(pointer);
        assertEquals("New Value", pointer.getValue());
    }

    @Test
    void testCreatePathExpandsCollection() {
        NodePointer pointer = collectionPointer.createPath(context, "First Value");
        assertNotNull(pointer);
        assertEquals("First Value", pointer.getValue());
        pointer = collectionPointer.createPath(context, "Second Value");
        assertNotNull(pointer);
        assertEquals("Second Value", pointer.getValue());
        assertEquals(2, collectionPointer.getLength());
    }

    @Test
    void testCreatePathWithNullValue() {
        NodePointer pointer = collectionPointer.createPath(context, null);
        assertNotNull(pointer);
        assertNull(pointer.getValue());
    }

    @Test
    void testCreatePathWithEmptyCollection() {
        CollectionPointer emptyCollectionPointer = new CollectionPointer(new ArrayList<>(), Locale.getDefault());
        NodePointer pointer = emptyCollectionPointer.createPath(context, "Value in Empty Collection");
        assertNotNull(pointer);
        assertEquals("Value in Empty Collection", pointer.getValue());
        assertEquals(1, emptyCollectionPointer.getLength());
    }

    @Test
    void testCreatePathHandlesMultipleCalls() {
        for (int i = 0; i < 5; i++) {
            collectionPointer.createPath(context, "Value " + i);
        }
        assertEquals(5, collectionPointer.getLength());
    }
}
