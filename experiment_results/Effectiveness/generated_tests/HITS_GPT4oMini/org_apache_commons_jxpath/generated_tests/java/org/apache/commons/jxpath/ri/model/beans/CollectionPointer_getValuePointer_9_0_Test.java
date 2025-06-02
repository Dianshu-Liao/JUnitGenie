package org.apache.commons.jxpath.ri.model.beans;

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
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.util.ValueUtils;

public class CollectionPointer_getValuePointer_9_0_Test {

    private CollectionPointer collectionPointer;

    private List<String> testCollection;

    @BeforeEach
    public void setUp() {
        // Initialize a test collection
        testCollection = new ArrayList<>();
        testCollection.add("Item 1");
        testCollection.add("Item 2");
        testCollection.add("Item 3");
        collectionPointer = new CollectionPointer(testCollection, Locale.getDefault());
    }

    @Test
    public void testGetValuePointer_WholeCollection() {
        // Set index to WHOLE_COLLECTION
        collectionPointer.setIndex(CollectionPointer.WHOLE_COLLECTION);
        NodePointer valuePointer = collectionPointer.getValuePointer();
        // Assert that the valuePointer is not null and is the same as the collectionPointer
        assertNotNull(valuePointer);
        assertEquals(collectionPointer, valuePointer);
    }

    @Test
    public void testGetValuePointer_SingleItem() {
        // Set index to 0 to get the first item
        collectionPointer.setIndex(0);
        NodePointer valuePointer = collectionPointer.getValuePointer();
        // Assert that valuePointer is not null
        assertNotNull(valuePointer);
        // Assert that the valuePointer points to the correct item
        assertEquals("Item 1", valuePointer.getImmediateNode());
    }

    @Test
    public void testGetValuePointer_SecondItem() {
        // Set index to 1 to get the second item
        collectionPointer.setIndex(1);
        NodePointer valuePointer = collectionPointer.getValuePointer();
        // Assert that valuePointer is not null
        assertNotNull(valuePointer);
        // Assert that the valuePointer points to the correct item
        assertEquals("Item 2", valuePointer.getImmediateNode());
    }

    @Test
    public void testGetValuePointer_ThirdItem() {
        // Set index to 2 to get the third item
        collectionPointer.setIndex(2);
        NodePointer valuePointer = collectionPointer.getValuePointer();
        // Assert that valuePointer is not null
        assertNotNull(valuePointer);
        // Assert that the valuePointer points to the correct item
        assertEquals("Item 3", valuePointer.getImmediateNode());
    }

    @Test
    public void testGetValuePointer_NonExistingIndex() {
        // Set index to an out of bounds value
        collectionPointer.setIndex(5);
        NodePointer valuePointer = collectionPointer.getValuePointer();
        // Assert that valuePointer is not null
        assertNotNull(valuePointer);
        // Assert that the valuePointer points to null as there is no item at index 5
        assertEquals(null, valuePointer.getImmediateNode());
    }
}
