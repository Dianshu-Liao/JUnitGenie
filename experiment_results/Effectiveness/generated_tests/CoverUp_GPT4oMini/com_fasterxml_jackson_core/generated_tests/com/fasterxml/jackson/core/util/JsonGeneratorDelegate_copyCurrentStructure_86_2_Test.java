package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;

@ExtendWith(MockitoExtension.class)
class JsonGeneratorDelegate_copyCurrentStructure_86_2_Test {

    private JsonGenerator mockDelegate;

    private JsonGeneratorDelegate jsonGeneratorDelegate;

    @BeforeEach
    void setUp() {
        mockDelegate = Mockito.mock(JsonGenerator.class);
        jsonGeneratorDelegate = new JsonGeneratorDelegate(mockDelegate);
    }

    @Test
    void testCopyCurrentStructure_whenDelegateCopyMethodsIsTrue() throws IOException {
        jsonGeneratorDelegate.delegateCopyMethods = true;
        JsonParser mockParser = Mockito.mock(JsonParser.class);
        jsonGeneratorDelegate.copyCurrentStructure(mockParser);
        verify(mockDelegate, times(1)).copyCurrentStructure(mockParser);
    }

    @Test
    void testCopyCurrentStructure_whenDelegateCopyMethodsIsFalse() throws IOException {
        jsonGeneratorDelegate.delegateCopyMethods = false;
        JsonParser mockParser = Mockito.mock(JsonParser.class);
        assertDoesNotThrow(() -> jsonGeneratorDelegate.copyCurrentStructure(mockParser));
    }

    @Test
    void testCopyCurrentStructure_withNullParser() {
        jsonGeneratorDelegate.delegateCopyMethods = true;
        assertThrows(IOException.class, () -> {
            jsonGeneratorDelegate.copyCurrentStructure(null);
        });
    }
}
