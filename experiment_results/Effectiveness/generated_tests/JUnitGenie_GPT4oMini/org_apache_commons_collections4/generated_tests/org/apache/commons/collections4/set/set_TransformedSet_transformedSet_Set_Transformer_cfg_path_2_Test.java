package org.apache.commons.collections4.set;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.set.TransformedSet;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;

public class set_TransformedSet_transformedSet_Set_Transformer_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testTransformedSet() {
        // Create a sample set
        Set<Integer> originalSet = new HashSet<>();
        originalSet.add(1);
        originalSet.add(2);
        originalSet.add(3);

        // Create a transformer that doubles the integer values
        Transformer<Integer, Integer> transformer = new Transformer<Integer, Integer>() {
            @Override
            public Integer transform(Integer input) {
                return input * 2;
            }
        };

        // Call the transformedSet method
        Set<Integer> transformedSet = TransformedSet.transformedSet(originalSet, transformer);

        // Verify the transformed set
        Set<Integer> expectedSet = new HashSet<>();
        expectedSet.add(2);
        expectedSet.add(4);
        expectedSet.add(6);

        // Check if the transformed set matches the expected set
        assertEquals(expectedSet, transformedSet);
    }

    @Test(timeout = 4000)
    public void testTransformedSetEmpty() {
        // Create an empty set
        Set<Integer> emptySet = new HashSet<>();

        // Create a transformer
        Transformer<Integer, Integer> transformer = new Transformer<Integer, Integer>() {
            @Override
            public Integer transform(Integer input) {
                return input * 2;
            }
        };

        // Call the transformedSet method
        Set<Integer> transformedSet = TransformedSet.transformedSet(emptySet, transformer);

        // Verify that the transformed set is also empty
        assertEquals(new HashSet<>(), transformedSet);
    }


}