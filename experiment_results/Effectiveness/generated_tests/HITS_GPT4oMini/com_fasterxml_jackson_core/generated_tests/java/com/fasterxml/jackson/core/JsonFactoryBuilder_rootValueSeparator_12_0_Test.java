package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.SerializedString;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;

public class JsonFactoryBuilder_rootValueSeparator_12_0_Test {

    private JsonFactoryBuilder jsonFactoryBuilder;

    @BeforeEach
    public void setUp() {
        jsonFactoryBuilder = new JsonFactoryBuilder();
    }

    @Test
    public void testRootValueSeparator_withValidSerializableString() {
        SerializableString separator = new SerializedString(": ");
        jsonFactoryBuilder.rootValueSeparator(separator);
        assertNotNull(jsonFactoryBuilder._rootValueSeparator);
        assertEquals(": ", jsonFactoryBuilder._rootValueSeparator.getValue());
    }

    @Test
    public void testRootValueSeparator_withNull() {
        jsonFactoryBuilder.rootValueSeparator((SerializableString) null);
        assertNull(jsonFactoryBuilder._rootValueSeparator);
    }

    @Test
    public void testRootValueSeparator_withEmptyString() {
        SerializableString separator = new SerializedString("");
        jsonFactoryBuilder.rootValueSeparator(separator);
        assertNotNull(jsonFactoryBuilder._rootValueSeparator);
        assertEquals("", jsonFactoryBuilder._rootValueSeparator.getValue());
    }

    @Test
    public void testRootValueSeparator_withSpecialCharacters() {
        SerializableString separator = new SerializedString("!@#$%^&*()");
        jsonFactoryBuilder.rootValueSeparator(separator);
        assertNotNull(jsonFactoryBuilder._rootValueSeparator);
        assertEquals("!@#$%^&*()", jsonFactoryBuilder._rootValueSeparator.getValue());
    }
}
