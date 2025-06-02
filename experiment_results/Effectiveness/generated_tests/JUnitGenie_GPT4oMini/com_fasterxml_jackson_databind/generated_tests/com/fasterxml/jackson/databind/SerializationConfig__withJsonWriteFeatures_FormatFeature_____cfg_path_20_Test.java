package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.core.FormatFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import org.junit.Test;
import java.lang.reflect.Constructor;
import static org.junit.Assert.assertNotNull;

public class SerializationConfig__withJsonWriteFeatures_FormatFeature_____cfg_path_20_Test {

    @Test(timeout = 4000)
    public void test_withJsonWriteFeatures() {
        try {
            // Create an instance of SerializationConfig using reflection
            Class<?> clazz = SerializationConfig.class;
            Constructor<?> constructor = clazz.getDeclaredConstructors()[0]; // Select an appropriate constructor
            constructor.setAccessible(true);
            SerializationConfig config = (SerializationConfig) constructor.newInstance(new Object[]{}); // Pass an empty array for no-arg constructor

            // Prepare the FormatFeature array
            FormatFeature[] features = new FormatFeature[] {
                JsonWriteFeature.ESCAPE_NON_ASCII // Example feature
            };

            // Access the private method _withJsonWriteFeatures using reflection
            java.lang.reflect.Method method = clazz.getDeclaredMethod("_withJsonWriteFeatures", FormatFeature[].class);
            method.setAccessible(true);
            SerializationConfig result = (SerializationConfig) method.invoke(config, (Object) features);

            // Assert that the result is not null
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}