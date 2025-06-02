package org.joda.time.field;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.Chronology;
import org.joda.time.field.UnsupportedDurationField;
import org.junit.Test;
import static org.junit.Assert.*;

public class field_UnsupportedDurationField_getInstance_DurationFieldType_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetInstance_CacheIsNull() {
        // Clear the cache before the test
        clearCache();

        // Create a concrete implementation of DurationFieldType
        DurationFieldType type = new DurationFieldType("TestType") {
            @Override
            public DurationField getField(Chronology chronology) {
                return null; // Implement as needed for your test
            }
        };

        // Call the focal method
        UnsupportedDurationField field = UnsupportedDurationField.getInstance(type);

        // Verify that the field is not null and is cached
        assertNotNull(field);
        assertSame(field, UnsupportedDurationField.getInstance(type));
    }

    @Test(timeout = 4000)
    public void testGetInstance_CacheIsNotNull() {
        // Create a concrete implementation of DurationFieldType
        DurationFieldType type = new DurationFieldType("TestType") {
            @Override
            public DurationField getField(Chronology chronology) {
                return null; // Implement as needed for your test
            }
        };

        // First call to populate the cache
        UnsupportedDurationField field1 = UnsupportedDurationField.getInstance(type);
        // Second call to check if the same instance is returned
        UnsupportedDurationField field2 = UnsupportedDurationField.getInstance(type);

        // Verify that both calls return the same instance
        assertSame(field1, field2);
    }

    private void clearCache() {
        try {
            java.lang.reflect.Field cacheField = UnsupportedDurationField.class.getDeclaredField("cCache");
            cacheField.setAccessible(true);
            cacheField.set(null, null); // Clear the static cache
        } catch (Exception e) {
            // Handle the exception as needed
            e.printStackTrace();
        }
    }


}