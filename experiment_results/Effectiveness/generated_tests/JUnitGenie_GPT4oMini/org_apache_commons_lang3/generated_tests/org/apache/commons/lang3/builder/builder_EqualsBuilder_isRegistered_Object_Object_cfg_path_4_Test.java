package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class builder_EqualsBuilder_isRegistered_Object_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testIsRegisteredWithNullRegistry() {
        // Arrange
        Object lhs = new Object();
        Object rhs = new Object();

        // Simulate the condition where getRegistry() returns null
        // This can be done by ensuring that the ThreadLocal variable used in getRegistry() is empty.

        // Act
        boolean result = EqualsBuilder.isRegistered(lhs, rhs);

        // Assert
        assertFalse(result);
    }

}