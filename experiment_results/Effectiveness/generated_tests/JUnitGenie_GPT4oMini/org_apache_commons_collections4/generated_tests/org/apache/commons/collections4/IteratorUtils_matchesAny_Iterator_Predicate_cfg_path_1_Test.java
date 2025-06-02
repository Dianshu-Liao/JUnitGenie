package org.apache.commons.collections4;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;
import static org.junit.Assert.assertTrue;

public class IteratorUtils_matchesAny_Iterator_Predicate_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMatchesAny() {
        // Create an iterator
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3, 4, 5).iterator();

        // Create a predicate that checks if the number is greater than 0
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer object) {
                return object > 0;
            }
        };

        // Call the matchesAny method and assert the result
        try {
            boolean result = IteratorUtils.matchesAny(iterator, predicate);
            assertTrue(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}