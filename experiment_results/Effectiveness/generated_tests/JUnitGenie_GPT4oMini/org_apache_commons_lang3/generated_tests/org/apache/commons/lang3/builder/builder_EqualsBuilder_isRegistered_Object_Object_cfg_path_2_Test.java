package org.apache.commons.lang3.builder;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;

public class builder_EqualsBuilder_isRegistered_Object_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsRegistered_withRegisteredPair() {
        // Arrange
        Pair<Object, Object> pair = Pair.of("left", "right");
        Set<Pair<Object, Object>> registry = new HashSet<>();
        registry.add(pair);
        
        setRegistryForTesting(registry);

        // Act
        boolean result = EqualsBuilder.isRegistered("left", "right");

        // Assert
        assertTrue(result);
    }
    
    @Test(timeout = 4000)
    public void testIsRegistered_withSwappedPair() {
        // Arrange
        Pair<Object, Object> swappedPair = Pair.of("right", "left");
        Set<Pair<Object, Object>> registry = new HashSet<>();
        registry.add(swappedPair);
        
        setRegistryForTesting(registry);
        
        // Act
        boolean result = EqualsBuilder.isRegistered("left", "right");

        // Assert
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsRegistered_withNullRegistry() {
        // Arrange
        setRegistryForTesting(null);

        // Act
        boolean result = EqualsBuilder.isRegistered("left", "right");

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsRegistered_withUnregisteredPair() {
        // Arrange
        Pair<Object, Object> pair = Pair.of("notRegistered1", "notRegistered2");
        Set<Pair<Object, Object>> registry = new HashSet<>();
        registry.add(pair);
        
        setRegistryForTesting(registry);

        // Act
        boolean result = EqualsBuilder.isRegistered("left", "right");

        // Assert
        assertFalse(result);
    }

    // Helper method to set registry for testing
    private void setRegistryForTesting(Set<Pair<Object, Object>> registry) {
        // Since there is no setRegistry method in EqualsBuilder, we need to find an alternative way
        // to set the registry. This could involve using reflection if the registry is private.
        try {
            java.lang.reflect.Field field = EqualsBuilder.class.getDeclaredField("registry");
            field.setAccessible(true);
            field.set(null, registry); // Assuming registry is a static field
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Field 'registry' does not exist in EqualsBuilder", e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to access field 'registry' in EqualsBuilder", e);
        }
    }

}