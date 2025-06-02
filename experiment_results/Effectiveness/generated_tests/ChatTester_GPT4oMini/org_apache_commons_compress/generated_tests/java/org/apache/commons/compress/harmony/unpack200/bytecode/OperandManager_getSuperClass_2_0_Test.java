package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.harmony.unpack200.Segment;
import org.apache.commons.compress.harmony.unpack200.SegmentConstantPool;

public class OperandManager_getSuperClass_2_0_Test {

    private OperandManager operandManager;

    @BeforeEach
    public void setUp() {
        // Initialize the OperandManager with dummy data
        int[] bcCaseCount = new int[0];
        int[] bcCaseValue = new int[0];
        int[] bcByte = new int[0];
        int[] bcShort = new int[0];
        int[] bcLocal = new int[0];
        int[] bcLabel = new int[0];
        int[] bcIntRef = new int[0];
        int[] bcFloatRef = new int[0];
        int[] bcLongRef = new int[0];
        int[] bcDoubleRef = new int[0];
        int[] bcStringRef = new int[0];
        int[] bcClassRef = new int[0];
        int[] bcFieldRef = new int[0];
        int[] bcMethodRef = new int[0];
        int[] bcIMethodRef = new int[0];
        int[] bcThisField = new int[0];
        int[] bcSuperField = new int[0];
        int[] bcThisMethod = new int[0];
        int[] bcSuperMethod = new int[0];
        int[] bcInitRef = new int[0];
        int[] wideByteCodes = new int[0];
        operandManager = new OperandManager(bcCaseCount, bcCaseValue, bcByte, bcShort, bcLocal, bcLabel, bcIntRef, bcFloatRef, bcLongRef, bcDoubleRef, bcStringRef, bcClassRef, bcFieldRef, bcMethodRef, bcIMethodRef, bcThisField, bcSuperField, bcThisMethod, bcSuperMethod, bcInitRef, wideByteCodes);
    }

    @Test
    public void testGetSuperClassThrowsErrorWhenSuperClassIsNull() {
        Error exception = assertThrows(Error.class, () -> {
            operandManager.getSuperClass();
        });
        assertEquals("SuperClass not set yet", exception.getMessage());
    }

    @Test
    public void testGetSuperClassReturnsSuperClassWhenSet() throws Exception {
        // Use reflection to set the private field superClass
        java.lang.reflect.Field superClassField = OperandManager.class.getDeclaredField("superClass");
        superClassField.setAccessible(true);
        superClassField.set(operandManager, "MySuperClass");
        String result = operandManager.getSuperClass();
        assertEquals("MySuperClass", result);
    }
}
