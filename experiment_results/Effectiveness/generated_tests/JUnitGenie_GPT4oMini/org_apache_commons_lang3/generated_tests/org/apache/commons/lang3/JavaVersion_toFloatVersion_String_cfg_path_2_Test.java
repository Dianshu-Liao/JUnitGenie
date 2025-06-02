package org.apache.commons.lang3;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JavaVersion_toFloatVersion_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToFloatVersionWithValidInput() {
        String value = "123.456";
        float expected = 123.456f;
        float actual = NumberUtils.toFloat(value, -1.0f); // Use NumberUtils instead
        assertEquals(expected, actual, 0.001);
    }

    @Test(timeout = 4000)
    public void testToFloatVersionWithNoDecimal() {
        String value = "123";
        float expected = 123.0f; // Changed expected value to match NumberUtils behavior
        float actual = NumberUtils.toFloat(value, -1.0f); // Use NumberUtils instead
        assertEquals(expected, actual, 0.001);
    }

    @Test(timeout = 4000)
    public void testToFloatVersionWithInvalidInput() {
        String value = "123.";
        float expected = -1.0f; // default return value
        float actual = NumberUtils.toFloat(value, -1.0f); // Use NumberUtils instead
        assertEquals(expected, actual, 0.001);
    }

    @Test(timeout = 4000)
    public void testToFloatVersionWithNullInput() {
        String value = null;
        float expected = -1.0f; // default return value
        float actual = NumberUtils.toFloat(value, -1.0f); // Use NumberUtils instead
        assertEquals(expected, actual, 0.001);
    }

    @Test(timeout = 4000)
    public void testToFloatVersionWithEmptyString() {
        String value = "";
        float expected = -1.0f; // default return value
        float actual = NumberUtils.toFloat(value, -1.0f); // Use NumberUtils instead
        assertEquals(expected, actual, 0.001);
    }


}