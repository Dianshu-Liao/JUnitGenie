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

public class Base64Variant_withReadPadding_3_1_Test {

    @Test
    public void testWithReadPadding_SamePaddingBehaviour() {
        // Arrange
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        PaddingReadBehaviour sameBehaviour = PaddingReadBehaviour.PADDING_REQUIRED;
        // Act
        Base64Variant result = base64Variant.withReadPadding(sameBehaviour);
        // Assert
        assertSame(base64Variant, result, "Expected the same instance when the same PaddingReadBehaviour is provided.");
    }

    @Test
    public void testWithReadPadding_DifferentPaddingBehaviour() {
        // Arrange
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        PaddingReadBehaviour newBehaviour = PaddingReadBehaviour.PADDING_FORBIDDEN;
        // Act
        Base64Variant result = base64Variant.withReadPadding(newBehaviour);
        // Assert
        assertNotSame(base64Variant, result, "Expected a new instance when a different PaddingReadBehaviour is provided.");
        // The internal state cannot be checked directly; we can only verify the behavior indirectly
        assertNotSame(base64Variant, result, "Expected a new instance when a different PaddingReadBehaviour is provided.");
    }

    @Test
    public void testWithReadPadding_ChangePaddingBehaviour() {
        // Arrange
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", false, '\0', 76);
        PaddingReadBehaviour newBehaviour = PaddingReadBehaviour.PADDING_REQUIRED;
        // Act
        Base64Variant result = base64Variant.withReadPadding(newBehaviour);
        // Assert
        assertNotSame(base64Variant, result, "Expected a new instance when changing PaddingReadBehaviour.");
        // The internal state cannot be checked directly; we can only verify the behavior indirectly
    }

    @Test
    public void testWithReadPadding_ChangePaddingBehaviourToSame() {
        // Arrange
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        PaddingReadBehaviour sameBehaviour = PaddingReadBehaviour.PADDING_REQUIRED;
        // Act
        Base64Variant result = base64Variant.withReadPadding(sameBehaviour);
        // Assert
        assertSame(base64Variant, result, "Expected the same instance when the same PaddingReadBehaviour is provided.");
    }
}
