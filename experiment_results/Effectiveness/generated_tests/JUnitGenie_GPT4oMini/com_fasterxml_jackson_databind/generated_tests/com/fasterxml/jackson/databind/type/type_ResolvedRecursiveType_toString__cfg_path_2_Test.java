package com.fasterxml.jackson.databind.type;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ResolvedRecursiveType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class type_ResolvedRecursiveType_toString__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToStringWithUnresolvedType() {
        // Arrange
        ResolvedRecursiveType resolvedRecursiveType = new ResolvedRecursiveType(String.class, null);
        // Act
        String result = resolvedRecursiveType.toString();
        // Assert
        assertEquals("[recursive type; UNRESOLVED]", result);
    }

    @Test(timeout = 4000)
    public void testToStringWithResolvedType() {
        // Arrange
        JavaType javaType = new ResolvedRecursiveType(String.class, null); // Use ResolvedRecursiveType instead of JavaType
        // Act
        ResolvedRecursiveType resolvedRecursiveType = new ResolvedRecursiveType(javaType.getRawClass(), null);
        // Assert
        String result = resolvedRecursiveType.toString();
        assertEquals("[recursive type; java.lang.String]", result);
    }

}