package org.apache.commons.compress.harmony.unpack200;

import org.apache.commons.compress.harmony.unpack200.CpBands;
import org.apache.commons.compress.harmony.unpack200.Segment;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPDouble;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPFieldRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPFloat;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPInteger;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPInterfaceMethodRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPLong;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPMethodRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPNameAndType;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPString;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CpBands_cpSignatureValue_11_2_Test {

    private CpBands cpBands;

    @BeforeEach
    public void setUp() throws Exception {
        Segment segment = new Segment();
        cpBands = new CpBands(segment);
        // Use reflection to set private fields
        setPrivateField(cpBands, "cpSignature", new String[] { "sig1", "sig2", "sig3" });
        setPrivateField(cpBands, "cpSignatureInts", new int[] { -1, -1, -1 });
        setPrivateField(cpBands, "signatureOffset", 10);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    @Test
    public void testCpSignatureValueWithNegativeIndex() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            cpBands.cpSignatureValue(-1);
        });
    }

    @Test
    public void testCpSignatureValueWithValidIndex() throws Exception {
        CPUTF8 result = cpBands.cpSignatureValue(1);
        assertNotNull(result);
        assertEquals("sig2", getValue(result));
        // 1 + signatureOffset
        assertEquals(11, getGlobalIndex(result));
    }

    @Test
    public void testCpSignatureValueWithPreviouslyComputedValue() throws Exception {
        CPUTF8 firstCall = cpBands.cpSignatureValue(2);
        CPUTF8 secondCall = cpBands.cpSignatureValue(2);
        // Should return the same instance
        assertSame(firstCall, secondCall);
    }

    @Test
    public void testCpSignatureValueWithValidIndexAndExistingGlobalIndex() throws Exception {
        // Set a valid global index
        setPrivateField(cpBands, "cpSignatureInts", new int[] { 5, -1, -1 });
        CPUTF8 result = cpBands.cpSignatureValue(0);
        assertNotNull(result);
        assertEquals("sig1", getValue(result));
        // Should use the existing global index
        assertEquals(5, getGlobalIndex(result));
    }

    @Test
    public void testCpSignatureValueWithInvalidIndex() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            // Index out of bounds
            cpBands.cpSignatureValue(3);
        });
    }

    private String getValue(CPUTF8 cpUtf8) throws Exception {
        Method method = cpUtf8.getClass().getDeclaredMethod("getValue");
        method.setAccessible(true);
        return (String) method.invoke(cpUtf8);
    }

    private int getGlobalIndex(CPUTF8 cpUtf8) throws Exception {
        Method method = cpUtf8.getClass().getDeclaredMethod("getGlobalIndex");
        method.setAccessible(true);
        return (int) method.invoke(cpUtf8);
    }
}
