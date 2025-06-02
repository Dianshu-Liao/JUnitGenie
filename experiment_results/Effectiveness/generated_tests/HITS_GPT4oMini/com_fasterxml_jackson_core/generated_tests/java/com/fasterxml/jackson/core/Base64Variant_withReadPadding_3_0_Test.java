package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.Base64Variant.PaddingReadBehaviour;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;

class Base64Variant_withReadPadding_3_0_Test {

    @Test
    void testWithReadPadding_SamePaddingBehaviour() {
        // Arrange
        Base64Variant variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        // Using the default behavior
        PaddingReadBehaviour sameBehaviour = PaddingReadBehaviour.PADDING_REQUIRED;
        // Act
        Base64Variant result = variant.withReadPadding(sameBehaviour);
        // Assert
        assertSame(variant, result, "Expected the same instance to be returned when padding behaviour is the same.");
    }

    @Test
    void testWithReadPadding_DifferentPaddingBehaviour() {
        // Arrange
        Base64Variant variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        PaddingReadBehaviour differentBehaviour = PaddingReadBehaviour.PADDING_FORBIDDEN;
        // Act
        Base64Variant result = variant.withReadPadding(differentBehaviour);
        // Assert
        assertNotSame(variant, result, "Expected a new instance to be returned when padding behaviour is different.");
        // Validate the updated padding behaviour indirectly by checking the instance creation logic
        // Since we cannot access the padding behaviour directly, we can only assert that a new instance is created
        assertNotSame(variant, result, "Expected a new instance to be returned when padding behaviour is different.");
    }
}
