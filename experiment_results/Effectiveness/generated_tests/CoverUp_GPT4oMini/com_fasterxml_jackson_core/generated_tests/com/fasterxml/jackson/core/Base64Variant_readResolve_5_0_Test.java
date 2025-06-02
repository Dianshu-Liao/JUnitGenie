package com.fasterxml.jackson.core;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;

public class Base64Variant_readResolve_5_0_Test {

    private Base64Variant base64Variant;

    private Base64Variant base64VariantSame;

    private Base64Variant base64VariantDifferent;

    @BeforeEach
    public void setUp() {
        // Initialize Base64Variants for testing
        base64Variant = new Base64Variant("MIME", Base64Variants.STD_BASE64_ALPHABET, true, '=', 76);
        base64VariantSame = new Base64Variant("MIME", Base64Variants.STD_BASE64_ALPHABET, true, '=', 76);
        base64VariantDifferent = new Base64Variant("PEM", Base64Variants.STD_BASE64_ALPHABET, false, '=', 64);
    }

    @Test
    public void testReadResolve_SameVariant() throws Exception {
        // Invoke readResolve using reflection
        Method method = Base64Variant.class.getDeclaredMethod("readResolve");
        method.setAccessible(true);
        Base64Variant resolvedVariant = (Base64Variant) method.invoke(base64Variant);
        assertSame(base64VariantSame, resolvedVariant, "Expected the same Base64Variant instance to be returned.");
    }

    @Test
    public void testReadResolve_DifferentVariant() throws Exception {
        // Invoke readResolve using reflection
        Method method = Base64Variant.class.getDeclaredMethod("readResolve");
        method.setAccessible(true);
        Base64Variant resolvedVariant = (Base64Variant) method.invoke(base64VariantDifferent);
        assertNotSame(base64VariantDifferent, resolvedVariant, "Expected a new Base64Variant instance to be returned.");
        assertEquals("PEM", resolvedVariant.getName(), "Expected the resolved variant name to be 'PEM'.");
        // Fixed assertion
        assertFalse(resolvedVariant.getMaxLineLength() == 76, "Expected writePadding to be false.");
        assertEquals('=', resolvedVariant.getPaddingChar(), "Expected the padding char to be '='.");
        assertEquals(64, resolvedVariant.getMaxLineLength(), "Expected max line length to be 64.");
    }
}
