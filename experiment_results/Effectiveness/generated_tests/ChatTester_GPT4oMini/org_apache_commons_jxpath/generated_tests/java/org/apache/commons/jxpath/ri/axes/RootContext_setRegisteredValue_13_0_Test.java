package org.apache.commons.jxpath.ri.axes;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.QName;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RootContext_setRegisteredValue_13_0_Test {

    private RootContext rootContext;

    private JXPathContextReferenceImpl jxpathContext;

    private NodePointer pointer;

    @BeforeEach
    public void setUp() {
        // Fixed the Buggy Line: Added a third parameter to the constructor
        jxpathContext = new JXPathContextReferenceImpl(mock(JXPathContext.class), new Object(), null);
        // Mocking NodePointer
        pointer = mock(NodePointer.class);
        rootContext = new RootContext(jxpathContext, pointer);
    }

    @Test
    public void testSetRegisteredValue_FirstValue() {
        int index = rootContext.setRegisteredValue("TestValue1");
        assertEquals(0, index);
    }

    @Test
    public void testSetRegisteredValue_SecondValue() {
        rootContext.setRegisteredValue("TestValue1");
        int index = rootContext.setRegisteredValue("TestValue2");
        assertEquals(1, index);
    }

    @Test
    public void testSetRegisteredValue_ThirdValue() {
        rootContext.setRegisteredValue("TestValue1");
        rootContext.setRegisteredValue("TestValue2");
        int index = rootContext.setRegisteredValue("TestValue3");
        assertEquals(2, index);
    }

    @Test
    public void testSetRegisteredValue_FourthValue() {
        rootContext.setRegisteredValue("TestValue1");
        rootContext.setRegisteredValue("TestValue2");
        rootContext.setRegisteredValue("TestValue3");
        int index = rootContext.setRegisteredValue("TestValue4");
        assertEquals(3, index);
    }

    @Test
    public void testSetRegisteredValue_ExceedMaxRegisters() {
        rootContext.setRegisteredValue("TestValue1");
        rootContext.setRegisteredValue("TestValue2");
        rootContext.setRegisteredValue("TestValue3");
        rootContext.setRegisteredValue("TestValue4");
        int index = rootContext.setRegisteredValue("TestValue5");
        assertEquals(-1, index);
    }

    @Test
    public void testSetRegisteredValue_InitialNullRegisters() throws Exception {
        // Check that registers are initialized properly
        int index = rootContext.setRegisteredValue("FirstValue");
        assertEquals(0, index);
        assertNotNull(getRegisters()[0]);
        assertEquals("FirstValue", getRegisters()[0]);
    }

    @Test
    public void testSetRegisteredValue_UnknownValueInitialization() throws Exception {
        int index = rootContext.setRegisteredValue("Value1");
        assertEquals(0, index);
        assertEquals("Value1", getRegisters()[0]);
        for (int i = 1; i < 4; i++) {
            assertEquals(RootContext.UNKNOWN_VALUE, getRegisters()[i]);
        }
    }

    // Reflection method to access private registers for testing
    private Object[] getRegisters() throws Exception {
        java.lang.reflect.Field field = RootContext.class.getDeclaredField("registers");
        field.setAccessible(true);
        return (Object[]) field.get(rootContext);
    }
}
