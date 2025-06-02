package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.QName;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class RootContext_setRegisteredValue_13_0_Test {

    private JXPathContextReferenceImpl jxpathContext;

    private NodePointer pointer;

    private RootContext rootContext;

    @BeforeEach
    void setUp() {
        // Mocking JXPathContextReferenceImpl with required parameters
        JXPathContext mockContext = mock(JXPathContext.class);
        jxpathContext = new JXPathContextReferenceImpl(mockContext, new Object(), null);
        pointer = null;
        rootContext = new RootContext(jxpathContext, pointer);
    }

    @Test
    void testSetRegisteredValueWhenRegistersIsNull() {
        int index = rootContext.setRegisteredValue("TestValue");
        assertEquals(0, index);
    }

    @Test
    void testSetRegisteredValueWhenRegistersIsInitialized() {
        rootContext.setRegisteredValue("FirstValue");
        int index = rootContext.setRegisteredValue("SecondValue");
        assertEquals(1, index);
    }

    @Test
    void testSetRegisteredValueWhenMaxRegisterReached() {
        rootContext.setRegisteredValue("Value1");
        rootContext.setRegisteredValue("Value2");
        rootContext.setRegisteredValue("Value3");
        rootContext.setRegisteredValue("Value4");
        // Should exceed max
        int index = rootContext.setRegisteredValue("Value5");
        assertEquals(-1, index);
    }

    @Test
    void testSetRegisteredValueWithUnknownValue() throws Exception {
        // Accessing private field 'registers' using reflection
        Field registersField = RootContext.class.getDeclaredField("registers");
        registersField.setAccessible(true);
        rootContext.setRegisteredValue("Value1");
        Object[] registers = (Object[]) registersField.get(rootContext);
        assertEquals("Value1", registers[0]);
        assertEquals(RootContext.UNKNOWN_VALUE, registers[1]);
    }

    @Test
    void testSetRegisteredValueWithNullValue() {
        int index = rootContext.setRegisteredValue(null);
        assertEquals(0, index);
    }

    @Test
    void testSetRegisteredValueWithMultipleNulls() {
        rootContext.setRegisteredValue(null);
        rootContext.setRegisteredValue(null);
        int index = rootContext.setRegisteredValue(null);
        assertEquals(2, index);
    }
}
