package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.Base64;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

public class Base64_toUrlSafeEncodeTable_18_0_Test {

    @Test
    public void testToUrlSafeEncodeTable_True() throws Exception {
        byte[] expected = getPrivateField("URL_SAFE_ENCODE_TABLE");
        byte[] actual = invokeToUrlSafeEncodeTable(true);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToUrlSafeEncodeTable_False() throws Exception {
        byte[] expected = getPrivateField("STANDARD_ENCODE_TABLE");
        byte[] actual = invokeToUrlSafeEncodeTable(false);
        assertArrayEquals(expected, actual);
    }

    private byte[] invokeToUrlSafeEncodeTable(boolean urlSafe) throws Exception {
        Method method = Base64.class.getDeclaredMethod("toUrlSafeEncodeTable", boolean.class);
        method.setAccessible(true);
        return (byte[]) method.invoke(null, urlSafe);
    }

    private byte[] getPrivateField(String fieldName) throws Exception {
        java.lang.reflect.Field field = Base64.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return (byte[]) field.get(null);
    }
}
