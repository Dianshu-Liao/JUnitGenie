package org.joda.time;
import org.joda.time.Partial;
import org.joda.time.ReadableInstant;
import org.joda.time.DateTimeFieldType;
import org.joda.time.Chronology;
import org.joda.time.Instant;
import org.joda.time.DateTimeUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class Partial_isMatch_ReadableInstant_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsMatch() {
        // Create a ReadableInstant instance using the current time
        ReadableInstant instant = new Instant(); // Use the current instant

        // Create a Partial instance with matching iTypes and iValues
        DateTimeFieldType[] iTypes = new DateTimeFieldType[] {
            DateTimeFieldType.year(),
            DateTimeFieldType.monthOfYear(),
            DateTimeFieldType.dayOfMonth()
        };
        int[] iValues = new int[] { 2023, 1, 1 };

        Partial partial = new Partial(iTypes, iValues);

        // Test the isMatch method
        boolean result = partial.isMatch(instant);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsMatchWithNonMatchingValues() {
        // Create a ReadableInstant instance using the current time
        ReadableInstant instant = new Instant(); // Use the current instant

        // Create a Partial instance with non-matching iTypes and iValues
        DateTimeFieldType[] iTypes = new DateTimeFieldType[] {
            DateTimeFieldType.year(),
            DateTimeFieldType.monthOfYear(),
            DateTimeFieldType.dayOfMonth()
        };
        int[] iValues = new int[] { 2022, 2, 2 }; // Non-matching values

        Partial partial = new Partial(iTypes, iValues);

        // Test the isMatch method
        boolean result = partial.isMatch(instant);
        assertFalse(result);
    }


}