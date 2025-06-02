package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class CPInterfaceMethodRef_hashCode_1_0_Test {

    private CPClass className;

    private CPUTF8 name;

    private CPUTF8 descriptor;

    private CPNameAndType nameAndType;

    private CPInterfaceMethodRef methodRef;

    @BeforeEach
    public void setUp() {
        name = new CPUTF8("methodName");
        descriptor = new CPUTF8("methodDescriptor");
        nameAndType = new CPNameAndType(name, descriptor, 1);
        className = new CPClass(name, 1);
        methodRef = new CPInterfaceMethodRef(className, nameAndType, 1);
    }

    @Test
    public void testHashCode_WhenCalledFirstTime_ShouldComputeHashCode() {
        int hashCode = methodRef.hashCode();
        assertEquals(hashCode, methodRef.hashCode(), "Hash code should be computed and consistent.");
    }

    @Test
    public void testHashCode_WhenCalledMultipleTimes_ShouldReturnSameHashCode() {
        int firstCall = methodRef.hashCode();
        int secondCall = methodRef.hashCode();
        assertEquals(firstCall, secondCall, "Hash code should remain the same on subsequent calls.");
    }

    @Test
    public void testHashCode_WhenDifferentInstances_ShouldReturnDifferentHashCodes() {
        CPClass anotherClassName = new CPClass(new CPUTF8("anotherMethodName"), 2);
        CPNameAndType anotherNameAndType = new CPNameAndType(new CPUTF8("anotherMethodName"), new CPUTF8("anotherMethodDescriptor"), 2);
        CPInterfaceMethodRef anotherMethodRef = new CPInterfaceMethodRef(anotherClassName, anotherNameAndType, 2);
        int hashCode1 = methodRef.hashCode();
        int hashCode2 = anotherMethodRef.hashCode();
        assertNotEquals(hashCode1, hashCode2, "Different instances should produce different hash codes.");
    }
}
