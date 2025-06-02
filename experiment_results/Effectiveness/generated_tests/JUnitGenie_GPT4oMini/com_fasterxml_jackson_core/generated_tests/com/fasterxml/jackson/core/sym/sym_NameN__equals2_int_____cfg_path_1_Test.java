package com.fasterxml.jackson.core.sym;
import com.fasterxml.jackson.core.sym.NameN;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class sym_NameN__equals2_int_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEquals2() {
        try {
            // Create an instance of NameN
            NameN nameN = new NameN("test", 1, 2, 3, 4, 5, new int[]{1, 2, 3, 4, 5, 6}, 7);
            
            // Access the private method _equals2 using reflection
            Method method = NameN.class.getDeclaredMethod("_equals2", int[].class);
            method.setAccessible(true);
            
            // Prepare test cases
            int[] quadsMatching = {1, 2, 3, 4, 5, 6}; // This should match the internal array q
            int[] quadsNotMatching = {1, 2, 3, 0, 5, 6}; // This should not match
            
            // Invoke the method and assert the results
            boolean resultMatching = (boolean) method.invoke(nameN, quadsMatching);
            assertTrue(resultMatching);
            
            boolean resultNotMatching = (boolean) method.invoke(nameN, quadsNotMatching);
            assertFalse(resultNotMatching);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}