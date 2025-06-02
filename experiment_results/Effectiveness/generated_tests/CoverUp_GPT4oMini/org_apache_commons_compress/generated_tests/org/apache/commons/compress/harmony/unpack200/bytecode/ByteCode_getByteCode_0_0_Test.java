package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode;
import org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteCodeForm;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataOutputStream;
import java.io.IOException;
import org.apache.commons.compress.harmony.unpack200.Segment;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ByteCode_getByteCode_0_0_Test {

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        // Reset the static noArgByteCodes array before each test
        Field field = ByteCode.class.getDeclaredField("noArgByteCodes");
        field.setAccessible(true);
        ByteCode[] noArgByteCodes = (ByteCode[]) field.get(null);
        for (int i = 0; i < 255; i++) {
            noArgByteCodes[i] = null;
        }
    }

    @Test
    void testGetByteCode_NoOperand() {
        // Assuming that ByteCodeForm.get(byteOpcode).hasNoOperand() returns true for opcode 0
        int opcode = 0;
        ByteCode byteCode = ByteCode.getByteCode(opcode);
        assertNotNull(byteCode);
        assertEquals(opcode, byteCode.getOpcode());
    }

    @Test
    void testGetByteCode_WithOperand() {
        // Assuming that ByteCodeForm.get(byteOpcode).hasNoOperand() returns false for opcode 1
        int opcode = 1;
        ByteCode byteCode = ByteCode.getByteCode(opcode);
        assertNotNull(byteCode);
        assertEquals(opcode, byteCode.getOpcode());
    }

    @Test
    void testGetByteCode_CachesNoOperandByteCode() {
        // Test to ensure caching behavior for no operand bytecode
        int opcode = 0;
        ByteCode firstCall = ByteCode.getByteCode(opcode);
        ByteCode secondCall = ByteCode.getByteCode(opcode);
        assertSame(firstCall, secondCall, "Both calls should return the same instance for no operand bytecode.");
    }

    @Test
    void testGetByteCode_DifferentOpcodes() {
        // Test to ensure that different opcodes return different instances
        ByteCode byteCode1 = ByteCode.getByteCode(0);
        ByteCode byteCode2 = ByteCode.getByteCode(1);
        assertNotSame(byteCode1, byteCode2, "Different opcodes should return different instances.");
    }

    @Test
    void testGetByteCode_OpcodeOutOfRange() {
        // Test for edge case of opcode out of range
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            // 256 is out of bounds for the noArgByteCodes array
            ByteCode.getByteCode(256);
        });
    }
}
