package org.apache.commons.compress.compressors.bzip2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorOutputStream;

class BZip2CompressorOutputStream_sendMTFValues_18_3_Test {

    private BZip2CompressorOutputStream compressorOutputStream;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() throws IOException {
        outputStream = new ByteArrayOutputStream();
        compressorOutputStream = new BZip2CompressorOutputStream(outputStream);
    }

    private void setPrivateField(String fieldName, int value) throws Exception {
        Field field = BZip2CompressorOutputStream.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(compressorOutputStream, value);
    }

    @Test
    void testSendMTFValuesWithLowNMTF() throws Exception {
        setPrivateField("nInUse", 5);
        setPrivateField("nMTF", 150);
        invokeSendMTFValues();
        assertNotNull(outputStream.toByteArray());
    }

    @Test
    void testSendMTFValuesWithMediumNMTF() throws Exception {
        setPrivateField("nInUse", 5);
        setPrivateField("nMTF", 500);
        invokeSendMTFValues();
        assertNotNull(outputStream.toByteArray());
    }

    @Test
    void testSendMTFValuesWithHighNMTF() throws Exception {
        setPrivateField("nInUse", 5);
        setPrivateField("nMTF", 1200);
        invokeSendMTFValues();
        assertNotNull(outputStream.toByteArray());
    }

    @Test
    void testSendMTFValuesWithVeryHighNMTF() throws Exception {
        setPrivateField("nInUse", 5);
        setPrivateField("nMTF", 2500);
        invokeSendMTFValues();
        assertNotNull(outputStream.toByteArray());
    }

    @Test
    void testSendMTFValuesWithZeroNMTF() throws Exception {
        setPrivateField("nMTF", 0);
        assertThrows(IOException.class, this::invokeSendMTFValues);
    }

    @Test
    void testSendMTFValuesWithNegativeNMTF() throws Exception {
        setPrivateField("nMTF", -1);
        assertThrows(IOException.class, this::invokeSendMTFValues);
    }

    private void invokeSendMTFValues() throws Exception {
        Method method = BZip2CompressorOutputStream.class.getDeclaredMethod("sendMTFValues");
        method.setAccessible(true);
        method.invoke(compressorOutputStream);
    }
}
