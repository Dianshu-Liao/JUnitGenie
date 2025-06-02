package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
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
        JsonFactoryBuilder result = jsonFactoryBuilder.configure(feature, true);
        // Using reflection to access the private method enable
        Method enableMethod = JsonFactoryBuilder.class.getDeclaredMethod("enable", JsonWriteFeature.class);
        enableMethod.setAccessible(true);
        JsonFactoryBuilder expected = (JsonFactoryBuilder) enableMethod.invoke(jsonFactoryBuilder, feature);
        assertSame(expected, result);
    }

    @Test
    public void testConfigureDisable() throws Exception {
        JsonWriteFeature feature = JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS;
        JsonFactoryBuilder result = jsonFactoryBuilder.configure(feature, false);
        // Using reflection to access the private method disable
        Method disableMethod = JsonFactoryBuilder.class.getDeclaredMethod("disable", JsonWriteFeature.class);
        disableMethod.setAccessible(true);
        JsonFactoryBuilder expected = (JsonFactoryBuilder) disableMethod.invoke(jsonFactoryBuilder, feature);
        assertSame(expected, result);
    }

    @Test
    public void testJsonFactoryBuilderInitialization() {
        assertNotNull(jsonFactoryBuilder);
    }
}
