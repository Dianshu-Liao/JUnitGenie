package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_CompareToBuilder_append_double_____double_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = {1.0, 2.0, 3.0};
        
        CompareToBuilder result = builder.append(lhs, rhs);
        assertSame(builder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullLhs() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = null;
        double[] rhs = {1.0, 2.0, 3.0};
        
        CompareToBuilder result = builder.append(lhs, rhs);
        assertSame(builder, result);
        assertEquals(-1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithNullRhs() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = null;
        
        CompareToBuilder result = builder.append(lhs, rhs);
        assertSame(builder, result);
        assertEquals(1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengths() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = {1.0, 2.0, 3.0};
        
        CompareToBuilder result = builder.append(lhs, rhs);
        assertSame(builder, result);
        assertEquals(-1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentValues() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = {1.0, 2.0, 4.0};
        
        CompareToBuilder result = builder.append(lhs, rhs);
        assertSame(builder, result);
        // The comparison should be 0 until the last element
        assertEquals(0, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithEmptyArrays() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {};
        double[] rhs = {};
        
        CompareToBuilder result = builder.append(lhs, rhs);
        assertSame(builder, result);
        assertEquals(0, builder.toComparison());
    }


}