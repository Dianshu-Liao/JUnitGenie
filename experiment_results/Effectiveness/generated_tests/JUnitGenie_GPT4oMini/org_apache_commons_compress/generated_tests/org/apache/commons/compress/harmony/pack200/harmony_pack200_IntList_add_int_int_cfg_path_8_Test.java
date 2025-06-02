package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_IntList_add_int_int_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testAddWithinBounds() {
        IntList intList = new IntList(10);
        intList.add(0, 5);
        intList.add(1, 10);
        intList.add(1, 7);
        
        // Validate the internal state of the IntList using public methods
        assertEquals(3, intList.size());
        // Removed getFirstIndex() as it does not exist
        assertEquals(5, intList.get(0));
        assertEquals(7, intList.get(1));
        assertEquals(10, intList.get(2));
    }

    @Test(timeout = 4000)
    public void testAddAtBeginning() {
        IntList intList = new IntList(10);
        intList.add(0, 5);
        
        // Validate the internal state of the IntList using public methods
        // Removed getFirstIndex() as it does not exist
        assertEquals(1, intList.size());
        assertEquals(5, intList.get(0));
    }

    @Test(timeout = 4000)
    public void testAddAtEnd() {
        IntList intList = new IntList(10);
        intList.add(0, 5);
        intList.add(1, 10);
        intList.add(2, 15);
        
        // Validate the internal state of the IntList using public methods
        assertEquals(3, intList.size());
        // Removed getFirstIndex() as it does not exist
        assertEquals(5, intList.get(0));
        assertEquals(10, intList.get(1));
        assertEquals(15, intList.get(2));
    }

    @Test(timeout = 4000)
    public void testAddThrowsIndexOutOfBoundsException() {
        IntList intList = new IntList(10);
        try {
            intList.add(5, 10); // This should throw an exception
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Exception is expected
        }
    }

}