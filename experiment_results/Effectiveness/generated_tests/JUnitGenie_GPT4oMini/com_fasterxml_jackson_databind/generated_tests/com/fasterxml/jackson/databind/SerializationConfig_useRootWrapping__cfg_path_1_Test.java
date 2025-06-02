package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SerializationConfig_useRootWrapping__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testUseRootWrappingWhenRootNameIsNull() {
        // Arrange
        SerializationConfig config = new SerializationConfig(null, null, null, null, null, null);
        
        // Act
        boolean result = config.useRootWrapping();
        
        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testUseRootWrappingWhenRootNameIsEmpty() {
        // Arrange
        SerializationConfig config = new SerializationConfig(null, null, null, null, null, null);
        // Using reflection to set the _rootName to an empty string
        try {
            java.lang.reflect.Field field = SerializationConfig.class.getDeclaredField("_rootName");
            field.setAccessible(true);
            field.set(config, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Act
        boolean result = config.useRootWrapping();
        
        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testUseRootWrappingWhenRootNameIsNotEmpty() {
        // Arrange
        SerializationConfig config = new SerializationConfig(null, null, null, null, null, null);
        // Using reflection to set the _rootName to a non-empty string
        try {
            java.lang.reflect.Field field = SerializationConfig.class.getDeclaredField("_rootName");
            field.setAccessible(true);
            field.set(config, "rootName");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Act
        boolean result = config.useRootWrapping();
        
        // Assert
        assertFalse(result); // Since WRAP_ROOT_VALUE is false, we expect false here
    }

    @Test(timeout = 4000)
    public void testUseRootWrappingWhenFeatureIsEnabled() {
        // Arrange
        SerializationConfig config = new SerializationConfig(null, null, null, null, null, null);
        // Using reflection to set the _rootName to null and simulate isEnabled returning true
        try {
            java.lang.reflect.Field field = SerializationConfig.class.getDeclaredField("_rootName");
            field.setAccessible(true);
            field.set(config, null);
            // Simulating isEnabled to return true
            java.lang.reflect.Method method = SerializationConfig.class.getDeclaredMethod("isEnabled", SerializationFeature.class);
            method.setAccessible(true);
            java.lang.reflect.Field featureField = SerializationFeature.class.getDeclaredField("WRAP_ROOT_VALUE");
            featureField.setAccessible(true);
            boolean isEnabledResult = (boolean) method.invoke(config, featureField.get(null));
            assertTrue(isEnabledResult); // Corrected assertTrue usage
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Act
        boolean result = config.useRootWrapping();
        
        // Assert
        assertTrue(result); // Corrected assertTrue usage
    }


}