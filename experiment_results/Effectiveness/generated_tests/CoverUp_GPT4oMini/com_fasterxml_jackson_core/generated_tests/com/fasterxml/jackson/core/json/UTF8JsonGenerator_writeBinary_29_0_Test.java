package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.NumberOutput;

class UTF8JsonGenerator_writeBinary_29_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext context = new IOContext(null, null, null, true);
        generator = new UTF8JsonGenerator(context, 0, null, outputStream, '"');
    }

    @Test
    void testWriteBinary_ValidInput() throws Exception {
        Base64Variant variant = new Base64Variant("Base64", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] data = { 1, 2, 3, 4, 5 };
        Method writeBinaryMethod = UTF8JsonGenerator.class.getDeclaredMethod("writeBinary", Base64Variant.class, byte[].class, int.class, int.class);
        writeBinaryMethod.setAccessible(true);
        writeBinaryMethod.invoke(generator, variant, data, 0, data.length);
        byte[] expectedOutput = new byte[] { '"', 'A', 'Q', 'I', 'B', 'A', 'C', 'Q', 'E', 'E', 'C', 'Q', 'E', 'A', 'E', 'A', '"' };
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    void testWriteBinary_EmptyInput() throws Exception {
        Base64Variant variant = new Base64Variant("Base64", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] data = {};
        Method writeBinaryMethod = UTF8JsonGenerator.class.getDeclaredMethod("writeBinary", Base64Variant.class, byte[].class, int.class, int.class);
        writeBinaryMethod.setAccessible(true);
        writeBinaryMethod.invoke(generator, variant, data, 0, data.length);
        byte[] expectedOutput = new byte[] { '"', '"' };
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    void testWriteBinary_NegativeOffset() {
        Base64Variant variant = new Base64Variant("Base64", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] data = { 1, 2, 3 };
        Method writeBinaryMethod = null;
        try {
            writeBinaryMethod = UTF8JsonGenerator.class.getDeclaredMethod("writeBinary", Base64Variant.class, byte[].class, int.class, int.class);
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        }
        writeBinaryMethod.setAccessible(true);
        // Make it effectively final
        final Method finalWriteBinaryMethod = writeBinaryMethod;
        assertThrows(IndexOutOfBoundsException.class, () -> {
            finalWriteBinaryMethod.invoke(generator, variant, data, -1, data.length);
        });
    }

    @Test
    void testWriteBinary_InvalidLength() {
        Base64Variant variant = new Base64Variant("Base64", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] data = { 1, 2, 3 };
        Method writeBinaryMethod = null;
        try {
            writeBinaryMethod = UTF8JsonGenerator.class.getDeclaredMethod("writeBinary", Base64Variant.class, byte[].class, int.class, int.class);
        } catch (NoSuchMethodException e) {
            fail("Method not found: " + e.getMessage());
        }
        writeBinaryMethod.setAccessible(true);
        // Make it effectively final
        final Method finalWriteBinaryMethod = writeBinaryMethod;
        assertThrows(IndexOutOfBoundsException.class, () -> {
            finalWriteBinaryMethod.invoke(generator, variant, data, 0, 5);
        });
    }
}
