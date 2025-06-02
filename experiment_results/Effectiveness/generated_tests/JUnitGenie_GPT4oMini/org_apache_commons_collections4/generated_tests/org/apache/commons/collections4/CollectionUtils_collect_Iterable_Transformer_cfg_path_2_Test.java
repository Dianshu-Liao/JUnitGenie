package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtils_collect_Iterable_Transformer_cfg_path_2_Test {

    private static class TestTransformer implements Transformer<Integer, String> {
        @Override
        public String transform(Integer input) {
            return input.toString();
        }
    }

    @Test(timeout = 4000)
    public void testCollectWithNonEmptyCollection() {
        List<Integer> inputCollection = new ArrayList<>();
        inputCollection.add(1);
        inputCollection.add(2);
        inputCollection.add(3);
        
        Transformer<Integer, String> transformer = new TestTransformer();
        
        Collection<String> result = null;
        try {
            result = CollectionUtils.collect(inputCollection, transformer);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        
        assertEquals(3, result.size());
        assertEquals("1", result.toArray()[0]);
        assertEquals("2", result.toArray()[1]);
        assertEquals("3", result.toArray()[2]);
    }

    @Test(timeout = 4000)
    public void testCollectWithNullInputCollection() {
        Transformer<Integer, String> transformer = new TestTransformer();
        
        Collection<String> result = null;
        try {
            result = CollectionUtils.collect((Iterable<Integer>) null, transformer);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        
        assertEquals(0, result.size());
    }

    @Test(timeout = 4000)
    public void testCollectWithEmptyCollection() {
        List<Integer> inputCollection = new ArrayList<>();
        Transformer<Integer, String> transformer = new TestTransformer();
        
        Collection<String> result = null;
        try {
            result = CollectionUtils.collect(inputCollection, transformer);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        
        assertEquals(0, result.size());
    }


}