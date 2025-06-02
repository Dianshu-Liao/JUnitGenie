package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class CPInterfaceMethodRef_hashCode_1_0_Test {

    private CPInterfaceMethodRef ref;

    @BeforeEach
    public void setUp() {
        // Assuming CPClass and CPNameAndType have appropriate constructors or mocks
        CPClass className = mock(CPClass.class);
        CPNameAndType descriptor = mock(CPNameAndType.class);
        ref = new CPInterfaceMethodRef(className, descriptor, 1);
    }

    @Test
    public void testHashCode_NotComputed() throws Exception {
        // Set up the private fields for the test
        Field hashCodeComputedField = CPInterfaceMethodRef.class.getDeclaredField("hashCodeComputed");
        hashCodeComputedField.setAccessible(true);
        // Ensure hashCodeComputed is false
        hashCodeComputedField.set(ref, false);
        // Invoke hashCode() to trigger hash code computation
        Method hashCodeMethod = CPInterfaceMethodRef.class.getDeclaredMethod("hashCode");
        hashCodeMethod.setAccessible(true);
        int result = (int) hashCodeMethod.invoke(ref);
        // Verify that the generateHashCode() method has been called and cachedHashCode is set
        Method generateHashCodeMethod = CPInterfaceMethodRef.class.getDeclaredMethod("generateHashCode");
        generateHashCodeMethod.setAccessible(true);
        // Manually invoke to set cachedHashCode
        generateHashCodeMethod.invoke(ref);
        // Retrieve the cachedHashCode value after generation
        Field cachedHashCodeField = CPInterfaceMethodRef.class.getDeclaredField("cachedHashCode");
        cachedHashCodeField.setAccessible(true);
        int expectedHashCode = (int) cachedHashCodeField.get(ref);
        // Assert that the result matches the expected cached hash code
        assertEquals(expectedHashCode, result);
    }

    @Test
    public void testHashCode_Computed() throws Exception {
        // Set up the private fields for the test
        Field hashCodeComputedField = CPInterfaceMethodRef.class.getDeclaredField("hashCodeComputed");
        hashCodeComputedField.setAccessible(true);
        // Ensure hashCodeComputed is true
        hashCodeComputedField.set(ref, true);
        // Manually set a cachedHashCode value for testing
        Field cachedHashCodeField = CPInterfaceMethodRef.class.getDeclaredField("cachedHashCode");
        cachedHashCodeField.setAccessible(true);
        // Example cached hash code
        cachedHashCodeField.set(ref, 12345);
        // Invoke hashCode() to verify it returns the cached value
        int firstCall = ref.hashCode();
        int secondCall = ref.hashCode();
        // Ensure that the same hash code is returned on subsequent calls
        assertEquals(12345, firstCall);
        assertEquals(firstCall, secondCall);
    }
}
