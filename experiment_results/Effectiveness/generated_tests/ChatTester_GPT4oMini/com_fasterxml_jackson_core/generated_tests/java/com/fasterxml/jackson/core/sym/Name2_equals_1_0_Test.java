package com.fasterxml.jackson.core.sym;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class Name2_equals_1_0_Test {

    private Name2 name2;

    @BeforeEach
    public void setUp() {
        // Initializing the Name2 instance with specific values for q1 and q2
        // Example values for name and hash
        name2 = new Name2("TestName", 123, 1, 2);
    }

    @Test
    public void testEquals_SameValues() throws Exception {
        // Testing with the same values as initialized
        assertTrue(invokeEquals(name2, 1, 2), "Expected equals(1, 2) to return true");
    }

    @Test
    public void testEquals_DifferentQuad1() throws Exception {
        // Testing with a different quad1
        assertFalse(invokeEquals(name2, 3, 2), "Expected equals(3, 2) to return false");
    }

    @Test
    public void testEquals_DifferentQuad2() throws Exception {
        // Testing with a different quad2
        assertFalse(invokeEquals(name2, 1, 4), "Expected equals(1, 4) to return false");
    }

    @Test
    public void testEquals_DifferentValues() throws Exception {
        // Testing with both values different
        assertFalse(invokeEquals(name2, 3, 4), "Expected equals(3, 4) to return false");
    }

    private boolean invokeEquals(Name2 name2, int quad1, int quad2) throws Exception {
        Method method = Name2.class.getDeclaredMethod("equals", int.class, int.class);
        method.setAccessible(true);
        return (boolean) method.invoke(name2, quad1, quad2);
    }
}
