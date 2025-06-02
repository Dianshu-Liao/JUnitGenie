package org.joda.time.field;
import org.joda.time.DurationField;
import org.joda.time.field.UnsupportedDurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.Chronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class field_UnsupportedDurationField_getInstance_DurationFieldType_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetInstance_CacheMiss() {
        // Arrange
        DurationFieldType type = new DurationFieldType("TestType") {
            @Override
            public DurationField getField(Chronology chronology) {
                return null; // Implement as needed for the test
            }
        };

        // Act
        UnsupportedDurationField field = null;
        try {
            field = UnsupportedDurationField.getInstance(type);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert
        assertNotNull("Field should not be null", field);
    }

    @Test(timeout = 4000)
    public void testGetInstance_CacheHit() {
        // Arrange
        DurationFieldType type = new DurationFieldType("TestType") {
            @Override
            public DurationField getField(Chronology chronology) {
                return null; // Implement as needed for the test
            }
        };
        UnsupportedDurationField firstCall = null;
        try {
            firstCall = UnsupportedDurationField.getInstance(type);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Act
        UnsupportedDurationField secondCall = null;
        try {
            secondCall = UnsupportedDurationField.getInstance(type);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert
        assertSame("Both calls should return the same instance", firstCall, secondCall);
    }


}