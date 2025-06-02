package org.apache.commons.jxpath.ri.model.container;

import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.container.ContainerPointer;
import org.apache.commons.jxpath.util.ValueUtils;
import java.lang.reflect.Method;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;

class ContainerPointer_getImmediateValuePointer_8_1_Test {

    private Container containerMock;

    private ContainerPointer containerPointer;

    @BeforeEach
    void setUp() {
        containerMock = mock(Container.class);
        containerPointer = new ContainerPointer(containerMock, Locale.getDefault());
    }

    @Test
    void testGetImmediateValuePointerWhenValuePointerIsNull() throws Exception {
        // Arrange
        Object expectedValue = new Object();
        when(containerMock.getValue()).thenReturn(expectedValue);
        Method getImmediateNodeMethod = ContainerPointer.class.getDeclaredMethod("getImmediateNode");
        getImmediateNodeMethod.setAccessible(true);
        when(getImmediateNodeMethod.invoke(containerPointer)).thenReturn(expectedValue);
        // Act
        NodePointer result = containerPointer.getImmediateValuePointer();
        // Assert
        assertNotNull(result);
        assertSame(containerPointer.getImmediateValuePointer(), result);
    }

    @Test
    void testGetImmediateValuePointerWhenValuePointerIsNotNull() throws Exception {
        // Arrange
        NodePointer existingPointer = mock(NodePointer.class);
        Method setValueMethod = ContainerPointer.class.getDeclaredMethod("setValue", Object.class);
        setValueMethod.setAccessible(true);
        setValueMethod.invoke(containerPointer, existingPointer);
        // Act
        NodePointer result = containerPointer.getImmediateValuePointer();
        // Assert
        assertSame(existingPointer, result);
    }

    @Test
    void testGetImmediateNode() throws Exception {
        // Arrange
        Object expectedValue = new Object();
        when(containerMock.getValue()).thenReturn(expectedValue);
        Method getImmediateNodeMethod = ContainerPointer.class.getDeclaredMethod("getImmediateNode");
        getImmediateNodeMethod.setAccessible(true);
        // Act
        Object result = getImmediateNodeMethod.invoke(containerPointer);
        // Assert
        assertEquals(expectedValue, result);
    }

    @Test
    void testGetBaseValue() {
        // Act
        Object result = containerPointer.getBaseValue();
        // Assert
        assertEquals(containerMock, result);
    }

    @Test
    void testGetLength() {
        // Arrange
        when(containerMock.getValue()).thenReturn(new Object[] { 1, 2, 3 });
        // Act
        int length = containerPointer.getLength();
        // Assert
        assertEquals(3, length);
    }
}
