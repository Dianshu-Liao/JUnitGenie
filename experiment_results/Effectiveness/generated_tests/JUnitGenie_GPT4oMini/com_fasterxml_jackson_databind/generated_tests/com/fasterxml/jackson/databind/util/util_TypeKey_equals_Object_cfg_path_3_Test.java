package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.TypeKey;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class util_TypeKey_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEqualsWithSameTypeKey() {
        // Arrange
        JavaType javaType = TypeFactory.defaultInstance().constructType(String.class); // Create a JavaType instance
        TypeKey key1 = new TypeKey(javaType, true);
        TypeKey key2 = new TypeKey(javaType, true);

        // Act
        boolean result = key1.equals(key2);

        // Assert
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentTypeKey() {
        // Arrange
        JavaType javaType1 = TypeFactory.defaultInstance().constructType(String.class); // Create a JavaType instance
        JavaType javaType2 = TypeFactory.defaultInstance().constructType(Integer.class); // Create a different JavaType instance
        TypeKey key1 = new TypeKey(javaType1, true);
        TypeKey key2 = new TypeKey(javaType2, true);

        // Act
        boolean result = key1.equals(key2);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        // Arrange
        JavaType javaType = TypeFactory.defaultInstance().constructType(String.class); // Create a JavaType instance
        TypeKey key = new TypeKey(javaType, true);

        // Act
        boolean result = key.equals(null);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentClass() {
        // Arrange
        JavaType javaType = TypeFactory.defaultInstance().constructType(String.class); // Create a JavaType instance
        TypeKey key = new TypeKey(javaType, true);
        Object differentClassObject = new Object();

        // Act
        boolean result = key.equals(differentClassObject);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameInstance() {
        // Arrange
        JavaType javaType = TypeFactory.defaultInstance().constructType(String.class); // Create a JavaType instance
        TypeKey key = new TypeKey(javaType, true);

        // Act
        boolean result = key.equals(key);

        // Assert
        assertTrue(result);
    }


}