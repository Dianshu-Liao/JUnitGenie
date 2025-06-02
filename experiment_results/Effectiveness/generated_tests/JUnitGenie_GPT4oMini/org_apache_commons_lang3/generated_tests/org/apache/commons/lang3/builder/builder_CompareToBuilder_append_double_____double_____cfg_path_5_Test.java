package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class builder_CompareToBuilder_append_double_____double_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] array1 = {1.0, 2.0, 3.0};
        double[] array2 = {1.0, 2.0, 3.0};

        CompareToBuilder result = builder.append(array1, array2);

        assertEquals("The comparison should remain equal for identical arrays", 0, builder.toComparison());
        assertEquals("The result should be the same instance", builder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithFirstArrayNull() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] array1 = null;
        double[] array2 = {1.0, 2.0, 3.0};

        CompareToBuilder result = builder.append(array1, array2);

        assertEquals("The comparison should return -1 with first array as null", -1, builder.toComparison());
        assertEquals("The result should be the same instance", builder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithSecondArrayNull() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] array1 = {1.0, 2.0, 3.0};
        double[] array2 = null;

        CompareToBuilder result = builder.append(array1, array2);

        assertEquals("The comparison should return 1 with second array as null", 1, builder.toComparison());
        assertEquals("The result should be the same instance", builder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengths() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] array1 = {1.0, 2.0};
        double[] array2 = {1.0, 2.0, 3.0};

        CompareToBuilder result = builder.append(array1, array2);

        assertEquals("The comparison should return -1 with first array shorter", -1, builder.toComparison());
        assertEquals("The result should be the same instance", builder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentValues() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] array1 = {1.0, 2.0, 3.0};
        double[] array2 = {1.0, 2.0, 4.0};

        CompareToBuilder result = builder.append(array1, array2);

        // After comparing, the comparison should reflect the difference
        assertEquals("The comparison should not be equal for different arrays", -1, builder.toComparison());
        assertEquals("The result should be the same instance", builder, result);
    }


}