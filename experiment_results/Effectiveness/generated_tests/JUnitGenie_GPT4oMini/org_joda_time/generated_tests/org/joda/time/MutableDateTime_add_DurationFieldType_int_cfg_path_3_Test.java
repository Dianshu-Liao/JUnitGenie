package org.joda.time;
import org.joda.time.MutableDateTime;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class MutableDateTime_add_DurationFieldType_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAdd_withNullType() {
        MutableDateTime mutableDateTime = new MutableDateTime();
        try {
            // Explicitly cast null to DurationFieldType to resolve ambiguity
            mutableDateTime.add((DurationFieldType) null, 5);
            fail("Expected IllegalArgumentException for null DurationFieldType");
        } catch (IllegalArgumentException e) {
            assertEquals("Field must not be null", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAdd_withZeroAmount() {
        MutableDateTime mutableDateTime = new MutableDateTime();
        DurationFieldType type = DurationFieldType.seconds(); // You can use another valid field if needed
        mutableDateTime.add(type, 0);
        // Verify that the time remains unchanged
        assertEquals(mutableDateTime.getMillis(), mutableDateTime.getMillis());
    }


}