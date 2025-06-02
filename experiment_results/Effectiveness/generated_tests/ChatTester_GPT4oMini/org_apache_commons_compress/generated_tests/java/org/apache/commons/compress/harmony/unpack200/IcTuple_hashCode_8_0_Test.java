package org.apache.commons.compress.harmony.unpack200;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IcTuple_hashCode_8_0_Test {

    private IcTuple icTuple;

    @BeforeEach
    public void setUp() {
        icTuple = new IcTuple("C", 1, "C2", "N", 0, 0, 0, 0);
    }

    @Test
    public void testHashCode_initialCall_generatesHashCode() throws Exception {
        // Invoke the private method using reflection to generate hash code
        Method hashCodeMethod = IcTuple.class.getDeclaredMethod("hashCode");
        hashCodeMethod.setAccessible(true);
        int initialHashCode = (int) hashCodeMethod.invoke(icTuple);
        assertEquals(initialHashCode, icTuple.hashCode(), "Hash code should be consistent on initial call");
    }

    @Test
    public void testHashCode_subsequentCall_returnsCachedHashCode() throws Exception {
        Method hashCodeMethod = IcTuple.class.getDeclaredMethod("hashCode");
        hashCodeMethod.setAccessible(true);
        int firstCallHashCode = (int) hashCodeMethod.invoke(icTuple);
        int secondCallHashCode = (int) hashCodeMethod.invoke(icTuple);
        assertEquals(firstCallHashCode, secondCallHashCode, "Subsequent calls should return the cached hash code");
    }

    @Test
    public void testHashCode_differentInstances_returnsDifferentHashCodes() throws Exception {
        IcTuple anotherIcTuple = new IcTuple("C", 1, "C2", "N", 0, 0, 0, 0);
        Method hashCodeMethod = IcTuple.class.getDeclaredMethod("hashCode");
        hashCodeMethod.setAccessible(true);
        int hashCode1 = (int) hashCodeMethod.invoke(icTuple);
        int hashCode2 = (int) hashCodeMethod.invoke(anotherIcTuple);
        assertNotEquals(hashCode1, hashCode2, "Different instances should have different hash codes");
    }
}
