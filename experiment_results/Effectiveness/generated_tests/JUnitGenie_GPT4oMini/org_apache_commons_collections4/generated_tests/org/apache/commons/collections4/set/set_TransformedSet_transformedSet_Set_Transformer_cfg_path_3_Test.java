package org.apache.commons.collections4.set;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.set.TransformedSet;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;

public class set_TransformedSet_transformedSet_Set_Transformer_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testTransformedSet() {
        // Arrange
        Set<Integer> originalSet = new HashSet<>();
        originalSet.add(1);
        originalSet.add(2);
        originalSet.add(3);

        Transformer<Integer, Integer> transformer = new Transformer<Integer, Integer>() {
            @Override
            public Integer transform(Integer input) {
                return input * 2; // Example transformation
            }
        };

        // Act
        Set<Integer> transformedSet = TransformedSet.transformedSet(originalSet, transformer);

        // Assert
        Set<Integer> expectedSet = new HashSet<>();
        expectedSet.add(2);
        expectedSet.add(4);
        expectedSet.add(6);
        assertEquals(expectedSet, transformedSet);
    }


}