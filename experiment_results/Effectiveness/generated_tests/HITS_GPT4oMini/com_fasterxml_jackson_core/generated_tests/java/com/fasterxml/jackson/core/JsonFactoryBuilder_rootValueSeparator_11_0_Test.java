package com.fasterxml.jackson.core;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;

public class JsonFactoryBuilder_rootValueSeparator_11_0_Test {

    private JsonFactoryBuilder jsonFactoryBuilder;

    @BeforeEach
    public void setUp() {
        jsonFactoryBuilder = new JsonFactoryBuilder();
    }

    @Test
    public void testRootValueSeparator_NullInput() {
        // Test with null input
        jsonFactoryBuilder.rootValueSeparator((String) null);
        assertNull(jsonFactoryBuilder._rootValueSeparator, "Root value separator should be null when input is null.");
    }

    @Test
    public void testRootValueSeparator_EmptyString() {
        // Test with empty string
        String emptySeparator = "";
        jsonFactoryBuilder.rootValueSeparator(emptySeparator);
        assertEquals(emptySeparator, jsonFactoryBuilder._rootValueSeparator.getValue(), "Root value separator should match the empty string input.");
    }

    @Test
    public void testRootValueSeparator_ValidString() {
        // Test with a valid separator string
        String validSeparator = ",";
        jsonFactoryBuilder.rootValueSeparator(validSeparator);
        assertEquals(validSeparator, jsonFactoryBuilder._rootValueSeparator.getValue(), "Root value separator should match the valid string input.");
    }

    @Test
    public void testRootValueSeparator_SpecialCharacters() {
        // Test with a string containing special characters
        String specialSeparator = " | ";
        jsonFactoryBuilder.rootValueSeparator(specialSeparator);
        assertEquals(specialSeparator, jsonFactoryBuilder._rootValueSeparator.getValue(), "Root value separator should match the special characters input.");
    }
}
