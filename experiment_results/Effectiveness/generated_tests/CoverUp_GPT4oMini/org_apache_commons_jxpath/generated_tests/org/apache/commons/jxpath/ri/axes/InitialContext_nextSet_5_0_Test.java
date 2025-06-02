package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class InitialContext_nextSet_5_0_Test {

    private InitialContext initialContext;

    private EvalContext mockEvalContext;

    @BeforeEach
    public void setUp() {
        mockEvalContext = mock(EvalContext.class);
        initialContext = new InitialContext(mockEvalContext);
    }

    @Test
    public void testNextSet_FirstCall_ReturnsTrue() throws Exception {
        // Invoke nextSet() method
        boolean result = invokeNextSet();
        // Verify the result
        assertTrue(result);
        // Check that started is set to true
        assertFieldValue("started", true);
    }

    @Test
    public void testNextSet_SecondCall_ReturnsFalse() throws Exception {
        // First call to nextSet() to set started to true
        invokeNextSet();
        // Second call to nextSet()
        boolean result = invokeNextSet();
        // Verify the result
        assertFalse(result);
    }

    private boolean invokeNextSet() throws Exception {
        // Use reflection to invoke the private nextSet() method
        return (boolean) InitialContext.class.getDeclaredMethod("nextSet").invoke(initialContext);
    }

    private void assertFieldValue(String fieldName, boolean expectedValue) throws Exception {
        Field field = InitialContext.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        boolean actualValue = (boolean) field.get(initialContext);
        assertTrue(actualValue == expectedValue);
    }
}
