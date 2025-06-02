package org.apache.commons.compress.harmony.unpack200;
import org.apache.commons.compress.harmony.unpack200.IcTuple;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class harmony_unpack200_IcTuple_predicted__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPredictedBothFalse() {
        // Arrange
        IcTuple icTuple = new IcTuple("test", 0, "test", "test", 0, 0, 0, 0);
        // Set private fields using reflection
        setPrivateField(icTuple, "predictOuter", false);
        setPrivateField(icTuple, "predictSimple", false);

        // Act
        boolean result = icTuple.predicted();

        // Assert
        assertFalse(result);
    }

    private void setPrivateField(IcTuple icTuple, String fieldName, boolean value) {
        try {
            java.lang.reflect.Field field = IcTuple.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(icTuple, value);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        }
    }

}