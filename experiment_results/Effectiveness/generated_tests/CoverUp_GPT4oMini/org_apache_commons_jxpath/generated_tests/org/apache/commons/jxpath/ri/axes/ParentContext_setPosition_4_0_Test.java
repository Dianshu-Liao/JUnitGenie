package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.axes.ParentContext;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class ParentContext_setPosition_4_0_Test {

    private ParentContext parentContext;

    private NodeTest nodeTestMock;

    @BeforeEach
    void setUp() {
        // Mocking NodeTest as it's abstract
        nodeTestMock = Mockito.mock(NodeTest.class);
        // Mocking EvalContext as it's abstract
        EvalContext evalContextMock = Mockito.mock(EvalContext.class);
        parentContext = new ParentContext(evalContextMock, nodeTestMock);
    }

    @Test
    void testSetPosition_WhenPositionIsOne_ShouldReturnTrue() throws Exception {
        // Invoke the private method using reflection
        Method setPositionMethod = ParentContext.class.getDeclaredMethod("setPosition", int.class);
        setPositionMethod.setAccessible(true);
        boolean result = (boolean) setPositionMethod.invoke(parentContext, 1);
        assertTrue(result);
    }

    @Test
    void testSetPosition_WhenPositionIsNotOne_ShouldReturnFalse() throws Exception {
        // Invoke the private method using reflection
        Method setPositionMethod = ParentContext.class.getDeclaredMethod("setPosition", int.class);
        setPositionMethod.setAccessible(true);
        boolean result = (boolean) setPositionMethod.invoke(parentContext, 2);
        assertFalse(result);
    }

    @Test
    void testSetPosition_WhenPositionIsZero_ShouldReturnFalse() throws Exception {
        // Invoke the private method using reflection
        Method setPositionMethod = ParentContext.class.getDeclaredMethod("setPosition", int.class);
        setPositionMethod.setAccessible(true);
        boolean result = (boolean) setPositionMethod.invoke(parentContext, 0);
        assertFalse(result);
    }
}
