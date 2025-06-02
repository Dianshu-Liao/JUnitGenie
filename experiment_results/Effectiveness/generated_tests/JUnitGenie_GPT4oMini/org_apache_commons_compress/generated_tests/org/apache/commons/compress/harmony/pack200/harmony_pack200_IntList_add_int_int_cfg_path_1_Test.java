package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_IntList_add_int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddAtFront() {
        IntList intList = new IntList(5);
        intList.add(0, 10); // Adding at the front
        assertEquals(10, intList.get(0)); // Use getter method
        assertEquals(1, intList.size()); // Corrected to size() for current size
        // Removed getFirstIndex() as it does not exist
    }

    @Test(timeout = 4000)
    public void testAddAtMiddle() {
        IntList intList = new IntList(5);
        intList.add(0, 10);
        intList.add(1, 20); // Adding at the end
        intList.add(1, 15); // Adding in the middle
        assertEquals(15, intList.get(1)); // Use getter method
        assertEquals(3, intList.size()); // Corrected to size() for current size
        // Removed getFirstIndex() as it does not exist
    }

    @Test(timeout = 4000)
    public void testAddAtEnd() {
        IntList intList = new IntList(5);
        intList.add(0, 10);
        intList.add(1, 20);
        intList.add(2, 30); // Adding at the end
        assertEquals(30, intList.get(2)); // Use getter method
        assertEquals(3, intList.size()); // Corrected to size() for current size
        // Removed getFirstIndex() as it does not exist
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddInvalidLocation() {
        IntList intList = new IntList(5);
        intList.add(5, 10); // Invalid location
    }


}