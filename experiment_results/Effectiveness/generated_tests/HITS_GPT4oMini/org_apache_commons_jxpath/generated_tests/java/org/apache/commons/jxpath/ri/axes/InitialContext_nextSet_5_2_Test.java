package org.apache.commons.jxpath.ri.axes;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.EvalContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.model.NodePointer;

@ExtendWith(MockitoExtension.class)
public class InitialContext_nextSet_5_2_Test {

    private InitialContext initialContext;

    private EvalContext mockEvalContext;

    @BeforeEach
    public void setUp() {
        // Create a mock of EvalContext
        mockEvalContext = Mockito.mock(EvalContext.class);
        initialContext = new InitialContext(mockEvalContext);
    }

    @Test
    public void testNextSet_WhenNotStarted_ShouldReturnTrue() {
        // Act
        boolean result = initialContext.nextSet();
        // Assert
        assertTrue(result, "nextSet() should return true when called for the first time.");
    }

    @Test
    public void testNextSet_WhenAlreadyStarted_ShouldReturnFalse() {
        // Arrange
        initialContext.nextSet();
        // Act
        boolean result = initialContext.nextSet();
        // Assert
        assertFalse(result, "nextSet() should return false when called after it has already been started.");
    }
}
