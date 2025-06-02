package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

public class CPClass_equals_0_0_Test {

    private CPUTF8 utf8Instance1;

    private CPUTF8 utf8Instance2;

    private CPClass cpClass1;

    private CPClass cpClass2;

    private CPClass cpClass3;

    @BeforeEach
    public void setUp() {
        utf8Instance1 = new CPUTF8("TestName1");
        utf8Instance2 = new CPUTF8("TestName2");
        cpClass1 = new CPClass(utf8Instance1, 1);
        cpClass2 = new CPClass(utf8Instance1, 2);
        cpClass3 = new CPClass(utf8Instance2, 3);
    }

    @Test
    public void testEquals_SameInstance() {
        assertTrue(cpClass1.equals(cpClass1), "Same instance should be equal");
    }

    @Test
    public void testEquals_NullObject() {
        assertFalse(cpClass1.equals(null), "Should not be equal to null");
    }

    @Test
    public void testEquals_DifferentClass() {
        assertFalse(cpClass1.equals("String"), "Should not be equal to different class");
    }

    @Test
    public void testEquals_SameUtf8() {
        assertTrue(cpClass1.equals(cpClass2), "Should be equal with same utf8");
    }

    @Test
    public void testEquals_DifferentUtf8() {
        assertFalse(cpClass1.equals(cpClass3), "Should not be equal with different utf8");
    }
}
