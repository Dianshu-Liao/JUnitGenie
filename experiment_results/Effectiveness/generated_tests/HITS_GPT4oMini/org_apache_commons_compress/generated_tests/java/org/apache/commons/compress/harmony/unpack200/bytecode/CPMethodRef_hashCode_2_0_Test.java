package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class CPMethodRef_hashCode_2_0_Test {

    private CPClass mockClassName;

    private CPNameAndType mockNameAndType;

    private CPMethodRef methodRef;

    @BeforeEach
    public void setUp() {
        CPUTF8 mockUtf8Name = new CPUTF8("MockClassName");
        CPUTF8 mockUtf8Descriptor = new CPUTF8("MockDescriptor");
        mockClassName = new CPClass(mockUtf8Name, 1);
        mockNameAndType = new CPNameAndType(mockUtf8Name, mockUtf8Descriptor, 1);
        methodRef = new CPMethodRef(mockClassName, mockNameAndType, 1);
    }

    @Test
    public void testHashCode_initialCall() {
        int expectedHashCode = 31 * mockClassName.hashCode() + mockNameAndType.hashCode();
        assertEquals(expectedHashCode, methodRef.hashCode());
    }

    @Test
    public void testHashCode_subsequentCalls() {
        int firstCallHashCode = methodRef.hashCode();
        int secondCallHashCode = methodRef.hashCode();
        assertEquals(firstCallHashCode, secondCallHashCode);
    }

    @Test
    public void testHashCode_differentInstances() {
        CPUTF8 anotherUtf8Name = new CPUTF8("AnotherClassName");
        CPUTF8 anotherUtf8Descriptor = new CPUTF8("AnotherDescriptor");
        CPClass anotherMockClassName = new CPClass(anotherUtf8Name, 2);
        CPNameAndType anotherMockNameAndType = new CPNameAndType(anotherUtf8Name, anotherUtf8Descriptor, 2);
        CPMethodRef anotherMethodRef = new CPMethodRef(anotherMockClassName, anotherMockNameAndType, 2);
        assertNotEquals(methodRef.hashCode(), anotherMethodRef.hashCode());
    }

    @Test
    public void testHashCode_sameValues() {
        CPMethodRef sameMethodRef = new CPMethodRef(mockClassName, mockNameAndType, 1);
        assertEquals(methodRef.hashCode(), sameMethodRef.hashCode());
    }
}
