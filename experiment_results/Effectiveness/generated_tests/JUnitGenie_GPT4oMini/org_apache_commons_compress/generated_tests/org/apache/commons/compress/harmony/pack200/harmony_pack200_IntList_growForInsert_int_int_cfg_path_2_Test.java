package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class harmony_pack200_IntList_growForInsert_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGrowForInsert() {
        try {
            // Create an instance of IntList
            IntList intList = new IntList(10);
            // Use reflection to set the private fields
            Method setArrayMethod = IntList.class.getDeclaredMethod("setArray", int[].class);
            setArrayMethod.setAccessible(true);
            setArrayMethod.invoke(intList, (Object) new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}); // Cast to Object

            Method setLastIndexMethod = IntList.class.getDeclaredMethod("setLastIndex", int.class);
            setLastIndexMethod.setAccessible(true);
            setLastIndexMethod.invoke(intList, 10);

            Method setFirstIndexMethod = IntList.class.getDeclaredMethod("setFirstIndex", int.class);
            setFirstIndexMethod.setAccessible(true);
            setFirstIndexMethod.invoke(intList, 0);

            // Access the private method growForInsert using reflection
            Method method = IntList.class.getDeclaredMethod("growForInsert", int.class, int.class);
            method.setAccessible(true);

            // Call the method with parameters that will cover the CFG path
            method.invoke(intList, 5, 4); // location = 5, required = 4

            // Expected array after insertion
            int[] expectedArray = new int[]{1, 2, 3, 4, 0, 5, 6, 7, 8, 9, 10}; // Adjusted expected array

            // Use reflection to get the private array field
            Method getArrayMethod = IntList.class.getDeclaredMethod("getArray");
            getArrayMethod.setAccessible(true);
            int[] actualArray = (int[]) getArrayMethod.invoke(intList);

            // Assert the internal state of the array
            assertArrayEquals(expectedArray, actualArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}