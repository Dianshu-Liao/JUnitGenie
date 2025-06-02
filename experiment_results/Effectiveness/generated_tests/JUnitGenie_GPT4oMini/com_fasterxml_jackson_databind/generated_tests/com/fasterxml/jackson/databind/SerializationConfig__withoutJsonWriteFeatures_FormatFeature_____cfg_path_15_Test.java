package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.core.FormatFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import org.junit.Test;
import static org.junit.Assert.*;

public class SerializationConfig__withoutJsonWriteFeatures_FormatFeature_____cfg_path_15_Test {

    @Test(timeout = 4000)
    public void test_withoutJsonWriteFeatures() {
        // Create an instance of SerializationConfig using reflection
        SerializationConfig config = createSerializationConfig();

        // Prepare the FormatFeature array to test
        FormatFeature[] features = new FormatFeature[] {
            JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS
        };

        // Invoke the private method using reflection
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
        // Use reflection to create an instance of SerializationConfig
        try {
            return (SerializationConfig) SerializationConfig.class.getDeclaredConstructors()[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed to create SerializationConfig instance: " + e.getMessage());
            return null; // This will never be reached due to fail()
        }
    }

}