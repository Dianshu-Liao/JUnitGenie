package org.apache.commons.compress.harmony.unpack200;

import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.harmony.pack200.Codec;
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
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;

@ExtendWith(MockitoExtension.class)
class CpBands_parseCpClass_29_0_Test {

    private CpBands cpBands;

    private Segment segment;

    private SegmentConstantPool constantPool;

    @BeforeEach
    void setUp() {
        segment = Mockito.mock(Segment.class);
        cpBands = new CpBands(segment);
        constantPool = new SegmentConstantPool(cpBands);
        Mockito.when(segment.getConstantPool()).thenReturn(constantPool);
    }

    @Test
    void testParseCpClass_ValidInput() throws Exception {
        InputStream inputStream = createValidInputStream(3);
        setConstantPoolFields(3, new String[] { "Class1", "Class2", "Class3" });
        invokeParseCpClass(inputStream);
        assertNotNull(cpBands.getCpClass());
        assertEquals(3, cpBands.getCpClass().length);
        assertArrayEquals(new String[] { "Class1", "Class2", "Class3" }, cpBands.getCpClass());
    }

    @Test
    void testParseCpClass_EmptyInput() throws Exception {
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        setConstantPoolFields(0, new String[] {});
        invokeParseCpClass(inputStream);
        assertNotNull(cpBands.getCpClass());
        assertEquals(0, cpBands.getCpClass().length);
    }

    @Test
    void testParseCpClass_InvalidInput() throws Exception {
        InputStream inputStream = null;
        assertThrows(IOException.class, () -> {
            invokeParseCpClass(inputStream);
        });
    }

    private InputStream createValidInputStream(int classCount) {
        byte[] data = new byte[classCount];
        for (int i = 0; i < classCount; i++) {
            data[i] = (byte) ('A' + i);
        }
        return new ByteArrayInputStream(data);
    }

    private void invokeParseCpClass(InputStream inputStream) throws Exception {
        java.lang.reflect.Method method = CpBands.class.getDeclaredMethod("parseCpClass", InputStream.class);
        method.setAccessible(true);
        method.invoke(cpBands, inputStream);
    }

    private void setConstantPoolFields(int classCount, String[] utf8) throws NoSuchFieldException, IllegalAccessException {
        Field classCountField = SegmentConstantPool.class.getDeclaredField("cpClassCount");
        classCountField.setAccessible(true);
        classCountField.set(constantPool, classCount);
        Field utf8Field = SegmentConstantPool.class.getDeclaredField("cpUTF8");
        utf8Field.setAccessible(true);
        utf8Field.set(constantPool, utf8);
    }
}
