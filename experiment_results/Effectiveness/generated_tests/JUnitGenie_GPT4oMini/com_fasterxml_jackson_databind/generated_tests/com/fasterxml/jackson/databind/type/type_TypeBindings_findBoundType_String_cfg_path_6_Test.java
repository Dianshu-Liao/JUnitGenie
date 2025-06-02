package com.fasterxml.jackson.databind.type;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ResolvedRecursiveType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class type_TypeBindings_findBoundType_String_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testFindBoundTypeWithResolvedRecursiveType() {
        // Setup
        String[] names = {"type1", "type2", "type3"};
        JavaType[] types = new JavaType[3];
        // Corrected instantiation of ResolvedRecursiveType
        ResolvedRecursiveType rrt = new ResolvedRecursiveType(JavaType.class, null); // Assuming JavaType.class is the required class
        types[1] = rrt; // Assuming type2 is a ResolvedRecursiveType
        TypeBindings typeBindings = TypeBindings.create(Arrays.asList(names), Arrays.asList(types)); // Convert to List

        // Execute
        JavaType result = null;
        try {
            result = typeBindings.findBoundType("type2");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Verify
        assertNotNull(result);
        assertTrue(result instanceof JavaType); // Further assertions can be made based on expected behavior
    }

    @Test(timeout = 4000)
    public void testFindBoundTypeWithNullName() {
        // Setup
        String[] names = {"type1", "type2", "type3"};
        JavaType[] types = new JavaType[3];
        TypeBindings typeBindings = TypeBindings.create(Arrays.asList(names), Arrays.asList(types)); // Convert to List

        // Execute
        JavaType result = null;
        try {
            result = typeBindings.findBoundType(null);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Verify
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testFindBoundTypeWithNonExistentName() {
        // Setup
        String[] names = {"type1", "type2", "type3"};
        JavaType[] types = new JavaType[3];
        TypeBindings typeBindings = TypeBindings.create(Arrays.asList(names), Arrays.asList(types)); // Convert to List

        // Execute
        JavaType result = null;
        try {
            result = typeBindings.findBoundType("nonExistentType");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Verify
        assertNull(result);
    }

}