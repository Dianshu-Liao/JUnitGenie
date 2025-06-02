package com.fasterxml.jackson.core;

import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;

public class ErrorReportConfiguration_overrideDefaultErrorReportConfiguration_0_0_Test {

    private ErrorReportConfiguration defaultConfig;

    @BeforeEach
    public void setUp() {
        defaultConfig = new ErrorReportConfiguration(ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH, ErrorReportConfiguration.DEFAULT_MAX_RAW_CONTENT_LENGTH);
    }

    @Test
    public void testOverrideDefaultErrorReportConfiguration_Null() throws Exception {
        // Arrange
        ErrorReportConfiguration.overrideDefaultErrorReportConfiguration(null);
        // Act
        Field defaultField = ErrorReportConfiguration.class.getDeclaredField("DEFAULT");
        defaultField.setAccessible(true);
        ErrorReportConfiguration newDefault = (ErrorReportConfiguration) defaultField.get(null);
        // Assert
        assertNotNull(newDefault);
        assertEquals(ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH, newDefault.getMaxErrorTokenLength());
        assertEquals(ErrorReportConfiguration.DEFAULT_MAX_RAW_CONTENT_LENGTH, newDefault.getMaxRawContentLength());
    }

    @Test
    public void testOverrideDefaultErrorReportConfiguration_ValidConfig() throws Exception {
        // Arrange
        ErrorReportConfiguration newConfig = new ErrorReportConfiguration(100, 200);
        // Act
        ErrorReportConfiguration.overrideDefaultErrorReportConfiguration(newConfig);
        // Access the private static field DEFAULT
        Field defaultField = ErrorReportConfiguration.class.getDeclaredField("DEFAULT");
        defaultField.setAccessible(true);
        ErrorReportConfiguration overriddenDefault = (ErrorReportConfiguration) defaultField.get(null);
        // Assert
        assertNotNull(overriddenDefault);
        assertEquals(100, overriddenDefault.getMaxErrorTokenLength());
        assertEquals(200, overriddenDefault.getMaxRawContentLength());
    }
}
