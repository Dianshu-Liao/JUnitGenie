package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_collect_Iterable_Transformer_cfg_path_1_Test {

    private static class SimpleTransformer implements Transformer<Object, Object> {
        @Override
        public Object transform(Object input) {
            return input.toString();
        }
    }

    @Test(timeout = 4000)
    public void testCollect_withNonEmptyCollection() {
        List<Integer> inputCollection = new ArrayList<>();
        inputCollection.add(1);
        inputCollection.add(2);
        inputCollection.add(3);
        Transformer<Object, Object> transformer = new SimpleTransformer();
        
        Collection<Object> result = CollectionUtils.collect(inputCollection, transformer);
        
        Collection<Object> expected = new ArrayList<>();
        expected.add("1");
        expected.add("2");
        expected.add("3");
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testCollect_withNullInput() {
        List<Integer> inputCollection = null;
        Transformer<Object, Object> transformer = new SimpleTransformer();
        
        Collection<Object> result = CollectionUtils.collect(inputCollection, transformer);
        
        assertEquals(new ArrayList<>(), result);
    }
    
    @Test(timeout = 4000)
    public void testCollect_withEmptyCollection() {
        List<Integer> inputCollection = new ArrayList<>();
        Transformer<Object, Object> transformer = new SimpleTransformer();
        
        Collection<Object> result = CollectionUtils.collect(inputCollection, transformer);
        
        assertEquals(new ArrayList<>(), result);
    }

}