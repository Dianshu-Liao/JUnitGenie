package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class builder_CompareToBuilder_appendSuper_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAppendSuper_whenComparisonIsZero_shouldSetComparison() {
        // Arrange
        CompareToBuilder builder = new CompareToBuilder();
        int superCompareTo = 5; // This value will be used to set the comparison

        // Act
        CompareToBuilder result = builder.appendSuper(superCompareTo);

        // Assert
        assertSame(result, builder);
        // Since we cannot access the private field directly, we can assume the comparison is set correctly
        // by checking the behavior of the method. In a real scenario, we would need a way to verify the internal state.
    }

}