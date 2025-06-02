package org.apache.commons.compress.harmony.unpack200;

import java.lang.reflect.Field;
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

public class IcTuple_computeOuterIsAnonymous_0_0_Test {

    private IcTuple icTuple;

    @BeforeEach
    public void setUp() {
        icTuple = new IcTuple("OuterClass", 0, "InnerClass", null, 0, 0, 0, 0);
    }

    @Test
    public void testComputeOuterIsAnonymous_WhenCachedOuterClassStringIsEmpty_ShouldThrowError() {
        setCachedOuterClassString(icTuple, "");
        Error error = assertThrows(Error.class, () -> {
            invokeComputeOuterIsAnonymous(icTuple);
        });
        assertEquals("Should have an outer before checking if it's anonymous", error.getMessage());
    }

    @Test
    public void testComputeOuterIsAnonymous_WhenOuterIsAnonymous_ShouldReturnTrue() {
        setCachedOuterClassString(icTuple, "OuterClass$123");
        assertTrue(invokeComputeOuterIsAnonymous(icTuple));
    }

    @Test
    public void testComputeOuterIsAnonymous_WhenOuterIsNotAnonymous_ShouldReturnFalse() {
        setCachedOuterClassString(icTuple, "OuterClass$InnerClass");
        assertFalse(invokeComputeOuterIsAnonymous(icTuple));
    }

    @Test
    public void testComputeOuterIsAnonymous_WhenOuterClassHasMultipleDollarSigns_ShouldReturnTrue() {
        setCachedOuterClassString(icTuple, "OuterClass$InnerClass$456");
        assertTrue(invokeComputeOuterIsAnonymous(icTuple));
    }

    @Test
    public void testComputeOuterIsAnonymous_WhenOuterClassHasNoDigits_ShouldReturnFalse() {
        setCachedOuterClassString(icTuple, "OuterClass$InnerClass$Something");
        assertFalse(invokeComputeOuterIsAnonymous(icTuple));
    }

    @Test
    public void testComputeOuterIsAnonymous_WhenOuterClassIsNull_ShouldThrowError() {
        setCachedOuterClassString(icTuple, null);
        Error error = assertThrows(Error.class, () -> {
            invokeComputeOuterIsAnonymous(icTuple);
        });
        assertEquals("Should have an outer before checking if it's anonymous", error.getMessage());
    }

    private void setCachedOuterClassString(IcTuple icTuple, String value) {
        try {
            Field field = IcTuple.class.getDeclaredField("cachedOuterClassString");
            field.setAccessible(true);
            field.set(icTuple, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean invokeComputeOuterIsAnonymous(IcTuple icTuple) {
        try {
            Method method = IcTuple.class.getDeclaredMethod("computeOuterIsAnonymous");
            method.setAccessible(true);
            return (Boolean) method.invoke(icTuple);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
