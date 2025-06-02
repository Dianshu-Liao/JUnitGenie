package com.fasterxml.jackson.core.sym;
import org.junit.Test;
import static org.junit.Assert.*;
import com.fasterxml.jackson.core.sym.Name2;

public class sym_Name2_equals_int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEquals_whenQuad1AndQuad2Match_shouldReturnTrue() {
        Name2 name = new Name2("test", 1, 1, 1);
        // Assuming q1 and q2 are initialized in the constructor
        // The initial values of q1 and q2 are set to 1
        assertTrue(name.equals(1, 1));
    }

    @Test(timeout = 4000)
    public void testEquals_whenQuad1DoesNotMatch_shouldReturnFalse() {
        Name2 name = new Name2("test", 1, 1, 1);
        // The initial values of q1 and q2 are set to 1
        assertFalse(name.equals(2, 1));
    }

    @Test(timeout = 4000)
    public void testEquals_whenQuad2DoesNotMatch_shouldReturnFalse() {
        Name2 name = new Name2("test", 1, 1, 1);
        // The initial values of q1 and q2 are set to 1
        assertFalse(name.equals(1, 2));
    }

    @Test(timeout = 4000)
    public void testEquals_whenQuad1AndQuad2DoNotMatch_shouldReturnFalse() {
        Name2 name = new Name2("test", 1, 1, 1);
        // The initial values of q1 and q2 are set to 1
        assertFalse(name.equals(2, 3));
    }

}