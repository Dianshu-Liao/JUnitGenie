package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class harmony_pack200_IntList_growAtEnd_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGrowAtEnd() {
        try {
            // Create an instance of IntList
            IntList intList = new IntList(10);
            // Use the public method to initialize the internal state of the IntList object
            intList.add(1);
            intList.add(2);
            intList.add(3);
            intList.add(4);
            intList.add(5);

            // Access the private method growAtEnd using reflection
            Method method = IntList.class.getDeclaredMethod("growAtEnd", int.class);
            method.setAccessible(true);

            // Call the method with a required size
            method.invoke(intList, 20); // Assuming we want to grow the capacity to 20

            // Verify the internal state after the method call using public methods
            assertEquals(5, intList.size()); // Assuming size() method returns the number of elements
            assertEquals(4, intList.size() - 1); // Corrected to use size() - 1 for last index
            assertEquals(20, intList.size()); // Assuming size() method returns the new capacity after growth

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}