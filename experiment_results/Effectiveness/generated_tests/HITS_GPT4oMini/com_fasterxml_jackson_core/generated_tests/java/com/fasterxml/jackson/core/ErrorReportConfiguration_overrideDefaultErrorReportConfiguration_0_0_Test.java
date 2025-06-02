package com.fasterxml.jackson.core;

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
        // Reset to default configuration before each test
        ErrorReportConfiguration.overrideDefaultErrorReportConfiguration(null);
        defaultConfig = new ErrorReportConfiguration(ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH, ErrorReportConfiguration.DEFAULT_MAX_RAW_CONTENT_LENGTH);
    }

    @Test
    public void testOverrideWithNull() {
        // Arrange
        ErrorReportConfiguration.overrideDefaultErrorReportConfiguration(defaultConfig);
        // Act
        ErrorReportConfiguration.overrideDefaultErrorReportConfiguration(null);
        // Assert
        assertEquals(ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH, defaultConfig.getMaxErrorTokenLength());
        assertEquals(ErrorReportConfiguration.DEFAULT_MAX_RAW_CONTENT_LENGTH, defaultConfig.getMaxRawContentLength());
    }

    @Test
    public void testOverrideWithValidConfiguration() {
        // Arrange
        ErrorReportConfiguration newConfig = new ErrorReportConfiguration(512, 1000);
        // Act
        ErrorReportConfiguration.overrideDefaultErrorReportConfiguration(newConfig);
        // Assert
        assertEquals(512, newConfig.getMaxErrorTokenLength());
        assertEquals(1000, newConfig.getMaxRawContentLength());
    }

    @Test
    public void testDefaultConfigurationAfterNullOverride() {
        // Arrange
        ErrorReportConfiguration newConfig = new ErrorReportConfiguration(512, 1000);
        ErrorReportConfiguration.overrideDefaultErrorReportConfiguration(newConfig);
        // Act
        ErrorReportConfiguration.overrideDefaultErrorReportConfiguration(null);
        // Assert
        assertNotNull(newConfig);
        assertEquals(ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH, newConfig.getMaxErrorTokenLength());
        assertEquals(ErrorReportConfiguration.DEFAULT_MAX_RAW_CONTENT_LENGTH, newConfig.getMaxRawContentLength());
    }
}
