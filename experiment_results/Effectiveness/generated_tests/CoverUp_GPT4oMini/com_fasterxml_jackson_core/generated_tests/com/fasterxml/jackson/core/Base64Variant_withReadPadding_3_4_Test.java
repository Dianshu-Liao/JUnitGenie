package com.fasterxml.jackson.core;

import java.lang.reflect.Field;
import com.fasterxml.jackson.core.Base64Variant.PaddingReadBehaviour;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;

class Base64Variant_withReadPadding_3_4_Test {

    private Base64Variant base64Variant;

    private Base64Variant base64VariantWithDifferentPadding;

    private PaddingReadBehaviour paddingReadBehaviour1;

    private PaddingReadBehaviour paddingReadBehaviour2;

    @BeforeEach
    void setUp() {
        paddingReadBehaviour1 = PaddingReadBehaviour.PADDING_REQUIRED;
        paddingReadBehaviour2 = PaddingReadBehaviour.PADDING_FORBIDDEN;
        base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        base64VariantWithDifferentPadding = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
    }

    @Test
    void testWithReadPaddingSameBehaviour() throws Exception {
        Base64Variant result = base64Variant.withReadPadding(paddingReadBehaviour1);
        assertSame(base64Variant, result, "Expected the same instance to be returned");
    }

    @Test
    void testWithReadPaddingDifferentBehaviour() throws Exception {
        Base64Variant result = base64Variant.withReadPadding(paddingReadBehaviour2);
        assertNotSame(base64Variant, result, "Expected a new instance to be created");
        // Using reflection to access private fields
        assertEquals(paddingReadBehaviour2, getPrivateField(result, "_paddingReadBehaviour"));
    }

    private Object getPrivateField(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
