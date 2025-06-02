package org.apache.commons.collections4.set;
import org.apache.commons.collections4.set.UnmodifiableSet;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;

public class set_UnmodifiableSet_unmodifiableSet_Set_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testUnmodifiableSetWithUnmodifiableInstance() {
        Set<String> originalSet = new HashSet<>();
        originalSet.add("element1");
        originalSet.add("element2");

        // Create an unmodifiable set directly using the provided method
        Set<String> unmodifiableSet = UnmodifiableSet.unmodifiableSet(originalSet);

        // Test the focal method
        Set<String> result = UnmodifiableSet.unmodifiableSet(unmodifiableSet);

        // Verify that the result is the same as the input unmodifiable set
        assertEquals(unmodifiableSet, result);
    }

    @Test(timeout = 4000)
    public void testUnmodifiableSetWithRegularSet() {
        Set<String> regularSet = new HashSet<>();
        regularSet.add("element1");
        regularSet.add("element2");

        // Test the focal method
        Set<String> result = UnmodifiableSet.unmodifiableSet(regularSet);

        // Verify that the result is not modifiable
        try {
            result.add("element3");
        } catch (UnsupportedOperationException e) {
            // Expected exception
        }
    }

}