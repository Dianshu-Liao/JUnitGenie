package org.apache.commons.jxpath.ri.model.beans;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CollectionPointerFactory_createNodePointer_2_1_Test {

    private CollectionPointerFactory factory;

    @BeforeEach
    public void setUp() {
        factory = new CollectionPointerFactory();
    }

    @Test
    public void testCreateNodePointerWithCollection() {
        // Arrange
        NodePointer parent = Mockito.mock(NodePointer.class);
        QName name = new QName("namespace", "localPart");
        // A collection
        Object bean = new java.util.ArrayList<>();
        // Act
        NodePointer result = factory.createNodePointer(parent, name, bean);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof CollectionPointer);
    }

    @Test
    public void testCreateNodePointerWithNonCollection() {
        // Arrange
        NodePointer parent = Mockito.mock(NodePointer.class);
        QName name = new QName("namespace", "localPart");
        // Not a collection
        Object bean = "Not a collection";
        // Act
        NodePointer result = factory.createNodePointer(parent, name, bean);
        // Assert
        assertNull(result);
    }

    @Test
    public void testCreateNodePointerWithNullBean() {
        // Arrange
        NodePointer parent = Mockito.mock(NodePointer.class);
        QName name = new QName("namespace", "localPart");
        // Null bean
        Object bean = null;
        // Act
        NodePointer result = factory.createNodePointer(parent, name, bean);
        // Assert
        assertNull(result);
    }
}
