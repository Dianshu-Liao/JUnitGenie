package org.apache.commons.collections4.map;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.map.PredicatedMap;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class map_PredicatedMap_checkSetValue_Object_cfg_path_2_Test {
    @Test(timeout = 4000)
    public void testCheckSetValue_ValidValue() {
        try {
            // Setup a mock Predicate that returns true for valid value
            Predicate<Object> validPredicate = new Predicate<Object>() {
                @Override
                public boolean evaluate(Object object) {
                    return object != null; // Simple predicate for demonstration
                }
            };
            
            // Create a PredicatedMap instance using the constructor
            PredicatedMap<Object, Object> predicatedMap = PredicatedMap.predicatedMap(new java.util.HashMap<Object, Object>(), validPredicate, validPredicate);

            // Call checkSetValue method using reflection
            Method checkSetValueMethod = PredicatedMap.class.getDeclaredMethod("checkSetValue", Object.class);
            checkSetValueMethod.setAccessible(true);
            
            Object valueToTest = new Object(); // A valid object
            Object result = checkSetValueMethod.invoke(predicatedMap, valueToTest);
            
            assertEquals(valueToTest, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCheckSetValue_InvalidValue() {
        try {
            // Setup a mock Predicate that rejects the invalid value
            Predicate<Object> invalidPredicate = new Predicate<Object>() {
                @Override
                public boolean evaluate(Object object) {
                    return object == null; // Reject null values
                }
            };
            
            // Create a PredicatedMap instance using the constructor
            PredicatedMap<Object, Object> predicatedMap = PredicatedMap.predicatedMap(new java.util.HashMap<Object, Object>(), invalidPredicate, invalidPredicate);

            // Call checkSetValue method using reflection
            Method checkSetValueMethod = PredicatedMap.class.getDeclaredMethod("checkSetValue", Object.class);
            checkSetValueMethod.setAccessible(true);
            
            Object invalidValue = null; // An invalid object
            try {
                checkSetValueMethod.invoke(predicatedMap, invalidValue);
            } catch (IllegalArgumentException e) {
                // Expected exception, test passed
                return;
            }
            
            // If no exception was thrown, fail the test
            throw new AssertionError("Expected IllegalArgumentException was not thrown.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}