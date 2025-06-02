package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_IntList_add_int_int_cfg_path_21_Test {

    @Test(timeout = 4000)
    public void testAddThrowsIndexOutOfBoundsException() {
        IntList intList = new IntList(); // Using the default constructor
        int location = 1; // This location is out of bounds since the list is empty
        int object = 42;

        try {
            intList.add(location, object);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Exception is expected, test passes
        }
    }

}