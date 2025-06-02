package org.apache.commons.jxpath.ri.parser;

import java.util.ArrayList;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.Compiler;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class XPathParser_CoreFunctionCall_20_1_Test {

    @Mock
    private Compiler compiler;

    @InjectMocks
    private XPathParser xPathParser;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCoreFunctionCallWithNullArgs() throws Exception {
        // Arrange
        // Mocking the behavior of CoreFunctionName and ArgumentList
        when(invokePrivateMethod("CoreFunctionName")).thenReturn(1);
        // Mocking ArgumentList to return null
        when(invokePrivateMethod("ArgumentList")).thenReturn(null);
        // Act
        Object result = xPathParser.CoreFunctionCall();
        // Assert
        verify(compiler).function(1, null);
        assertNotNull(result);
    }

    @Test
    public void testCoreFunctionCallWithArgs() throws Exception {
        // Arrange
        ArrayList<Object> args = new ArrayList<>();
        args.add("arg1");
        args.add("arg2");
        // Mocking the behavior of CoreFunctionName and ArgumentList
        when(invokePrivateMethod("CoreFunctionName")).thenReturn(2);
        when(invokePrivateMethod("ArgumentList")).thenReturn(args);
        // Act
        Object result = xPathParser.CoreFunctionCall();
        // Assert
        verify(compiler).function(2, args.toArray());
        assertNotNull(result);
    }

    @Test
    public void testCoreFunctionCallThrowsError() throws Exception {
        // Arrange
        // Mocking the behavior of CoreFunctionName and ArgumentList
        when(invokePrivateMethod("CoreFunctionName")).thenReturn(3);
        // Mocking a non-null ArgumentList
        when(invokePrivateMethod("ArgumentList")).thenReturn(new ArrayList<>());
        // Act & Assert
        Error error = assertThrows(Error.class, () -> {
            xPathParser.CoreFunctionCall();
        });
        assertEquals("Missing return statement in function", error.getMessage());
    }

    private Object invokePrivateMethod(String methodName) throws Exception {
        // Fixed the symbol error by using Class<?> instead of var
        java.lang.reflect.Method method = XPathParser.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return method.invoke(xPathParser);
    }
}
