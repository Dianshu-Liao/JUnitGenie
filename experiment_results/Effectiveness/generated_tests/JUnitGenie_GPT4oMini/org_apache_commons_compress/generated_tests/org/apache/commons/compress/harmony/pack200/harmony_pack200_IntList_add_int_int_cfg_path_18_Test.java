package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_IntList_add_int_int_cfg_path_18_Test {

    @Test(timeout = 4000)
    public void testAddAtFront() {
        IntList intList = new IntList();
        intList.add(0, 10); // Adding at the front when firstIndex is 0

        // Verify the state of the IntList after the operation
        assertEquals(10, intList.get(0)); // Assuming get method exists to access elements
        assertEquals(0, intList.size()); // Changed to size() to check the number of elements
        assertEquals(0, intList.get(0)); // Assuming get method exists to access first element
        assertEquals(1, intList.size()); // Changed to size() to check the number of elements
    }

    @Test(timeout = 4000)
    public void testAddAtLocation() {
        IntList intList = new IntList();
        intList.add(0, 20); // First add to make the list non-empty
        intList.add(1, 30); // Now add at location 1

        // Verify the state of the IntList after the operation
        assertEquals(20, intList.get(0)); // Assuming get method exists to access elements
        assertEquals(30, intList.get(1)); // Assuming get method exists to access elements
        assertEquals(2, intList.size()); // Changed to size() to check the number of elements
    }

    @Test(timeout = 4000)
    public void testAddThrowsIndexOutOfBoundsException() {
        IntList intList = new IntList();
        try {
            intList.add(2, 40); // This should throw an exception
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Exception is expected, test passes
        }
    }


}