package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.ri.model.beans.CollectionPointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.util.ValueUtils;

public class CollectionPointer_equals_15_0_Test {

    private CollectionPointer collectionPointer1;

    private CollectionPointer collectionPointer2;

    private CollectionPointer collectionPointer3;

    private Object collection;

    @BeforeEach
    public void setUp() {
        // Dummy collection object
        collection = new Object();
        collectionPointer1 = new CollectionPointer(collection, null);
        collectionPointer2 = new CollectionPointer(collection, null);
        collectionPointer3 = new CollectionPointer(new Object(), null);
    }

    @Test
    public void testEquals_SameObject() {
        assertTrue(collectionPointer1.equals(collectionPointer1));
    }

    @Test
    public void testEquals_NullObject() {
        assertFalse(collectionPointer1.equals(null));
    }

    @Test
    public void testEquals_DifferentType() {
        assertFalse(collectionPointer1.equals("Not a CollectionPointer"));
    }

    @Test
    public void testEquals_SameCollectionDifferentIndex() {
        // Assuming index is a field in CollectionPointer, we need to set it using reflection
        setIndex(collectionPointer1, 0);
        setIndex(collectionPointer2, 1);
        assertFalse(collectionPointer1.equals(collectionPointer2));
    }

    @Test
    public void testEquals_SameCollectionSameIndex() {
        // Assuming index is a field in CollectionPointer, we need to set it using reflection
        setIndex(collectionPointer1, 0);
        setIndex(collectionPointer2, 0);
        assertTrue(collectionPointer1.equals(collectionPointer2));
    }

    @Test
    public void testEquals_DifferentCollections() {
        // Assuming index is a field in CollectionPointer, we need to set it using reflection
        setIndex(collectionPointer1, 0);
        setIndex(collectionPointer3, 0);
        assertFalse(collectionPointer1.equals(collectionPointer3));
    }

    private void setIndex(CollectionPointer pointer, int index) {
        try {
            java.lang.reflect.Field indexField = CollectionPointer.class.getDeclaredField("index");
            indexField.setAccessible(true);
            indexField.setInt(pointer, index);
        } catch (Exception e) {
            fail("Failed to set index via reflection");
        }
    }
}
