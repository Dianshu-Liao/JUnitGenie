package org.apache.commons.collections4.map;
import static org.junit.Assert.*;
import org.junit.Test;
import org.apache.commons.collections4.map.TransformedSortedMap;
import org.apache.commons.collections4.Transformer;
import java.util.SortedMap;
import java.util.TreeMap;

public class map_TransformedSortedMap_transformedSortedMap_SortedMap_Transformer_Transformer_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testTransformedSortedMap() {
        SortedMap<String, Integer> map = new TreeMap<>();
        map.put("A", 1);
        map.put("B", 2);

        Transformer<String, String> keyTransformer = new Transformer<String, String>() {
            public String transform(String input) {
                return input.toLowerCase();
            }
        };

        Transformer<Integer, Integer> valueTransformer = new Transformer<Integer, Integer>() {
            public Integer transform(Integer input) {
                return input + 1;
            }
        };

        TransformedSortedMap<String, Integer> transformedMap = null;
        try {
            transformedMap = TransformedSortedMap.transformedSortedMap(map, keyTransformer, valueTransformer);
        } catch (Exception e) {
            fail("Should not have thrown an exception: " + e.getMessage());
        }

        assertNotNull(transformedMap);
        assertEquals((Integer) 2, transformedMap.get("a")); // Transformed key "a" should give value 2
        assertEquals((Integer) 3, transformedMap.get("b")); // Transformed key "b" should give value 3
    }

}