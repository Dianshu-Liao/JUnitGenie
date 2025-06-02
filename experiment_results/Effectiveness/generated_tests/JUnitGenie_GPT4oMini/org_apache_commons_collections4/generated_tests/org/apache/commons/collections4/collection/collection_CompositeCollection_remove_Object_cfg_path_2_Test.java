package org.apache.commons.collections4.collection;
import org.apache.commons.collections4.collection.CompositeCollection;
import org.junit.Test;
import static org.junit.Assert.fail;

public class collection_CompositeCollection_remove_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemoveUnsupportedOperationException() {
        CompositeCollection collection = new CompositeCollection(); // Using the default constructor
        try {
            collection.remove(new Object());
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            // Exception is expected, test passes
            assert e.getMessage().equals("remove() is not supported on CompositeCollection without a CollectionMutator strategy");
        }
    }

}