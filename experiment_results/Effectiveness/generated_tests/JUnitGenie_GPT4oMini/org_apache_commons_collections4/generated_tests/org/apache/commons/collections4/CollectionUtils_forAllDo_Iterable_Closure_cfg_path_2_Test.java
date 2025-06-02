package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.IterableUtils;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CollectionUtils_forAllDo_Iterable_Closure_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testForAllDoWithNonNullClosure() {
        // Arrange
        Iterable<String> collection = java.util.Arrays.asList("a", "b", "c");
        Closure<String> closure = new Closure<String>() {
            public void execute(String input) {
                // Dummy implementation for testing
            }
        };

        // Act
        Closure<?> result = CollectionUtils.forAllDo(collection, closure);

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testForAllDoWithNullClosure() {
        // Arrange
        Iterable<String> collection = java.util.Arrays.asList("a", "b", "c");
        Closure<String> closure = null;

        // Act
        Closure<?> result = CollectionUtils.forAllDo(collection, closure);

        // Assert
        assertNull(result); // Now assertNull is correctly imported
    }


}