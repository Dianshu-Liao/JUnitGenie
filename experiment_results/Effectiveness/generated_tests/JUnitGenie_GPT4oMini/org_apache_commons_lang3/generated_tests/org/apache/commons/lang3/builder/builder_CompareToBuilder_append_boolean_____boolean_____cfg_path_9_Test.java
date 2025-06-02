package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_CompareToBuilder_append_boolean_____boolean_____cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testAppendWithDifferentArrays() {
        CompareToBuilder builder = new CompareToBuilder();

        boolean[] lhs = new boolean[]{true, false};
        boolean[] rhs = new boolean[]{false, true};

        CompareToBuilder result = builder.append(lhs, rhs);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        CompareToBuilder builder = new CompareToBuilder();

        boolean[] lhs = new boolean[]{true, false};
        boolean[] rhs = lhs;

        CompareToBuilder result = builder.append(lhs, rhs);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullLhs() {
        CompareToBuilder builder = new CompareToBuilder();

        boolean[] lhs = null;
        boolean[] rhs = new boolean[]{true, false};

        CompareToBuilder result = builder.append(lhs, rhs);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullRhs() {
        CompareToBuilder builder = new CompareToBuilder();

        boolean[] lhs = new boolean[]{true, false};
        boolean[] rhs = null;

        CompareToBuilder result = builder.append(lhs, rhs);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengths() {
        CompareToBuilder builder = new CompareToBuilder();

        boolean[] lhs = new boolean[]{true};
        boolean[] rhs = new boolean[]{true, false};

        CompareToBuilder result = builder.append(lhs, rhs);
        assertNotNull(result);
    }

}