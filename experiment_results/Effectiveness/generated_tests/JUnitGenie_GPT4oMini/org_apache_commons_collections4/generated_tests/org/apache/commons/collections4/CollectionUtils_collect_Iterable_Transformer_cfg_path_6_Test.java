package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtils_collect_Iterable_Transformer_cfg_path_6_Test {

    private static class TestTransformer implements Transformer<Integer, String> {
        @Override
        public String transform(Integer input) {
            return input.toString();
        }
    }

    @Test(timeout = 4000)
    public void testCollectWithNonEmptyInput() {
        List<Integer> inputCollection = new ArrayList<>();
        inputCollection.add(1);
        inputCollection.add(2);
        inputCollection.add(3);
        Transformer<Integer, String> transformer = new TestTransformer();
        Collection<String> result = CollectionUtils.collect(inputCollection, transformer);
        
        Collection<String> expected = new ArrayList<>();
        expected.add("1");
        expected.add("2");
        expected.add("3");
        
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testCollectWithEmptyInput() {
        List<Integer> inputCollection = new ArrayList<>();
        Transformer<Integer, String> transformer = new TestTransformer();
        Collection<String> result = CollectionUtils.collect(inputCollection, transformer);
        
        Collection<String> expected = new ArrayList<>();
        
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testCollectWithNullInput() {
        Transformer<Integer, String> transformer = new TestTransformer();
        Collection<String> result = CollectionUtils.collect((Iterable<Integer>) null, transformer);
        
        Collection<String> expected = new ArrayList<>();
        
        assertEquals(expected, result);
    }

}