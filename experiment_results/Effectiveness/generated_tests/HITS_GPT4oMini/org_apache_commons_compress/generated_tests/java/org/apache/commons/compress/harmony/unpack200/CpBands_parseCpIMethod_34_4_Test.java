package org.apache.commons.compress.harmony.unpack200;

import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
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

class CpBands_parseCpIMethod_34_4_Test {

    private CpBands cpBands;

    private Segment segment;

    @BeforeEach
    void setUp() {
        segment = Mockito.mock(Segment.class);
        cpBands = new CpBands(segment);
    }

    @Test
    void testParseCpIMethod_ValidInput() throws Exception {
        String inputData = "valid_input_data";
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        SegmentHeader mockedHeader = Mockito.mock(SegmentHeader.class);
        Mockito.when(mockedHeader.getCpIMethodCount()).thenReturn(2);
        Mockito.when(segment.getSegmentHeader()).thenReturn(mockedHeader);
        invokePrivateMethod(cpBands, "parseCpIMethod", inputStream);
        String[] cpIMethodClass = (String[]) getFieldValue(cpBands, "cpIMethodClass");
        String[] cpIMethodDescriptor = (String[]) getFieldValue(cpBands, "cpIMethodDescriptor");
        assertNotNull(cpIMethodClass);
        assertNotNull(cpIMethodDescriptor);
        assertEquals(2, cpIMethodClass.length);
        assertEquals(2, cpIMethodDescriptor.length);
    }

    @Test
    void testParseCpIMethod_EmptyInput() {
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        assertThrows(IOException.class, () -> {
            invokePrivateMethod(cpBands, "parseCpIMethod", inputStream);
        });
    }

    @Test
    void testParseCpIMethod_InvalidData() {
        String invalidData = "invalid_data";
        InputStream inputStream = new ByteArrayInputStream(invalidData.getBytes());
        assertThrows(Pack200Exception.class, () -> {
            invokePrivateMethod(cpBands, "parseCpIMethod", inputStream);
        });
    }

    @Test
    void testParseCpIMethod_NullInput() {
        assertThrows(NullPointerException.class, () -> {
            invokePrivateMethod(cpBands, "parseCpIMethod", null);
        });
    }

    private Object getFieldValue(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void invokePrivateMethod(Object obj, String methodName, Object... args) throws Exception {
        Class<?>[] argTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass();
        }
        Method method = obj.getClass().getDeclaredMethod(methodName, argTypes);
        method.setAccessible(true);
        method.invoke(obj, args);
    }
}
