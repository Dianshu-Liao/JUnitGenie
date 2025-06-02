package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.AnyPredicate;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.util.Arrays;

public class functors_AnyPredicate_anyPredicate_Predicate_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAnyPredicateWithSinglePredicate() {
        // Arrange
        Predicate<Object> singlePredicate = new Predicate<Object>() {
            @Override
            public boolean evaluate(Object object) {
                return true; // Example implementation
            }
        };
        Predicate<Object>[] predicates = new Predicate[]{singlePredicate};

        // Act
        Predicate<Object> result = null;
        try {
            result = AnyPredicate.anyPredicate(Arrays.asList(predicates));
        } catch (Exception e) {
            // Handle exception if needed
        }

        // Assert
        assertNotNull(result);
    }


}