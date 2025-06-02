package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ObjectGraphIterator;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import static org.junit.Assert.*;

public class iterators_ObjectGraphIterator__init__Object_Transformer_cfg_path_2_Test {

    private class TestTransformer implements Transformer<Object, Object> {
        @Override
        public Object transform(Object input) {
            return input; // Simple transformation for testing
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithObjectAndTransformer() {
        Object root = new Object(); // Create a test root object
        Transformer<Object, Object> transformer = new TestTransformer(); // Instantiate the transformer

        try {
            ObjectGraphIterator<Object> iterator = new ObjectGraphIterator<>(root, transformer);
            assertNotNull(iterator); // Ensure the iterator is created successfully
        } catch (Exception e) {
            fail("Constructor threw an exception: " + e.getMessage());
        }
    }

}