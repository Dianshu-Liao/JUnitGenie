package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.IdentityPredicate;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class functors_IdentityPredicate_identityPredicate_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIdentityPredicateWithNonNullObject() {
        Object testObject = new Object(); // Create a non-null object
        Predicate<Object> predicate = null;

        try {
            predicate = IdentityPredicate.identityPredicate(testObject);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        assertNotNull("Predicate should not be null for a non-null object", predicate);
    }

    @Test(timeout = 4000)
    public void testIdentityPredicateWithNullObject() {
        Predicate<Object> predicate = null;

        try {
            predicate = IdentityPredicate.identityPredicate(null);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        assertNotNull("Predicate should not be null when passing null object", predicate);
    }

}