package org.apache.commons.jxpath.ri.axes;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class InitialContext_nextSet_5_0_Test {

    private InitialContext initialContext;

    private EvalContext evalContextMock;

    @BeforeEach
    public void setUp() {
        // Create a mock of EvalContext
        evalContextMock = mock(EvalContext.class);
        initialContext = new InitialContext(evalContextMock);
    }

    @Test
    public void testNextSet_WhenNotStarted_ShouldReturnTrue() throws Exception {
        // Invoke the private method nextSet using reflection
        Method nextSetMethod = InitialContext.class.getDeclaredMethod("nextSet");
        nextSetMethod.setAccessible(true);
        boolean result = (boolean) nextSetMethod.invoke(initialContext);
        assertTrue(result, "Expected nextSet() to return true when context is not started.");
    }

    @Test
    public void testNextSet_WhenAlreadyStarted_ShouldReturnFalse() throws Exception {
        // First call to nextSet to start it
        Method nextSetMethod = InitialContext.class.getDeclaredMethod("nextSet");
        nextSetMethod.setAccessible(true);
        // Start the context
        nextSetMethod.invoke(initialContext);
        // Second call should return false
        boolean result = (boolean) nextSetMethod.invoke(initialContext);
        assertFalse(result, "Expected nextSet() to return false when context is already started.");
    }
}
