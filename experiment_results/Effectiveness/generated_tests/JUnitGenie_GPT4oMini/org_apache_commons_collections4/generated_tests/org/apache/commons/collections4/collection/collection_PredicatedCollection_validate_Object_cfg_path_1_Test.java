package org.apache.commons.collections4.collection;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class collection_PredicatedCollection_validate_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testValidateThrowsException() {
        // Create a Predicate that always returns false
        Predicate<Object> falsePredicate = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object object) {
                return false; // Always returns false
            }
        };

        // Create a PredicatedCollection with the falsePredicate
        List<Object> collection = new ArrayList<>();
        PredicatedCollection<Object> predicatedCollection = new PredicatedCollection<>(collection, falsePredicate);

        // Access the protected validate method using reflection
        try {
            Method validateMethod = PredicatedCollection.class.getDeclaredMethod("validate", Object.class);
            validateMethod.setAccessible(true); // Make the method accessible

            // Test with an object that will cause the exception
            Object testObject = new Object();
            validateMethod.invoke(predicatedCollection, testObject);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assertTrue(e.getMessage().contains("Cannot add Object '"));
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

}