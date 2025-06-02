package org.apache.commons.compress.harmony.pack200;

import org.apache.commons.compress.harmony.pack200.CPFloat;
import org.apache.commons.compress.harmony.pack200.CpBands;
import org.apache.commons.compress.harmony.pack200.PackingUtils;
import org.apache.commons.compress.harmony.pack200.Segment;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Set;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.BiFunction;
import org.objectweb.asm.Type;

public class CpBands_writeCpFloat_23_0_Test {

    private CpBands cpBands;

    private Segment segment;

    @BeforeEach
    public void setUp() {
        segment = new Segment();
        cpBands = new CpBands(segment, 0);
    }

    @Test
    public void testWriteCpFloatWithEmptySet() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        invokeWriteCpFloat(out);
        // Expect no bytes written for empty cp_Float
        assertArrayEquals(new byte[0], out.toByteArray());
    }

    @Test
    public void testWriteCpFloatWithSingleEntry() throws Exception {
        CPFloat cpFloat = new CPFloat(1.5f);
        addCpFloatEntry(cpFloat);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        invokeWriteCpFloat(out);
        // Expected encoded byte array for 1.5f
        byte[] expected = encodeFloatToBytes(new float[] { 1.5f });
        assertArrayEquals(expected, out.toByteArray());
    }

    @Test
    public void testWriteCpFloatWithMultipleEntries() throws Exception {
        addCpFloatEntry(new CPFloat(1.5f));
        addCpFloatEntry(new CPFloat(2.5f));
        addCpFloatEntry(new CPFloat(3.5f));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        invokeWriteCpFloat(out);
        // Expected encoded byte array for 1.5f, 2.5f, 3.5f
        byte[] expected = encodeFloatToBytes(new float[] { 1.5f, 2.5f, 3.5f });
        assertArrayEquals(expected, out.toByteArray());
    }

    private void addCpFloatEntry(CPFloat cpFloat) {
        // Use reflection to access the private Set<CPFloat> cp_Float
        try {
            Set<CPFloat> cpFloatSet = (Set<CPFloat>) CpBands.class.getDeclaredField("cp_Float").get(cpBands);
            cpFloatSet.add(cpFloat);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void invokeWriteCpFloat(OutputStream out) throws Exception {
        Method method = CpBands.class.getDeclaredMethod("writeCpFloat", OutputStream.class);
        method.setAccessible(true);
        method.invoke(cpBands, out);
    }

    private byte[] encodeFloatToBytes(float[] floats) {
        // Simulate the encoding process as in the original method
        int[] intBits = new int[floats.length];
        for (int i = 0; i < floats.length; i++) {
            intBits[i] = Float.floatToIntBits(floats[i]);
        }
        // Here we would normally call the actual encoding method
        // For the sake of this test, we will just return a byte representation
        // of the intBits array (this is a simplification)
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (int intBit : intBits) {
            baos.write(intBit >> 24);
            baos.write(intBit >> 16);
            baos.write(intBit >> 8);
            baos.write(intBit);
        }
        return baos.toByteArray();
    }
}
