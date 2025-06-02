package org.apache.commons.jxpath.ri.axes;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.model.NodePointer;

class InitialContext_InitialContext_6_0_Test {

    private EvalContext mockParentContext;

    private NodePointer mockNodePointer;

    @BeforeEach
    void setUp() {
        mockParentContext = Mockito.mock(EvalContext.class);
        mockNodePointer = Mockito.mock(NodePointer.class);
    }

    @Test
    void testInitialContextWithWholeCollection() throws Exception {
        // Arrange
        Mockito.when(mockParentContext.getCurrentNodePointer()).thenReturn(mockNodePointer);
        Mockito.when(mockNodePointer.clone()).thenReturn(mockNodePointer);
        Mockito.when(mockNodePointer.getIndex()).thenReturn(NodePointer.WHOLE_COLLECTION);
        // Act
        InitialContext initialContext = new InitialContext(mockParentContext);
        // Assert
        assertNotNull(initialContext);
        assertTrue(isCollection(initialContext));
    }

    @Test
    void testInitialContextWithNullNodePointer() throws Exception {
        // Arrange
        Mockito.when(mockParentContext.getCurrentNodePointer()).thenReturn(mockNodePointer);
        Mockito.when(mockNodePointer.clone()).thenReturn(mockNodePointer);
        // Not whole collection
        Mockito.when(mockNodePointer.getIndex()).thenReturn(-1);
        // Act
        InitialContext initialContext = new InitialContext(mockParentContext);
        // Assert
        assertNotNull(initialContext);
        assertFalse(isCollection(initialContext));
    }

    @Test
    void testInitialContextWithNullParentContext() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            new InitialContext(null);
        });
    }

    private boolean isCollection(InitialContext initialContext) throws Exception {
        // Use reflection to access the private field
        java.lang.reflect.Field field = InitialContext.class.getDeclaredField("collection");
        field.setAccessible(true);
        return field.getBoolean(initialContext);
    }
}
