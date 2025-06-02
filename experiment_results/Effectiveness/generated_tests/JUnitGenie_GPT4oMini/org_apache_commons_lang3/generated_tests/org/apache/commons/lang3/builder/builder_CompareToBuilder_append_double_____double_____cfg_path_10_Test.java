package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_CompareToBuilder_append_double_____double_____cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testAppendBothArraysAreNull() {
        CompareToBuilder compareToBuilder = new CompareToBuilder();
        double[] lhs = null;
        double[] rhs = null;

        CompareToBuilder result = compareToBuilder.append(lhs, rhs);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendLeftArrayIsNull() {
        CompareToBuilder compareToBuilder = new CompareToBuilder();
        double[] lhs = null;
        double[] rhs = {1.0, 2.0};

        CompareToBuilder result = compareToBuilder.append(lhs, rhs);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendRightArrayIsNull() {
        CompareToBuilder compareToBuilder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = null;

        CompareToBuilder result = compareToBuilder.append(lhs, rhs);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendArraysOfDifferentLengths() {
        CompareToBuilder compareToBuilder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = {1.0};

        CompareToBuilder result = compareToBuilder.append(lhs, rhs);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendEqualArrays() {
        CompareToBuilder compareToBuilder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = {1.0, 2.0};

        CompareToBuilder result = compareToBuilder.append(lhs, rhs);
        assertNotNull(result);
    }

}