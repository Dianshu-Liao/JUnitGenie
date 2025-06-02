package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathIntrospector;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;

public class CollectionPointer_isLeaf_4_1_Test {

    private CollectionPointer collectionPointer;

    @BeforeEach
    public void setUp() {
        // Using the constructor that takes an Object and Locale
        collectionPointer = new CollectionPointer((Object) null, Locale.getDefault());
    }

    @Test
    public void testIsLeafWithNullValue() {
        // Directly setting the collection field using reflection
        setCollectionField(collectionPointer, null);
        assertTrue(collectionPointer.isLeaf(), "Expected isLeaf() to return true when value is null");
    }

    @Test
    public void testIsLeafWithAtomicValue() {
        // Directly setting the collection field using reflection
        setCollectionField(collectionPointer, "Test String");
        assertTrue(collectionPointer.isLeaf(), "Expected isLeaf() to return true for atomic value");
    }

    @Test
    public void testIsLeafWithNonAtomicValue() {
        // Directly setting the collection field using reflection
        setCollectionField(collectionPointer, new Object());
        assertFalse(collectionPointer.isLeaf(), "Expected isLeaf() to return false for non-atomic value");
    }

    private void setCollectionField(CollectionPointer collectionPointer, Object value) {
        try {
            java.lang.reflect.Field field = CollectionPointer.class.getDeclaredField("collection");
            field.setAccessible(true);
            field.set(collectionPointer, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to set collection field", e);
        }
    }
}
