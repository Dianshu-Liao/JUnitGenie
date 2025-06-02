package org.apache.commons.jxpath.ri.axes;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodePointer;

public class ParentContext_setPosition_4_0_Test {

    private ParentContext parentContext;

    private EvalContext mockEvalContext;

    private NodeTest mockNodeTest;

    @BeforeEach
    public void setUp() {
        mockEvalContext = Mockito.mock(EvalContext.class);
        mockNodeTest = Mockito.mock(NodeTest.class);
        parentContext = new ParentContext(mockEvalContext, mockNodeTest);
    }

    @Test
    public void testSetPosition_WhenPositionIsOne_ShouldReturnTrue() {
        // Arrange
        int position = 1;
        // Act
        boolean result = invokeSetPosition(parentContext, position);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testSetPosition_WhenPositionIsNotOne_ShouldReturnFalse() {
        // Arrange
        int position = 2;
        // Act
        boolean result = invokeSetPosition(parentContext, position);
        // Assert
        assertFalse(result);
    }

    private boolean invokeSetPosition(ParentContext parentContext, int position) {
        try {
            java.lang.reflect.Method method = ParentContext.class.getDeclaredMethod("setPosition", int.class);
            method.setAccessible(true);
            return (boolean) method.invoke(parentContext, position);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
