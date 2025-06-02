package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointerFactory;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.apache.commons.jxpath.util.ValueUtils;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CollectionPointerFactory_createNodePointer_2_2_Test {

    private CollectionPointerFactory collectionPointerFactory;

    @BeforeEach
    void setUp() {
        collectionPointerFactory = new CollectionPointerFactory();
    }

    @Test
    void testCreateNodePointerWithCollection() {
        // Arrange
        NodePointer parentPointer = mock(NodePointer.class);
        QName qName = new QName("test");
        List<String> collection = new ArrayList<>();
        collection.add("item1");
        collection.add("item2");
        // Act
        NodePointer result = collectionPointerFactory.createNodePointer(parentPointer, qName, collection);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof CollectionPointer);
    }

    @Test
    void testCreateNodePointerWithArray() {
        // Arrange
        NodePointer parentPointer = mock(NodePointer.class);
        QName qName = new QName("test");
        String[] array = new String[] { "item1", "item2" };
        // Act
        NodePointer result = collectionPointerFactory.createNodePointer(parentPointer, qName, array);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof CollectionPointer);
    }

    @Test
    void testCreateNodePointerWithNull() {
        // Arrange
        NodePointer parentPointer = mock(NodePointer.class);
        QName qName = new QName("test");
        // Act
        NodePointer result = collectionPointerFactory.createNodePointer(parentPointer, qName, null);
        // Assert
        assertNull(result);
    }

    @Test
    void testCreateNodePointerWithNonCollection() {
        // Arrange
        NodePointer parentPointer = mock(NodePointer.class);
        QName qName = new QName("test");
        String notACollection = "I am not a collection";
        // Act
        NodePointer result = collectionPointerFactory.createNodePointer(parentPointer, qName, notACollection);
        // Assert
        assertNull(result);
    }
}
