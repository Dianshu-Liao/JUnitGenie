package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Before;
import org.junit.Test;

public class harmony_pack200_IntList_add_int_int_cfg_path_5_Test {
    private IntList intList;

    @Before
    public void setUp() {
        intList = new IntList(); // or intList = new IntList(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAdd_OutOfBounds() {
        int location = -1; // Invalid location
        int object = 5;
        
        try {
            intList.add(location, object);
        } catch (IndexOutOfBoundsException e) {
            // Exception is expected
            throw e; // Re-throw to satisfy the @Test annotation
        }
    }

}