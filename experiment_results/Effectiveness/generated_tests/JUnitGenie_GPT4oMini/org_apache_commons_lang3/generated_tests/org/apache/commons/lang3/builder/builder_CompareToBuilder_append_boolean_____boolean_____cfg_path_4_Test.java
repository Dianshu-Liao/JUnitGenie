package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class builder_CompareToBuilder_append_boolean_____boolean_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        CompareToBuilder builder = new CompareToBuilder();
        boolean[] lhs = {true, false, true};
        boolean[] rhs = {true, false, true};
        
        builder.append(lhs, rhs);
        
        assertEquals(0, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengthArrays() {
        CompareToBuilder builder = new CompareToBuilder();
        boolean[] lhs = {true, false};
        boolean[] rhs = {true, false, true};
        
        builder.append(lhs, rhs);
        
        assertEquals(-1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithNullLhs() {
        CompareToBuilder builder = new CompareToBuilder();
        boolean[] lhs = null;
        boolean[] rhs = {true, false};
        
        builder.append(lhs, rhs);
        
        assertEquals(-1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithNullRhs() {
        CompareToBuilder builder = new CompareToBuilder();
        boolean[] lhs = {true, false};
        boolean[] rhs = null;
        
        builder.append(lhs, rhs);
        
        assertEquals(1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentElements() {
        CompareToBuilder builder = new CompareToBuilder();
        boolean[] lhs = {true, false, true};
        boolean[] rhs = {false, true, false};
        
        builder.append(lhs, rhs);
        
        assertEquals(-1, builder.toComparison()); // First element comparison should determine the result
    }


}