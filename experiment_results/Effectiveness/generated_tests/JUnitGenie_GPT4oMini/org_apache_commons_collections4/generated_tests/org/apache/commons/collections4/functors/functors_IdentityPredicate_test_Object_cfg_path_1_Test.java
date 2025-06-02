package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.IdentityPredicate;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class functors_IdentityPredicate_test_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIdentityPredicateWithDifferentObjects() {
        // Arrange
        Object differentObject = new Object();
        IdentityPredicate<Object> predicate = new IdentityPredicate<>(new Object());

        // Act
        boolean result = false;
        try {
            result = predicate.test(differentObject);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertFalse(result);
    }

}