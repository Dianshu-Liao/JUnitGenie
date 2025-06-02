package org.apache.commons.jxpath.ri.model.container;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ContainerPointer_getImmediateValuePointer_8_0_Test {

    private Container container;

    private ContainerPointer containerPointer;

    @BeforeEach
    void setUp() {
        // Mock the Container class since it is abstract
        container = mock(Container.class);
        containerPointer = new ContainerPointer(container, Locale.ENGLISH);
    }

    @Test
    void testGetImmediateValuePointer_WhenValuePointerIsNull() throws Exception {
        // Invoke the focal method
        Method method = ContainerPointer.class.getDeclaredMethod("getImmediateValuePointer");
        method.setAccessible(true);
        NodePointer result = (NodePointer) method.invoke(containerPointer);
        assertNotNull(result);
        // Assuming getName() returns a String
        assertEquals(containerPointer.getName(), result.getName());
        // Assuming getImmediateNode() returns the value
        assertEquals(containerPointer.getImmediateNode(), result.getValue());
    }

    @Test
    void testGetImmediateValuePointer_WhenValuePointerIsNotNull() throws Exception {
        // Create a mock NodePointer since it is abstract
        NodePointer existingPointer = mock(NodePointer.class);
        // Set valuePointer to the mock NodePointer
        Field valuePointerField = ContainerPointer.class.getDeclaredField("valuePointer");
        valuePointerField.setAccessible(true);
        valuePointerField.set(containerPointer, existingPointer);
        // Invoke the focal method
        Method method = ContainerPointer.class.getDeclaredMethod("getImmediateValuePointer");
        method.setAccessible(true);
        NodePointer result = (NodePointer) method.invoke(containerPointer);
        assertNotNull(result);
        // Should return the existing valuePointer
        assertSame(existingPointer, result);
    }

    @Test
    void testGetImmediateValuePointer_WhenContainerIsNull() throws Exception {
        // Create a ContainerPointer with a null container
        containerPointer = new ContainerPointer(null, Locale.ENGLISH);
        // Invoke the focal method
        Method method = ContainerPointer.class.getDeclaredMethod("getImmediateValuePointer");
        method.setAccessible(true);
        NodePointer result = (NodePointer) method.invoke(containerPointer);
        assertNotNull(result);
        // Assuming that with a null container, the value should be null
        assertNull(result.getValue());
    }
}
