package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class harmony_pack200_IntList_growAtEnd_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGrowAtEnd() {
        try {
            // Create an instance of IntList
            IntList intList = new IntList();
            
            // Set up the private fields to create a specific state of the object
            // Accessing the private field 'array' using reflection
            java.lang.reflect.Field arrayField = IntList.class.getDeclaredField("array");
            arrayField.setAccessible(true);
            int[] testArray = new int[5]; // Initial size 5
            arrayField.set(intList, testArray);
            
            // Accessing the private field 'lastIndex' and setting it to 5
            java.lang.reflect.Field lastIndexField = IntList.class.getDeclaredField("lastIndex");
            lastIndexField.setAccessible(true);
            lastIndexField.set(intList, 5);
            
            // Accessing the private field 'firstIndex' and setting it to 0
            java.lang.reflect.Field firstIndexField = IntList.class.getDeclaredField("firstIndex");
            firstIndexField.setAccessible(true);
            firstIndexField.set(intList, 0);
            
            // Invoke the private method 'growAtEnd' using reflection with required parameter
            Method growAtEndMethod = IntList.class.getDeclaredMethod("growAtEnd", int.class);
            growAtEndMethod.setAccessible(true);
            growAtEndMethod.invoke(intList, 10); // Required size greater than current lastIndex
            
            // Verify the results after invoking the method
            int[] newArray = (int[]) arrayField.get(intList);
            assertEquals(10, newArray.length); // Check if the length is adjusted
            assertEquals(0, firstIndexField.get(intList)); // Check if firstIndex is reset
            assertEquals(5, lastIndexField.get(intList)); // Check the lastIndex
            
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions that might occur during reflection
        }
    }

}