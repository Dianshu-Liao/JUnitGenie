package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointer;
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

class CollectionPointer_createPath_10_0_Test {

    private CollectionPointer collectionPointer;

    private JXPathContext context;

    @BeforeEach
    void setUp() {
        List<Object> collection = new ArrayList<>();
        collection.add("item1");
        collection.add("item2");
        collectionPointer = new CollectionPointer(collection, Locale.getDefault());
        context = JXPathContext.newContext(collection);
    }

    @Test
    void testCreatePathWhenCollectionIsExpanded() {
        // Set the index to a value that requires expansion
        // Expanding the collection to hold at least 3 items
        collectionPointer.setIndex(2);
        // Invoke the private method using reflection
        NodePointer result = invokeCreatePath(collectionPointer, context);
        // Verify that the collection has been expanded
        assertEquals(3, ValueUtils.getLength(collectionPointer.getBaseValue()));
        assertNotNull(result);
    }

    @Test
    void testCreatePathWhenCollectionIsNotExpanded() {
        // Set the index to a value that does not require expansion
        // The collection already has 2 items
        collectionPointer.setIndex(1);
        // Invoke the private method using reflection
        NodePointer result = invokeCreatePath(collectionPointer, context);
        // Verify that the collection has not been expanded
        assertEquals(2, ValueUtils.getLength(collectionPointer.getBaseValue()));
        assertNotNull(result);
    }

    private NodePointer invokeCreatePath(CollectionPointer collectionPointer, JXPathContext context) {
        try {
            java.lang.reflect.Method method = CollectionPointer.class.getDeclaredMethod("createPath", JXPathContext.class);
            method.setAccessible(true);
            return (NodePointer) method.invoke(collectionPointer, context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
