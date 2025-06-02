package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_IntList_add_int_int_cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testAddValidLocation() {
        IntList intList = new IntList(5);
        intList.add(0, 10); // Adding at the start
        intList.add(1, 20); // Adding at the second position
        intList.add(1, 15); // Adding in the middle

        // Validate the contents of the array using a public method
        assertEquals(10, intList.get(0));
        assertEquals(15, intList.get(1));
        assertEquals(20, intList.get(2));
    }

    @Test(timeout = 4000)
    public void testAddAtEnd() {
        IntList intList = new IntList(5);
        intList.add(0, 10);
        intList.add(1, 20);
        intList.add(2, 30); // Adding at the end

        // Validate the contents of the array using a public method
        assertEquals(10, intList.get(0));
        assertEquals(20, intList.get(1));
        assertEquals(30, intList.get(2));
    }

    @Test(timeout = 4000)
    public void testAddAtFrontWhenFirstIndexIsZero() {
        IntList intList = new IntList(5);
        intList.add(0, 10); // Adding at the start
        intList.add(0, 20); // Adding again at the start

        // Validate the contents of the array using a public method
        assertEquals(20, intList.get(0));
        assertEquals(10, intList.get(1));
    }

    @Test(timeout = 4000)
    public void testAddThrowsIndexOutOfBoundsException() {
        IntList intList = new IntList(5);
        intList.add(0, 10); // Adding at the start

        try {
            intList.add(6, 20); // Invalid index, should throw exception
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testAddWhenArrayNeedsToGrow() {
        IntList intList = new IntList(2);
        intList.add(0, 10);
        intList.add(1, 20);
        intList.add(2, 30); // This should trigger growAtEnd

        // Validate the contents of the array using a public method
        assertEquals(10, intList.get(0));
        assertEquals(20, intList.get(1));
        assertEquals(30, intList.get(2));
    }


}