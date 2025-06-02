package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.util.ValueUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CollectionPointer_getImmediateNode_6_0_Test {

    private CollectionPointer collectionPointer;

    // Assuming WHOLE_COLLECTION is defined as -1
    private static final int WHOLE_COLLECTION = -1;

    @BeforeEach
    void setUp() {
        // Setting up a collection for testing
        List<String> collection = Arrays.asList("A", "B", "C");
        collectionPointer = new CollectionPointer((Object) collection, Locale.getDefault());
        collectionPointer.setIndex(WHOLE_COLLECTION);
    }

    @Test
    void testGetImmediateNodeWholeCollection() {
        Object result = collectionPointer.getImmediateNode();
        assertEquals(Arrays.asList("A", "B", "C"), result);
    }

    @Test
    void testGetImmediateNodeWithIndex() {
        collectionPointer.setIndex(1);
        Object result = collectionPointer.getImmediateNode();
        assertEquals("B", result);
    }

    @Test
    void testGetImmediateNodeWithOutOfBoundsIndex() {
        // Out of bounds
        collectionPointer.setIndex(5);
        Object result = collectionPointer.getImmediateNode();
        assertNull(result);
    }

    @Test
    void testGetImmediateNodeWithNegativeIndex() {
        // Negative index
        collectionPointer.setIndex(-1);
        Object result = collectionPointer.getImmediateNode();
        assertNull(result);
    }

    @Test
    void testGetImmediateNodeEmptyCollection() {
        collectionPointer = new CollectionPointer((Object) Collections.emptyList(), Locale.getDefault());
        collectionPointer.setIndex(WHOLE_COLLECTION);
        Object result = collectionPointer.getImmediateNode();
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void testGetImmediateNodeWithNullCollection() {
        collectionPointer = new CollectionPointer((Object) null, Locale.getDefault());
        collectionPointer.setIndex(WHOLE_COLLECTION);
        Object result = collectionPointer.getImmediateNode();
        assertNull(result);
    }
}
