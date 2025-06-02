package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_IntList_add_int_int_cfg_path_20_Test {

    @Test(timeout = 4000)
    public void testAddAtEnd() {
        IntList intList = new IntList(5); // Initialize with a capacity of 5
        intList.add(0, 1); // Add first element
        intList.add(1, 2); // Add second element
        intList.add(2, 3); // Add third element
        intList.add(3, 4); // Add fourth element
        intList.add(4, 5); // Add fifth element

        // This should trigger growAtEnd
        try {
            intList.add(5, 6); // Attempt to add sixth element
        } catch (IndexOutOfBoundsException e) {
            fail("Should not throw IndexOutOfBoundsException");
        }
    }

    @Test(timeout = 4000)
    public void testAddAtInvalidLocation() {
        IntList intList = new IntList(5); // Initialize with a capacity of 5
        intList.add(0, 1); // Add first element

        try {
            intList.add(2, 2); // Attempt to add at an invalid location
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testAddAtFront() {
        IntList intList = new IntList(5); // Initialize with a capacity of 5
        intList.add(0, 1); // Add first element
        intList.add(0, 2); // Add at front

        // Check if the first element is now 2
        try {
            // Use a public method to get the value instead of accessing private fields
            assertEquals(2, intList.get(0)); // Assuming get(int index) is a public method in IntList
        } catch (ArrayIndexOutOfBoundsException e) {
            fail("Array index out of bounds");
        }
    }


}