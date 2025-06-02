package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class WideForm_setByteCodeOperands_0_0_Test {

    private WideForm wideForm;

    private ByteCode byteCode;

    private OperandManager operandManager;

    @BeforeEach
    public void setUp() {
        wideForm = new WideForm(0, "test");
        // Create a mock ByteCode since the constructor is protected
        byteCode = mock(ByteCode.class);
        // Mocking the opcode
        when(byteCode.getOpcode()).thenReturn(0);
        // Mocking OperandManager
        operandManager = mock(OperandManager.class);
    }

    @Test
    public void testSetByteCodeOperandsFormat1() throws Exception {
        setNextWideByteCode(operandManager, 131);
        wideForm.setByteCodeOperands(byteCode, operandManager, 0);
        int[] expectedRewrite = new int[4];
        expectedRewrite[0] = byteCode.getOpcode();
        expectedRewrite[1] = 131;
        expectedRewrite[2] = 0;
        expectedRewrite[3] = 0;
        verify(byteCode).setRewrite(expectedRewrite);
    }

    @Test
    public void testSetByteCodeOperandsFormat2() throws Exception {
        setNextWideByteCode(operandManager, 132);
        wideForm.setByteCodeOperands(byteCode, operandManager, 0);
        int[] expectedRewrite = new int[6];
        expectedRewrite[0] = byteCode.getOpcode();
        expectedRewrite[1] = 132;
        expectedRewrite[2] = 0;
        expectedRewrite[3] = 0;
        expectedRewrite[4] = 0;
        expectedRewrite[5] = 0;
        verify(byteCode).setRewrite(expectedRewrite);
    }

    private void setNextWideByteCode(OperandManager operandManager, int value) throws Exception {
        Method method = OperandManager.class.getDeclaredMethod("nextWideByteCode");
        method.setAccessible(true);
        when(method.invoke(operandManager)).thenReturn(value);
    }
}
