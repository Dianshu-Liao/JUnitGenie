package com.fasterxml.jackson.databind.type;
import com.fasterxml.jackson.databind.type.ClassStack;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class type_ClassStack_find_Class_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testFindWithCurrentClass() {
        Class<?> testClass = String.class;
        ClassStack stack = new ClassStack(testClass);
        
        // Testing when the current class is the same as the input class
        ClassStack result = stack.find(testClass);
        assertEquals(stack, result);
    }


    @Test(timeout = 4000)
    public void testFindWithNull() {
        ClassStack stack = new ClassStack(String.class);
        
        // Testing when the class is not found
        ClassStack result = stack.find(Object.class);
        assertEquals(null, result);
    }


}
