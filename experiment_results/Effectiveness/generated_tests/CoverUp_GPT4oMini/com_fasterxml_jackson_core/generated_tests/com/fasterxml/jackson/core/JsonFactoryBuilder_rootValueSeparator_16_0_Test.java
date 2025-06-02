package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;

public class JsonFactoryBuilder_rootValueSeparator_16_0_Test {

    private JsonFactoryBuilder jsonFactoryBuilder;

    @BeforeEach
    public void setUp() {
        jsonFactoryBuilder = new JsonFactoryBuilder();
    }

    @Test
    public void testRootValueSeparator_WhenNull() throws Exception {
        jsonFactoryBuilder.rootValueSeparator((String) null);
        assertNull(invokeRootValueSeparator());
    }

    @Test
    public void testRootValueSeparator_WhenNonNull() throws Exception {
        String separator = "testSeparator";
        jsonFactoryBuilder.rootValueSeparator(separator);
        assertEquals(new SerializedString(separator), invokeRootValueSeparator());
    }

    @Test
    public void testRootValueSeparator_WithSerializableString() throws Exception {
        SerializedString separator = new SerializedString("testSerializableSeparator");
        jsonFactoryBuilder.rootValueSeparator(separator);
        assertEquals(separator, invokeRootValueSeparator());
    }

    private SerializableString invokeRootValueSeparator() throws Exception {
        Method method = JsonFactoryBuilder.class.getDeclaredMethod("rootValueSeparator");
        method.setAccessible(true);
        return (SerializableString) method.invoke(jsonFactoryBuilder);
    }
}
