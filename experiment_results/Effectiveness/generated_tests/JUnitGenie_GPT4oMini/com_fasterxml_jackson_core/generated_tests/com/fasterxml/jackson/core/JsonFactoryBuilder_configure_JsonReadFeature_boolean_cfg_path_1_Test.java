package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class JsonFactoryBuilder_configure_JsonReadFeature_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testConfigureDisable() {
        JsonFactoryBuilder builder = new JsonFactoryBuilder();
        JsonReadFeature feature = JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES; // Example feature
        boolean state = false;

        try {
            JsonFactoryBuilder result = builder.configure(feature, state);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}