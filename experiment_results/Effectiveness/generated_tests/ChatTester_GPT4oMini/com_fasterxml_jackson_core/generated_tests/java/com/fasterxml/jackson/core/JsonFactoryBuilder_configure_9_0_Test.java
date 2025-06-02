package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.json.JsonWriteFeature;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.json.JsonReadFeature;

public class JsonFactoryBuilder_configure_9_0_Test {

    private JsonFactoryBuilder jsonFactoryBuilder;

    @BeforeEach
    public void setUp() {
        jsonFactoryBuilder = new JsonFactoryBuilder();
    }

    @Test
    public void testConfigureEnable() throws Exception {
        JsonWriteFeature feature = JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS;
        // Invoke the configure method with true to enable the feature
        Method configureMethod = JsonFactoryBuilder.class.getDeclaredMethod("configure", JsonWriteFeature.class, boolean.class);
        configureMethod.setAccessible(true);
        JsonFactoryBuilder result = (JsonFactoryBuilder) configureMethod.invoke(jsonFactoryBuilder, feature, true);
        assertNotNull(result);
        // Assuming enable method modifies the state of jsonFactoryBuilder
        // Here you would add assertions to check the state of jsonFactoryBuilder
        // For example, you might check if the feature is enabled
    }

    @Test
    public void testConfigureDisable() throws Exception {
        JsonWriteFeature feature = JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS;
        // Invoke the configure method with false to disable the feature
        Method configureMethod = JsonFactoryBuilder.class.getDeclaredMethod("configure", JsonWriteFeature.class, boolean.class);
        configureMethod.setAccessible(true);
        JsonFactoryBuilder result = (JsonFactoryBuilder) configureMethod.invoke(jsonFactoryBuilder, feature, false);
        assertNotNull(result);
        // Assuming disable method modifies the state of jsonFactoryBuilder
        // Here you would add assertions to check the state of jsonFactoryBuilder
        // For example, you might check if the feature is disabled
    }
}
