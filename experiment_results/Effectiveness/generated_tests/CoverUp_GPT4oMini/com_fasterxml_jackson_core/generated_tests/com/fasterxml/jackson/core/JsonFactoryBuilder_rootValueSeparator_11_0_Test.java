package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.SerializedString;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;

public class JsonFactoryBuilder_rootValueSeparator_11_0_Test {

    private JsonFactoryBuilder jsonFactoryBuilder;

    @BeforeEach
    public void setUp() {
        jsonFactoryBuilder = new JsonFactoryBuilder();
    }

    @Test
    public void testRootValueSeparator_NullInput() throws Exception {
        jsonFactoryBuilder.rootValueSeparator((String) null);
        Field rootValueSeparatorField = JsonFactoryBuilder.class.getDeclaredField("_rootValueSeparator");
        rootValueSeparatorField.setAccessible(true);
        SerializedString rootValueSeparator = (SerializedString) rootValueSeparatorField.get(jsonFactoryBuilder);
        assertNull(rootValueSeparator);
    }

    @Test
    public void testRootValueSeparator_EmptyString() throws Exception {
        jsonFactoryBuilder.rootValueSeparator("");
        Field rootValueSeparatorField = JsonFactoryBuilder.class.getDeclaredField("_rootValueSeparator");
        rootValueSeparatorField.setAccessible(true);
        SerializedString rootValueSeparator = (SerializedString) rootValueSeparatorField.get(jsonFactoryBuilder);
        assertEquals("", rootValueSeparator.getValue());
    }

    @Test
    public void testRootValueSeparator_ValidString() throws Exception {
        String separator = "separator";
        jsonFactoryBuilder.rootValueSeparator(separator);
        Field rootValueSeparatorField = JsonFactoryBuilder.class.getDeclaredField("_rootValueSeparator");
        rootValueSeparatorField.setAccessible(true);
        SerializedString rootValueSeparator = (SerializedString) rootValueSeparatorField.get(jsonFactoryBuilder);
        assertEquals(separator, rootValueSeparator.getValue());
    }
}
