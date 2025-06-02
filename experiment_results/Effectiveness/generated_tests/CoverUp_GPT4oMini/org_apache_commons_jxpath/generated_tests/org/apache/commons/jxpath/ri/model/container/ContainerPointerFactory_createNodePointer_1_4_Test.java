package org.apache.commons.jxpath.ri.model.container;

import java.util.Locale;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.container.ContainerPointerFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;

class ContainerPointerFactory_createNodePointer_1_4_Test {

    private ContainerPointerFactory factory;

    @BeforeEach
    void setUp() {
        factory = new ContainerPointerFactory();
    }

    @Test
    void testCreateNodePointerWithContainer() {
        // Arrange
        QName name = new QName("testName");
        // A mock or test implementation of Container
        Container bean = new TestContainer();
        Locale locale = Locale.ENGLISH;
        // Act
        NodePointer result = factory.createNodePointer(name, bean, locale);
        // Assert
        assertNotNull(result);
    }

    @Test
    void testCreateNodePointerWithNonContainer() {
        // Arrange
        QName name = new QName("testName");
        // Non-Container object
        Object bean = new Object();
        Locale locale = Locale.ENGLISH;
        // Act
        NodePointer result = factory.createNodePointer(name, bean, locale);
        // Assert
        assertNull(result);
    }

    // Test implementation of Container for testing purposes
    private static class TestContainer implements Container {

        // Implement required methods for the Container interface
        @Override
        public Object getValue() {
            return null;
        }

        @Override
        public void setValue(Object value) {
        }
        // Other methods from the Container interface can be stubbed as needed
    }
}
