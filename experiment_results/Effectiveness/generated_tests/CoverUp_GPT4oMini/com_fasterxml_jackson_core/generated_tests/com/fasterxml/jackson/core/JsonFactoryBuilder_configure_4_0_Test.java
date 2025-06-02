package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.json.JsonWriteFeature;

public class JsonFactoryBuilder_configure_4_0_Test {

    private JsonFactoryBuilder jsonFactoryBuilder;

    @BeforeEach
    public void setUp() {
        jsonFactoryBuilder = new JsonFactoryBuilder();
    }

    @Test
    public void testConfigureEnable() throws Exception {
        JsonReadFeature feature = JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        jsonFactoryBuilder.configure(feature, true);
        // Use reflection to access the private method enable
        Method enableMethod = JsonFactoryBuilder.class.getDeclaredMethod("enable", JsonReadFeature.class);
        enableMethod.setAccessible(true);
        JsonFactoryBuilder result = (JsonFactoryBuilder) enableMethod.invoke(jsonFactoryBuilder, feature);
        assertNotNull(result);
        assertSame(jsonFactoryBuilder, result);
    }

    @Test
    public void testConfigureDisable() throws Exception {
        JsonReadFeature feature = JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        jsonFactoryBuilder.configure(feature, false);
        // Use reflection to access the private method disable
        Method disableMethod = JsonFactoryBuilder.class.getDeclaredMethod("disable", JsonReadFeature.class);
        disableMethod.setAccessible(true);
        JsonFactoryBuilder result = (JsonFactoryBuilder) disableMethod.invoke(jsonFactoryBuilder, feature);
        assertNotNull(result);
        assertSame(jsonFactoryBuilder, result);
    }
}
