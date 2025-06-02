package org.apache.commons.jxpath;

import java.lang.reflect.Method;
import java.util.HashMap;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class BasicVariables_getVariable_1_0_Test {

    private BasicVariables basicVariables;

    @BeforeEach
    public void setUp() {
        basicVariables = new BasicVariables();
        // Using reflection to access the private 'vars' field and populate it for testing
        try {
            java.lang.reflect.Field varsField = BasicVariables.class.getDeclaredField("vars");
            varsField.setAccessible(true);
            HashMap<String, Object> vars = (HashMap<String, Object>) varsField.get(basicVariables);
            vars.put("existingVar", "value");
            vars.put("nullVar", null);
        } catch (Exception e) {
            fail("Setup failed due to reflection error: " + e.getMessage());
        }
    }

    @Test
    public void testGetVariable_existingVariable() {
        // Test retrieving an existing variable
        Object result = basicVariables.getVariable("existingVar");
        assertEquals("value", result);
    }

    @Test
    public void testGetVariable_nullValue() {
        // Test retrieving a variable that has a null value
        Object result = basicVariables.getVariable("nullVar");
        assertNull(result);
    }

    @Test
    public void testGetVariable_nonExistentVariable() {
        // Test retrieving a non-existent variable
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            basicVariables.getVariable("nonExistentVar");
        });
        assertEquals("No such variable: 'nonExistentVar'", exception.getMessage());
    }
}
