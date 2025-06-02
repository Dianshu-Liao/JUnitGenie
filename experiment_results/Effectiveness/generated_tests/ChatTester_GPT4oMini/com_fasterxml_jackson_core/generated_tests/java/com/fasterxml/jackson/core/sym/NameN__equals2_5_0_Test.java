package com.fasterxml.jackson.core.sym;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

public class NameN__equals2_5_0_Test {

    private NameN nameN;

    @BeforeEach
    public void setUp() {
        // Assuming qlen = 8 and q = {1, 2, 3, 4}
        // Example initialization
        int[] quads = { 1, 2, 3, 4, 5, 6, 7, 8 };
        nameN = new NameN("Test", 0, 1, 2, 3, 4, quads, 8);
    }

    @Test
    public void test_Equals2_MatchingArrays() throws Exception {
        // Should match
        int[] quads = { 0, 0, 0, 0, 1, 2, 3, 4 };
        boolean result = invokeEquals2(quads);
        assertTrue(result);
    }

    @Test
    public void test_Equals2_NonMatchingArrays() throws Exception {
        // Should not match
        int[] quads = { 0, 0, 0, 0, 5, 6, 7, 8 };
        boolean result = invokeEquals2(quads);
        assertFalse(result);
    }

    @Test
    public void test_Equals2_EmptyArray() throws Exception {
        // Should not match since qlen = 8
        int[] quads = {};
        boolean result = invokeEquals2(quads);
        assertFalse(result);
    }

    @Test
    public void test_Equals2_ShortArray() throws Exception {
        // Should not match since length is less than expected
        int[] quads = { 0, 0, 0, 0 };
        boolean result = invokeEquals2(quads);
        assertFalse(result);
    }

    @Test
    public void test_Equals2_ExactMatch() throws Exception {
        // Should match exactly
        int[] quads = { 0, 0, 0, 0, 1, 2, 3, 4 };
        boolean result = invokeEquals2(quads);
        assertTrue(result);
    }

    @Test
    public void test_Equals2_OneMismatch() throws Exception {
        // Should not match (last element mismatch)
        int[] quads = { 0, 0, 0, 0, 1, 2, 3, 5 };
        boolean result = invokeEquals2(quads);
        assertFalse(result);
    }

    private boolean invokeEquals2(int[] quads) throws Exception {
        Method method = NameN.class.getDeclaredMethod("_equals2", int[].class);
        method.setAccessible(true);
        return (boolean) method.invoke(nameN, (Object) quads);
    }
}
