package com.fasterxml.jackson.core;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.Serializable;

public class ErrorReportConfiguration_overrideDefaultErrorReportConfiguration_0_0_Test {

    private ErrorReportConfiguration defaultConfig;

    @BeforeEach
    public void setUp() throws Exception {
        // Accessing the private DEFAULT field using reflection
        Field defaultField = ErrorReportConfiguration.class.getDeclaredField("DEFAULT");
        defaultField.setAccessible(true);
        defaultConfig = (ErrorReportConfiguration) defaultField.get(null);
    }

    @Test
    public void testOverrideDefaultWithNull() throws Exception {
        // Invoke the focal method with null
        ErrorReportConfiguration.overrideDefaultErrorReportConfiguration(null);
        // Accessing the private DEFAULT field using reflection
        Field defaultField = ErrorReportConfiguration.class.getDeclaredField("DEFAULT");
        defaultField.setAccessible(true);
        ErrorReportConfiguration newDefaultConfig = (ErrorReportConfiguration) defaultField.get(null);
        assertEquals(ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH, newDefaultConfig.getMaxErrorTokenLength());
        assertEquals(ErrorReportConfiguration.DEFAULT_MAX_RAW_CONTENT_LENGTH, newDefaultConfig.getMaxRawContentLength());
    }

    @Test
    public void testOverrideDefaultWithCustomConfig() throws Exception {
        // Create a custom configuration
        ErrorReportConfiguration customConfig = new ErrorReportConfiguration(100, 200);
        // Invoke the focal method with the custom configuration
        ErrorReportConfiguration.overrideDefaultErrorReportConfiguration(customConfig);
        // Accessing the private DEFAULT field using reflection
        Field defaultField = ErrorReportConfiguration.class.getDeclaredField("DEFAULT");
        defaultField.setAccessible(true);
        ErrorReportConfiguration newDefaultConfig = (ErrorReportConfiguration) defaultField.get(null);
        assertEquals(100, newDefaultConfig.getMaxErrorTokenLength());
        assertEquals(200, newDefaultConfig.getMaxRawContentLength());
    }

    @Test
    public void testOverrideDefaultMultipleTimes() throws Exception {
        // Create a first custom configuration
        ErrorReportConfiguration firstCustomConfig = new ErrorReportConfiguration(100, 200);
        ErrorReportConfiguration.overrideDefaultErrorReportConfiguration(firstCustomConfig);
        // Create a second custom configuration
        ErrorReportConfiguration secondCustomConfig = new ErrorReportConfiguration(150, 250);
        ErrorReportConfiguration.overrideDefaultErrorReportConfiguration(secondCustomConfig);
        // Accessing the private DEFAULT field using reflection
        Field defaultField = ErrorReportConfiguration.class.getDeclaredField("DEFAULT");
        defaultField.setAccessible(true);
        ErrorReportConfiguration newDefaultConfig = (ErrorReportConfiguration) defaultField.get(null);
        assertEquals(150, newDefaultConfig.getMaxErrorTokenLength());
        assertEquals(250, newDefaultConfig.getMaxRawContentLength());
    }
}
