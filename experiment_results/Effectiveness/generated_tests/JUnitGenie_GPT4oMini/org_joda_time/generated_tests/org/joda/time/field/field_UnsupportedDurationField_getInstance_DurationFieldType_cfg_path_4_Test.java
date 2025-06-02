package org.joda.time.field;
import org.joda.time.field.UnsupportedDurationField;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class field_UnsupportedDurationField_getInstance_DurationFieldType_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetInstance_CacheIsNull() {
        // Clear the cache before the test
        clearCache();

        // Create a concrete implementation of DurationFieldType
        DurationFieldType type = createMockDurationFieldType("mockType");

        // Call the focal method
        UnsupportedDurationField field = UnsupportedDurationField.getInstance(type);

        // Verify that the field is not null
        assertNotNull(field);
    }

    @Test(timeout = 4000)
    public void testGetInstance_CacheIsNotNull() {
        // Create a concrete implementation of DurationFieldType
        DurationFieldType type = createMockDurationFieldType("mockType");

        // First call to populate the cache
        UnsupportedDurationField firstCall = UnsupportedDurationField.getInstance(type);

        // Second call to retrieve from cache
        UnsupportedDurationField secondCall = UnsupportedDurationField.getInstance(type);

        // Verify that both calls return the same instance
        assertSame(firstCall, secondCall);
    }

    private void clearCache() {
        try {
            java.lang.reflect.Field cacheField = UnsupportedDurationField.class.getDeclaredField("cCache");
            cacheField.setAccessible(true);
            cacheField.set(null, null); // Set the cache to null
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private DurationFieldType createMockDurationFieldType(String name) {
        try {
            java.lang.reflect.Constructor<DurationFieldType> constructor = DurationFieldType.class.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            return constructor.newInstance(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}