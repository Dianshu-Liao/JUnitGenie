package org.joda.time.field;
import org.joda.time.field.PreciseDurationField;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class field_PreciseDurationField_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEqualsWithDifferentObjectType() {
        PreciseDurationField field1 = new PreciseDurationField(DurationFieldType.seconds(), 1000);
        Object differentObject = new Object(); // Different type

        try {
            // This should return false as the object is of a different type
            assertFalse(field1.equals(differentObject));
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameObject() {
        PreciseDurationField field1 = new PreciseDurationField(DurationFieldType.seconds(), 1000);

        try {
            // This should return true as it is the same object
            assertTrue(field1.equals(field1));
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithEqualFields() {
        PreciseDurationField field1 = new PreciseDurationField(DurationFieldType.seconds(), 1000);
        PreciseDurationField field2 = new PreciseDurationField(DurationFieldType.seconds(), 1000);

        try {
            // This should return true as both fields are equal
            assertTrue(field1.equals(field2));
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentFields() {
        PreciseDurationField field1 = new PreciseDurationField(DurationFieldType.seconds(), 1000);
        PreciseDurationField field2 = new PreciseDurationField(DurationFieldType.minutes(), 1000);

        try {
            // This should return false as the fields are different
            assertFalse(field1.equals(field2));
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }


}