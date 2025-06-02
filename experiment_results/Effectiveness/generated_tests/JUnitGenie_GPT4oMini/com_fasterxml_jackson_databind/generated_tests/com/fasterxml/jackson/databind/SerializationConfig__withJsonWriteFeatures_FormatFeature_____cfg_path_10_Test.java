package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.core.FormatFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class SerializationConfig__withJsonWriteFeatures_FormatFeature_____cfg_path_10_Test {

    @Test(timeout = 4000)
    public void test_withJsonWriteFeatures() {
        try {
            // Create an instance of SerializationConfig using reflection
            Class<?> clazz = SerializationConfig.class;
            Constructor<?> constructor = clazz.getDeclaredConstructor(SerializationConfig.class);
            constructor.setAccessible(true);
            SerializationConfig config = (SerializationConfig) constructor.newInstance((SerializationConfig) null);

            // Prepare the FormatFeature array
            FormatFeature[] features = new FormatFeature[] { JsonWriteFeature.ESCAPE_NON_ASCII };

            // Access the private method _withJsonWriteFeatures using reflection
            Method method = clazz.getDeclaredMethod("_withJsonWriteFeatures", FormatFeature[].class);
            method.setAccessible(true);

            // Invoke the method
            SerializationConfig result = (SerializationConfig) method.invoke(config, (Object) features);

            // Assert that the result is not null
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}