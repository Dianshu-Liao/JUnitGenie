package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtils_collect_Iterable_Transformer_cfg_path_5_Test {

    private static class TestTransformer implements Transformer<Object, Object> {
        @Override
        public Object transform(Object input) {
            return input.toString(); // Simple transformation for testing
        }
    }

    @Test(timeout = 4000)
    public void testCollectWithNonEmptyInput() {
        List<Integer> inputCollection = new ArrayList<>();
        inputCollection.add(1);
        inputCollection.add(2);
        inputCollection.add(3);
        Transformer<Object, Object> transformer = new TestTransformer();
        Collection<Object> result = null;

        try {
            result = CollectionUtils.collect(inputCollection, transformer);
        } catch (Exception e) {
            // Handle exception if needed
        }

        assertEquals(3, result.size());
        assertEquals("1", result.iterator().next()); // Check the first transformed element
    }

    @Test(timeout = 4000)
    public void testCollectWithEmptyInput() {
        List<Integer> inputCollection = new ArrayList<>();
        Transformer<Object, Object> transformer = new TestTransformer();
        Collection<Object> result = null;

        try {
            result = CollectionUtils.collect(inputCollection, transformer);
        } catch (Exception e) {
            // Handle exception if needed
        }

        assertEquals(0, result.size());
    }


}