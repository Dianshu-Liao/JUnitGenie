package org.apache.commons.lang3.time;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.commons.lang3.time.FastDatePrinter;
import org.junit.Test;
import static org.junit.Assert.*;

public class time_FastDateFormat_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEqualsWithSamePrinter() {
        // Arrange
        FastDatePrinter printer = new FastDatePrinter("yyyy-MM-dd", java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        FastDateFormat format1 = new FastDateFormat("yyyy-MM-dd", java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        FastDateFormat format2 = new FastDateFormat("yyyy-MM-dd", java.util.TimeZone.getDefault(), java.util.Locale.getDefault()); // Same format

        // Act & Assert
        assertTrue(format1.equals(format2));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentInstances() {
        // Arrange
        FastDateFormat format1 = new FastDateFormat("yyyy-MM-dd", java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        FastDateFormat format2 = new FastDateFormat("dd/MM/yyyy", java.util.TimeZone.getDefault(), java.util.Locale.getDefault()); // Different format

        // Act & Assert
        assertFalse(format1.equals(format2));
    }

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        // Arrange
        FastDateFormat format = new FastDateFormat("yyyy-MM-dd", java.util.TimeZone.getDefault(), java.util.Locale.getDefault());

        // Act & Assert
        assertFalse(format.equals(null));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentType() {
        // Arrange
        FastDateFormat format = new FastDateFormat("yyyy-MM-dd", java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        String notADateFormat = "not a FastDateFormat";

        // Act & Assert
        assertFalse(format.equals(notADateFormat));
    }


}