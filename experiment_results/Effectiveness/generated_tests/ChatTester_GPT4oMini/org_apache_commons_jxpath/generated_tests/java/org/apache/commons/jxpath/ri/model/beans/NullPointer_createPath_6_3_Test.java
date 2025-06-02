package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.ri.QName;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NullPointer_createPath_6_3_Test {

    private NullPointer nullPointer;

    @Mock
    private JXPathContext context;

    @Mock
    private NodePointer parentNodePointer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // Use the appropriate constructor for NullPointer
        nullPointer = new NullPointer(parentNodePointer, null);
    }

    @Test
    public void testCreatePath_ThrowsUnsupportedOperationException_WhenParentIsNull() {
        // Fixed the constructor call to correctly match the expected constructor
        nullPointer = new NullPointer((NodePointer) null, (QName) null);
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            nullPointer.createPath(context, new Object());
        });
        String expectedMessage = "Cannot create the root object: " + nullPointer.asPath();
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testCreatePath_ReturnsValuePointer_WhenParentIsNotNull() {
        // Set up the NullPointer with a mock parent
        nullPointer = new NullPointer(parentNodePointer, null);
        // Mock the behavior of parentNodePointer
        when(parentNodePointer.createPath(context, new Object())).thenReturn(parentNodePointer);
        // Invoke the method
        NodePointer result = nullPointer.createPath(context, new Object());
        // Verify that the result is the same as the mocked parentNodePointer
        assertEquals(parentNodePointer, result);
        verify(parentNodePointer).createPath(context, new Object());
    }

    // Reflection test to invoke a private method if needed
    @Test
    public void testPrivateMethodUsingReflection() throws Exception {
        // Assuming there is a private method to test, for example:
        // Method method = NullPointer.class.getDeclaredMethod("privateMethodName", parameterTypes);
        // method.setAccessible(true);
        // Object result = method.invoke(nullPointer, parameters);
        // assertEquals(expectedValue, result);
    }
}
