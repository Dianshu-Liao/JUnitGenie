package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_IntList_add_int_int_cfg_path_13_Test {
    private IntList intList;

    @Before
    public void setUp() {
        intList = new IntList();
    }

    @Test(timeout = 4000)
    public void testAddAtLocationWithinBounds() {
        intList.add(0, 10);
        intList.add(1, 20);
        intList.add(1, 15); // Adding 15 at index 1

        // Validate that the elements are in expected positions
        assertEquals(10, intList.get(0));
        assertEquals(15, intList.get(1));
        assertEquals(20, intList.get(2));
    }

    @Test(timeout = 4000)
    public void testAddAtStart() {
        intList.add(0, 5);
        assertEquals(5, intList.get(0));
    }

    @Test(timeout = 4000)
    public void testAddAtEnd() {
        intList.add(0, 1);
        intList.add(1, 2); // behave correctly when last index is increased
        intList.add(2, 3);

        // Validate that the last element is added correctly
        assertEquals(3, intList.get(2));
    }

    @Test(timeout = 4000)
    public void testAddExceptionOutOfBounds() {
        try {
            intList.add(-1, 10); // Out of bounds
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }

        try {
            intList.add(10, 10); // Out of bounds
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

}