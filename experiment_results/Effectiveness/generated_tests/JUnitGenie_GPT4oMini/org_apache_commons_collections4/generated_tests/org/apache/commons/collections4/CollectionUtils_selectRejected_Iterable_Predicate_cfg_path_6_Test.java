package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_selectRejected_Iterable_Predicate_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testSelectRejectedWithNonEmptyCollection() {
        // Arrange
        List<Integer> inputCollection = new ArrayList<>();
        inputCollection.add(1);
        inputCollection.add(2);
        inputCollection.add(3);
        
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer object) {
                return object > 2; // Reject numbers greater than 2
            }
        };

        // Act
        Collection<Integer> result = null;
        try {
            result = CollectionUtils.selectRejected(inputCollection, predicate);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertEquals(2, result.size());
        assertEquals(true, result.contains(1));
        assertEquals(true, result.contains(2));
    }

    @Test(timeout = 4000)
    public void testSelectRejectedWithNullInputCollection() {
        // Arrange
        Iterable<Integer> inputCollection = null;
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer object) {
                return object > 2; // Reject numbers greater than 2
            }
        };

        // Act
        Collection<Integer> result = null;
        try {
            result = CollectionUtils.selectRejected(inputCollection, predicate);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertEquals(0, result.size());
    }

    @Test(timeout = 4000)
    public void testSelectRejectedWithEmptyCollection() {
        // Arrange
        List<Integer> inputCollection = new ArrayList<>();
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean evaluate(Integer object) {
                return object > 2; // Reject numbers greater than 2
            }
        };

        // Act
        Collection<Integer> result = null;
        try {
            result = CollectionUtils.selectRejected(inputCollection, predicate);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertEquals(0, result.size());
    }

}