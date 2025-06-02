package org.joda.time.field;
import org.joda.time.field.UnsupportedDurationField;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class field_UnsupportedDurationField_getInstance_DurationFieldType_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetInstance_CacheHit() {
        try {
            // Create a concrete implementation of DurationFieldType
            DurationFieldType type = (DurationFieldType) java.lang.reflect.Proxy.newProxyInstance(
                DurationFieldType.class.getClassLoader(),
                new Class<?>[]{DurationFieldType.class},
                (proxy, method, args) -> {
                    if ("getField".equals(method.getName())) {
                        return null; // Return null for the sake of this test
                    }
                    return null;
                }
            );

            // First call to getInstance should create a new instance
            UnsupportedDurationField field1 = UnsupportedDurationField.getInstance(type);
            assertNotNull(field1);

            // Second call should return the cached instance
            UnsupportedDurationField field2 = UnsupportedDurationField.getInstance(type);
            assertSame(field1, field2); // field1 and field2 should be the same instance

        } catch (Exception e) {
            fail("Exception thrown during test: " + e.getMessage());
        }
    }

}