package org.joda.time.field;
import org.joda.time.field.PreciseDurationField;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class field_PreciseDurationField_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        PreciseDurationField field = new PreciseDurationField(DurationFieldType.seconds(), 1000);
        assertTrue(field.equals(field));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        PreciseDurationField field = new PreciseDurationField(DurationFieldType.seconds(), 1000);
        String notADurationField = "Not a PreciseDurationField";
        assertFalse(field.equals(notADurationField));
    }

    @Test(timeout = 4000)
    public void testEquals_Null() {
        PreciseDurationField field = new PreciseDurationField(DurationFieldType.seconds(), 1000);
        assertFalse(field.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentFields() {
        PreciseDurationField field1 = new PreciseDurationField(DurationFieldType.seconds(), 1000);
        PreciseDurationField field2 = new PreciseDurationField(DurationFieldType.seconds(), 2000);
        assertFalse(field1.equals(field2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameFields() {
        PreciseDurationField field1 = new PreciseDurationField(DurationFieldType.seconds(), 1000);
        PreciseDurationField field2 = new PreciseDurationField(DurationFieldType.seconds(), 1000);
        assertTrue(field1.equals(field2));
    }

}