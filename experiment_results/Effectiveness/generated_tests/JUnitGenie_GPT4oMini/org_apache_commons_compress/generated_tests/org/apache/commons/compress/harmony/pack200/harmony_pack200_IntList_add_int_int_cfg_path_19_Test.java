package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_IntList_add_int_int_cfg_path_19_Test {

    @Test(timeout = 4000)
    public void testAddAtValidLocation() {
        IntList intList = new IntList(10);
        intList.add(0, 5); // Adding at the start
        intList.add(1, 10); // Adding at the second position
        intList.add(1, 7); // Adding in the middle

        // Validate the contents of the list using a public method
        assertEquals(5, intList.get(0));
        assertEquals(7, intList.get(1));
        assertEquals(10, intList.get(2));
    }

    @Test(timeout = 4000)
    public void testAddAtEnd() {
        IntList intList = new IntList(5);
        intList.add(0, 1);
        intList.add(1, 2);
        intList.add(2, 3);
        intList.add(3, 4);
        intList.add(4, 5); // Adding at the end

        // Validate the contents of the list using a public method
        assertEquals(1, intList.get(0));
        assertEquals(2, intList.get(1));
        assertEquals(3, intList.get(2));
        assertEquals(4, intList.get(3));
        assertEquals(5, intList.get(4));
    }

    @Test(timeout = 4000)
    public void testAddAtInvalidLocation() {
        IntList intList = new IntList(5);
        intList.add(0, 1);
        intList.add(1, 2);
        intList.add(2, 3);

        try {
            intList.add(5, 4); // Invalid location (size is 3)
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testAddAtZeroLocationWhenEmpty() {
        IntList intList = new IntList(5);
        intList.add(0, 1); // Adding at the start when empty

        // Validate the contents of the list using a public method
        assertEquals(1, intList.get(0));
    }

    @Test(timeout = 4000)
    public void testAddAtZeroLocationWhenNotEmpty() {
        IntList intList = new IntList(5);
        intList.add(0, 1);
        intList.add(0, 2); // Adding at the start when not empty

        // Validate the contents of the list using a public method
        assertEquals(2, intList.get(0));
        assertEquals(1, intList.get(1));
    }


}