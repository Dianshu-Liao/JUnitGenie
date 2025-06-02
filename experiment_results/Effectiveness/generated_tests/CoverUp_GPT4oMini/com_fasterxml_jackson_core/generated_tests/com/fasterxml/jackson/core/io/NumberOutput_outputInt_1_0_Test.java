package com.fasterxml.jackson.core.io;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;

public class NumberOutput_outputInt_1_0_Test {

    private static NumberOutput numberOutput;

    @BeforeAll
    public static void setUp() {
        numberOutput = new NumberOutput();
    }

    @Test
    public void testOutputInt_NegativeMinValue() throws Exception {
        byte[] output = new byte[20];
        int off = invokeOutputInt(Integer.MIN_VALUE, output, 0);
        assertArrayEquals("-2147483648".getBytes(), getOutputBytes(output, off));
    }

    @Test
    public void testOutputInt_NegativeSmallValue() throws Exception {
        byte[] output = new byte[20];
        int off = invokeOutputInt(-5, output, 0);
        assertArrayEquals("-5".getBytes(), getOutputBytes(output, off));
    }

    @Test
    public void testOutputInt_SmallValue() throws Exception {
        byte[] output = new byte[20];
        int off = invokeOutputInt(5, output, 0);
        assertArrayEquals("5".getBytes(), getOutputBytes(output, off));
    }

    @Test
    public void testOutputInt_LessThanThousand() throws Exception {
        byte[] output = new byte[20];
        int off = invokeOutputInt(999, output, 0);
        assertArrayEquals("999".getBytes(), getOutputBytes(output, off));
    }

    @Test
    public void testOutputInt_ThousandToMillion() throws Exception {
        byte[] output = new byte[20];
        int off = invokeOutputInt(1000, output, 0);
        assertArrayEquals("1000".getBytes(), getOutputBytes(output, off));
    }

    @Test
    public void testOutputInt_Billion() throws Exception {
        byte[] output = new byte[20];
        int off = invokeOutputInt(1000000000, output, 0);
        assertArrayEquals("1000000000".getBytes(), getOutputBytes(output, off));
    }

    @Test
    public void testOutputInt_AboveBillion() throws Exception {
        byte[] output = new byte[20];
        int off = invokeOutputInt(2000000000, output, 0);
        assertArrayEquals("2000000000".getBytes(), getOutputBytes(output, off));
    }

    private int invokeOutputInt(int v, byte[] b, int off) throws Exception {
        Method method = NumberOutput.class.getDeclaredMethod("outputInt", int.class, byte[].class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(null, v, b, off);
    }

    private byte[] getOutputBytes(byte[] output, int length) {
        byte[] result = new byte[length];
        System.arraycopy(output, 0, result, 0, length);
        return result;
    }
}
