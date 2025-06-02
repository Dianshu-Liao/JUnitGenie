package org.apache.commons.compress.compressors.lzma;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.compress.utils.OsgiUtils;

public class LZMAUtils_matches_9_0_Test {

    @Test
    public void testMatches_ValidSignature_ReturnsTrue() throws Exception {
        byte[] validSignature = { (byte) 0x5D, 0, 0 };
        int length = validSignature.length;
        boolean result = invokeMatches(validSignature, length);
        assertTrue(result);
    }

    @Test
    public void testMatches_ShortSignature_ReturnsFalse() throws Exception {
        byte[] shortSignature = { (byte) 0x5D };
        int length = shortSignature.length;
        boolean result = invokeMatches(shortSignature, length);
        assertFalse(result);
    }

    @Test
    public void testMatches_InvalidSignature_ReturnsFalse() throws Exception {
        // Last byte is different
        byte[] invalidSignature = { (byte) 0x5D, 0, 1 };
        int length = invalidSignature.length;
        boolean result = invokeMatches(invalidSignature, length);
        assertFalse(result);
    }

    @Test
    public void testMatches_EmptySignature_ReturnsFalse() throws Exception {
        byte[] emptySignature = {};
        int length = emptySignature.length;
        boolean result = invokeMatches(emptySignature, length);
        assertFalse(result);
    }

    private boolean invokeMatches(byte[] signature, int length) throws Exception {
        Method method = LZMAUtils.class.getDeclaredMethod("matches", byte[].class, int.class);
        method.setAccessible(true);
        return (boolean) method.invoke(null, signature, length);
    }
}
