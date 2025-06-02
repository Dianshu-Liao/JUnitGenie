package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class harmony_pack200_IntList_growAtEnd_int_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testGrowAtEnd() {
        try {
            // Create an instance of IntList
            IntList intList = new IntList(10); // using a constructor with an initial capacity

            // Set required size to trigger the array growth
            int required = 15;

            // Access the private method growAtEnd using reflection
            Method method = IntList.class.getDeclaredMethod("growAtEnd", int.class);
            method.setAccessible(true); // allow access to the private method

            // Invoke the private method
            method.invoke(intList, required);

            // Assert conditions after growAtEnd is called
            assertNotNull("Array should be resized", getArray(intList));
            assertTrue("Array length should be greater than or equal to 15", getArray(intList).length >= 15);
            assertEquals("First index should be reset to 0", 0, getFirstIndex(intList));
            assertEquals("Last index should be updated correctly", 0, getLastIndex(intList)); // adjust based on actual expected condition
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("An exception occurred during the test: " + e.getMessage());
        }
    }

    // Helper methods to access private fields
    private int[] getArray(IntList intList) throws Exception {
        Method method = IntList.class.getDeclaredMethod("getArray");
        method.setAccessible(true);
        return (int[]) method.invoke(intList);
    }

    private int getFirstIndex(IntList intList) throws Exception {
        Method method = IntList.class.getDeclaredMethod("getFirstIndex");
        method.setAccessible(true);
        return (int) method.invoke(intList);
    }

    private int getLastIndex(IntList intList) throws Exception {
        Method method = IntList.class.getDeclaredMethod("getLastIndex");
        method.setAccessible(true);
        return (int) method.invoke(intList);
    }

}