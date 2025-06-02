// Test method
package com.fasterxml.jackson.core;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class JsonFactoryBuilder_rootValueSeparator_11_0_Test {

    private JsonFactoryBuilder jsonFactoryBuilder;

    @BeforeEach
    public void setUp() {
        jsonFactoryBuilder = new JsonFactoryBuilder();
    }

    @Test
    public void testRootValueSeparator_NullInput() {
        JsonFactoryBuilder result = jsonFactoryBuilder.rootValueSeparator((String) null);
        assertNull(result._rootValueSeparator, "Expected _rootValueSeparator to be null when input is null");
    }

    @Test
    public void testRootValueSeparator_EmptyString() {
        JsonFactoryBuilder result = jsonFactoryBuilder.rootValueSeparator("");
        assertNotNull(result._rootValueSeparator, "Expected _rootValueSeparator to be not null when input is an empty string");
        assertEquals("", result._rootValueSeparator.getValue(), "Expected _rootValueSeparator to be an empty string");
    }

    @Test
    public void testRootValueSeparator_ValidString() {
        String separator = ",";
        JsonFactoryBuilder result = jsonFactoryBuilder.rootValueSeparator(separator);
        assertNotNull(result._rootValueSeparator, "Expected _rootValueSeparator to be not null when input is a valid string");
        assertEquals(separator, result._rootValueSeparator.getValue(), "Expected _rootValueSeparator to match the input string");
    }
}
