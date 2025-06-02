package org.apache.commons.jxpath;

import java.lang.reflect.Field;
import java.util.HashMap;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class BasicVariables_getVariable_1_0_Test {

    private BasicVariables basicVariables;

    @BeforeEach
    void setUp() {
        basicVariables = new BasicVariables();
    }

    @Test
    void testGetVariable_ExistingVariable() throws Exception {
        // Arrange
        String varName = "testVar";
        Object expectedValue = "testValue";
        setVariable(varName, expectedValue);
        // Act
        Object actualValue = basicVariables.getVariable(varName);
        // Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testGetVariable_NonExistingVariable() {
        // Arrange
        String varName = "nonExistentVar";
        // Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            basicVariables.getVariable(varName);
        });
        assertEquals("No such variable: '" + varName + "'", thrown.getMessage());
    }

    private void setVariable(String varName, Object value) throws Exception {
        // Use reflection to access the private vars field and set a value
        Field varsField = BasicVariables.class.getDeclaredField("vars");
        varsField.setAccessible(true);
        HashMap<String, Object> vars = (HashMap<String, Object>) varsField.get(basicVariables);
        vars.put(varName, value);
    }
}
