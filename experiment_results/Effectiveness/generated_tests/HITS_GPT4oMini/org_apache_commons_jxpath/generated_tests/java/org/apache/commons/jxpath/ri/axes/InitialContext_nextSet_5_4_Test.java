package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.EvalContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.model.NodePointer;

public class InitialContext_nextSet_5_4_Test {

    private InitialContext initialContext;

    @BeforeEach
    public void setUp() {
        // Assuming EvalContext can be instantiated or mocked appropriately
        // Replace with actual initialization if possible
        EvalContext parentContext = null;
        initialContext = new InitialContext(parentContext);
    }

    @Test
    public void testNextSet_WhenCalledFirstTime_ShouldReturnTrue() {
        // Act
        boolean result = initialContext.nextSet();
        // Assert
        assertTrue(result, "nextSet() should return true on first call");
    }

    @Test
    public void testNextSet_WhenCalledSecondTime_ShouldReturnFalse() {
        // Arrange
        // Call it once to change the state
        initialContext.nextSet();
        // Act
        boolean result = initialContext.nextSet();
        // Assert
        assertFalse(result, "nextSet() should return false on subsequent calls");
    }
}
