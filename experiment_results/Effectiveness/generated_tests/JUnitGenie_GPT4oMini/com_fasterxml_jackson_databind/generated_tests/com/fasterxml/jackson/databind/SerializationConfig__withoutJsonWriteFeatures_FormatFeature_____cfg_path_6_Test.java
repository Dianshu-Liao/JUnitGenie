package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.core.FormatFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import org.junit.Test;
import static org.junit.Assert.*;

public class SerializationConfig__withoutJsonWriteFeatures_FormatFeature_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testWithoutJsonWriteFeatures() {
        // Create an instance of SerializationConfig using reflection
        SerializationConfig config = createSerializationConfig();

        // Prepare the FormatFeature array
        FormatFeature[] features = new FormatFeature[] {
            JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS
        };

        // Call the private method using reflection
        try {
            SerializationConfig result = (SerializationConfig) 
                SerializationConfig.class.getDeclaredMethod("_withoutJsonWriteFeatures", FormatFeature[].class)
                .invoke(config, (Object) features);

            // Assert the result is not null
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred while invoking _withoutJsonWriteFeatures: " + e.getMessage());
        }
    }

    private SerializationConfig createSerializationConfig() {
        // Use reflection to access the constructor
        try {
            return (SerializationConfig) SerializationConfig.class.getDeclaredConstructor(
                SerializationConfig.class, long.class, int.class, int.class, int.class, int.class, int.class)
                .newInstance(null, 0L, 0, 0, 0, 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed to create SerializationConfig instance: " + e.getMessage());
            return null; // This will never be reached due to fail()
        }
    }

}