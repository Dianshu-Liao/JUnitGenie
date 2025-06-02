package org.apache.commons.jxpath.ri.model.beans;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.apache.commons.jxpath.util.ValueUtils;

public class CollectionPointerFactory_createNodePointer_2_0_Test {

    private CollectionPointerFactory factory;

    private NodePointer parent;

    private QName name;

    @BeforeEach
    public void setUp() {
        factory = new CollectionPointerFactory();
        parent = Mockito.mock(NodePointer.class);
        name = Mockito.mock(QName.class);
    }

    @Test
    public void testCreateNodePointerWithCollection() {
        // Example of a collection
        Object collectionBean = new java.util.ArrayList<>();
        NodePointer result = factory.createNodePointer(parent, name, collectionBean);
        assertNotNull(result);
        assertTrue(result instanceof CollectionPointer);
    }

    @Test
    public void testCreateNodePointerWithNonCollection() {
        // Example of a non-collection
        Object nonCollectionBean = new Object();
        NodePointer result = factory.createNodePointer(parent, name, nonCollectionBean);
        assertNull(result);
    }

    @Test
    public void testCreateNodePointerWithNull() {
        NodePointer result = factory.createNodePointer(parent, name, null);
        assertNull(result);
    }
}
