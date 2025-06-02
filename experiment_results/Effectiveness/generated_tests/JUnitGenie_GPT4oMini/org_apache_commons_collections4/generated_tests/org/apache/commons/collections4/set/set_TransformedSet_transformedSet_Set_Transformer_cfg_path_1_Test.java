package org.apache.commons.collections4.set;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.set.TransformedSet;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;

public class set_TransformedSet_transformedSet_Set_Transformer_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testTransformedSet() {
        // Create a sample set
        Set<Integer> originalSet = new HashSet<>();
        originalSet.add(1);
        originalSet.add(2);
        originalSet.add(3);

        // Create a transformer that adds 10 to each element
        Transformer<Integer, Integer> transformer = new Transformer<Integer, Integer>() {
            @Override
            public Integer transform(Integer input) {
                return input + 10;
            }
        };

        // Call the focal method
        Set<Integer> transformedSet = TransformedSet.transformedSet(originalSet, transformer);

        // Verify the transformed set
        Set<Integer> expectedSet = new HashSet<>();
        expectedSet.add(11);
        expectedSet.add(12);
        expectedSet.add(13);
        assertEquals(expectedSet, transformedSet);
    }

}