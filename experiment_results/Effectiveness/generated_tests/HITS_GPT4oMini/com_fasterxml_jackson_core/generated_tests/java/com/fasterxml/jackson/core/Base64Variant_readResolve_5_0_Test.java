package com.fasterxml.jackson.core;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;

public class Base64Variant_readResolve_5_0_Test {

    private static Base64Variant mimeVariant;

    private static Base64Variant mimeNoLineFeedsVariant;

    private static Base64Variant pemVariant;

    @BeforeAll
    public static void setUp() {
        mimeVariant = Base64Variants.MIME;
        mimeNoLineFeedsVariant = Base64Variants.MIME_NO_LINEFEEDS;
        pemVariant = Base64Variants.PEM;
    }

    @Test
    public void testReadResolve_withSameProperties_returnsSameInstance() {
        Base64Variant variant = new Base64Variant(mimeVariant, "MIME", 76);
        Object result = variant.readResolve();
        assertSame(mimeVariant, result, "Expected to return the same instance for equivalent properties.");
    }

    @Test
    public void testReadResolve_withDifferentWritePadding_returnsNewInstance() {
        Base64Variant variant = new Base64Variant(mimeVariant, "MIME", false, '=', 76);
        Object result = variant.readResolve();
        assertNotSame(mimeVariant, result, "Expected to return a new instance when writePadding differs.");
        assertTrue(result instanceof Base64Variant, "Expected result to be an instance of Base64Variant.");
    }

    @Test
    public void testReadResolve_withDifferentPaddingChar_returnsNewInstance() {
        Base64Variant variant = new Base64Variant(mimeVariant, "MIME", true, '*', 76);
        Object result = variant.readResolve();
        assertNotSame(mimeVariant, result, "Expected to return a new instance when paddingChar differs.");
        assertTrue(result instanceof Base64Variant, "Expected result to be an instance of Base64Variant.");
    }

    @Test
    public void testReadResolve_withDifferentMaxLineLength_returnsNewInstance() {
        Base64Variant variant = new Base64Variant(mimeVariant, "MIME", true, '=', 128);
        Object result = variant.readResolve();
        assertNotSame(mimeVariant, result, "Expected to return a new instance when maxLineLength differs.");
        assertTrue(result instanceof Base64Variant, "Expected result to be an instance of Base64Variant.");
    }

    @Test
    public void testReadResolve_withDifferentPaddingReadBehaviour_returnsNewInstance() {
        Base64Variant variant = new Base64Variant(mimeVariant, "MIME", true, '=', 76);
        variant = new Base64Variant(variant, "MIME", false, '=', 76);
        Object result = variant.readResolve();
        assertNotSame(mimeVariant, result, "Expected to return a new instance when paddingReadBehaviour differs.");
        assertTrue(result instanceof Base64Variant, "Expected result to be an instance of Base64Variant.");
    }

    @Test
    public void testReadResolve_withNullName_throwsException() {
        Base64Variant variant = new Base64Variant(mimeVariant, null, true, '=', 76);
        assertThrows(IllegalArgumentException.class, variant::readResolve, "Expected IllegalArgumentException for null name.");
    }
}
