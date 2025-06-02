package org.joda.time.field;
import org.joda.time.field.PreciseDurationField;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class field_PreciseDurationField_equals_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEquals_WithDifferentObjectType_ReturnsFalse() {
        PreciseDurationField field = new PreciseDurationField(DurationFieldType.minutes(), 60000L);
        Object otherObject = new Object(); // Different type
        try {
            boolean result = field.equals(otherObject);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testEquals_WithSameObject_ReturnsTrue() {
        PreciseDurationField field = new PreciseDurationField(DurationFieldType.minutes(), 60000L);
        try {
            boolean result = field.equals(field); // Same instance
            assertFalse(!result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testEquals_WithNullObject_ReturnsFalse() {
        PreciseDurationField field = new PreciseDurationField(DurationFieldType.minutes(), 60000L);
        try {
            boolean result = field.equals(null); // Null check
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testEquals_WithDifferentPreciseDurationField_ReturnsFalse() {
        PreciseDurationField field1 = new PreciseDurationField(DurationFieldType.minutes(), 60000L);
        PreciseDurationField field2 = new PreciseDurationField(DurationFieldType.seconds(), 60000L); // Different type
        try {
            boolean result = field1.equals(field2);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testEquals_WithSamePreciseDurationField_ReturnsTrue() {
        PreciseDurationField field1 = new PreciseDurationField(DurationFieldType.minutes(), 60000L);
        PreciseDurationField field2 = new PreciseDurationField(DurationFieldType.minutes(), 60000L); // Same type and value
        try {
            boolean result = field1.equals(field2);
            assertFalse(!result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}