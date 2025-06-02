package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_select_Iterable_Predicate_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testSelectWithNonEmptyCollection() {
        // Setup
        List<Integer> inputCollection = new ArrayList<>();
        inputCollection.add(1);
        inputCollection.add(2);
        inputCollection.add(3);
        
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer object) {
                return object > 1; // Select elements greater than 1
            }
        };
        
        Collection<Integer> outputCollection = new ArrayList<>();

        // Execute
        Collection<Integer> result = CollectionUtils.select(inputCollection, predicate, outputCollection);

        // Verify
        assertEquals(2, result.size());
        assertEquals(true, result.contains(2));
        assertEquals(true, result.contains(3));
    }

    @Test(timeout = 4000)
    public void testSelectWithEmptyCollection() {
        // Setup
        List<Integer> inputCollection = new ArrayList<>();
        
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer object) {
                return object > 1; // Select elements greater than 1
            }
        };
        
        Collection<Integer> outputCollection = new ArrayList<>();

        // Execute
        Collection<Integer> result = CollectionUtils.select(inputCollection, predicate, outputCollection);

        // Verify
        assertEquals(0, result.size());
    }

    @Test(timeout = 4000)
    public void testSelectWithNullInputCollection() {
        // Setup
        Iterable<Integer> inputCollection = null;
        
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer object) {
                return object > 1; // Select elements greater than 1
            }
        };
        
        Collection<Integer> outputCollection = new ArrayList<>();

        // Execute
        try {
            Collection<Integer> result = CollectionUtils.select(inputCollection, predicate, outputCollection);
        } catch (Exception e) {
            // Verify that an exception is thrown
            assertEquals("Input collection cannot be null", e.getMessage());
        }
    }

}