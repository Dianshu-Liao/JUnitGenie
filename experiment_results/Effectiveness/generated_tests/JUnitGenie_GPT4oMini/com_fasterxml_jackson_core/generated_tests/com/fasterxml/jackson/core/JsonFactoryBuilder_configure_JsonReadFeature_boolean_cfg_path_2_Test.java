package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import org.junit.Test;
import static org.junit.Assert.*;

public class JsonFactoryBuilder_configure_JsonReadFeature_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConfigureEnable() {
        JsonFactoryBuilder builder = new JsonFactoryBuilder();
        JsonReadFeature feature = JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES; // Example feature
        boolean state = true;

        JsonFactoryBuilder result = builder.configure(feature, state);
        assertNotNull(result);
        // Additional assertions can be added to verify the state of the builder if necessary
    }

    @Test(timeout = 4000)
    public void testConfigureDisable() {
        JsonFactoryBuilder builder = new JsonFactoryBuilder();
        JsonReadFeature feature = JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES; // Example feature
        boolean state = false;

        JsonFactoryBuilder result = builder.configure(feature, state);
        assertNotNull(result);
        // Additional assertions can be added to verify the state of the builder if necessary
    }

}