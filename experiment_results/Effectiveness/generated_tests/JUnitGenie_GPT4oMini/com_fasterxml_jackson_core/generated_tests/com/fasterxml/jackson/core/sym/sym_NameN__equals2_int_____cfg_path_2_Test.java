package com.fasterxml.jackson.core.sym;
import com.fasterxml.jackson.core.sym.NameN;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;

public class sym_NameN__equals2_int_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEquals2() {
        try {
            // Create an instance of NameN using the constructor
            NameN nameN = new NameN("test", 1, 2, 3, 4, 5, new int[]{1, 2, 3, 4, 5, 6}, 7);
            
            // Access the private method _equals2 using reflection
            Method method = NameN.class.getDeclaredMethod("_equals2", int[].class);
            method.setAccessible(true);
            
            // Prepare the input for the method
            int[] quads = new int[]{5, 6, 7, 8, 1, 2, 3, 4}; // This should match the internal array q
            
            // Invoke the method and assert the result
            boolean result = (boolean) method.invoke(nameN, (Object) quads);
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}