package com.fasterxml.jackson.core.sym;
import com.fasterxml.jackson.core.sym.Name2;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class sym_Name2_equals_int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEqualsWithDifferentQuad1() {
        Name2 name2 = new Name2("test", 1, 2, 3);
        int quad1 = 0; // Different from q1
        int quad2 = 2; // Same as q2
        try {
            boolean result = name2.equals(quad1, quad2);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentQuad2() {
        Name2 name2 = new Name2("test", 1, 2, 3);
        int quad1 = 1; // Same as q1
        int quad2 = 0; // Different from q2
        try {
            boolean result = name2.equals(quad1, quad2);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithBothDifferent() {
        Name2 name2 = new Name2("test", 1, 2, 3);
        int quad1 = 0; // Different from q1
        int quad2 = 0; // Different from q2
        try {
            boolean result = name2.equals(quad1, quad2);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithBothSame() {
        Name2 name2 = new Name2("test", 1, 2, 3);
        int quad1 = 1; // Same as q1
        int quad2 = 2; // Same as q2
        try {
            boolean result = name2.equals(quad1, quad2);
            assertFalse(!result); // Should return true
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}