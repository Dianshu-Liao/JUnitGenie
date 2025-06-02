package com.fasterxml.jackson.core;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class Base64Variants_valueOf_1_0_Test {

    @Test
    public void testValueOf_MIME() {
        Base64Variant result = Base64Variants.valueOf("MIME");
        assertEquals(Base64Variants.MIME, result);
    }

    @Test
    public void testValueOf_MIME_NO_LINEFEEDS() {
        Base64Variant result = Base64Variants.valueOf("MIME_NO_LINEFEEDS");
        assertEquals(Base64Variants.MIME_NO_LINEFEEDS, result);
    }

    @Test
    public void testValueOf_PEM() {
        Base64Variant result = Base64Variants.valueOf("PEM");
        assertEquals(Base64Variants.PEM, result);
    }

    @Test
    public void testValueOf_MODIFIED_FOR_URL() {
        Base64Variant result = Base64Variants.valueOf("MODIFIED_FOR_URL");
        assertEquals(Base64Variants.MODIFIED_FOR_URL, result);
    }

    @Test
    public void testValueOf_NullInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Base64Variants.valueOf(null);
        });
        assertEquals("No Base64Variant with name '<null>'", exception.getMessage());
    }

    @Test
    public void testValueOf_InvalidInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Base64Variants.valueOf("INVALID");
        });
        assertEquals("No Base64Variant with name ''INVALID''", exception.getMessage());
    }
}
