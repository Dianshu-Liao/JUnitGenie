package com.fasterxml.jackson.core.sym;
import com.fasterxml.jackson.core.sym.Name2;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class sym_Name2_equals_int_____int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEqualsWithMatchingValues() {
        Name2 name2 = new Name2("test", 1, 2, 3);
        int[] quads = {1, 2};
        int qlen = 2;
        assertTrue(name2.equals(quads, qlen));
    }

    @Test(timeout = 4000)
    public void testEqualsWithNonMatchingFirstValue() {
        Name2 name2 = new Name2("test", 1, 2, 3);
        int[] quads = {3, 2};
        int qlen = 2;
        assertFalse(name2.equals(quads, qlen));
    }

    @Test(timeout = 4000)
    public void testEqualsWithNonMatchingSecondValue() {
        Name2 name2 = new Name2("test", 1, 2, 3);
        int[] quads = {1, 3};
        int qlen = 2;
        assertFalse(name2.equals(quads, qlen));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentLength() {
        Name2 name2 = new Name2("test", 1, 2, 3);
        int[] quads = {1};
        int qlen = 1;
        assertFalse(name2.equals(quads, qlen));
    }

}