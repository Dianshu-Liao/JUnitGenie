package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.ConstantTransformer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class functors_ConstantTransformer_hashCode__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHashCodeWithNonNullConstant() {
        // Arrange
        Object constantValue = new Object(); // Non-null constant
        ConstantTransformer transformer = new ConstantTransformer(constantValue);

        // Act
        int result = transformer.hashCode();

        // Assert
        int expected = ("ConstantTransformer".hashCode() << 2) | constantValue.hashCode();
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testHashCodeWithNullConstant() {
        // Arrange
        ConstantTransformer transformer = new ConstantTransformer(null);

        // Act
        int result = transformer.hashCode();

        // Assert
        int expected = "ConstantTransformer".hashCode() << 2;
        assertEquals(expected, result);
    }

}