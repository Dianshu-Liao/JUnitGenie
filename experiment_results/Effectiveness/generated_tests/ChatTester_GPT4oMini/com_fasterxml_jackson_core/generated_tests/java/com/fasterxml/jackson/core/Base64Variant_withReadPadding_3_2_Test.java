// Test method
package com.fasterxml.jackson.core;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
class Base64Variant_withReadPadding_3_2_Test {

    private Base64Variant base64Variant;

    @BeforeEach
    void setUp() {
        base64Variant = new Base64Variant("name", "base64Alphabet", true, '=', 76);
    }

    @Test
    void testWithReadPaddingReturnsSameInstanceWhenSameReadPadding() {
        Base64Variant result = base64Variant.withReadPadding(base64Variant.paddingReadBehaviour());
        assertSame(base64Variant, result, "Expected the same instance to be returned.");
    }

    @Test
    void testWithReadPaddingReturnsNewInstanceWhenDifferentReadPadding() {
        Base64Variant result = base64Variant.withReadPadding(Base64Variant.PaddingReadBehaviour.PADDING_REQUIRED);
        assertNotSame(base64Variant, result, "Expected a new instance to be returned.");
    }

    @Test
    void testWithReadPaddingHandlesNullReadPadding() {
        Base64Variant result = base64Variant.withReadPadding(null);
        assertNotSame(base64Variant, result, "Expected a new instance to be returned when passing null.");
    }

    @Test
    void testWithReadPaddingHandlesEmptyReadPadding() {
        Base64Variant result = base64Variant.withReadPadding(Base64Variant.PaddingReadBehaviour.PADDING_FORBIDDEN);
        assertNotSame(base64Variant, result, "Expected a new instance to be returned when passing empty behaviour.");
    }
}
