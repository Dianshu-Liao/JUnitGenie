package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.QName;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class RootContext_setRegisteredValue_13_0_Test {

    private RootContext rootContext;

    private JXPathContextReferenceImpl jxpathContext;

    private NodePointer nodePointer;

    @BeforeEach
    public void setUp() {
        jxpathContext = Mockito.mock(JXPathContextReferenceImpl.class);
        nodePointer = Mockito.mock(NodePointer.class);
        rootContext = new RootContext(jxpathContext, nodePointer);
    }

    private Object[] getRegisters() throws Exception {
        Field registersField = RootContext.class.getDeclaredField("registers");
        registersField.setAccessible(true);
        return (Object[]) registersField.get(rootContext);
    }

    @Test
    public void testSetRegisteredValue_FirstTimeInitialization() throws Exception {
        int index = rootContext.setRegisteredValue("TestValue");
        assertEquals(0, index);
        Object[] registers = getRegisters();
        assertEquals("TestValue", registers[0]);
        assertEquals(RootContext.UNKNOWN_VALUE, registers[1]);
        assertEquals(RootContext.UNKNOWN_VALUE, registers[2]);
        assertEquals(RootContext.UNKNOWN_VALUE, registers[3]);
    }

    @Test
    public void testSetRegisteredValue_SecondValue() throws Exception {
        rootContext.setRegisteredValue("FirstValue");
        int index = rootContext.setRegisteredValue("SecondValue");
        assertEquals(1, index);
        Object[] registers = getRegisters();
        assertEquals("SecondValue", registers[1]);
    }

    @Test
    public void testSetRegisteredValue_ExceedMaxRegisters() throws Exception {
        rootContext.setRegisteredValue("Value1");
        rootContext.setRegisteredValue("Value2");
        rootContext.setRegisteredValue("Value3");
        rootContext.setRegisteredValue("Value4");
        int index = rootContext.setRegisteredValue("Value5");
        assertEquals(-1, index);
    }

    @Test
    public void testSetRegisteredValue_AfterExceedingMaxRegisters() throws Exception {
        rootContext.setRegisteredValue("Value1");
        rootContext.setRegisteredValue("Value2");
        rootContext.setRegisteredValue("Value3");
        rootContext.setRegisteredValue("Value4");
        rootContext.setRegisteredValue("Value5");
        int index = rootContext.setRegisteredValue("Value6");
        assertEquals(-1, index);
    }
}
