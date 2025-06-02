package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SerializationConfig_useRootWrapping__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testUseRootWrappingWhenRootNameIsNull() {
        // Arrange
        SerializationConfig config = new SerializationConfig(null, null, null, null, null, null);
        // Set the _rootName to null
        PropertyName rootName = null;
        // Use reflection to set the private field _rootName
        try {
            java.lang.reflect.Field field = SerializationConfig.class.getDeclaredField("_rootName");
            field.setAccessible(true);
            field.set(config, rootName);
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
        PropertyName rootName = PropertyName.construct("root");
        // Use reflection to set the private field _rootName
        try {
            java.lang.reflect.Field field = SerializationConfig.class.getDeclaredField("_rootName");
            field.setAccessible(true);
            field.set(config, rootName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        boolean result = config.useRootWrapping();

        // Assert
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testUseRootWrappingWhenRootNameIsEmpty() {
        // Arrange
        SerializationConfig config = new SerializationConfig(null, null, null, null, null, null);
        PropertyName rootName = PropertyName.construct("");
        // Use reflection to set the private field _rootName
        try {
            java.lang.reflect.Field field = SerializationConfig.class.getDeclaredField("_rootName");
            field.setAccessible(true);
            field.set(config, rootName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        boolean result = config.useRootWrapping();

        // Assert
        assertFalse(result);
    }


}