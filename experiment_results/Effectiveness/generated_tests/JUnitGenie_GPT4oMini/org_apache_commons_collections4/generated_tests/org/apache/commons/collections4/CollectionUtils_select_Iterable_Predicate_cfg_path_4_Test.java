package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtils_select_Iterable_Predicate_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSelectWithEmptyCollection() {
        // Arrange
        Iterable<String> inputCollection = new ArrayList<>();
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean evaluate(String object) {
                return false; // No elements should be selected
            }
        };

        // Act
        Collection<String> result = null;
        try {
            result = CollectionUtils.select(inputCollection, predicate);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertEquals(0, result.size());
    }

    @Test(timeout = 4000)
    public void testSelectWithNonEmptyCollection() {
        // Arrange
        List<String> inputCollection = new ArrayList<>();
        inputCollection.add("apple");
        inputCollection.add("banana");
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean evaluate(String object) {
                return object.equals("banana"); // Only "banana" should be selected
            }
        };

        // Act
        Collection<String> result = null;
        try {
            result = CollectionUtils.select(inputCollection, predicate);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertEquals(1, result.size());
        assertEquals(true, result.contains("banana"));
        assertEquals(false, result.contains("apple"));
    }


}