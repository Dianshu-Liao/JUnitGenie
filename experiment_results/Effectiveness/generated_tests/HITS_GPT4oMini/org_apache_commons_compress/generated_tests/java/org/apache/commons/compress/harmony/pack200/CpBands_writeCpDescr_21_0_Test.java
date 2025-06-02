package org.apache.commons.compress.harmony.pack200;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.BiFunction;
import org.objectweb.asm.Type;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CpBands_writeCpDescr_21_0_Test {

    private CpBands cpBands;

    private OutputStream outputStream;

    private Segment segment;

    @BeforeEach
    public void setUp() {
        // Create a new Segment object
        segment = new Segment();
        cpBands = new CpBands(segment, 0);
        outputStream = mock(OutputStream.class);
    }

    @Test
    public void testWriteCpDescr_EmptyDescriptor() throws Exception {
        // Act
        invokeWriteCpDescr(outputStream);
        // Assert
        verify(outputStream, times(1)).write(any(byte[].class));
    }

    @Test
    public void testWriteCpDescr_SingleDescriptor() throws Exception {
        // Arrange
        CPUTF8 name = mock(CPUTF8.class);
        CPSignature signature = mock(CPSignature.class);
        when(name.getIndex()).thenReturn(1);
        when(signature.getIndex()).thenReturn(2);
        CPNameAndType cpNameAndType = new CPNameAndType(name, signature);
        // Use reflection to add the descriptor to cp_Descr
        Field cpDescrField = CpBands.class.getDeclaredField("cp_Descr");
        cpDescrField.setAccessible(true);
        Set<CPNameAndType> cpDescrSet = (Set<CPNameAndType>) cpDescrField.get(cpBands);
        cpDescrSet.add(cpNameAndType);
        // Capture the output
        ArgumentCaptor<byte[]> byteArrayCaptor = ArgumentCaptor.forClass(byte[].class);
        // Act
        invokeWriteCpDescr(outputStream);
        // Assert
        verify(outputStream, times(2)).write(byteArrayCaptor.capture());
        List<byte[]> capturedBytes = byteArrayCaptor.getAllValues();
        // Validate the captured byte arrays
        byte[] expectedNameBytes = cpBands.encodeBandInt("cp_Descr_Name", new int[] { 1 }, Codec.DELTA5);
        byte[] expectedTypeBytes = cpBands.encodeBandInt("cp_Descr_Type", new int[] { 2 }, Codec.UDELTA5);
        assertArrayEquals(expectedNameBytes, capturedBytes.get(0));
        assertArrayEquals(expectedTypeBytes, capturedBytes.get(1));
    }

    private void invokeWriteCpDescr(OutputStream out) throws Exception {
        Method method = CpBands.class.getDeclaredMethod("writeCpDescr", OutputStream.class);
        method.setAccessible(true);
        method.invoke(cpBands, out);
    }
}
