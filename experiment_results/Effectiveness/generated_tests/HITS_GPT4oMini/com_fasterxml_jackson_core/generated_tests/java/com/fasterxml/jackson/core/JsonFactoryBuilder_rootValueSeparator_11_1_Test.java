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

public class JsonFactoryBuilder_rootValueSeparator_11_1_Test {

    @Test
    public void testRootValueSeparator_NullInput() {
        JsonFactoryBuilder builder = new JsonFactoryBuilder();
        builder.rootValueSeparator((String) null);
        assertNull(builder._rootValueSeparator, "Root value separator should be null when input is null");
    }

    @Test
    public void testRootValueSeparator_EmptyString() {
        JsonFactoryBuilder builder = new JsonFactoryBuilder();
        builder.rootValueSeparator("");
        assertEquals("", builder._rootValueSeparator.getValue(), "Root value separator should be an empty string");
    }

    @Test
    public void testRootValueSeparator_ValidString() {
        JsonFactoryBuilder builder = new JsonFactoryBuilder();
        String separator = "separator";
        builder.rootValueSeparator(separator);
        assertEquals(separator, builder._rootValueSeparator.getValue(), "Root value separator should match the input string");
    }

    @Test
    public void testRootValueSeparator_SpecialCharacters() {
        JsonFactoryBuilder builder = new JsonFactoryBuilder();
        String separator = "\n\t\r";
        builder.rootValueSeparator(separator);
        assertEquals(separator, builder._rootValueSeparator.getValue(), "Root value separator should correctly handle special characters");
    }
}
