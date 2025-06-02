package org.apache.commons.compress.harmony.pack200;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
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
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiFunction;
import org.objectweb.asm.Type;

public class CpBands_writeCpFloat_23_0_Test {

    private CpBands cpBands;

    private Segment segment;

    @BeforeEach
    public void setUp() {
        segment = new Segment();
        // Providing an integer as the second argument
        cpBands = new CpBands(segment, 0);
    }

    @Test
    public void testWriteCpFloat_WithNoFloats() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        invokeWriteCpFloat(byteArrayOutputStream);
        assertEquals(0, byteArrayOutputStream.size());
    }

    @Test
    public void testWriteCpFloat_WithOneFloat() throws Exception {
        addCpFloat(1.0f);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        invokeWriteCpFloat(byteArrayOutputStream);
        assertEquals(4, byteArrayOutputStream.size());
    }

    @Test
    public void testWriteCpFloat_WithMultipleFloats() throws Exception {
        addCpFloat(1.0f);
        addCpFloat(2.0f);
        addCpFloat(3.0f);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        invokeWriteCpFloat(byteArrayOutputStream);
        assertEquals(12, byteArrayOutputStream.size());
    }

    private void invokeWriteCpFloat(OutputStream out) throws Exception {
        Method method = CpBands.class.getDeclaredMethod("writeCpFloat", OutputStream.class);
        method.setAccessible(true);
        method.invoke(cpBands, out);
    }

    private void addCpFloat(float value) {
        try {
            Method method = CpBands.class.getDeclaredMethod("addCpFloat", CPFloat.class);
            method.setAccessible(true);
            method.invoke(cpBands, new CPFloat(value));
        } catch (Exception e) {
            throw new RuntimeException("Failed to add CPFloat", e);
        }
    }
}
