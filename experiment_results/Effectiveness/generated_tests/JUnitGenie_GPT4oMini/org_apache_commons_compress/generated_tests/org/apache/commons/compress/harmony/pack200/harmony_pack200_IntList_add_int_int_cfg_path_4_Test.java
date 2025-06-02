package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_IntList_add_int_int_cfg_path_4_Test {

    private IntList intList;

    @Before
    public void setUp() {
        // Assuming the array size of 10 for testing purposes
        intList = new IntList(10);
    }

    @Test(timeout = 4000)
    public void testAddAtEnd() {
        try {
            intList.add(0, 5); // Initially adding an element at index 0
            intList.add(1, 10); // Adding at index 1
            // This should not trigger growAtEnd since the list is not full
            intList.add(2, 15); // Adding at index 2
            assertEquals(5, intList.get(0));
            assertEquals(10, intList.get(1));
            assertEquals(15, intList.get(2));
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }
    
    @Test(timeout = 4000)
    public void testAddThrowIndexOutOfBounds() {
        try {
            intList.add(-1, 5); // This should throw an IndexOutOfBoundsException
            fail("Expected IndexOutOfBoundsException not thrown");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGrowAtEnd() {
        try {
            for (int i = 0; i < 10; i++) { // Filling the list
                intList.add(i, i + 1);
            }
            intList.add(10, 11); // This should trigger growAtEnd
            
            // Verify that the last element has been added
            assertEquals(11, intList.get(10));
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }


}