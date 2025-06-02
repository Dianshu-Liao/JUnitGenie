package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_IntList_add_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAddAtFrontWhenFirstIndexIsZero() {
        IntList intList = new IntList(5); // Initialize with a capacity of 5
        intList.add(0, 10); // Add an element at the front

        // Verify the state of the IntList using public methods
        assertEquals(10, intList.get(0)); // Access the first element directly
        assertEquals(1, intList.size());
        // Removed the assertion for getFirstIndex() as it does not exist
    }

    @Test(timeout = 4000)
    public void testAddAtFrontWhenFirstIndexIsNotZero() {
        IntList intList = new IntList(5);
        intList.add(0, 10); // Add an element at the front
        intList.add(0, 20); // Add another element at the front

        // Verify the state of the IntList using public methods
        assertEquals(20, intList.get(0)); // Access the first element directly
        assertEquals(2, intList.size());
        // Removed the assertion for getFirstIndex() as it does not exist
    }

    @Test(timeout = 4000)
    public void testAddThrowsIndexOutOfBoundsException() {
        IntList intList = new IntList(5);
        try {
            intList.add(10, 30); // This should throw an exception
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Exception is expected
        }
    }


}