package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_IntList_add_int_int_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testAddWithinBounds() {
        IntList intList = new IntList(5);
        intList.add(0, 10);
        intList.add(1, 20);
        intList.add(2, 30);
        
        assertEquals(10, intList.get(0));
        assertEquals(20, intList.get(1));
        assertEquals(30, intList.get(2));
    }

    @Test(timeout = 4000)
    public void testAddAtBeginning() {
        IntList intList = new IntList(5);
        intList.add(0, 10);
        
        assertEquals(10, intList.get(0));
    }

    @Test(timeout = 4000)
    public void testAddAtEnd() {
        IntList intList = new IntList(5);
        intList.add(0, 10);
        intList.add(1, 20);
        
        intList.add(2, 30);
        assertEquals(30, intList.get(2));
    }

    @Test(timeout = 4000)
    public void testAddThrowsIndexOutOfBoundsException() {
        IntList intList = new IntList(5);
        try {
            intList.add(10, 100); // This should throw an exception
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // Exception is expected
        }
    }


}