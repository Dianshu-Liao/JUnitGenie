package org.apache.commons.collections4.collection;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class collection_TransformedCollection_transform_Collection_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testTransform() {
        try {
            // Create a sample collection to transform
            Collection<String> inputCollection = Arrays.asList("one", "two", "three"); // Use Arrays.asList instead of List.of

            // Create a transformer that transforms String to its length
            Transformer<String, Integer> transformer = String::length;

            // Instantiate the TransformedCollection using reflection
            TransformedCollection<String> transformedCollection = 
                (TransformedCollection<String>) TransformedCollection.class
                    .getDeclaredConstructor(Collection.class, Transformer.class)
                    .newInstance(inputCollection, transformer);

            // Access the protected method 'transform' using reflection
            Method transformMethod = TransformedCollection.class.getDeclaredMethod("transform", Collection.class);
            transformMethod.setAccessible(true);

            // Invoke the transform method
            Collection<Integer> result = (Collection<Integer>) transformMethod.invoke(transformedCollection, inputCollection);

            // Expected result
            List<Integer> expected = new ArrayList<>();
            for (String item : inputCollection) {
                expected.add(item.length());
            }

            // Assert the result
            assertEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}