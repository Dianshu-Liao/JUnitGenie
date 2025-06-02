package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.util.ValueUtils;

public class CollectionPointer_isLeaf_4_4_Test {

    private CollectionPointer collectionPointer;

    @BeforeEach
    public void setUp() {
        // Initialize CollectionPointer with an empty ArrayList
        collectionPointer = new CollectionPointer(new ArrayList<>(), Locale.getDefault());
    }

    @Test
    public void testIsLeafWithNullValue() throws Exception {
        // Set the collection to null and test
        invokeSetCollectionMethod(null);
        assertTrue(collectionPointer.isLeaf());
    }

    @Test
    public void testIsLeafWithAtomicValue() throws Exception {
        // Set the collection to an atomic value (e.g., Integer)
        invokeSetCollectionMethod(42);
        assertTrue(collectionPointer.isLeaf());
    }

    @Test
    public void testIsLeafWithNonAtomicValue() throws Exception {
        // Set the collection to a non-atomic value (e.g., a List)
        invokeSetCollectionMethod(new ArrayList<>());
        assertFalse(collectionPointer.isLeaf());
    }

    private void invokeSetCollectionMethod(Object collection) throws Exception {
        // Use reflection to set the private field 'collection'
        java.lang.reflect.Field field = CollectionPointer.class.getDeclaredField("collection");
        field.setAccessible(true);
        field.set(collectionPointer, collection);
    }

    private Object getNode() throws Exception {
        // Use reflection to access the private method 'getNode'
        java.lang.reflect.Method method = CollectionPointer.class.getDeclaredMethod("getNode");
        method.setAccessible(true);
        return method.invoke(collectionPointer);
    }
}
