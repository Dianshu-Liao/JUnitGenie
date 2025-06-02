package org.apache.commons.collections4.collection;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class collection_PredicatedCollection_validate_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testValidateWithValidObject() {
        // Create a predicate that always returns true
        Predicate<Object> alwaysTruePredicate = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object object) {
                return true;
            }
        };

        // Create a PredicatedCollection with the always true predicate
        List<Object> collection = new ArrayList<>();
        PredicatedCollection<Object> predicatedCollection = new PredicatedCollection<>(collection, alwaysTruePredicate);

        // Use reflection to access the protected validate method
        try {
            Method validateMethod = PredicatedCollection.class.getDeclaredMethod("validate", Object.class);
            validateMethod.setAccessible(true);
            validateMethod.invoke(predicatedCollection, new Object()); // Pass a valid object
        } catch (Exception e) {
            fail("Should not have thrown an exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testValidateWithInvalidObject() {
        // Create a predicate that always returns false
        Predicate<Object> alwaysFalsePredicate = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object object) {
                return false;
            }
        };

        // Create a PredicatedCollection with the always false predicate
        List<Object> collection = new ArrayList<>();
        PredicatedCollection<Object> predicatedCollection = new PredicatedCollection<>(collection, alwaysFalsePredicate);

        // Use reflection to access the protected validate method
        try {
            Method validateMethod = PredicatedCollection.class.getDeclaredMethod("validate", Object.class);
            validateMethod.setAccessible(true);
            validateMethod.invoke(predicatedCollection, new Object()); // Pass an invalid object
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Should have thrown IllegalArgumentException: " + e.getMessage());
        }
    }

}