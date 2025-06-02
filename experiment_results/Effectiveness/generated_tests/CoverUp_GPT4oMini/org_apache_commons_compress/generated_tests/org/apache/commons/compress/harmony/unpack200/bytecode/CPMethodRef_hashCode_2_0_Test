package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPMethodRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPNameAndType;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class CPMethodRef_hashCode_2_0_Test {

    private CPClass className;

    private CPNameAndType descriptor;

    private CPMethodRef cpMethodRef;

    @BeforeEach
    public void setUp() {
        CPUTF8 name = new CPUTF8("TestClass");
        className = new CPClass(name, 1);
        CPUTF8 methodName = new CPUTF8("methodName");
        CPUTF8 methodDescriptor = new CPUTF8("()V");
        descriptor = new CPNameAndType(methodName, methodDescriptor, 2);
        cpMethodRef = new CPMethodRef(className, descriptor, 3);
    }

    @Test
    public void testHashCodeInitiallyComputed() throws Exception {
        int hashCode = cpMethodRef.hashCode();
        assertEquals(hashCode, cpMethodRef.hashCode());
    }

    @Test
    public void testHashCodeAfterModification() throws Exception {
        invokeGenerateHashCode();
        int hashCode = cpMethodRef.hashCode();
        assertEquals(hashCode, cpMethodRef.hashCode());
    }

    private void invokeGenerateHashCode() throws Exception {
        Method method = CPMethodRef.class.getDeclaredMethod("generateHashCode");
        method.setAccessible(true);
        method.invoke(cpMethodRef);
    }
}
