package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_IntList_add_int_int_cfg_path_6_Test {

    private IntList intList;

    @Before
    public void setUp() {
        intList = new IntList();
    }

    @Test(timeout = 4000)
    public void testAddWithLocationInBounds() {
        // Initializes the internal state
        intList.add(0, 1); // Adding at the beginning
        intList.add(1, 2); // Adding at location 1
        assertEquals(1, getValueAtIndex(0)); // Check value at index 0
        assertEquals(2, getValueAtIndex(1)); // Check value at index 1
    }

    @Test(timeout = 4000)
    public void testAddAtFront() {
        intList.add(0, 1); // Adding at the beginning
        intList.add(0, 0); // Adding another element at the front
        assertEquals(0, getValueAtIndex(0)); // Check value at index 0
        assertEquals(1, getValueAtIndex(1)); // Check value at index 1
    }

    @Test(timeout = 4000)
    public void testAddAtEnd() {
        intList.add(0, 1); // Adding at the beginning
        intList.add(1, 2); // Adding at the end
        assertEquals(1, getValueAtIndex(0)); // Check value at index 0
        assertEquals(2, getValueAtIndex(1)); // Check value at index 1
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddOutOfBoundsNegative() {
        intList.add(-1, 0); // Should throw IndexOutOfBoundsException
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddOutOfBoundsExceedingSize() {
        intList.add(1, 0); // Should throw IndexOutOfBoundsException
    }

    private int getValueAtIndex(int index) {
        // Access private variable `array` through reflection
        try {
            java.lang.reflect.Field field = IntList.class.getDeclaredField("array");
            field.setAccessible(true);
            int[] array = (int[]) field.get(intList);
            return array[index];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // Return -1 in case of failure
    }

}