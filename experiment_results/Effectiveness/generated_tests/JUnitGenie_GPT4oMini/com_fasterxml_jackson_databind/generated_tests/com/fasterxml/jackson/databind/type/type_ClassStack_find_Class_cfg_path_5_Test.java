package com.fasterxml.jackson.databind.type;
import com.fasterxml.jackson.databind.type.ClassStack;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class type_ClassStack_find_Class_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testFindCurrentClass() {
        // Arrange
        Class<?> testClass = String.class; // Example class
        ClassStack classStack = new ClassStack(testClass); // Using the constructor to create an instance

        // Act
        ClassStack result = classStack.find(testClass);

        // Assert
        assertEquals(classStack, result);
    }


    @Test(timeout = 4000)
    public void testFindNullClass() {
        // Arrange
        ClassStack classStack = new ClassStack(String.class); // Example class

        // Act
        ClassStack result = classStack.find(Integer.class); // Searching for a class not in the stack

        // Assert
        assertEquals(null, result);
    }


}
