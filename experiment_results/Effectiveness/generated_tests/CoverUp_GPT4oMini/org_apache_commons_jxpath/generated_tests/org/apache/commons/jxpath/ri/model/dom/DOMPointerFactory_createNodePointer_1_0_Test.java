package org.apache.commons.jxpath.ri.model.dom;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.dom.DOMPointerFactory;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.w3c.dom.Node;

public class DOMPointerFactory_createNodePointer_1_0_Test {

    private final DOMPointerFactory factory = new DOMPointerFactory();

    @Test
    public void testCreateNodePointerWithValidNode() {
        // Arrange
        QName name = new QName("example");
        Node mockNode = org.mockito.Mockito.mock(Node.class);
        Locale locale = Locale.ENGLISH;
        // Act
        NodePointer result = factory.createNodePointer(name, mockNode, locale);
        // Assert
        assertNotNull(result);
    }

    @Test
    public void testCreateNodePointerWithNullBean() {
        // Arrange
        QName name = new QName("example");
        Object bean = null;
        Locale locale = Locale.ENGLISH;
        // Act
        NodePointer result = factory.createNodePointer(name, bean, locale);
        // Assert
        assertNull(result);
    }

    @Test
    public void testCreateNodePointerWithNonNodeBean() {
        // Arrange
        QName name = new QName("example");
        // Not a Node
        Object bean = new Object();
        Locale locale = Locale.ENGLISH;
        // Act
        NodePointer result = factory.createNodePointer(name, bean, locale);
        // Assert
        assertNull(result);
    }
}
