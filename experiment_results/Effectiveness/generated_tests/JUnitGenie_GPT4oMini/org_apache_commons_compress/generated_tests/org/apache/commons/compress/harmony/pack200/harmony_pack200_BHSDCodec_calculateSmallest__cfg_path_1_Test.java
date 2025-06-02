package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.BHSDCodec;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class harmony_pack200_BHSDCodec_calculateSmallest__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCalculateSmallestWhenDIsOneAndCardinalityIsGreaterThanOrEqualTo4294967296() {
        try {
            // Arrange
            BHSDCodec codec = new BHSDCodec(1, 0); // d = 1
            // Use reflection to set the private field 'cardinality'
            java.lang.reflect.Field cardinalityField = BHSDCodec.class.getDeclaredField("cardinality");
            cardinalityField.setAccessible(true);
            cardinalityField.set(codec, 4294967296L); // cardinality >= 4294967296

            // Act
            Method method = BHSDCodec.class.getDeclaredMethod("calculateSmallest");
            method.setAccessible(true);
            long result = (long) method.invoke(codec);

            // Assert
            assertEquals(Integer.MIN_VALUE, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCalculateSmallestWhenDIsOneAndCardinalityIsLessThan4294967296() {
        try {
            // Arrange
            BHSDCodec codec = new BHSDCodec(1, 0); // d = 1
            // Use reflection to set the private field 'cardinality'
            java.lang.reflect.Field cardinalityField = BHSDCodec.class.getDeclaredField("cardinality");
            cardinalityField.setAccessible(true);
            cardinalityField.set(codec, 1000L); // cardinality < 4294967296

            // Act
            Method method = BHSDCodec.class.getDeclaredMethod("calculateSmallest");
            method.setAccessible(true);
            long result = (long) method.invoke(codec);

            // Assert
            assertEquals(0, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}