package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.IntList;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class harmony_pack200_IntList_growAtEnd_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGrowAtEnd() {
        try {
            // Create an instance of IntList
            IntList intList = new IntList(10);
            // Use reflection to set the private fields
            Method setFirstIndex = IntList.class.getDeclaredMethod("setFirstIndex", int.class);
            setFirstIndex.setAccessible(true);
            setFirstIndex.invoke(intList, 0);

            Method setLastIndex = IntList.class.getDeclaredMethod("setLastIndex", int.class);
            setLastIndex.setAccessible(true);
            setLastIndex.invoke(intList, 5);

            Method setArray = IntList.class.getDeclaredMethod("setArray", int[].class);
            setArray.setAccessible(true);
            setArray.invoke(intList, (Object) new int[]{1, 2, 3, 4, 5, 0, 0, 0, 0, 0}); // Cast to Object

            // Access the private method growAtEnd using reflection
            Method method = IntList.class.getDeclaredMethod("growAtEnd", int.class);
            method.setAccessible(true);

            // Invoke the method with a required size
            method.invoke(intList, 8);

            // Expected array after growing
            int[] expectedArray = new int[]{1, 2, 3, 4, 5, 0, 0, 0, 0, 0}; // Adjust based on expected behavior
            Method getArray = IntList.class.getDeclaredMethod("getArray");
            getArray.setAccessible(true);
            int[] actualArray = (int[]) getArray.invoke(intList);

            assertArrayEquals(expectedArray, actualArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}