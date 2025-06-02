package org.apache.commons.collections4.set;
import org.apache.commons.collections4.set.CompositeSet;
import org.junit.Test;
import static org.junit.Assert.fail;

public class set_CompositeSet_add_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAdd_UnsupportedOperationException() {
        CompositeSet<Object> compositeSet = new CompositeSet<>(); // Using the default constructor
        try {
            compositeSet.add(new Object());
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            // Exception is expected, test passes
            assert e.getMessage().equals("add() is not supported on CompositeSet without a SetMutator strategy");
        }
    }

}