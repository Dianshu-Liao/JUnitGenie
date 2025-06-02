package org.apache.commons.jxpath.ri.axes;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.ri.model.NodePointer;

@ExtendWith(MockitoExtension.class)
public class ParentContext_setPosition_4_4_Test {

    @Mock
    private EvalContext evalContext;

    @Mock
    private NodeTest nodeTest;

    private ParentContext parentContext;

    @BeforeEach
    public void setUp() {
        parentContext = new ParentContext(evalContext, nodeTest);
    }

    @Test
    public void testSetPosition_WhenPositionIsOne_ShouldReturnTrue() {
        boolean result = parentContext.setPosition(1);
        assertTrue(result, "setPosition should return true when position is 1");
    }

    @Test
    public void testSetPosition_WhenPositionIsNotOne_ShouldReturnFalse() {
        boolean result = parentContext.setPosition(2);
        assertFalse(result, "setPosition should return false when position is not 1");
    }
}
