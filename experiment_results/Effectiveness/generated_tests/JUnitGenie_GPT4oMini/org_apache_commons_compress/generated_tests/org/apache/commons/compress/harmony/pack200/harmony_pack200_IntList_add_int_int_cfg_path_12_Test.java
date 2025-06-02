package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_IntList_add_int_int_cfg_path_12_Test {
    private IntList intList;

    @Before
    public void setUp() {
        intList = new IntList(10); // Initialize with a capacity of 10
    }

    @Test(timeout = 4000)
    public void testAddAtValidLocation() {
        intList.add(0, 5); // Add at the beginning
        intList.add(1, 10); // Add at the second position
        intList.add(1, 7); // Add in the middle

        // Validate the contents of the IntList using a public method
        assertEquals(5, intList.get(0));
        assertEquals(7, intList.get(1));
        assertEquals(10, intList.get(2));
    }

    @Test(timeout = 4000)
    public void testAddAtEnd() {
        intList.add(0, 5);
        intList.add(1, 10);
        intList.add(2, 15); // Add at the end

        // Validate the contents of the IntList using a public method
        assertEquals(5, intList.get(0));
        assertEquals(10, intList.get(1));
        assertEquals(15, intList.get(2));
    }

    @Test(timeout = 4000)
    public void testAddAtFrontWhenFirstIndexIsZero() {
        intList.add(0, 5); // Add at the beginning
        intList.add(0, 3); // Add at the front again

        // Validate the contents of the IntList using a public method
        assertEquals(3, intList.get(0));
        assertEquals(5, intList.get(1));
    }

    @Test(timeout = 4000)
    public void testAddThrowsIndexOutOfBoundsException() {
        try {
            intList.add(-1, 5); // Invalid location
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }

        try {
            intList.add(1, 5); // Invalid location (when size is 0)
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

}