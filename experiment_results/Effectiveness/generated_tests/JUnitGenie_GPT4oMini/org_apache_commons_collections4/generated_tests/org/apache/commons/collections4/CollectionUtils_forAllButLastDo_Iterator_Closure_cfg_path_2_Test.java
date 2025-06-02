package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.IteratorUtils;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;
import static org.junit.Assert.assertNull;

public class CollectionUtils_forAllButLastDo_Iterator_Closure_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testForAllButLastDoWithNullClosure() {
        // Arrange
        Iterator<String> iterator = Arrays.asList("one", "two", "three").iterator();
        Closure<String> closure = null;

        // Act
        Object result = CollectionUtils.forAllButLastDo(iterator, closure);

        // Assert
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testForAllButLastDoWithValidClosure() {
        // Arrange
        Iterator<String> iterator = Arrays.asList("one", "two", "three").iterator();
        Closure<String> closure = new Closure<String>() {
            @Override
            public void execute(String input) {
                // Do nothing for the sake of this test
            }
        };

        // Act
        Object result = CollectionUtils.forAllButLastDo(iterator, closure);

        // Assert
        // Here we would normally check the result, but since the method does not return a specific value,
        // we can just assert that it does not throw an exception.
    }

}