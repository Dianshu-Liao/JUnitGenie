package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.compress.harmony.unpack200.Segment;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.DataOutputStream;
import java.io.IOException;

public class CodeAttribute_getLength_2_3_Test {

    private CodeAttribute codeAttribute;

    @BeforeEach
    public void setUp() {
        Segment segment = mock(Segment.class);
        OperandManager operandManager = mock(OperandManager.class);
        List<ExceptionTableEntry> exceptionTable = new ArrayList<>();
        codeAttribute = new CodeAttribute(10, 5, new byte[] {}, segment, operandManager, exceptionTable);
    }

    @Test
    public void testGetLength_NoAttributes_NoExceptionTable() {
        codeAttribute.codeLength = 100;
        codeAttribute.exceptionTable = new ArrayList<>();
        int expectedLength = 2 + 2 + 4 + 100 + 2 + 0 + 2;
        assertEquals(expectedLength, invokeGetLength());
    }

    @Test
    public void testGetLength_WithAttributes_NoExceptionTable() {
        codeAttribute.codeLength = 100;
        codeAttribute.exceptionTable = new ArrayList<>();
        Attribute mockAttribute = mock(Attribute.class);
        when(mockAttribute.getLengthIncludingHeader()).thenReturn(10);
        codeAttribute.attributes.add(mockAttribute);
        int expectedLength = 2 + 2 + 4 + 100 + 2 + 0 + 2 + 10;
        assertEquals(expectedLength, invokeGetLength());
    }

    @Test
    public void testGetLength_WithAttributes_WithExceptionTable() {
        codeAttribute.codeLength = 100;
        Attribute mockAttribute = mock(Attribute.class);
        when(mockAttribute.getLengthIncludingHeader()).thenReturn(10);
        codeAttribute.attributes.add(mockAttribute);
        ExceptionTableEntry mockEntry = mock(ExceptionTableEntry.class);
        when(mockEntry.getCatchType()).thenReturn(null);
        codeAttribute.exceptionTable.add(mockEntry);
        int expectedLength = 2 + 2 + 4 + 100 + 2 + 1 * (2 + 2 + 2 + 2) + 2 + 10;
        assertEquals(expectedLength, invokeGetLength());
    }

    @Test
    public void testGetLength_WithMultipleExceptionTableEntries() {
        codeAttribute.codeLength = 100;
        Attribute mockAttribute = mock(Attribute.class);
        when(mockAttribute.getLengthIncludingHeader()).thenReturn(10);
        codeAttribute.attributes.add(mockAttribute);
        for (int i = 0; i < 3; i++) {
            ExceptionTableEntry mockEntry = mock(ExceptionTableEntry.class);
            when(mockEntry.getCatchType()).thenReturn(null);
            codeAttribute.exceptionTable.add(mockEntry);
        }
        int expectedLength = 2 + 2 + 4 + 100 + 2 + 3 * (2 + 2 + 2 + 2) + 2 + 10;
        assertEquals(expectedLength, invokeGetLength());
    }

    private int invokeGetLength() {
        try {
            java.lang.reflect.Method method = CodeAttribute.class.getDeclaredMethod("getLength");
            method.setAccessible(true);
            return (int) method.invoke(codeAttribute);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
