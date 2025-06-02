package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.PropertyName;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SerializationConfig_useRootWrapping__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testUseRootWrappingWhenRootNameIsNull() {
        // Arrange
        SerializationConfig config = new SerializationConfig(null, null, null, null, null, null);
        // Accessing the private field _rootName using reflection
        try {
            java.lang.reflect.Field rootNameField = SerializationConfig.class.getDeclaredField("rootName"); // Changed from "_rootName" to "rootName"
            rootNameField.setAccessible(true);
            rootNameField.set(config, null); // Set rootName to null

            // Act
            boolean result = config.useRootWrapping();

            // Assert
            assertFalse(result); // Expecting false since rootName is null
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testUseRootWrappingWhenRootNameIsEmpty() {
        // Arrange
        SerializationConfig config = new SerializationConfig(null, null, null, null, null, null);
        // Accessing the private field rootName using reflection
        try {
            java.lang.reflect.Field rootNameField = SerializationConfig.class.getDeclaredField("rootName"); // Changed from "_rootName" to "rootName"
            rootNameField.setAccessible(true);
            PropertyName emptyRootName = PropertyName.construct(""); // Create an empty PropertyName
            rootNameField.set(config, emptyRootName); // Set rootName to an empty PropertyName

            // Act
            boolean result = config.useRootWrapping();

            // Assert
            assertFalse(result); // Expecting false since rootName is empty
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testUseRootWrappingWhenRootNameIsNotEmpty() {
        // Arrange
        SerializationConfig config = new SerializationConfig(null, null, null, null, null, null);
        // Accessing the private field rootName using reflection
        try {
            java.lang.reflect.Field rootNameField = SerializationConfig.class.getDeclaredField("rootName"); // Changed from "_rootName" to "rootName"
            rootNameField.setAccessible(true);
            PropertyName nonEmptyRootName = PropertyName.construct("root"); // Create a non-empty PropertyName
            rootNameField.set(config, nonEmptyRootName); // Set rootName to a non-empty PropertyName

            // Act
            boolean result = config.useRootWrapping();

            // Assert
            assertTrue(result); // Expecting true since rootName is non-empty
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}