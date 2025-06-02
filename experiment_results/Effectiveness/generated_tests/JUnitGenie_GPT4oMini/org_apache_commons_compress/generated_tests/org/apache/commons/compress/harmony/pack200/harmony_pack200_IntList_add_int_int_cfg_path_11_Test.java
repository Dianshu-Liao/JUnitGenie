package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_IntList_add_int_int_cfg_path_11_Test {
    private IntList intList;

    @Before
    public void setUp() {
        intList = new IntList(10); // Initialize with a capacity of 10
    }

    @Test(timeout = 4000)
    public void testAddAtLocationWithinBounds() {
        intList.add(0, 5); // Add at the beginning
        intList.add(1, 10); // Add at the second position
        intList.add(1, 7); // Add at the middle position

        // Validate the contents of the IntList using a public method
        assertEquals(5, intList.get(0));
        assertEquals(7, intList.get(1));
        assertEquals(10, intList.get(2));
    }

    @Test(timeout = 4000)
    public void testAddAtLocationZero() {
        intList.add(0, 5); // Add at the beginning
        assertEquals(5, intList.get(0));
    }

    @Test(timeout = 4000)
    public void testAddAtLocationEqualToSize() {
        intList.add(0, 5); // Add at the beginning
        intList.add(1, 10); // Add at the second position
        intList.add(2, 15); // Add at the end

        // Validate the contents of the IntList using a public method
        assertEquals(5, intList.get(0));
        assertEquals(10, intList.get(1));
        assertEquals(15, intList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtInvalidLocation() {
        intList.add(5, 20); // This should throw an exception
    }

    @Test(timeout = 4000)
    public void testAddWhenGrowingArray() {
        for (int i = 0; i < 10; i++) {
            intList.add(i, i + 1); // Fill the array
        }
        intList.add(10, 11); // This should trigger the growAtEnd method

        // Validate the last element using a public method
        assertEquals(11, intList.get(10));
    }

}