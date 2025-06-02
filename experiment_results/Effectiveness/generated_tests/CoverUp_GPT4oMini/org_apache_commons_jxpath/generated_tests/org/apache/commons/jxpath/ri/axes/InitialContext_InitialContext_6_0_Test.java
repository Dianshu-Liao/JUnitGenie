package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class InitialContext_InitialContext_6_0_Test {

    private EvalContext parentContextMock;

    private NodePointer nodePointerMock;

    private InitialContext initialContext;

    @BeforeEach
    void setUp() {
        parentContextMock = mock(EvalContext.class);
        nodePointerMock = mock(NodePointer.class);
        when(parentContextMock.getCurrentNodePointer()).thenReturn(nodePointerMock);
    }

    @Test
    void testInitialContextWithNonNullNodePointer() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Arrange
        when(nodePointerMock.clone()).thenReturn(nodePointerMock);
        // Not a whole collection
        when(nodePointerMock.getIndex()).thenReturn(0);
        // Act
        Constructor<InitialContext> constructor = InitialContext.class.getDeclaredConstructor(EvalContext.class);
        constructor.setAccessible(true);
        initialContext = constructor.newInstance(parentContextMock);
        // Assert
        assertNotNull(initialContext);
        assertFalse(initialContext.getCurrentNodePointer().getIndex() == NodePointer.WHOLE_COLLECTION);
    }

    @Test
    void testInitialContextWithWholeCollection() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Arrange
        when(nodePointerMock.clone()).thenReturn(nodePointerMock);
        // Whole collection
        when(nodePointerMock.getIndex()).thenReturn(NodePointer.WHOLE_COLLECTION);
        // Act
        Constructor<InitialContext> constructor = InitialContext.class.getDeclaredConstructor(EvalContext.class);
        constructor.setAccessible(true);
        initialContext = constructor.newInstance(parentContextMock);
        // Assert
        assertNotNull(initialContext);
        assertTrue(initialContext.getCurrentNodePointer().getIndex() == NodePointer.WHOLE_COLLECTION);
    }

    @Test
    void testInitialContextWithNullNodePointer() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Arrange
        when(parentContextMock.getCurrentNodePointer()).thenReturn(null);
        // Act
        Constructor<InitialContext> constructor = InitialContext.class.getDeclaredConstructor(EvalContext.class);
        constructor.setAccessible(true);
        initialContext = constructor.newInstance(parentContextMock);
        // Assert
        assertNotNull(initialContext);
        assertNull(initialContext.getCurrentNodePointer());
    }
}
