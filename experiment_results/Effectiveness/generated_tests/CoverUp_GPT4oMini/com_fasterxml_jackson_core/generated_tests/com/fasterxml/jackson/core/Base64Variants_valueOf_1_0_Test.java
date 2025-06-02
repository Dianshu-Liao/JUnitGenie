package com.fasterxml.jackson.core;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class Base64Variants_valueOf_1_0_Test {

    @BeforeAll
    public static void setup() {
        // Any necessary setup can be done here
    }

    @Test
    public void testValueOfWithMIME() {
        Base64Variant result = Base64Variants.valueOf("MIME");
        assertEquals(Base64Variants.MIME, result);
    }

    @Test
    public void testValueOfWithMIME_NO_LINEFEEDS() {
        Base64Variant result = Base64Variants.valueOf("MIME_NO_LINEFEEDS");
        assertEquals(Base64Variants.MIME_NO_LINEFEEDS, result);
    }

    @Test
    public void testValueOfWithPEM() {
        Base64Variant result = Base64Variants.valueOf("PEM");
        assertEquals(Base64Variants.PEM, result);
    }

    @Test
    public void testValueOfWithMODIFIED_FOR_URL() {
        Base64Variant result = Base64Variants.valueOf("MODIFIED_FOR_URL");
        assertEquals(Base64Variants.MODIFIED_FOR_URL, result);
    }

    @Test
    public void testValueOfWithNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Base64Variants.valueOf(null);
        });
        assertEquals("No Base64Variant with name '<null>'", exception.getMessage());
    }

    @Test
    public void testValueOfWithInvalidName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Base64Variants.valueOf("INVALID_NAME");
        });
        assertEquals("No Base64Variant with name ''INVALID_NAME''", exception.getMessage());
    }
}
