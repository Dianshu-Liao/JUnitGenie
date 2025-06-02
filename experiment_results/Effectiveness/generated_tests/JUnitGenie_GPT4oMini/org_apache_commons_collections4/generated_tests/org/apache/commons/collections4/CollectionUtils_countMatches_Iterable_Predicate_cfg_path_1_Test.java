package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_countMatches_Iterable_Predicate_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCountMatches() {
        // Prepare input data
        List<String> input = Arrays.asList("apple", "banana", "cherry", "date");

        // Create a predicate that matches strings with length greater than 5
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean evaluate(String object) {
                return object.length() > 5;
            }
        };

        // Call the focal method
        int result = CollectionUtils.countMatches(input, predicate);

        // Assert the expected result
        assertEquals(1, result); // Only "banana" has length greater than 5
    }

    @Test(timeout = 4000)
    public void testCountMatchesWithNullPredicate() {
        // Prepare input data
        List<String> input = Arrays.asList("apple", "banana", "cherry", "date");

        // Call the focal method with a null predicate
        int result = CollectionUtils.countMatches(input, null);

        // Assert the expected result
        assertEquals(0, result); // Should return 0 when predicate is null
    }


}