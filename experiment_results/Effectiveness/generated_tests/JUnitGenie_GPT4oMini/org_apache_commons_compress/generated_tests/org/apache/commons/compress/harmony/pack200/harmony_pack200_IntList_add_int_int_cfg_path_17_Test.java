package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_IntList_add_int_int_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testAddAtBeginning() {
        IntList intList = new IntList(5);
        intList.add(0, 10);
        // Verify that the size is 1 and the object is added
        assertEquals(1, intList.size()); // Changed from getSize() to size()
        assertEquals(10, intList.get(0));
    }

    @Test(timeout = 4000)
    public void testAddAtEnd() {
        IntList intList = new IntList(5);
        intList.add(0, 10);
        intList.add(1, 20);
        // Verify that the size is 2 and the object is added
        assertEquals(2, intList.size()); // Changed from getSize() to size()
        assertEquals(20, intList.get(1));
    }

    @Test(timeout = 4000)
    public void testAddInMiddle() {
        IntList intList = new IntList(5);
        intList.add(0, 10);
        intList.add(1, 20);
        intList.add(1, 15); // Add in the middle
        // Verify that the object is added in the correct position
        assertEquals(15, intList.get(1));
        assertEquals(20, intList.get(2));
    }

    @Test(timeout = 4000)
    public void testAddThrowsIndexOutOfBoundsException() {
        IntList intList = new IntList(5);
        try {
            intList.add(10, 30); // This should throw an exception
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Exception is expected
        }
    }


}