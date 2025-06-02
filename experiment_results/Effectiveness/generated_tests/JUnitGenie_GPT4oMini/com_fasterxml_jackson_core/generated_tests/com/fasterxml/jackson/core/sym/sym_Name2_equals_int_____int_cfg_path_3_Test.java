package com.fasterxml.jackson.core.sym;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import com.fasterxml.jackson.core.sym.Name2;

public class sym_Name2_equals_int_____int_cfg_path_3_Test {
    private Name2 name2Instance;

    @Before
    public void setUp() {
        // Example values for q1 and q2, assuming they're initialized to some integers
        name2Instance = new Name2("test", 1, 2, 0); 
    }

    @Test(timeout = 4000)
    public void testEquals_WithValidArray_ReturnsTrue() {
        int[] quads = {1, 2}; // Values matching q1 and q2
        int qlen = 2;
        assertTrue(name2Instance.equals(quads, qlen));
    }

    @Test(timeout = 4000)
    public void testEquals_WithInvalidArrayLength_ReturnsFalse() {
        int[] quads = {1}; // Length not matching qlen
        int qlen = 1;
        assertFalse(name2Instance.equals(quads, qlen));
    }

    @Test(timeout = 4000)
    public void testEquals_WithMismatchedValues_ReturnsFalse() {
        int[] quads = {3, 4}; // Values not matching q1 and q2
        int qlen = 2;
        assertFalse(name2Instance.equals(quads, qlen));
    }

    @Test(timeout = 4000)
    public void testEquals_WithNullArray_ReturnsFalse() {
        int[] quads = null; // Passing null to check how equals handles it
        int qlen = 2;
        try {
            assertFalse(name2Instance.equals(quads, qlen));
        } catch (NullPointerException e) {
            // Handle the potential exception if it occurs
        }
    }

}