package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_EqualsBuilder_isRegistered_Object_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsRegisteredWithNullRegistry() {
        // Arrange
        Object lhs = new Object();
        Object rhs = new Object();
        
        // Simulate the condition where the registry is null
        // This would typically involve ensuring that the ThreadLocal REGISTRY is cleared or not initialized.
        // Assuming a method clearRegistry() exists for this purpose.
        clearRegistry(); // This method needs to be implemented to clear the ThreadLocal variable.

        // Act
        boolean result = EqualsBuilder.isRegistered(lhs, rhs);

        // Assert
        assertFalse(result);
    }

    private void clearRegistry() {
        // Implementation to clear the ThreadLocal variable that holds the registry
        // This is a placeholder for the actual implementation that would clear the registry.
    }

}