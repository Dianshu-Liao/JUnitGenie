package org.apache.commons.compress.harmony.unpack200.bytecode.forms;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager;

public class TableSwitchForm_setByteCodeOperands_0_0_Test {

    private TableSwitchForm tableSwitchForm;

    private ByteCode byteCode;

    private OperandManager operandManager;

    @BeforeEach
    public void setUp() {
        tableSwitchForm = new TableSwitchForm(0, "Test");
        byteCode = mock(ByteCode.class);
        operandManager = mock(OperandManager.class);
    }

    @Test
    public void testSetByteCodeOperands_withNoCases() {
        when(operandManager.nextCaseCount()).thenReturn(0);
        when(operandManager.nextLabel()).thenReturn(1);
        when(operandManager.nextCaseValues()).thenReturn(0);
        tableSwitchForm.setByteCodeOperands(byteCode, operandManager, 0);
        verify(byteCode).setByteCodeTargets(new int[] { 1 });
        verify(byteCode).setRewrite(argThat(rewrite -> rewrite.length == 5 && rewrite[0] == byteCode.getOpcode()));
    }

    @Test
    public void testSetByteCodeOperands_withMultipleCases() {
        when(operandManager.nextCaseCount()).thenReturn(3);
        when(operandManager.nextLabel()).thenReturn(1, 2, 3, 4);
        when(operandManager.nextCaseValues()).thenReturn(5);
        tableSwitchForm.setByteCodeOperands(byteCode, operandManager, 0);
        verify(byteCode).setByteCodeTargets(new int[] { 1, 2, 3, 4 });
        verify(byteCode).setRewrite(argThat(rewrite -> rewrite.length == 13 && rewrite[0] == byteCode.getOpcode()));
    }

    @Test
    public void testSetByteCodeOperands_withPadding() {
        when(operandManager.nextCaseCount()).thenReturn(2);
        when(operandManager.nextLabel()).thenReturn(1, 2, 3);
        when(operandManager.nextCaseValues()).thenReturn(6);
        // codeLength is 1
        tableSwitchForm.setByteCodeOperands(byteCode, operandManager, 1);
        verify(byteCode).setByteCodeTargets(new int[] { 1, 2, 3 });
        verify(byteCode).setRewrite(argThat(rewrite -> rewrite.length == 11 && rewrite[0] == byteCode.getOpcode()));
    }

    @Test
    public void testSetByteCodeOperands_withHighCodeLength() {
        when(operandManager.nextCaseCount()).thenReturn(1);
        when(operandManager.nextLabel()).thenReturn(1, 2);
        when(operandManager.nextCaseValues()).thenReturn(7);
        // codeLength is 3
        tableSwitchForm.setByteCodeOperands(byteCode, operandManager, 3);
        verify(byteCode).setByteCodeTargets(new int[] { 1, 2 });
        verify(byteCode).setRewrite(argThat(rewrite -> rewrite.length == 9 && rewrite[0] == byteCode.getOpcode()));
    }

    // Helper method to invoke private methods using reflection
    private void invokePrivateMethod(String methodName, Object... args) throws Exception {
        Method method = TableSwitchForm.class.getDeclaredMethod(methodName, int.class, int[].class);
        method.setAccessible(true);
        method.invoke(tableSwitchForm, args);
    }
}
