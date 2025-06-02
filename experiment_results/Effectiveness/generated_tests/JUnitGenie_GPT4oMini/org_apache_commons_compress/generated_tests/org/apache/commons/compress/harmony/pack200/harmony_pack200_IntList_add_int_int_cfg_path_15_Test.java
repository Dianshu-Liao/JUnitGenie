package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_IntList_add_int_int_cfg_path_15_Test {
    private IntList intList;

    @Before
    public void setUp() {
        intList = new IntList();
    }

    @Test(timeout = 4000)
    public void testAddWithinBounds() {
        try {
            intList.add(0, 5); // Adding at location 0
            intList.add(1, 10); // Adding at location 1
            assertEquals(5, intList.get(0)); // Test first element using getter
            assertEquals(10, intList.get(1)); // Test second element using getter
            assertEquals(2, intList.size()); // Check size using getter
        } catch (IndexOutOfBoundsException e) {
            fail("Should not throw IndexOutOfBoundsException for valid location");
        }
    }

    @Test(timeout = 4000)
    public void testAddAtSize() {
        try {
            intList.add(0, 15); // Adding at location 0
            intList.add(1, 20); // Adding at location 1
            intList.add(2, 25); // Adding at location 2, matches size (2)
            assertEquals(15, intList.get(0)); // Test first element using getter
            assertEquals(20, intList.get(1)); // Test second element using getter
            assertEquals(25, intList.get(2)); // Test third element using getter
            assertEquals(3, intList.size()); // Check size using getter
        } catch (IndexOutOfBoundsException e) {
            fail("Should not throw IndexOutOfBoundsException for valid location");
        }
    }

    @Test(timeout = 4000)
    public void testAddBeyondBounds() {
        try {
            intList.add(5, 30); // Out of bounds
            fail("Expected IndexOutOfBoundsException"); // Should throw exception
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testAddAtNegativeLocation() {
        try {
            intList.add(-1, 40); // Negative location
            fail("Expected IndexOutOfBoundsException"); // Should throw exception
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

}